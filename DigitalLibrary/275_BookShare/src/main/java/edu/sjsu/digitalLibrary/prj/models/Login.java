package edu.sjsu.digitalLibrary.prj.models;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class Login implements Serializable {
	
	private static final long serialVersionUID = 1L;

	// Persistent Fields:
   
    private int id;
	private String userEmail;
	private String password;
	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int userId) {
		this.id = userId;
	}
	
	
}
