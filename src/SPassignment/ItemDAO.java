package SPassignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

public class ItemDAO implements SqlFactory {
	String connectionString = "jdbc:mysql://localhost:3306/spassignment";
	String username = "root";
	String pword = "SQ8wvP5d";
	Connection connection = null;

	public ItemDAO() {

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
		// TODO Auto-generated method stub

	}

	@Override
	public void createItem(String name, String manu, double price, String category, String image_path, int createdBy) {
		// TODO Auto-generated method stub

		try {
			Statement statement = connection.createStatement();
			String sqlStatement = "INSERT INTO Items(name, manufacturer, price, category, image_path, createdBy) "
					+ "values('" + name + "','" + manu + "','" + price + "','" + category + "','" + image_path + "','"
					+ createdBy + "');";
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
			String sqlStatement = "DELETE FROM items where sku = " + id + ";";

			statement.executeUpdate(sqlStatement);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updateItem(int id, String name, String manu, double price, String category, String image_path) {
		// TODO Auto-generated method stub

		try {
			Statement statement = connection.createStatement();
			String sqlStatement = "UPDATE items" + " SET name = '" + name + "' ,manufacturer = '" + manu
					+ "', price = '" + price + "', category = '" + category + "', image_path = '" + image_path + "'"
					+ " WHERE sku = " + id + ";";

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
	public Items readItem(int id) {
		// TODO Auto-generated method stub
		Items item = null;
		try {
			Statement command = connection.createStatement();
			ResultSet data = command.executeQuery("SELECT * FROM items WHERE sku = " + id + ";");
			while (data.next()) {

				int dbSku = data.getInt("sku");
				String dbName = data.getString("name");
				String dbManu = data.getString("manufacturer");
				double dbPrice = data.getDouble("price");
				String dbCategory = data.getString("category");
				String imagePath = data.getString("image_path");
				String createdBy = data.getString("createdBy");

				item = new Items(dbSku, dbName, dbManu, dbPrice, dbCategory, imagePath, createdBy);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return item;
	}

	@Override
	public ArrayList<Items> readAllItems() {
		// TODO Auto-generated method stub
		ArrayList<Items> items = new ArrayList<>();

		try {
			Statement command = connection.createStatement();
			ResultSet data = command.executeQuery("select * from items;");

			while (data.next()) {
				int dbSku = data.getInt("sku");
				String dbName = data.getString("name");
				String dbManu = data.getString("manufacturer");
				double dbPrice = data.getDouble("price");
				String dbCategory = data.getString("category");
				String imagePath = data.getString("image_path");
				String createdBy = data.getString("createdBy");

				Items i = new Items(dbSku, dbName, dbManu, dbPrice, dbCategory, imagePath, createdBy);
				items.add(i);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return items;
	}
	
	public void updateCart(Items item, HttpSession session) {
		ArrayList<Items> cart = (ArrayList<Items>) session.getAttribute("cart");
		cart.add(item);
		
		session.removeAttribute("cart");
		session.setAttribute("cart", cart);
	}

}
