package Controllers;

import javax.servlet.http.HttpServletResponse;

import Models.Items;

public class stockState {
	DaoFacade df = new DaoFacade();
	
	public stockState() {
		
	}
	
	public String checkStock(int id, HttpServletResponse response) {
		String msgStock = "";
		
		Items item = (Items) df.readObject("itemIndiv", id, response);
		
		if(item.getStock() > 0) {
			msgStock = String.valueOf(item.getStock());
		}
		else {
			msgStock = "Out of Stock.";
		}
		
		return msgStock;
	}

}
