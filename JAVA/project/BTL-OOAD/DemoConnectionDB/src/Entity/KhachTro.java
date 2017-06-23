package Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JOptionPane;

import control.AbstractDB;

public class KhachTro extends AbstractDB {
	private int maKhach;
	private String hoTen;
	private long cmnd;
	private String diaChi;
	private String quocTich;

	public KhachTro() {
		super();
	}

	public KhachTro(int maKhach, String hoTen, long cmnd, String diaChi, String quocTich) {
		super();
		this.maKhach = maKhach;
		this.hoTen = hoTen;
		this.cmnd = cmnd;
		this.diaChi = diaChi;
		this.quocTich = quocTich;
	}

	public KhachTro(String hoTen, long cmnd, String diaChi, String quocTich) {
		super();
		this.hoTen = hoTen;
		this.cmnd = cmnd;
		this.diaChi = diaChi;
		this.quocTich = quocTich;
	}

	public int getMaKhach() {
		return maKhach;
	}

	public String getHoTen() {
		return hoTen;
	}

	public long getCmnd() {
		return cmnd;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public String getQuocTich() {
		return quocTich;
	}

	@Override
	public String toString() {
		return "KhachTro [maKhach=" + maKhach + ", hoTen=" + hoTen + ", cmnd=" + cmnd + ", diaChi=" + diaChi
				+ ", quocTich=" + quocTich + "]";
	}

	public ArrayList<KhachTro> getDsKhachTro() {
		String sql = "SELECT * FROM KhachTro";
		Connection cnn = this.condb.getConnect();

		ArrayList<KhachTro> result = new ArrayList<KhachTro>();
		try {
			PreparedStatement pst = cnn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int maKhach = rs.getInt(1);
				String hoTen = rs.getString(2);
				long cmnd = rs.getInt(3);
				String diaChi = rs.getString(4);
				String quocTich = rs.getString(5);
				KhachTro khach = new KhachTro(maKhach, hoTen, cmnd, diaChi, quocTich);
				result.add(khach);
			}
			rs.close();
			pst.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Collections.sort(result, new Comparator<KhachTro>() {

			@Override
			public int compare(KhachTro arg0, KhachTro arg1) {
				return -(arg0.maKhach - arg1.maKhach);
			}
		});
		return result;
	}

	public boolean themKhachTro(KhachTro kh) throws SQLException {
		for (KhachTro i : getDsKhachTro())
			if (i.getCmnd() == kh.getCmnd()) {
				JOptionPane.showMessageDialog(null, "Trùng CMND");
				return false;
			}

		Connection cnn = this.condb.getConnect();
		String sql = "INSERT INTO KhachTro VALUES(?,?,?,?)";

		PreparedStatement pst = cnn.prepareStatement(sql);
		pst.setString(1, kh.getHoTen());
		pst.setLong(2, kh.getCmnd());
		pst.setString(3, kh.getDiaChi());
		pst.setString(4, kh.getQuocTich());

		int result = pst.executeUpdate();
		pst.close();
		cnn.close();

		if (result > 0) {
			JOptionPane.showMessageDialog(null, "Thêm khách thành công khách hàng: \n" + kh.getCmnd() + "\n"
					+ kh.getHoTen() + "\n" + kh.getDiaChi() + " " + kh.getQuocTich());
			return true;
		}

		JOptionPane.showMessageDialog(null, "Thêm khách không thành công");
		return false;
	}

	public boolean xoaKhachTro(long cmnd) throws SQLException {
		String sql = "DELETE FROM KhachTro WHERE cmnd=?";
		Connection cnn = this.condb.getConnect();
		try {
			PreparedStatement pst = cnn.prepareStatement(sql);
			pst.setLong(1, cmnd);
			int result = pst.executeUpdate();
			cnn.close();
			pst.close();
			if (result > 0) {
				JOptionPane.showMessageDialog(null, "Xóa " + cmnd + " thành công");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Xóa " + cmnd + " thất bại");
		return false;
	}

	public boolean suaKhachTro(KhachTro kh) throws SQLException {
		for (KhachTro i : getDsKhachTro())
			if (i.getCmnd() == kh.getCmnd() & i.getMaKhach() != kh.getMaKhach()) {
				JOptionPane.showMessageDialog(null, "Trùng CMND");
				return false;
			}

		String sql = "UPDATE KhachTro SET hoten=?, cmnd=?, diachi=?, quoctich=? WHERE makhach=?";
		Connection cnn = this.condb.getConnect();
		try {
			PreparedStatement pst = cnn.prepareStatement(sql);
			pst.setString(1, kh.getHoTen());
			pst.setLong(2, kh.getCmnd());
			pst.setString(3, kh.getDiaChi());
			pst.setString(4, kh.getQuocTich());
			pst.setInt(5, kh.getMaKhach());
			int result = pst.executeUpdate();
			cnn.close();
			pst.close();
			if (result > 0) {
				JOptionPane.showMessageDialog(null, "Cập nhật thành công");
				return true;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Cập nhật không thành công");
		return false;
	}

	public ArrayList<KhachTro> timKiem(String s) throws SQLException {
		String sql = "SELECT * FROM KhachTro WHERE hoten LIKE N'%" + s + "%'";
		Connection cnn = this.condb.getConnect();

		ArrayList<KhachTro> result = new ArrayList<KhachTro>();
		try {
			PreparedStatement pst = cnn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int maKhach = rs.getInt(1);
				KhachTro khach = new KhachTro(maKhach, hoTen, cmnd, diaChi, quocTich);
				result.add(khach);
			}
			rs.close();
			pst.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}