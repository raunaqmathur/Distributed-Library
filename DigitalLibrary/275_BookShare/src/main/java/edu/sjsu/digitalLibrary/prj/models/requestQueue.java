package edu.sjsu.digitalLibrary.prj.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("unused")
@Entity
public class requestQueue implements Serializable {

	// SELECT q.isbn,count(q.isbn),u.regionid FROM BookShareDB.requestQueue q,
	// BookShareDB.user u where q.userid = u.id group by q.isbn,u.regionid
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "userid")
	private int userid;

	@Column(name = "isbn")
	private String isbn;

	@Column(name = "isOrdered")
	private int isOrdered;

	@Column(name = "orderDate")
	private Date orderDate;

	@Column(name = "requestTime")
	private Date requestTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getIsOrdered() {
		return isOrdered;
	}

	public void setIsOrdered(int isOrdered) {
		this.isOrdered = isOrdered;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}

}
