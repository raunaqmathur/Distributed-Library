package edu.sjsu.digitalLibrary.prj.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;











import edu.sjsu.digitalLibrary.prj.dao.*;
import edu.sjsu.digitalLibrary.prj.models.MongoBook;
import edu.sjsu.digitalLibrary.prj.models.address;
import edu.sjsu.digitalLibrary.prj.models.Registration;
import edu.sjsu.digitalLibrary.prj.models.LandingPage;
import edu.sjsu.digitalLibrary.prj.models.Login;
import edu.sjsu.digitalLibrary.prj.models.statistics;
import edu.sjsu.digitalLibrary.prj.models.user;
import edu.sjsu.digitalLibrary.prj.utils.CheckSession;
import edu.sjsu.digitalLibrary.prj.utils.PlayPP;
import edu.sjsu.digitalLibrary.prjservices.SearchService;
import edu.sjsu.digitalLibrary.prjservices.UserRecordService;
 
@SuppressWarnings("unused")
@Controller
public class FirstController {

    
    //private internalCategory homepageModel;
    private user userModel;
    //private book bookModel;
    //private category categoryModel;
    private LandingPage landingPage;
    HttpSession session;
    private static Jedis jedis;
    
    @Autowired
    private SearchService searchService;
    
    @Autowired
   	private HttpSession httpSession;
   	
   	@Autowired
   	private CheckSession sessionService;
    
    //1.Creating the u.i for user sign up page
    @RequestMapping(value = "/signup",method = RequestMethod.GET)
    public ModelAndView initN() {
    	userModel = new user();
        return new ModelAndView("signup", "userdetails", userModel);

    }
    
    @RequestMapping(value = "/showuser/{userId}",method = RequestMethod.GET)
    public ModelAndView showBook(@PathVariable int userId) {
    	
    	if(!sessionService.checkAuth())
    	{
    		System.out.println("chk class wrked!");
    		Login login = new Login();
        	
    		
    	    return new ModelAndView("login", "logindetails", login);
    		
    		
    	}

    	ModelAndView mv = new ModelAndView();
    	userModel = new user();
    	
    	JPAUserDAO obj= new JPAUserDAO();
    	userModel = obj.getUser(userId);
	
        mv.addObject("userdetails", userModel);
        mv.setViewName("showuser");
        
        return mv;
    }
    
    
    @RequestMapping(value = "/signup/{userId}",method = RequestMethod.GET)
    public ModelAndView edituser(@PathVariable int userId, HttpServletRequest request) {

    	ModelAndView mv = new ModelAndView();
    	userModel = new user();
    	
    	JPAUserDAO obj= new JPAUserDAO();
    	userModel = obj.getUser(userId);
    	mv.addObject("path", "../editprofile");
        mv.addObject("userdetails", userModel);
        mv.setViewName("profileedit");
        
        return mv;
    }
    
   
    @RequestMapping(value = "/signup",method = RequestMethod.POST)
    public ModelAndView initN1(@ModelAttribute("userdetails")Registration registrationModel, BindingResult bindingResult, 
            HttpServletRequest request,  HttpServletResponse response) 
    {
    	
    	
        try 
        {
        	String msg=null;
           
            //ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult,"id","id", "id can not be empty.");
            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult,"name","name", "name not be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "emailId", "emailId", "emailId cant be empty");
            //ValidationUtils.r
 
            JPAUserDAO tempEmail = new JPAUserDAO();
            System.out.println("Email in reg: " + registrationModel.getEmailId());
            
            
             
            if(tempEmail.getExistingEmail(registrationModel.getEmailId()) > 0)
            {
            	System.out.println("Error in email: " + registrationModel.getDob());
            	 ModelAndView mv1 = new ModelAndView();
            	 mv1.addObject("msg", "user with this email already exists");
                 mv1.setViewName("signup");
            	
            	 return mv1;
            	 
            }	
            if (bindingResult.hasErrors())
            {
            	System.out.println("Error in form: " + registrationModel.getDob());
                //returning the errors on same page if any errors..
                return new ModelAndView("signup", "userdetails", registrationModel);
            }
            else
            {
            	
            	//User Table Entry
            	System.out.println("user model details here --" +registrationModel.getDob());
            	
            	
            	registrationModel.setActiveUser(1);
            	//System.out.println(PlayPP.sha1(registrationModel.getPassword()));
            	registrationModel.setPassword(PlayPP.sha1(registrationModel.getPassword()));
            	
            	user registerUser = new user();
            	registerUser.setActive(registrationModel.getActiveUser());
            	registerUser.setCategory(registrationModel.getCategory());
            	//registerUser.setDob(registrationModel.getDob());
            	registerUser.setEmailId(registrationModel.getEmailId());
            	registerUser.setName(registrationModel.getName());
            	registerUser.setPassword(registrationModel.getPassword());
            	//change here
            	registerUser.setParentId(1);
            	registerUser.setPhone(registrationModel.getPhone());
            	
            	
            	
            	JPAUserDAO obj= new JPAUserDAO();
            	int newUserId =obj.insert(registerUser);
            	registerUser.setId(newUserId);
            	
            	System.out.println("UserId Added: " + newUserId);
            	//User Table Entry Ends/////////////////////////////////
            	//System.out.println("Apt#: " + registrationModel.getAptNo());
            	
            	//address Entry
            	registrationModel.setActive(1);
            	address newUserAddress = new address();
            	
            	newUserAddress.setUserId(newUserId);
            	newUserAddress.setStreet(registrationModel.getStreet());
            	newUserAddress.setAptNo(registrationModel.getAptNo());
            	newUserAddress.setCity(registrationModel.getCity());
            	newUserAddress.setState(registrationModel.getState());
            	newUserAddress.setCountry(registrationModel.getCountry());
            	newUserAddress.setZip(registrationModel.getZip());
            	newUserAddress.setAttachmentId(registrationModel.getAttachmentId());
            	newUserAddress.setActive(registrationModel.getActive());
            	
            	JPAAddressDAO objAddress = new JPAAddressDAO();
            	int newAddressId =objAddress.insert(newUserAddress);
            	newUserAddress.setId(newAddressId);
            	System.out.println("AddressId Added: " + newAddressId);
            	//address Entry Ends
            	
            	
            	Login loginModel = new Login();
            	ModelAndView model = new ModelAndView("login");
            	
            	model.addObject("logindetails", loginModel);

           	 	
           	 	return model;
          }
        } catch (Exception e) {
            System.out.println("Exception in FirstController "+e.getMessage());
            e.printStackTrace();
            return new ModelAndView("signup", "userdetails", registrationModel);
        }
        
    }
    

    
    @RequestMapping(value = "/editprofile",method = RequestMethod.POST)
    public Object editProfile(@ModelAttribute("userdetails")user userModel1, BindingResult bindingResult, 
            HttpServletRequest request,  HttpServletResponse response) 
    {
    	if(!sessionService.checkAuth())
    	{
    		System.out.println("chk class wrked!");
    		Login login = new Login();
        	
    		
    		return "redirect:/login";
    		
    		
    	}
        try 
        {
        	String msg=null;
           
            //ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult,"id","id", "id can not be empty.");
            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult,"name","name", "name not be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "emailId", "emailId", "emailId cant be empty");
            //ValidationUtils.r
 
            JPAUserDAO tempEmail = new JPAUserDAO();
            
            String one = userModel1.getEmailId();
         	
            if (bindingResult.hasErrors())
            {
                //returning the errors on same page if any errors..
            	 ModelAndView mv1 = new ModelAndView();
            	 mv1.addObject("userdetails", userModel1);
            	 mv1.addObject("path", "editprofile");
                 mv1.setViewName("profileedit");
            	
            	 return mv1;
                
            }
            else
            {
            	System.out.println("user model details here --" +userModel1.getName()+userModel1.getPhone());
            	// insert the record by calling the service
            	//userRecordService.insertUser(userModel1);
            	
            	//userModel1.setActive(1);
            	System.out.println("???? " + userModel1.getId());
            	userModel1.setPassword(PlayPP.sha1(userModel1.getPassword()));
            	JPAUserDAO obj= new JPAUserDAO();
            	
            	
            	user x =obj.getUser(userModel1.getId());
            	//userModel1.setUserId(l);
            	
            	
            	
            	x.setActive(1);
            	//x.setAddress(userModel1.getAddress());
            	//x.setAge(userModel1.getAge());
            	x.setName(userModel1.getName());
            	x.setPassword(userModel1.getPassword());
            	x.setPhone(userModel1.getPhone());

            	obj= new JPAUserDAO();
            	obj.update(x);
            	
            	
            	

            	
           	 	return new ModelAndView("redirect: /showuser/" + userModel1.getId());
          }
        } catch (Exception e) {
            System.out.println("Exception in FirstController "+e.getMessage());
            e.printStackTrace();
            return new ModelAndView("signup", "userdetails", userModel1);
        }
        
    }

    
    
    
    /*
     * This method loads the homepage on application startup.
     * Works on "/" mapping.     * */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView initM() {

		System.out.println("Landing Page");
		ModelAndView mv = new ModelAndView();
		// getting data
		landingPage = new LandingPage();
		JPALandingPageDAO obj = new JPALandingPageDAO();
		landingPage.setBooks(obj.getBooks());
		landingPage.setCategories(obj.getCategories());
		System.out.println(landingPage);
		mv.addObject("pagedetails", landingPage);
		mv.setViewName("home");
		return mv;
    }
    
 //karan code starts

    	
   

	 //method to testCassandra
    @RequestMapping(value = "/Cassandra",method = RequestMethod.GET)
    public ModelAndView initN09() {
    	
    	CassandraConnectionDAO.testCassandra();
		
		
		
    	return initN();
    }
    
    //method to testredis
    @RequestMapping(value = "/Redis",method = RequestMethod.GET)
    public ModelAndView initN10() {
    	
    	/*CassandraConnectionDAO.testCassandra();
    	userModel = new user();
    	jedis=new Jedis("localhost");
		jedis.connect();
		System.out.println("Successfully connected to the redis server");
		String [] Kar={"karan khanna","sjsu","se"};
		System.out.println(Kar);
		jedis.set("karan", "khanna");
		System.out.println("saving in redis");
		System.out.println("getting from redis---" + jedis.get("karan"));*/
		
		
		
       return initN();
    }
	//karan code ends
   
    //method to search
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/searchResults",method = RequestMethod.GET)
    public Object SearchR(
    		HttpServletRequest request,final RedirectAttributes redirectAttributes) {
    	//List<book> list1 = new ArrayList<book>();
    	
    	Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
    	  if (inputFlashMap != null) {
    	    
			 //list1 = (List<book>) inputFlashMap.get("pagedetails");
			
    	  }
    	 
    	ModelAndView mv = new ModelAndView();
    	//mv.addObject("pagedetails", list1);
  		mv.setViewName("searchResults");
	return mv;
    } 
    
    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public String Search(
    		@RequestParam(value ="searchbox", required = true, defaultValue = "C++") String input,
    		HttpServletRequest request,final RedirectAttributes redirectAttributes) {
    	System.out.println(input);
    	//List<book> lis = searchService.getAllResults(input);
    	
		//redirectAttributes.addFlashAttribute("pagedetails", lis);
    	
    	
    	
    	//Search for book in MongoDB
    	List<MongoBook> searchedBooks = new ArrayList<MongoBook>();
    	searchedBooks = searchService.searchBooksInDB(input);
    	
    	//End of search in MongoDB
    	
    	//Suppose No book is found
    	
    	//Google API implementation
    	
    	
    	if(searchedBooks == null)
    	{
    		searchService.getBooksFromGoogle(input);
    		searchedBooks = searchService.searchBooksInDB(input);
        	
    	}
    	
    	
    	//End
    	if(searchedBooks != null)
    	{
    		for(MongoBook m : searchedBooks)
    			System.out.println("book id searched: " + m.getBookId());
    	}
		return "redirect:searchResults";

    } 
    
    
    @RequestMapping(value = "/advanceSearch",method = RequestMethod.GET)
    public Object SearchA( 
    		HttpServletRequest request) {
    	
    	System.out.println("in advance search get");
    	//List<category> cat = new ArrayList<category>();
    	//cat =searchService.getCategoriesByBookJonCateg();
    	
    //	internalCategory cobj = new internalCategory();
    	
    	//List<internalCategory> clist = new ArrayList<internalCategory>();
    	//clist=cobj.change(cat);
    	
    	
    	
    	//cobj.setCm(clist);
    	
    	ModelAndView mv = new ModelAndView();
    	
    	//mv.addObject("advanceSearchDetails", cobj);
  		mv.setViewName("advanceSearch");
  		return mv;

    } 
    
    @RequestMapping(value = "/advanceSearch",method = RequestMethod.POST)
    public Object SearchAR(
    		@RequestParam(value ="byAuthChkBox", defaultValue = "Def") String byAuthChkBox,
    		@RequestParam(value ="byAuthTxt",  defaultValue = "Def") String byAuthTxt,
    		@RequestParam(value ="byCondChkBox",  defaultValue = "Def") String byCondChkBox,
    		@RequestParam(value ="oldCondCheckbox",  defaultValue = "Def") String oldCondCheckbox,
    		@RequestParam(value ="newCondCheckbox",  defaultValue = "Def") String newCondCheckbox,
    		@RequestParam(value ="byPricChkBox",  defaultValue = "Def") String byPricChkBox,
    		@RequestParam(value ="byPriceLowerTxt",  defaultValue = "0.0") String byPriceLowerTxt,
    		@RequestParam(value ="byPriceUpperTxt",  defaultValue = "0.0") String byPriceUpperTxt,
    		@RequestParam(value ="byCategChkBoxP",  defaultValue = "Def") String byCategChkBoxP,
    	//	@ModelAttribute("advanceSearchDetails")internalCategory cobj,
    		
    		
    		HttpServletRequest request) {
    	
    	System.out.println("in advancesearch post");
    	double priceLow=00.00,priceHigh=00.00;
    	int [] catArray={-1};
    	String [] condi= new String[2];
    	condi[0]="ALL";
    	if(byAuthChkBox.equalsIgnoreCase("Def")) {
    		System.out.println("not checked");
    		byAuthTxt="ALL";
    		System.out.println(byAuthTxt+"  auth name not picked dude");
    	}
    	
    	//condition input parsing starts
    	if(byCondChkBox.equalsIgnoreCase("Def")) {
    		System.out.println("cond. not checked");
    		newCondCheckbox="ALL";
    		oldCondCheckbox="ALL";
    		condi[0]="ALL";
    		System.out.println(newCondCheckbox+"---new cond,old cond---"+oldCondCheckbox);
    	}
    	
    	if((!(byCondChkBox.equalsIgnoreCase("Def"))) && (!(newCondCheckbox.equalsIgnoreCase("Def"))) && (!(oldCondCheckbox.equalsIgnoreCase("Def")))) {
    		condi[0]="New";
    		condi[1]="Old";
    	}
    	
    	if((!(byCondChkBox.equalsIgnoreCase("Def"))) && (newCondCheckbox.equalsIgnoreCase("Def")) && (!(oldCondCheckbox.equalsIgnoreCase("Def")))) {
    		condi[0]="Old";
    		condi[1]="Old";
    	}
    	
    	if((!(byCondChkBox.equalsIgnoreCase("Def"))) && (!(newCondCheckbox.equalsIgnoreCase("Def"))) && (oldCondCheckbox.equalsIgnoreCase("Def"))) {
    		condi[0]="New";
    		condi[1]="New";
    	}
    	//condition input parsing ends
    	
    	if(byPricChkBox.equalsIgnoreCase("Def")) {
    		System.out.println("price. not checked");
    		byPriceLowerTxt="ALL";
    		byPriceUpperTxt="ALL";
    		priceHigh=00.00;
    		priceLow=00.00;
    		System.out.println(priceHigh+"---hgh price cond,low price---"+priceLow);
    	}
    	
    	if(!(byPricChkBox.equalsIgnoreCase("Def"))) {
    		priceHigh=Double.parseDouble(byPriceUpperTxt)+00.00;
    		priceLow=Double.parseDouble(byPriceLowerTxt)+00.00;
    	}
    	
    	//byCategChkBoxP
    	
    	if(byCategChkBoxP.equalsIgnoreCase("Def")) {
    		System.out.println("cat. not checked");
    		catArray[0]=-1;
    	}
    	
    	if(!(byCategChkBoxP.equalsIgnoreCase("Def"))) {
    	//	for (int categ : cobj.getSlist()) {
        		//System.out.println(categ);
    		//}
    	//	catArray=cobj.getSlist();
    	}
    	
    	//List<book> lb = searchService.doAdvanceSearch(byAuthTxt, priceLow, priceHigh, condi, catArray);
    /*	System.out.println("advanceSearch result size " + lb.size());
    	System.out.println(lb.get(0).getAuthor());
    	
    	ModelAndView mv = new ModelAndView();
    	mv.addObject("pagedetails", lb);*/
    	ModelAndView mv = new ModelAndView();
  		mv.setViewName("searchResults");
  		return mv;
    }
}