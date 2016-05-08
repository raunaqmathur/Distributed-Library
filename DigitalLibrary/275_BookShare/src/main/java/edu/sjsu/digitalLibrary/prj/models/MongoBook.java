package edu.sjsu.digitalLibrary.prj.models;


import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



public class MongoBook implements Serializable,Comparable {
	
	    private int bookId;
	
	    private String title;

        private List<String> authors;
    
   
	    private String description;
    
	    private double rating;
    
	    private List<String> categories;
    
	    private String image;
	
	    private String language;
    
	    private int pageCount;
    
	    private String publisher;
    
	    private double price;

	    private String isbn;
	    
		public String getIsbn() {
			return isbn;
		}

		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}

		public int getBookId() {
			return bookId;
		}

		public void setBookId(int bookId) {
			this.bookId = bookId;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public List<String> getAuthors() {
			return authors;
		}

		public void setAuthors(List<String> authors) {
			this.authors = authors;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public double getRating() {
			return rating;
		}

		public void setRating(double rating) {
			this.rating = rating;
		}

		public List<String> getCategories() {
			return categories;
		}

		public void setCategories(List<String> categories) {
			this.categories = categories;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public String getLanguage() {
			return language;
		}

		public void setLanguage(String language) {
			this.language = language;
		}

		public int getPageCount() {
			return pageCount;
		}

		public void setPageCount(int pageCount) {
			this.pageCount = pageCount;
		}

		public String getPublisher() {
			return publisher;
		}

		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}
		class CustomComparator implements Comparator<MongoBook> {
		    @Override
		    public int compare(MongoBook o1, MongoBook o2) {
		    	if(o1.getRating() > o2.getRating())
		    		return 1;
		    	else
		    		return 0;
		        //return o1.getRating().compareTo(o2.getRating());
		    }
		}
		@Override
		public int compareTo(Object o) {
			double compareRatings=((MongoBook)o).getRating();
			return (int) (this.rating-compareRatings);
		}
		
}

 
