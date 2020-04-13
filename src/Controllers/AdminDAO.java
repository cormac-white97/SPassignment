package Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Models.Items;
import Models.SqlFactory;
import Models.Users;

public class AdminDAO implements SqlFactory {
	String connectionString = "jdbc:mysql://localhost:3306/spassignment";
	String username = "root";
	String pword = "SQ8wvP5d";
	Connection connection = null;

	public AdminDAO() {
		
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
					+ "','" + email + "','" + password + "','admin','" + address + "');";
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
	public Users readIndividual(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Users> readAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createItem(String name, String manu, double price, String category,int stock, String image_path, int createdBy) {
		// TODO Auto-generated method stub

	}

	@Override

	public void updateItem(int id, String name, String manu, double price, String category,int stock, String image_path) {
		// TODO Auto-generated method stub

	}

	@Override

	public Items readItem(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override

	public ArrayList<Items> readAllItems() {
		// TODO Auto-generated method stub
		return null;
	}

}
