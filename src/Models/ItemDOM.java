package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ItemDOM{
	String connectionString = "jdbc:mysql://localhost:3306/spassignment";
	String username = "root";
	String pword = "SQ8wvP5d";
	Connection connection = null;

	public ItemDOM() {

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


	public void createItem(String name, String manu, double price, String category, int stock, String image_path,
			int createdBy, HttpServletResponse response) {

		try {
			Statement statement = connection.createStatement();
			String sqlStatement = "INSERT INTO Items(name, manufacturer, price, category, image_path, createdBy, stock) "
					+ "values('" + name + "','" + manu + "','" + price + "','" + category + "','" + image_path + "','"
					+ createdBy + "','" + stock + "');";
			// insert the data

			statement.executeUpdate(sqlStatement);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public void delete(int id, HttpServletResponse response) {
		try {
			Statement statement = connection.createStatement();
			String sqlStatement = "DELETE FROM items where sku = " + id + ";";

			statement.executeUpdate(sqlStatement);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public void updateItem(int id, String name, String manu, double price, String category, int stock,
			String image_path, HttpServletResponse response) {

		try {
			Statement statement = connection.createStatement();
			String sqlStatement = "UPDATE items" + " SET name = '" + name + "' ,manufacturer = '" + manu
					+ "', price = '" + price + "', category = '" + category + "', image_path = '" + image_path
					+ "', stock = '" + stock + "' WHERE sku = " + id + ";";

			statement.executeUpdate(sqlStatement);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateStock(int id, int stock) {
		// TODO Auto-generated method stub

		try {
			Statement statement = connection.createStatement();
			String sqlStatement = "UPDATE items" + " SET stock = '" + stock + "' WHERE sku = " + id + ";";

			statement.executeUpdate(sqlStatement);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Items readItem(int id, HttpServletResponse response) {
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
				int dbStock = data.getInt("stock");
				String imagePath = data.getString("image_path");
				String createdBy = data.getString("createdBy");

				item = new Items(dbSku, dbName, dbManu, dbPrice, dbCategory, dbStock, imagePath, createdBy);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return item;
	}

	public ArrayList<Items> readAllItems(HttpServletResponse response) {

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
				int dbStock = data.getInt("stock");
				String imagePath = data.getString("image_path");
				String createdBy = data.getString("createdBy");

				Items i = new Items(dbSku, dbName, dbManu, dbPrice, dbCategory, dbStock, imagePath, createdBy);
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

	public void createPurchase(ArrayList<Items> purchasedItems, int purchaserId) {
		try {
			for (Items item : purchasedItems) {
				Statement statement = connection.createStatement();
				String sqlStatement = "INSERT INTO Orders(OrderNumber, PersonID) " + "values('" + item.getSku() + "','"
						+ purchaserId + "');";

				statement.executeUpdate(sqlStatement);
				int stock = item.getStock() - 1;
				updateStock(item.getSku(), stock);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Items> getOrderHistory(int userId) {
		ArrayList<Items> items = new ArrayList<>();

		try {
			Statement command = connection.createStatement();
			ResultSet data = command
					.executeQuery("select * from items where sku in (select OrderNumber from orders where PersonID = "
							+ userId + ");");

			while (data.next()) {
				int dbSku = data.getInt("sku");
				String dbName = data.getString("name");
				String dbManu = data.getString("manufacturer");
				double dbPrice = data.getDouble("price");
				String dbCategory = data.getString("category");
				int dbStock = data.getInt("stock");
				String imagePath = data.getString("image_path");
				String createdBy = data.getString("createdBy");

				Items i = new Items(dbSku, dbName, dbManu, dbPrice, dbCategory, dbStock, imagePath, createdBy);
				items.add(i);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return items;
	}
}
