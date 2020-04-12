package SPassignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerDAO implements UserFactory {
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
	public void create(String name, String email, String password, String address) {

		try {
			connection = DriverManager.getConnection(connectionString, username, pword);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

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

	}

	@Override
	public void update(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Users> readAll() {
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
	public Object readIndividual(int id) {
		return null;
	}

}
