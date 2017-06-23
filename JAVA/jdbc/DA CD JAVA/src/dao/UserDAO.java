package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import connect.DBConnect;
import interfacce.Interface_User;
import model.User;

public class UserDAO implements Interface_User {

	private Connection con;

	public UserDAO() {
		super();
		con = DBConnect.getInstance();
	}

	@Override
	public boolean checUsername(String username, String email) {
		String sql = "SELECT * FROM user WHERE username = ? OR email = ?";

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, email);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				rs.close();
				pst.close();
				return true;
			}

			rs.close();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean register(User user) {

		if (checUsername(user.getUsername(), user.getEmail()) == false) {

			String sql = "INSERT INTO user(username,password,sdt, email,ten,quyen, avatar,diemtichluy) VALUES (?,?,?,?,?,?,?,?)";
			try {

				PreparedStatement pst = con.prepareCall(sql);
				pst.setString(1, user.getUsername());
				pst.setString(2, user.getPassword());
				pst.setString(3, user.getSdt());
				pst.setString(4, user.getEmail());
				pst.setString(5, user.getTen());

				pst.setString(6, user.getQuyen());
				pst.setString(7, user.getAvatar());
				pst.setInt(8, user.getDiemTichTuy());

				boolean kq = pst.execute();

				pst.close();
				return kq;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public User login(String username, String password) {

		User results = null;

		try {
			String sql = "SELECT * FROM user WHERE username= ? AND password=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int stt = rs.getInt(1);
				String name = rs.getString(2);
				String sdt = rs.getString(3);
				String email = rs.getString(4);
				String ten = rs.getString(5);
				String quyen = rs.getString(6);
				String avatar = rs.getString(7);
				String pass = rs.getString(8);
				int diemTichTuy = rs.getInt(9);

				results = new User(stt, name, sdt, email, ten, quyen, avatar, pass, diemTichTuy);
			}
			rs.close();
			pst.close();

			if (results != null)
				return results;

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public ArrayList<User> getAllUser() {
		String sql = "SELECT * FROM user";

		ArrayList<User> results = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int stt = rs.getInt(1);

				String username = rs.getString(2);
				String sdt = rs.getString(3);
				String email = rs.getString(4);
				String ten = rs.getString(5);
				String quyen = rs.getString(6);
				String avatar = rs.getString(7);
				String password = rs.getString(8);

				int diemTichTuy = rs.getInt(9);

				results.add(new User(stt, username, sdt, email, ten, quyen, avatar, password, diemTichTuy));
			}
			rs.close();
			pst.close();

			if (results.size() > 0)
				return results;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean insert(Object obj) {
		return false;
	}

	@Override
	public boolean update(Object obj) {
		User user = (User) obj;

		if(user.getAvatar()!=null){
			String sql = "UPDATE user SET username=?,password=?,sdt=?, email=?,ten=?,quyen=?, avatar=?,diemtichluy=? WHERE stt=?";
			try {
				PreparedStatement pst = con.prepareCall(sql);

				pst.setString(1, user.getUsername());
				pst.setString(2, user.getPassword());
				pst.setString(3, user.getSdt());
				pst.setString(4, user.getEmail());
				pst.setString(5, user.getTen());

				pst.setString(6, user.getQuyen());
				pst.setString(7, user.getAvatar());
				pst.setInt(8, user.getDiemTichTuy());

				pst.setInt(9, user.getStt());

				boolean kq = pst.execute();

				pst.close();
				return kq;
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		} else {
			String sql = "UPDATE user SET username=?,password=?,sdt=?, email=?,ten=?,quyen=?, diemtichluy=? WHERE stt=?";
			try {
				PreparedStatement pst = con.prepareCall(sql);

				pst.setString(1, user.getUsername());
				pst.setString(2, user.getPassword());
				pst.setString(3, user.getSdt());
				pst.setString(4, user.getEmail());
				pst.setString(5, user.getTen());

				pst.setString(6, user.getQuyen());
				pst.setInt(7, user.getDiemTichTuy());

				pst.setInt(8, user.getStt());

				boolean kq = pst.execute();

				pst.close();
				return kq;
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		
		return false;
	}

	@Override
	public boolean delete(long stt) {
		return false;
	}

	@Override
	public User getUserByStt(int sott) {
		String sql = "SELECT * FROM user WHERE stt=?";

		User results = null;
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, sott);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int stt = rs.getInt(1);

				String username = rs.getString(2);
				String sdt = rs.getString(3);
				String email = rs.getString(4);
				String ten = rs.getString(5);
				String quyen = rs.getString(6);
				String avatar = rs.getString(7);
				String password = rs.getString(8);

				int diemTichTuy = rs.getInt(9);

				results = new User(stt, username, sdt, email, ten, quyen, avatar, password, diemTichTuy);
			}
			rs.close();
			pst.close();

			return results;

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	@Override
	public User getUserByEmail(String mail) {
		String sql = "SELECT * FROM user WHERE email=?";

		User results = null;
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, mail);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int stt = rs.getInt(1);

				String username = rs.getString(2);
				String sdt = rs.getString(3);
				String email = rs.getString(4);
				String ten = rs.getString(5);
				String quyen = rs.getString(6);
				String avatar = rs.getString(7);
				String password = rs.getString(8);

				int diemTichTuy = rs.getInt(9);

				results = new User(stt, username, sdt, email, ten, quyen, avatar, password, diemTichTuy);
			}
			rs.close();
			pst.close();

			return results;

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}

	public static void main(String[] args) {
		// System.out.println(dao.checUsername("admin1"));

		// System.out.println(dao.login("admin", "admin"));

		// User user = new User(0, "username", "sdt", "email", "Bùi Hiếu Thiện",
		// "quyen", "avatar", "password", 0);
		// System.out.println(dao.register(user));

		 System.out.println(new UserDAO().getAllUser());
		
//		User user = new UserDAO().getUserByStt(71);
//		user.setDiemTichTuy(user.getDiemTichTuy()+1);
//		user.setAvatar(null);
//		new UserDAO().update(user);
		
//		System.out.println(new UserDAO().checUsername("sdsds", "hieuthien95@gmail.com"));
	}
}
