package Controllers;

import javax.servlet.http.HttpServletResponse;

public class productState {
	
	public productState() {
		
	}
	
	public Object checkState(String type, int id, HttpServletResponse response) {
		Object state = null;
		stockState s = new stockState();
		reviewState r = new reviewState();
		
		if(type.equals("stock")) {
			state = s.checkStock(id, response);
		}
		else if(type.equals("review")) {
			state = r.checkReviews(id, response);
		}
		
		
		return state;
		
	}

}
