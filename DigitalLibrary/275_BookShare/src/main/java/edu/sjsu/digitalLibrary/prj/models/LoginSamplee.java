package edu.sjsu.digitalLibrary.prj.models;


import java.io.Serializable;


import javax.persistence.Entity;


@Entity
public class LoginSamplee implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	/**
	 * 
	 */
	
	// Persistent Fields:
   
    private int id;
    
    private String email;
    
    
    
    
    private String password;




	public int getId() {
		return id;
	}




	public void setId(int userId) {
		this.id = userId;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getUserEmail() {
		return email;
	}




	public void setUserEmail(String userEmail) {
		this.email = userEmail;
	}
    
	
    
   


	
}
