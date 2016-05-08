package edu.sjsu.digitalLibrary.prj.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sjsu.digitalLibrary.prj.Recommendations.Recommendations;
import edu.sjsu.digitalLibrary.prj.dataoperations.DBCrud;
import edu.sjsu.digitalLibrary.prj.dataoperations.MongoCrud;
import edu.sjsu.digitalLibrary.prj.models.BookId;
import edu.sjsu.digitalLibrary.prj.models.MongoBook;
import edu.sjsu.digitalLibrary.prj.models.order;
import edu.sjsu.digitalLibrary.prj.models.subbook;
import edu.sjsu.digitalLibrary.prj.models.user;


/*
 * Class to perform business functions
 * it implements the DAO of address
 */
@SuppressWarnings("unused")
public class JPABookDAO {

	
	
	public int getBookParentId(int bookId) {
		
		try {
			DBCrud<subbook> db = new DBCrud<subbook>();
			return db.getBookParentId(bookId);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	return -1;
		
	}


public List<MongoBook> doAdvanceSearch(String auth, String publisher, String desc,
		String[] categories) {
	try {
		
		
		MongoCrud db = new MongoCrud("book");
		return db.doAdvanceSearch(auth, publisher, desc, categories);
		
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
			return null;
	
}

//Google API implementation

		public void getBooksFromGoogle(String input, int bookId) {
			
			try {
				MongoCrud db = new MongoCrud("book");
				db.GetBooksFromGoogle(input, bookId);
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			
		}

		public void getBooksFromGoogleAdvance(String byAuthTxt, String byPubTxt, String byDescTxt, String [] catArray, int bookId) {
			
			try {
				MongoCrud db = new MongoCrud("book");
				db.GetBooksFromGoogleAdvance(byAuthTxt,  byPubTxt,  byDescTxt,  catArray, bookId);
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			
		}
		//Search books in MongoDB

				public List<MongoBook> searchBooksInDB(String input) {
					
					try {
						MongoCrud db = new MongoCrud("book");
						return db.searchBooksInDB(input);
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
					return null	;
				}
				
				//Search book with book id in MongoDB

				public MongoBook searchBooksInDBByID(String input) {
					
					try {
						MongoCrud db = new MongoCrud("book");
						return db.searchBooksInDBByID(input);
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
					return null	;
				}

				public int getLatestBookId()
				{
					try {
						
						BookId bTemp = new BookId();
						bTemp.setId(1);
						
						DBCrud<BookId> db = new DBCrud<BookId>();
						bTemp = db.get(bTemp, 1);
					    return bTemp.getBookId();
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					return 1;
				}
				
				public void insertLatestBookId(int id)
				{
					try {
						BookId bTemp = new BookId();
						bTemp.setId(1);
						bTemp.setBookId(id);
						DBCrud<BookId> db = new DBCrud<BookId>();
						 db.update(bTemp);
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
				
				public int getOrderCount(int userId)
				{
					try {
						
						DBCrud<order> db = new DBCrud<order>();
						 return db.getOrderCount(userId);
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					return 0;
				}
				
				public List<MongoBook> searchTop5CategoryBooks(String[] categories) {
					
					try {
						MongoCrud db = new MongoCrud("book");
						return db.searchTop5CategoryBooks(categories);
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
					return null	;
				}
				
				
				public List<Integer> getMahoutRecomm(int userId) {
					
					try {
						Recommendations r = new Recommendations();
						return r.getBookRecommendationsMahout(userId, 10);
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
					return null	;
				}
				
}