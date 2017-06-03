package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.DBConnect;
import interfacce.Interface_BaiViet;
import model.BaiViet;

public class BaiVietDAO implements Interface_BaiViet {

	private Connection con;

	public BaiVietDAO() {
		super();
		con = DBConnect.getInstance();
	}

	@Override
	public boolean insert(Object obj) {
		BaiViet bv = (BaiViet) obj;

		if (!bv.getHinhanh().equals("") || bv.getHinhanh() != null) {
			String sql = "INSERT INTO baiviet(loaitin,tieude,tomtat, hinhanh,noidung,trangthai) VALUES (?,?,?, ?,?,?)";
			try {

				PreparedStatement pst = con.prepareCall(sql);
				pst.setString(1, bv.getLoaitin());
				pst.setString(2, bv.getTieude());
				pst.setString(3, bv.getTomtat());

				pst.setString(4, bv.getHinhanh());
				pst.setString(5, bv.getNoidung());
				pst.setInt(6, bv.getTrangthai());

				boolean kq = pst.execute();

				pst.close();
				return kq;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			String sql = "INSERT INTO baiviet(loaitin,tieude,tomtat, noidung,trangthai) VALUES (?,?,?, ?,?)";
			try {

				PreparedStatement pst = con.prepareCall(sql);
				pst.setString(1, bv.getLoaitin());
				pst.setString(2, bv.getTieude());
				pst.setString(3, bv.getTomtat());

				pst.setString(4, bv.getNoidung());
				pst.setInt(5, bv.getTrangthai());

				boolean kq = pst.execute();

				pst.close();
				return kq;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public boolean update(Object obj) {
		BaiViet bv = (BaiViet) obj;

		String sql = "UPDATE baiviet SET loaitin=?,tieude=?,tomtat=?, hinhanh=?,noidung=?,trangthai=? WHERE stt=?";
		try {

			PreparedStatement pst = con.prepareCall(sql);
			pst.setString(1, bv.getLoaitin());
			pst.setString(2, bv.getTieude());
			pst.setString(3, bv.getTomtat());

			pst.setString(4, bv.getHinhanh());
			pst.setString(5, bv.getNoidung());
			pst.setInt(6, bv.getTrangthai());

			pst.setInt(7, bv.getStt());

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
		String sql = "DELETE FROM baiviet WHERE stt = ?";
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
	public ArrayList<BaiViet> getAllBaiViet() {
		String sql = "SELECT * FROM baiviet ORDER BY STT DESC";

		ArrayList<BaiViet> results = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int stt = rs.getInt(1);
				String loaitin = rs.getString(2);
				String tieude = rs.getString(3);
				String tomtat = rs.getString(4);
				String hinhanh = rs.getString(5);
				String noidung = rs.getString(6);
				int trangthai = rs.getInt(7);

				results.add(new BaiViet(stt, loaitin, tieude, tomtat, hinhanh, noidung, trangthai));
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
	public ArrayList<BaiViet> getBaiVietByLoai(String loai) {
		String sql = "SELECT * FROM baiviet WHERE loaitin = ?";

		ArrayList<BaiViet> results = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, loai);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int stt = rs.getInt(1);
				String loaitin = rs.getString(2);
				String tieude = rs.getString(3);
				String tomtat = rs.getString(4);
				String hinhanh = rs.getString(5);
				String noidung = rs.getString(6);
				int trangthai = rs.getInt(7);

				results.add(new BaiViet(stt, loaitin, tieude, tomtat, hinhanh, noidung, trangthai));
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
	public BaiViet getBaiVietByStt(int sott) {
		String sql = "SELECT * FROM baiviet WHERE stt = ?";

		BaiViet results = null;
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, sott);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int stt = rs.getInt(1);
				String loaitin = rs.getString(2);
				String tieude = rs.getString(3);
				String tomtat = rs.getString(4);
				String hinhanh = rs.getString(5);
				String noidung = rs.getString(6);
				int trangthai = rs.getInt(7);

				results = new BaiViet(stt, loaitin, tieude, tomtat, hinhanh, noidung, trangthai);
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
		BaiVietDAO dao = new BaiVietDAO();

		 for(BaiViet i: dao.getAllBaiViet())
		 System.out.println(i.getTieude());

		// for(BaiViet i: dao.getBaiVietByLoai("Tin tức"))
		// System.out.println(i.getTieude());

		// System.out.println(dao.getBaiVietByStt(18).getTieude());

//		dao.insert(new BaiViet(0, "loaitin", "tieude", "tomtat", "hinhanh", "noidung", 0));

		// BaiViet bv = dao.getBaiVietByStt(17);
		// bv.setTieude(bv.getTieude() + "...");

		// dao.update(bv);
	}

}
