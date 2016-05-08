package edu.sjsu.digitalLibrary.prj.models;

public class requestQueueCount {

	String isbn;
	int countReq;
	int regionId;
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getCountReq() {
		return countReq;
	}
	public void setCountReq(int countReq) {
		this.countReq = countReq;
	}
	public int getRegionId() {
		return regionId;
	}
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	
}
