package edu.sjsu.digitalLibrary.prj.dao;

import java.sql.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sjsu.digitalLibrary.prj.dataoperations.DBCrud;
import edu.sjsu.digitalLibrary.prj.models.internalCategory;
import edu.sjsu.digitalLibrary.prj.models.Tokens;
import edu.sjsu.digitalLibrary.prj.models.user;

@SuppressWarnings("unused")
public class JPATokenDAO {
	
	/*
	 * Function to add token
	 * 
	 */
	
	public int insert(Tokens token) 
	{
		System.out.println("in user jpa");
		int id= 0;
		try {
			DBCrud<Tokens> db = new DBCrud<Tokens>();
			id = db.Insert(token);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return id;
	}
	
	/*
	 * Function to delete token data from databse
	 * 
	 */
	public void delete(Tokens token) {
		
		try {
			DBCrud<Tokens> db = new DBCrud<Tokens>();
			db.delete(token);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
	}
	
	public Tokens getToken(int id) {
		Tokens token = new Tokens();
		try {
			DBCrud<Tokens> db = new DBCrud<Tokens>();
			token=  db.get(token, id);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return token;
	}
	
	
	
	public Tokens getTokenData(int userid) {
		Tokens token = new Tokens();
		try {
			DBCrud<Tokens> db = new DBCrud<Tokens>();
			token=  db.getTokenData(userid);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return token;
	}
	
	/*
	 * Function to update expiry date
	 * 
	 */
	public void update(Tokens token) {
		
		try {
			DBCrud<Tokens> db = new DBCrud<Tokens>();
			db.delete(token);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
	}

	

}
