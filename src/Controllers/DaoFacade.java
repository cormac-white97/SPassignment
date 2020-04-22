package Controllers;

import java.sql.*;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.AdminDOM;
import Models.CustomerDOM;
import Models.ItemDOM;
import Models.Items;
import Models.Users;

public class DaoFacade {
	static String connectionString = "jdbc:mysql://localhost:3306/spassignment";
	static String username = "root";
	static String pword = "SQ8wvP5d";
	private static Connection connection;
	private Users loggedUser;

	public DaoFacade() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection(connectionString, username, pword);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public Users getLoggedInDetails(String email, HttpServletResponse response) {
		NullObject no = new NullObject();
		try {
			Statement command = connection.createStatement();
			ResultSet data = command.executeQuery("SELECT * FROM users union SELECT * FROM admin;");

			while (data.next()) {
				int id = data.getInt("id");
				String dbName = data.getString("name");
				String dbEmail = data.getString("email");
				String dbAccountType = data.getString("accountType");
				String dbAddress = data.getString("address");

				if (dbEmail.equals(email)) {
					loggedUser = new Users(id, dbName, dbEmail, dbAccountType, dbAddress);
					break;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			no.redirect(response);
			
		}
		return loggedUser;
	}

	public boolean signIn(String name, String password) {
		boolean found = false;
		try {
			Statement command = connection.createStatement();
			ResultSet data = command.executeQuery("select * from admin union select * from users;");

			while (data.next()) {
				String dbName = data.getString("email");
				String dbPass = data.getString("password");

				if (name.equals(dbName) && password.equals(dbPass)) {
					found = true;
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return found;
	}

	public void create(String type, String name, String email, String password, String address, String manu,
			double price, String category, int stock, String image_path, int createdBy, ArrayList<Items> purchaseItems,
			int purchaserId, int productId, String reviewBody, HttpServletResponse response) {

		if (type.equals("Customer")) {
			CustomerDOM cd = new CustomerDOM();
			cd.createUser(name, email, password, address, response);
		} else if (type.equals("Admin")) {
			AdminDOM ad = new AdminDOM();
			ad.createUser(name, email, password, address, response);
		} else if (type.equals("item")) {
			ItemDOM itemDOM = new ItemDOM();
			itemDOM.createItem(name, manu, price, category, stock, image_path, createdBy, response);
		} else if (type.equals("purchase")) {

			int parsedId = (int) purchaserId;
			ItemDOM i = new ItemDOM();
			i.createPurchase(purchaseItems, parsedId);
		}
		else if(type.equals("review")) {
			ItemDOM i = new ItemDOM();
			i.addReview(productId, purchaserId, reviewBody, response);
		}

	}
	
	public void updateCart(Items item, HttpSession session) {
		ItemDOM i = new ItemDOM();
		i.updateCart(item, session);
	}

	public void delete(String type, int id, HttpServletResponse response) {
		if (type.equals("user")) {
			CustomerDOM cd = new CustomerDOM();
			cd.delete(id, response);
		} else if (type.equals("item")) {
			ItemDOM itemDom = new ItemDOM();
			itemDom.delete(id, response);
		}
	}

	public void update(String type, int id, String name, String email, String address, String manu, double price,
			String category, int stock, String image_path, HttpServletResponse response, HttpSession session,
			Items item) {
		
		if (type.equals("adminUser")) {
			AdminDOM ad = new AdminDOM();
			ad.updateUser(id, name, email, address, response);
		} else if (type.equals("cusomer")) {
			CustomerDOM cd = new CustomerDOM();
			cd.updateUser(id, name, email, address, response);
		} else if (type.equals("item")) {
			ItemDOM itemDOM = new ItemDOM();
			itemDOM.updateItem(id, name, manu, price, category, stock, image_path, response);
		} else if (type.equals("cart")) {
			ItemDOM itemDOM = new ItemDOM();
			itemDOM.updateCart(item, session);
		}
	}

	public Object readObject(String type, int id, HttpServletResponse response) {
		Object returnObj = null;

		if (type.equals("customerIndiv")) {
			CustomerDOM cd = new CustomerDOM();
			returnObj = cd.readIndividual(id, response);
		} else if (type.equals("customerAll")) {
			CustomerDOM cd = new CustomerDOM();
			returnObj = cd.readAllUsers(response);
		} else if (type.equals("itemIndiv")) {
			ItemDOM itemDOM = new ItemDOM();
			returnObj = itemDOM.readItem(id, response);
		} else if (type.equals("itemAll")) {
			ItemDOM itemDOM = new ItemDOM();
			returnObj = itemDOM.readAllItems(response);
		}
		else if(type.equals("history")) {
			ItemDOM itemDOM = new ItemDOM();
			returnObj = itemDOM.getOrderHistory(id);
		}
		else if(type.equals("review")) {
			ItemDOM itemDOM = new ItemDOM();
			returnObj = itemDOM.getReviews(id, response);
		}

		return returnObj;
	}

	public void createReview(int productId, int personId, String reviewBody, HttpServletResponse response) {
		ItemDOM i = new ItemDOM();
		i.addReview(productId, personId, reviewBody, response);
	}
}
