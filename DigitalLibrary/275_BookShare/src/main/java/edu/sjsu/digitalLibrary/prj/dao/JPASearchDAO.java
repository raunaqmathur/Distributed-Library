package edu.sjsu.digitalLibrary.prj.dao;

import java.util.List;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

import edu.sjsu.digitalLibrary.prj.dataoperations.MongoCrud;
import edu.sjsu.digitalLibrary.prj.models.searchSuggetion;

public class JPASearchDAO {
	public List<searchSuggetion> getSearchSuggestion(String query) {
		System.out.println("in search jpa fr getSearchSuggestion ");

		try {
			MongoCrud mc = new MongoCrud("book");
			JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
			List<searchSuggetion> searchList = mc.getGoogleBooksSuggetion(jsonFactory, query);
			return searchList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
