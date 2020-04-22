package Controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import Models.Items;

public class reviewState {
	DaoFacade df = new DaoFacade();
	
	public reviewState() {
		
	}
	
	
	public ArrayList<String> checkReviews(int id, HttpServletResponse response) {
		ArrayList<String> returnList = new ArrayList<>();
		
		ArrayList<String> reviewList = (ArrayList<String>) df.readObject("review", id, response);
		
		if(reviewList.size() > 0) {
			returnList = reviewList;
		}
		else {
			returnList.add("No Reviews");
		}
		
		return returnList;
	}
}
