package Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JOptionPane;

import control.AbstractDB;

public class Phong extends AbstractDB {
	private String maPhong;
	private String loaiPhong;
	private int sucChua;
	private int donGia;

	public Phong() {
	}

	public Phong(String maPhong, String loaiPhong, int sucChua, int donGia) {
		super();
		this.maPhong = maPhong;
		this.loaiPhong = loaiPhong;
		this.sucChua = sucChua;
		this.donGia = donGia;
	}

	public String getMaPhong() {
		return maPhong;
	}

	public String getLoaiPhong() {
		return loaiPhong;
	}

	public int getSucChua() {
		return sucChua;
	}

	public int getDonGia() {
		return donGia;
	}

	@Override
	public String toString() {
		return "Phong [maPhong=" + maPhong + ", loaiPhong=" + loaiPhong + ", sucChua=" + sucChua + ", donGia=" + donGia
				+ "]";
	}

	public ArrayList<Phong> getDsPhong() {
		String sql = "SELECT * FROM Phong";
		Connection cnn = this.condb.getConnect();

		ArrayList<Phong> result = new ArrayList<Phong>();
		try {
			PreparedStatement pst = cnn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String maPhong = rs.getString(1);
				String loaiPhong = rs.getString(2);
				int sucChua = rs.getInt(3);
				int donGia = rs.getInt(4);
				Phong phong = new Phong(maPhong, loaiPhong, sucChua, donGia);
				result.add(phong);
			}
			rs.close();
			pst.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Collections.sort(result, new Comparator<Phong>() {

			@Override
			public int compare(Phong arg0, Phong arg1) {
				return arg0.sucChua - arg1.sucChua;
			}
		});
		return result;
	}

	public boolean themPhong(Phong p) throws SQLException {
		Connection cnn = this.condb.getConnect();
		String sql = "INSERT INTO Phong VALUES(?,?,?,?)";

		PreparedStatement pst = cnn.prepareStatement(sql);
		pst.setString(1, p.getMaPhong());
		pst.setString(2, p.getLoaiPhong());
		pst.setInt(3, p.getSucChua());
		pst.setInt(4, p.getDonGia());

		int result = pst.executeUpdate();
		pst.close();
		cnn.close();

		if (result > 0) {
			System.out.println("Thêm phòng " + p.getMaPhong() + " thành công");
			JOptionPane.showMessageDialog(null, "Thêm phòng thành công" + "\nMã phòng: " + p.getMaPhong()
					+ "\nSức chứa: " + p.getSucChua() + "\nGiá: " + p.getDonGia());
			return true;
		}
		System.out.println("Thêm phòng " + p.getMaPhong() + " không thành công");
		return true;
	}

	public boolean xoaPhong(String ma) {
		String sql = "DELETE FROM Phong WHERE maphong=?";
		Connection cnn = this.condb.getConnect();
		try {
			PreparedStatement pst = cnn.prepareStatement(sql);
			pst.setString(1, ma);
			PhongDangSuDung pdsd = new PhongDangSuDung();
			for (PhongDangSuDung i : pdsd.getDsPhongDangSuDung())
				if (i.getMaPhongThue().equals(ma)) {
					JOptionPane.showMessageDialog(null, "Đang có người thuê phòng này");
					return false;
				}
			int result = pst.executeUpdate();
			cnn.close();
			pst.close();
			if (result > 0) {
				JOptionPane.showMessageDialog(null, "Xóa phòng " + ma + " thành công");
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Xóa phòng " + ma + " không thành công");
		return false;
	}

	public boolean suaPhong(Phong p) {
		String sql = "UPDATE Phong SET loaiphong=?, succhua=?, dongia=? WHERE maphong=?";
		Connection cnn = this.condb.getConnect();
		try {
			PreparedStatement pst = cnn.prepareStatement(sql);
			pst.setString(1, p.getLoaiPhong());
			pst.setInt(2, p.getSucChua());
			pst.setInt(3, p.getDonGia());
			pst.setString(4, p.getMaPhong());
			int result = pst.executeUpdate();
			cnn.close();
			pst.close();
			if (result > 0) {
				JOptionPane.showMessageDialog(null, "Cập nhật phòng " + p.getMaPhong() + " thành công");
				return true;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Cập nhật phòng " + p.getMaPhong() + " không thành công");
		return false;
	}

}
