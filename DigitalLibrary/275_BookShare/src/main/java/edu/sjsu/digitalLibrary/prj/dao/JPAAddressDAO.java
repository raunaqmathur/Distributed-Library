package edu.sjsu.digitalLibrary.prj.dao;

import edu.sjsu.digitalLibrary.prj.dataoperations.DBCrud;
import edu.sjsu.digitalLibrary.prj.models.address;

public class JPAAddressDAO {
	

		
		
		public int insert(address address1) 
		{
			System.out.println("in address jpa");
			int addressId= 0;
			try {
				DBCrud<address> db = new DBCrud<address>();
				addressId = db.Insert(address1);
				
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			return addressId;
		}
}
