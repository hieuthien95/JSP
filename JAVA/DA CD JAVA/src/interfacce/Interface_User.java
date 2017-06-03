package interfacce;

import java.util.ArrayList;

import model.User;


public interface Interface_User extends CRUD{
	public ArrayList<User> getAllUser();
	
	public boolean checUsername(String username, String email);

	public boolean register(User user);

	public User login(String username, String password);
	
	public User getUserByStt(int stt);
	
	public User getUserByEmail(String email);
}
