package edu.sjsu.digitalLibrary.prj.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class region implements Serializable{
	
	private static final long serialVersionUID = 1L;


	
	 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id")
	 private int id;
	 
	 @Column(name = "longitude")
	 private double longitude;
	 
	 @Column(name = "latitude")	 
	 private double latitude;
	 
	 @Column(name = "name")	 
	 private String name;
	 
	 @Column(name = "funding_region")	 
	 private int funding_region;

	 
	 @Column(name = "city")	 
	 private String city;
	 
	 @Column(name = "active")	 
	 private int active;
	 
	 
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFunding_region() {
		return funding_region;
	}

	public void setFunding_region(int funding_region) {
		this.funding_region = funding_region;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	 
	 

}
