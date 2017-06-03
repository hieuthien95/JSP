package Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import control.AbstractDB;

public class Quyen extends AbstractDB{
	private String id;
	private String pass;
	private String quyen;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getQuyen() {
		return quyen;
	}

	public void setQuyen(String quyen) {
		this.quyen = quyen;
	}

	public Quyen(String id, String pass, String quyen) {
		super();
		this.id = id;
		this.pass = pass;
		this.quyen = quyen;
	}

	public Quyen() {
		super();
	}

	@Override
	public String toString() {
		return "Quyen [id=" + id + ", pass=" + pass + ", quyen=" + quyen + "]";
	}
	
	public String login(String id, String password) {
		String sql = "SELECT * FROM DangNhap Where id=? AND pass=?";
		Connection cnn = this.condb.getConnect();
		try {
			PreparedStatement pst = cnn.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				System.out.println("Thanh Cong");
				return rs.getString(3);
			} else {
				System.out.println("That bai");
				return "";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}

}
