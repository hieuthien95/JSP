package Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import control.AbstractDB;

public class ThanhVienThue extends AbstractDB {
	private long cmnd;
	private String hoTen;
	private int maThuePhong;

	public long getCmnd() {
		return cmnd;
	}

	public String getHoTen() {
		return hoTen;
	}

	public int getMaThuePhong() {
		return maThuePhong;
	}

	public ThanhVienThue() {
		super();
	}

	public ThanhVienThue(long cmnd, String hoTen, int maThuePhong) {
		super();
		this.cmnd = cmnd;
		this.hoTen = hoTen;
		this.maThuePhong = maThuePhong;
	}

	@Override
	public String toString() {
		return "ThanhVienThue [cmnd=" + cmnd + ", hoTen=" + hoTen + ", maThuePhong=" + maThuePhong + "]";
	}

	public ArrayList<ThanhVienThue> getDsThanhVienThue() {
		String sql = "SELECT * FROM ThanhVienThue";
		Connection cnn = this.condb.getConnect();

		ArrayList<ThanhVienThue> result = new ArrayList<ThanhVienThue>();
		try {
			PreparedStatement pst = cnn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				long cmnd = rs.getLong(1);
				String hoTen = rs.getString(2);
				int maThuePhong = rs.getInt(3);
				ThanhVienThue tvt = new ThanhVienThue(cmnd, hoTen, maThuePhong);
				result.add(tvt);
			}
			rs.close();
			pst.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean themThanhVienThuePhong(ThanhVienThue tvt) throws SQLException {
		for (ThanhVienThue i : getDsThanhVienThue())
			if (i.getCmnd() == tvt.getCmnd() && i.getMaThuePhong() == tvt.getMaThuePhong()) {
				JOptionPane.showMessageDialog(null, tvt.getHoTen() + " đã có trong danh sách");
				return false;
			}

		Connection cnn = this.condb.getConnect();
		String sql = "INSERT INTO ThanhVienThue VALUES(?,?,?)";

		PreparedStatement pst = cnn.prepareStatement(sql);
		pst.setLong(1, tvt.getCmnd());
		pst.setString(2, tvt.getHoTen());
		pst.setInt(3, tvt.getMaThuePhong());

		pst.executeUpdate();
		JOptionPane.showMessageDialog(null, "Thêm " + tvt.getHoTen() + " thành công");

		pst.close();
		cnn.close();

		return true;
	}

	public boolean xoaThanhVienThue(long cmnd, int maThuePhong) throws SQLException {
		String sql = "DELETE FROM ThanhVienThue WHERE cmnd=? AND mathuephong=?";
		Connection cnn = this.condb.getConnect();
		try {
			PreparedStatement pst = cnn.prepareStatement(sql);
			pst.setLong(1, cmnd);
			pst.setInt(2, maThuePhong);
			int result = pst.executeUpdate();
			cnn.close();
			pst.close();
			if (result > 0)
				JOptionPane.showMessageDialog(null, "Xóa " + cmnd + " thành công");
			else
				JOptionPane.showMessageDialog(null, "Xóa " + cmnd + " không thành công");
			return result > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
