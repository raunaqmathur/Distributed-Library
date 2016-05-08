package edu.sjsu.digitalLibrary.prj.models;
import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class subbook implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private int id;

   
    @Column(name = "parentId")
    private int parentId;
	
	@Column(name = "dateSince")
    private Date dateSince;
	
	@Column(name = "active")
    private int active;
	
	@Column(name = "regionId")
    private int regionId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public Date getDateSince() {
		return dateSince;
	}

	public void setDateSince(Date dateSince) {
		this.dateSince = dateSince;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
