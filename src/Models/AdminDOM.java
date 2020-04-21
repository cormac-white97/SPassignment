package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import Controllers.NullObject;

public class AdminDOM implements SqlFactory {
	String connectionString = "jdbc:mysql://localhost:3306/spassignment";
	String username = "root";
	String pword = "SQ8wvP5d";
	Connection connection = null;
	NullObject no = new NullObject();

	public AdminDOM() {
		
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
	public void createUser(String name, String email, String password, String address, HttpServletResponse response) {

		try {
			Statement statement = connection.createStatement();
			String sqlStatement = "INSERT INTO admin(name, email, password, address, accountType) " + "values('" + name
					+ "','" + email + "','" + password + "',' '" + "'admin');";
			// insert the data

			statement.executeUpdate(sqlStatement);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		try {
			Statement statement = connection.createStatement();
			String sqlStatement = "DELETE FROM admin where id = " + id + ";";

			statement.executeUpdate(sqlStatement);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updateUser(int id, String name, String email, String address, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			Statement statement = connection.createStatement();
			String sqlStatement = "UPDATE admin" + " SET name = '" + name + "' ,email = '" + email + "' WHERE id = " + id + ";";

			statement.executeUpdate(sqlStatement);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Users readIndividual(int id, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Users> readAllUsers(HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}


}
