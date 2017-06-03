package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.DBConnect;
import interfacce.Interface_DonHang;
import model.DonHang;

public class DonHangDAO implements Interface_DonHang {
	private Connection con;

	public DonHangDAO() {
		super();
		con = DBConnect.getInstance();
	}

	@Override
	public boolean insert(Object obj) {
		DonHang bill = (DonHang) obj;

		String sql = "INSERT INTO donhang(stt,gia,sdt, ghichu,thoigian,magiaodich) VALUES(?,?,?, ?,?,?)";
		try {
			PreparedStatement pst = con.prepareCall(sql);

			pst.setLong(1, bill.getStt());
			pst.setLong(2, bill.getGia());
			pst.setString(3, bill.getSdt());

			pst.setString(4, bill.getGhiChu());
			pst.setString(5, bill.getThoiGian());
			pst.setString(6, bill.getMaGiaoDich());

			boolean kq = pst.execute();
			pst.close();
			return kq;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Object obj) {
		DonHang bill = (DonHang) obj;

		String sql = "UPDATE donhang SET thoigian=?,magiaodich=? WHERE stt=?";
		try {
			PreparedStatement pst = con.prepareCall(sql);

			pst.setString(1, bill.getThoiGian());
			pst.setString(2, bill.getMaGiaoDich());

			pst.setLong(3, bill.getStt());

			boolean kq = pst.execute();
			pst.close();
			return kq;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(long stt) {
		String sql = "DELETE FROM donhang WHERE stt = ?";
		try {
			PreparedStatement ps = con.prepareCall(sql);
			ps.setLong(1, stt);
			int temp = ps.executeUpdate();

			return temp == 1;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public ArrayList<DonHang> getAllDonHang() {
		String sql = "SELECT * FROM donhang ORDER BY stt DESC";

		ArrayList<DonHang> results = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				long stt = rs.getLong(1);
				int gia = rs.getInt(2);
				String sdt = rs.getString(3);
				String ghiChu = rs.getString(4);
				String maGiaoDich = rs.getString(5);
				String thoiGian = rs.getString(6);

				results.add(new DonHang(stt, gia, sdt, ghiChu, maGiaoDich, thoiGian));
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
	public DonHang getDonHangByStt(int sott) {
		String sql = "SELECT * FROM donhang WHERE stt = ?";

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, sott);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int stt = rs.getInt(1);
				int gia = rs.getInt(2);
				String sdt = rs.getString(3);
				String ghiChu = rs.getString(4);
				String maGiaoDich = rs.getString(5);
				String thoiGian = rs.getString(6);

				return new DonHang(stt, gia, sdt, ghiChu, maGiaoDich, thoiGian);
			}
			rs.close();
			pst.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<DonHang> getAllDonHangBySdt(String sodt) {
		String sql = "SELECT * FROM donhang WHERE sdt = ? ORDER BY stt DESC";

		ArrayList<DonHang> results = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, sodt);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				long stt = rs.getLong(1);
				int gia = rs.getInt(2);
				String sdt = rs.getString(3);
				String ghiChu = rs.getString(4);
				String maGiaoDich = rs.getString(5);
				String thoiGian = rs.getString(6);

				results.add(new DonHang(stt, gia, sdt, ghiChu, maGiaoDich, thoiGian));
			}
			rs.close();
			pst.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	public static void main(String[] args) {
		DonHangDAO dao = new DonHangDAO();
		// System.out.println(dao.insertDonHang(new DonHang(0, 120000,
		// "01653990", "ghiChu", "maGiaoDich", "thoiGian")));

		System.out.println(dao.getAllDonHangBySdt("01293245504"));
	}
}
