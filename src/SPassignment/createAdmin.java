package SPassignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class createAdmin implements create {

	@Override
	public void Create(String name, String email, String password, String address) {
		String connectionString = "jdbc:mysql://localhost:3306/spassignment";
		String username = "root";
		String pword = "SQ8wvP5d";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(connectionString, username, pword);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
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

}
