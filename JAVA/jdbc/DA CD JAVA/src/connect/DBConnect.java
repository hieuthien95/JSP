package connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	private static Connection con = new DBConnect().getConnection();

	public static Connection getInstance() {
		if (con == null)
			return new DBConnect().getConnection();
		return con;
	}

	public Connection getConnection() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/shop_jdbc?useUnicode=yes&characterEncoding=UTF-8", "root",
					"123456789");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void main(String[] args) {
		System.out.println(DBConnect.getInstance());
	}
}
