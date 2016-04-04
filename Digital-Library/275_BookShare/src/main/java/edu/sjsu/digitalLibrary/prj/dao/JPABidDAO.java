package edu.sjsu.digitalLibrary.prj.dao;

import java.util.ArrayList;
import java.util.List;

import edu.sjsu.digitalLibrary.prj.dataoperations.DBCrud;
import edu.sjsu.digitalLibrary.prj.models.bid;

public class JPABidDAO implements BidDAO {

	public List<bid> getBidByBookId(int bookId) 
	{
		List<bid> tempBid = new ArrayList<bid>();
		try {
			DBCrud<bid> db = new DBCrud<bid>();
			tempBid=  db.getBidByBook(bookId);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return tempBid;
	}
	
	
	

	public int insert(bid Bid) {
		System.out.println("in feedback jpa");
		int feedbackId= 0;
		try {
			DBCrud<bid> db = new DBCrud<bid>();
			feedbackId = db.Insert(Bid);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return feedbackId;
	}

	public void delete(bid Bid) {
		try {
			DBCrud<bid> db = new DBCrud<bid>();
			db.delete(Bid);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	public void updateBid(bid upBid) {
		try {
			DBCrud<bid> db = new DBCrud<bid>();
			db.update(upBid);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
