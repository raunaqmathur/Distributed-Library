package edu.sjsu.digitalLibrary.prj.dao;

import java.util.List;

import edu.sjsu.digitalLibrary.prj.dataoperations.DBCrud;
import edu.sjsu.digitalLibrary.prj.dataoperations.MongoCrud;
import edu.sjsu.digitalLibrary.prj.models.MongoBook;
import edu.sjsu.digitalLibrary.prj.models.region;
import edu.sjsu.digitalLibrary.prj.models.requestQueue;
import edu.sjsu.digitalLibrary.prj.models.requestQueueCount;
import edu.sjsu.digitalLibrary.prj.models.subbook;

public class JPARequestQueueDAO {

	public List<requestQueueCount> getRequestdetails() {
		try {
			DBCrud db = new DBCrud();
			return db.getRequestQueueInfo();

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;

	}

	public void updateRegion(region region) {
		try {
			DBCrud<region> db = new DBCrud<region>();
			db.update(region);

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public int getBookIdByISBN(String ISBN) {
		try {
			MongoCrud mdb = new MongoCrud("book");
			MongoBook mbook = mdb.searchBooksInDBWithBookISBN(ISBN);
			return mbook.getBookId();
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return 0;
	}
	

	public int insertSubBook(subbook subbook) 
	{
		System.out.println("in subbook jpa");
		int subbookId= 0;
		try {
			DBCrud<subbook> db = new DBCrud<subbook>();
			subbookId = db.Insert(subbook);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return subbookId;
	}
	
	public void update(requestQueue requestQueue) {
		
		
		try {
			DBCrud<requestQueue> db = new DBCrud<requestQueue>();
			db.update(requestQueue);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

}
	
	public List<requestQueue> getRequestQueueInfoByISBNRegion(String isbn,int regionid){
		try {
			DBCrud<requestQueue> db = new DBCrud<requestQueue>();
			return db.getRequestQueueInfoByISBNRegion(isbn, regionid);
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}


}
