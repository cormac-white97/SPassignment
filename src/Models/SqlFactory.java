package Models;

import java.util.ArrayList;

public interface SqlFactory {

	public void createUser(String name, String email, String password, String address);

	public void createItem(String name, String manu, double price, String category, int stock, String image_path,
			int createdBy);

	public void delete(int id);

	public void updateUser(int id, String name, String email, String address);

	public void updateItem(int id, String name, String manu, double price, String category, int stock,
			String image_path);

	public Users readIndividual(int id);

	public ArrayList<Users> readAllUsers();

	public Items readItem(int id);

	public ArrayList<Items> readAllItems();

}
