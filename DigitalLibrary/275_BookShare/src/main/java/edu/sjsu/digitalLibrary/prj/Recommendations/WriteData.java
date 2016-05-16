package edu.sjsu.digitalLibrary.prj.Recommendations;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteData {

	public boolean writeData(long userId, long bookId, long feedback) {

		
		boolean fileWrite = false;
		File file = new File("/Users/raunaqmathur/project295B/Distributed-Library/DigitalLibrary/275_BookShare/src/main/webapp/resources/MahoutData/userBookData.csv");
		
		//File file = new File("/usr/share/tomcat7/webapps/275_BookShare/src/main/webapp/resources/MahoutData/userBookData.csv");
		
		try {
			file.createNewFile();
			FileWriter writer = new FileWriter(file, true);
			
			String output = userId + "," + bookId + "," + feedback;
			writer.write(output);
			writer.write("\n");

				
			
			
			writer.flush();
			writer.close();
			
			fileWrite = true;
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		
		return fileWrite;

	}
}
