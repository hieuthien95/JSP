package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.DBConnect;
import interfacce.Interface_HinhAnh;
import model.HinhAnh;

public class HinhAnhDAO implements Interface_HinhAnh {

	private Connection con;

	public HinhAnhDAO() {
		super();
		con = DBConnect.getInstance();
	}

	@Override
	public boolean insert(Object obj) {
		HinhAnh ha = (HinhAnh) obj;

		String sql = "INSERT INTO hinhanh(loaihinh,sttsp,hinhanh) VALUES(?,?,?)";
		try {
			PreparedStatement pst = con.prepareCall(sql);

			pst.setString(1, ha.getLoaiHinh());
			pst.setInt(2, ha.getSttSp());
			pst.setString(3, ha.getHinhAnh());

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
		return false;
	}

	@Override
	public boolean delete(long stt) {
		String sql = "DELETE FROM hinhanh WHERE stt = ?";
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
	public ArrayList<HinhAnh> getAllHinhAnh() {
		String sql = "SELECT * FROM hinhanh ORDER BY sttsp DESC";

		ArrayList<HinhAnh> results = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int stt = rs.getInt(1);
				String loaiHinh = rs.getString(2);
				int sttsp = rs.getInt(3);
				String hinhAnh = rs.getString(4);

				results.add(new HinhAnh(stt, loaiHinh, sttsp, hinhAnh));
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
	public HinhAnh getHinhAnhByStt(int sott) {
		String sql = "SELECT * FROM hinhanh WHERE stt=?";

		HinhAnh results = null;

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, sott);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int stt = rs.getInt(1);
				String loaiHinh = rs.getString(2);
				int sttsp = rs.getInt(3);
				String hinhAnh = rs.getString(4);

				results = new HinhAnh(stt, loaiHinh, sttsp, hinhAnh);
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
	public ArrayList<HinhAnh> getAllHinhAnhBySttSP(int sttSP) {
		String sql = "SELECT * FROM hinhanh WHERE sttsp = ? ORDER BY stt DESC";

		ArrayList<HinhAnh> results = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, sttSP);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int stt = rs.getInt(1);
				String loaiHinh = rs.getString(2);
				int sttsp = rs.getInt(3);
				String hinhAnh = rs.getString(4);

				results.add(new HinhAnh(stt, loaiHinh, sttsp, hinhAnh));
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

	public static void main(String[] args) {
		HinhAnhDAO dao = new HinhAnhDAO();
		// System.out.println(dao.getAllHinhAnhtBySttSP(26));
		// dao.delete(30);
		// System.out.println(dao.getAllHinhAnh());

		System.out.println(dao.insert(new HinhAnh(0, "hang", 99, "hinhanh")));
	}

}
