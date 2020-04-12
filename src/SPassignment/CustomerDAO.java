package SPassignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

public class CustomerDAO implements SqlFactory {
	String connectionString = "jdbc:mysql://localhost:3306/spassignment";
	String username = "root";
	String pword = "SQ8wvP5d";
	Connection connection;

	public CustomerDAO() {
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

	@Override
	public void createUser(String name, String email, String password, String address) {

		try {
			Statement statement = connection.createStatement();
			String sqlStatement = "INSERT INTO users(name, email, password,accountType, address) " + "values('" + name
					+ "','" + email + "','" + password + "','customer','" + address + "');";
			// insert the data

			statement.executeUpdate(sqlStatement);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		try {
			Statement statement = connection.createStatement();
			String sqlStatement = "DELETE FROM users where id = " + id + ";";

			statement.executeUpdate(sqlStatement);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateUser(int id, String name, String email, String address) {
		// TODO Auto-generated method stub
			
	}

	@Override
	public ArrayList<Users> readAllUsers() {
		ArrayList<Users> users = new ArrayList<>();

		try {
			Statement command = connection.createStatement();
			ResultSet data = command.executeQuery("SELECT * FROM users;");

			while (data.next()) {
				int dbId = data.getInt("id");
				String dbName = data.getString("name");
				String dbEmail = data.getString("email");
				String dbType = data.getString("accountType");
				String dbAddress = data.getString("address");

				Users u = new Users(dbId, dbName, dbEmail, dbType, dbAddress);
				users.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return users;
	}

	@Override
	public Users readIndividual(int id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void createItem(String name, String manu, double price, String category, String image_path, int createdBy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateItem(int id, String name, String manu, double price, String category, String image_path) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Items> readAllItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Items readItem(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateCart(Items item, HttpSession session) {
		ArrayList<Items> cart = (ArrayList<Items>) session.getAttribute("cart");
		cart.add(item);
		
		session.removeAttribute("cart");
		session.setAttribute("cart", cart);
	}
}
