package Models;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

public interface SqlFactory {

	public void createUser(String name, String email, String password, String address, HttpServletResponse response);

	public void delete(int id, HttpServletResponse response);

	public void updateUser(int id, String name, String email, String address, HttpServletResponse response);

	public Users readIndividual(int id, HttpServletResponse response);

	public ArrayList<Users> readAllUsers(HttpServletResponse response);

}
