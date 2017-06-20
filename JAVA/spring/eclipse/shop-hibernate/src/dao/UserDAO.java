package dao;

import model.User;

public interface UserDAO {

	// thêm user
	public void insertUser(User user);

	// lấy user dựa vào user_id
	public User getUser(int user_id);

	// kiểm tra thông tin user
	public boolean checkLogin(String username, String password);

	// kiểm tra username trùng
	public boolean checkUsername(String username);
}
