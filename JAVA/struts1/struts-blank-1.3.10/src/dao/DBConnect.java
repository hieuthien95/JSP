package dao;

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
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(
					"jdbc:sqlserver://DESKTOP-QSF92MV\\SQLEXPRESS:1433;database=CustomerSystem;user=sa;password=123456789;");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void main(String[] args) {
		System.out.println(DBConnect.getInstance());
	}
}
