package edu.sjsu.digitalLibrary.prj.dao;

import org.json.JSONObject;

import edu.sjsu.digitalLibrary.prj.dataoperations.DBCrud;
import edu.sjsu.digitalLibrary.prj.models.Login;



/*
 * Class to perform business functions
 * it implements the DAO of address
 */
@SuppressWarnings("unused")
public class JPALoginDAO implements LoginDAO{

	public int validate(Login login) {
		
		System.out.println("in Login jpa");
		int loginId= 0;
		try {
			DBCrud<Login> db = new DBCrud<Login>();
			loginId = db.validate(login);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return loginId;
	}
	
public JSONObject validateActivation(Login login) {
		
		System.out.println("in validateActivation jpa");
		JSONObject obj = new JSONObject();
		try {
			
			DBCrud<Login> db = new DBCrud<Login>();
			obj = db.validateActivation(login);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			obj = null;
			e1.printStackTrace();
			
		}
		return obj;
	}

public JSONObject checkUser(Login login) {
	
	System.out.println("in checkUser jpa");
	JSONObject obj = new JSONObject();
	try {
		
		DBCrud<Login> db = new DBCrud<Login>();
		obj = db.checkUser(login);
		
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		obj = null;
		e1.printStackTrace();
		
	}
	return obj;
}
	
}
