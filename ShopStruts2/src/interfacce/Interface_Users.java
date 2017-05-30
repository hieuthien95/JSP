package interfacce;

import java.util.ArrayList;

import model.Users;

public interface Interface_Users extends CRUD {

	public ArrayList<Users> getAllUsers();
	
	public boolean checUsername(String username, String email);

	public boolean register(Users users);

	public Users login(String username, String password);
	
	public Users getUserById(int id);
	
	public Users getUserByEmail(String email);
}
