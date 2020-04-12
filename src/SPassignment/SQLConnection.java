package SPassignment;

import java.sql.*;
import java.util.ArrayList;


public class SQLConnection {
	static String connectionString = "jdbc:mysql://localhost:3306/spassignment";
	static String username = "root";
	static String pword = "SQ8wvP5d";
	private static Connection connection;
	private Users loggedUser;

	public SQLConnection() {

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

	public Users getLoggedInDetails(String email) {
		try {
			Statement command = connection.createStatement();
			ResultSet data = command.executeQuery("SELECT * FROM users;");

			while (data.next()) {
				int id = data.getInt("id");
				String dbName = data.getString("name");
				String dbEmail = data.getString("email");
				String dbAccountType = data.getString("accountType");
				String dbAddress = data.getString("address");

				if (dbEmail.equals(email)) {
					loggedUser = new Users(id, dbName,dbEmail ,dbAccountType, dbAddress);
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loggedUser;
	}
	
	
	
	public boolean signIn(String name, String password) {
		boolean found = false;
		try {
			Statement command = connection.createStatement();
			ResultSet data = command.executeQuery("SELECT * FROM users;");

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




}
