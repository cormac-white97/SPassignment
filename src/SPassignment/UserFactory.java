package SPassignment;

import java.util.ArrayList;

public interface UserFactory {

	public void create(String name, String email, String password, String address);
	
	public void delete(int id);
	
	public void update(int id);
	
	public Object readIndividual(int id);
	
	public ArrayList<Users> readAll();

}
