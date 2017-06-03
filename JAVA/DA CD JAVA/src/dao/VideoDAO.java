package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.DBConnect;
import interfacce.Interface_Video;
import model.Video;

public class VideoDAO implements Interface_Video {

	private Connection con;

	public VideoDAO() {
		super();
		con = DBConnect.getInstance();
	}

	@Override
	public boolean insert(Object obj) {
		Video v = (Video) obj;

		String sql = "INSERT INTO video(ten,hinhanh,trangthai, duongdan,noidung) VALUES (?,?,?, ?,?)";
		try {

			PreparedStatement pst = con.prepareCall(sql);
			pst.setString(1, v.getTen());
			pst.setString(2, v.getHinhanh());
			pst.setInt(3, v.getTrangthai());

			pst.setString(4, v.getDuongdan());
			pst.setString(5, v.getNoidung());

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
		Video v = (Video) obj;

		String sql = "UPDATE video SET ten=?,hinhanh=?,trangthai=?, duongdan=?,noidung=? WHERE stt=?";
		try {

			PreparedStatement pst = con.prepareCall(sql);
			pst.setString(1, v.getTen());
			pst.setString(2, v.getHinhanh());
			pst.setInt(3, v.getTrangthai());

			pst.setString(4, v.getDuongdan());
			pst.setString(5, v.getNoidung());

			pst.setInt(6, v.getStt());

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
		String sql = "DELETE FROM video WHERE stt = ?";
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
	public ArrayList<Video> getAllVideo() {
		String sql = "SELECT * FROM video ORDER BY stt DESC";

		ArrayList<Video> results = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int stt = rs.getInt(1);
				String ten = rs.getString(2);
				String hinhanh = rs.getString(3);
				int trangthai = rs.getInt(4);
				String duongdan = rs.getString(5);
				String noidung = rs.getString(6);

				results.add(new Video(stt, ten, hinhanh, trangthai, duongdan, noidung));
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
	public Video getVideoByStt(int sott) {
		String sql = "SELECT * FROM video WHERE stt = ?";

		Video results = null;
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, sott);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int stt = rs.getInt(1);
				String ten = rs.getString(2);
				String hinhanh = rs.getString(3);
				int trangthai = rs.getInt(4);
				String duongdan = rs.getString(5);
				String noidung = rs.getString(6);

				results = new Video(stt, ten, hinhanh, trangthai, duongdan, noidung);
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

		// for (Video i : dao.getAllVideo())
		// System.out.println(i.getTen());
		//
		// System.out.println(dao.getVideoByStt(12).getTen());

		// Video v = dao.getVideoByStt(17);

	}

}
