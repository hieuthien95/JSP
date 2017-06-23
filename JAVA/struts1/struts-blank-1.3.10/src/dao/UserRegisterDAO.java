package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.User;
import form.Na14Form;

public class UserRegisterDAO {
	public void insertData(String firstName, String lastName, String userName, String password, String email,
			String phone) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/strutsdb", "root", "123456789");

		try {

			try {
				Statement st = con.createStatement();
				int value = st
						.executeUpdate("INSERT INTO USER_DETAILS(FIRST_NAME,LAST_NAME,USER_NAME,PASSWORD,EMAIL,PHONE) "
								+ "VALUES('" + firstName + "','" + lastName + "','" + userName + "','" + password
								+ "','" + email + "','" + phone + "')");
				System.out.println("1 row affected " + (value == 1));
			} catch (SQLException ex) {
				System.out.println("SQL statement is not executed!" + ex);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Na14Form> getData(int numPage) throws Exception {
		List<Na14Form>list = new ArrayList<Na14Form>();
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/strutsdb", "root", "123456789");

		try {
			try {
				PreparedStatement pst = con.prepareStatement("SELECT * FROM user_details limit " + numPage*5 +", " + 5);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					Na14Form user = new Na14Form();
					user.setFirstName(rs.getString(1));
					user.setLastName(rs.getString(2));
					user.setUserName(rs.getString(3));
					user.setPassword(rs.getString(4));
					user.setEmail(rs.getString(5));
					user.setPhone(rs.getString(6));
					user.setCheck("0");
					user.setNum("0");
					list.add(user);
				}
			} catch (SQLException ex) {
				System.out.println("SQL statement is not executed!" + ex);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<User> getDataUsers(int numPage) throws Exception {
		List<User>list = new ArrayList<User>();
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/strutsdb", "root", "123456789");

		try {
			try {
				PreparedStatement pst = con.prepareStatement("SELECT * FROM user_details limit " + numPage*5 +", " + 5);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					User user = new User();
					user.setFirstName(rs.getString(1));
					user.setLastName(rs.getString(2));
					user.setUserName(rs.getString(3));
					user.setPassword(rs.getString(4));
					user.setEmail(rs.getString(5));
					user.setPhone(rs.getString(6));
					list.add(user);
				}
			} catch (SQLException ex) {
				System.out.println("SQL statement is not executed!" + ex);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public static void main(String[] args) {
		try {
			System.out.println(new UserRegisterDAO().getDataUsers(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
