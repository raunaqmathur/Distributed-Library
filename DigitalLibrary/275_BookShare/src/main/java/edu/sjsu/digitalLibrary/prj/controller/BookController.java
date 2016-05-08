package edu.sjsu.digitalLibrary.prj.controller;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

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
import edu.sjsu.digitalLibrary.prj.models.LoginSamplee;
import edu.sjsu.digitalLibrary.prj.models.category;
import edu.sjsu.digitalLibrary.prj.models.internalCategory;
import edu.sjsu.digitalLibrary.prj.models.user;
import edu.sjsu.digitalLibrary.prj.utils.CheckSession;
import edu.sjsu.digitalLibrary.prj.utils.PlayPP;
import edu.sjsu.digitalLibrary.prjservices.SearchServiceImpl;
import edu.sjsu.digitalLibrary.prjservices.UserRecordService;
 
@SuppressWarnings("unused")
@Controller
public class BookController {

    int passwordDiff = 0;
    //private internalCategory homepageModel;
    private user userModel;
    //private book bookModel;
    //private category categoryModel;
    private LandingPage landingPage;
    HttpSession session;
    private static Jedis jedis;
    
   
    @Autowired
   	private HttpSession httpSession;
   	
   	@Autowired
   	private CheckSession sessionService;
    
   	private MongoBook bookModel;
   	
   	private SearchServiceImpl searchService= new SearchServiceImpl();
   	
    @RequestMapping(value = "/showbook/{bookId}",method = RequestMethod.GET)
    public ModelAndView showBook(@PathVariable int bookId, HttpServletRequest request) {
    	
    	ModelAndView mv = new ModelAndView();
    	System.out.println("book id here:" + bookId);
    	bookModel = searchService.searchBooksInDBByID(bookId + "");
    	
    	System.out.println("Book User ID: " +bookModel.getPublisher() );
		System.out.println("going: " +bookModel.getCategories().size() );
    	
        mv.addObject("bookdetails", bookModel);
        //mv.addObject("addressdetails", "101 E San Fernando, Apt#320, San Jose, CA, 95134");
        mv.setViewName("showbook");
        
       return mv;
    }
    
    @RequestMapping(value = "/convertToParentBook/{bookId}",method = RequestMethod.GET)
    public Object convertToParentBook(@PathVariable int bookId) {
    	
    	//ModelAndView mv = new ModelAndView();
    	
    	return "redirect:/showbook/" + getParentBook(bookId);
       
    }
    
    public int getParentBook( int bookId) {
    	
    	
    	JPABookDAO j = new JPABookDAO();
    	int parentId = j.getBookParentId(bookId);
    	
    	return parentId;
       
    }
}