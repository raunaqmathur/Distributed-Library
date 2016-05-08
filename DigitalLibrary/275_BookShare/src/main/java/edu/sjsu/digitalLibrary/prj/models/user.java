package edu.sjsu.digitalLibrary.prj.models;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class user implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private int id;
    
   
	@Column(name = "emailId", length  = 50)
    private String emailId;
    
    @Column(name = "name", length = 100)
    private String name;
    
    
    @Column(name = "phone", length = 45)
    private String phone;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "dob")
    private Date dob;
    
	
    
    @Column(name = "category", length = 45)
    private String category;
	
    @Column(name = "parentId")
    private int parentId;
    
    
    @Column(name = "active")
    private int active;
    
    @Column(name = "Password", length = 100)
    private String password ;
    
    @Column(name = "activation_code", length = 45)
    private String activationCode ;
    
    @Column(name = "regionId", length = 11)
    private int regionId ;
    
///////////
    
    public String getActivationCode() {
		return activationCode;
	}

	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	
}
