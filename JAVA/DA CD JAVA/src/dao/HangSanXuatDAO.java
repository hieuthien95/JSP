package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import connect.DBConnect;
import interfacce.Interface_HangSX;
import model.HangSanXuat;

public class HangSanXuatDAO implements Interface_HangSX {

	private Connection con;

	public HangSanXuatDAO() {
		super();
		con = DBConnect.getInstance();
	}

	@Override
	public boolean insert(Object obj) {
		return false;
	}

	@Override
	public boolean update(Object obj) {
		HangSanXuat h = (HangSanXuat) obj;

		String sql = "UPDATE hangsx SET mahang = ?, tenhang = ?, sttloaisp = ? WHERE stt=?";
		try {

			PreparedStatement pst = con.prepareCall(sql);
			pst.setString(1, h.getMaHang());
			pst.setString(2, h.getTenHang());
			pst.setString(3, h.getSttloaisp());

			pst.setInt(4, h.getStt());

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
		String sql = "DELETE FROM hangsx WHERE stt = ?";
		try {
			PreparedStatement ps = con.prepareCall(sql);
			ps.setLong(1, stt);
			int temp = ps.executeUpdate();

			return temp == 1;
		} catch (SQLException e) {
		}
		return false;
	}

	@Override
	public ArrayList<HangSanXuat> getAllHangSX() {
		String sql = "SELECT * FROM hangsx";

		ArrayList<HangSanXuat> results = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int stt = rs.getInt(1);
				String mahang = rs.getString(2);
				String tenloai = rs.getString(3);
				String sttloaisp = rs.getString(4);

				results.add(new HangSanXuat(stt, mahang, tenloai, sttloaisp));
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
	public HangSanXuat getHangSXByStt(int sott) {
		String sql = "SELECT * FROM hangsx WHERE stt = ?";

		HangSanXuat results = null;
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, sott);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int stt = rs.getInt(1);
				String mahang = rs.getString(2);
				String tenhang = rs.getString(3);
				String sttloaisp = rs.getString(4);

				results = new HangSanXuat(stt, mahang, tenhang, sttloaisp);
			}
			rs.close();
			pst.close();

			if (results != null)
				return results;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		List<String> ds = new ArrayList<>();
		for (HangSanXuat i : new HangSanXuatDAO().getAllHangSX()) {
			String[] arr = i.getSttloaisp().split(",");
			for (int j = 0; j < arr.length; j++) {
				ds = Arrays.asList(arr);
				System.out.println(ds);
			}
		}
	}

}
