package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.DBConnect;
import interfacce.Interface_SanPham;
import model.SanPham;

public class SanPhamDAO implements Interface_SanPham {

	private Connection con;

	public SanPhamDAO() {
		super();
		con = DBConnect.getInstance();
	}

	@Override
	public boolean insert(Object obj) {
		SanPham sp = (SanPham) obj;

		String sql = "INSERT INTO sanpham(hinhanh,ten,gia,manhinh,hdh, cpu,camera,pin,nhieuhon,hangsx, loaisp,km,trangthai,sl,luotxem) VALUES (?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?)";
		try {

			PreparedStatement pst = con.prepareCall(sql);
			pst.setString(1, sp.getHinhanh());
			pst.setString(2, sp.getTen());
			pst.setInt(3, sp.getGia());
			pst.setString(4, sp.getManhinh());
			pst.setString(5, sp.getHdh());

			pst.setString(6, sp.getCpu());
			pst.setString(7, sp.getCamera());
			pst.setString(8, sp.getPin());
			pst.setString(9, sp.getNhieuhon());
			pst.setString(10, sp.getHangsx());

			pst.setString(11, sp.getLoaisp());
			pst.setString(12, sp.getKm());
			pst.setInt(13, sp.getTrangthai());
			pst.setString(14, sp.getSl());
			pst.setInt(15, sp.getLuotxem());

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
		SanPham sp = (SanPham) obj;

		String sql = "UPDATE sanpham SET hinhanh=?,ten=?,gia=?,manhinh=?,hdh=?, cpu=?,camera=?,pin=?,nhieuhon=?,hangsx=?, loaisp=?,km=?,trangthai=?,sl=?,luotxem=? WHERE stt=?";
		try {
			PreparedStatement pst = con.prepareCall(sql);
			pst.setString(1, sp.getHinhanh());
			pst.setString(2, sp.getTen());
			pst.setInt(3, sp.getGia());
			pst.setString(4, sp.getManhinh());
			pst.setString(5, sp.getHdh());

			pst.setString(6, sp.getCpu());
			pst.setString(7, sp.getCamera());
			pst.setString(8, sp.getPin());
			pst.setString(9, sp.getNhieuhon());
			pst.setString(10, sp.getHangsx());

			pst.setString(11, sp.getLoaisp());
			pst.setString(12, sp.getKm());
			pst.setInt(13, sp.getTrangthai());
			pst.setString(14, sp.getSl());
			pst.setInt(15, sp.getLuotxem());

			pst.setInt(16, sp.getStt());

			int temp = pst.executeUpdate();
			return temp == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean delete(long stt) {
		String sql = "DELETE FROM sanpham WHERE stt = ?";
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
	public ArrayList<SanPham> getAllSanPham() {
		String sql = "SELECT * FROM sanpham ORDER BY stt DESC";

		ArrayList<SanPham> results = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int stt = rs.getInt(1);
				String hinhanh = rs.getString(2);
				String ten = rs.getString(3);
				int gia = rs.getInt(4);
				String manhinh = rs.getString(5);
				String hdh = rs.getString(6);
				String cpu = rs.getString(7);
				String camera = rs.getString(8);
				String pin = rs.getString(9);
				String nhieuhon = rs.getString(10);
				String hangsx = rs.getString(11);
				String loaisp = rs.getString(12);
				String km = rs.getString(13);
				int trangthai = rs.getInt(14);
				String sl = rs.getString(15);

				results.add(new SanPham(stt, hinhanh, ten, gia, manhinh, hdh, cpu, camera, pin, nhieuhon, hangsx,
						loaisp, km, trangthai, sl));
			}
			rs.close();
			pst.close();

			if (results.size() > 0) {
				return results;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	@Override
	public ArrayList<SanPham> getAllSanPham(int min, int max) {
		String sql = "SELECT * FROM sanpham WHERE gia>=? AND gia<=? ORDER BY gia ASC";

		ArrayList<SanPham> results = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, min);
			pst.setInt(2, max);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int stt = rs.getInt(1);
				String hinhanh = rs.getString(2);
				String ten = rs.getString(3);
				int gia = rs.getInt(4);
				String manhinh = rs.getString(5);
				String hdh = rs.getString(6);
				String cpu = rs.getString(7);
				String camera = rs.getString(8);
				String pin = rs.getString(9);
				String nhieuhon = rs.getString(10);
				String hangsx = rs.getString(11);
				String loaisp = rs.getString(12);
				String km = rs.getString(13);
				int trangthai = rs.getInt(14);
				String sl = rs.getString(15);

				results.add(new SanPham(stt, hinhanh, ten, gia, manhinh, hdh, cpu, camera, pin, nhieuhon, hangsx,
						loaisp, km, trangthai, sl));
			}
			rs.close();
			pst.close();

			if (results.size() > 0) {
				return results;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	@Override
	public ArrayList<SanPham> getSanPhamByLoai(String loai) {
		String sql = "SELECT * FROM sanpham WHERE loaisp = ? ";

		ArrayList<SanPham> results = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, loai);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int stt = rs.getInt(1);
				String hinhanh = rs.getString(2);
				String ten = rs.getString(3);
				int gia = rs.getInt(4);
				String manhinh = rs.getString(5);
				String hdh = rs.getString(6);
				String cpu = rs.getString(7);
				String camera = rs.getString(8);
				String pin = rs.getString(9);
				String nhieuhon = rs.getString(10);
				String hangsx = rs.getString(11);
				String loaisp = rs.getString(12);
				String km = rs.getString(13);
				int trangthai = rs.getInt(14);
				String sl = rs.getString(15);

				results.add(new SanPham(stt, hinhanh, ten, gia, manhinh, hdh, cpu, camera, pin, nhieuhon, hangsx,
						loaisp, km, trangthai, sl));
			}
			rs.close();
			pst.close();

			if (results.size() > 0) {
				return results;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	@Override
	public SanPham getSanPhamByStt(int sott) {
		String sql = "SELECT * FROM sanpham WHERE stt = ? ";

		SanPham results = null;

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, sott);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int stt = rs.getInt(1);
				String hinhanh = rs.getString(2);
				String ten = rs.getString(3);
				int gia = rs.getInt(4);
				String manhinh = rs.getString(5);
				String hdh = rs.getString(6);
				String cpu = rs.getString(7);
				String camera = rs.getString(8);
				String pin = rs.getString(9);
				String nhieuhon = rs.getString(10);
				String hangsx = rs.getString(11);
				String loaisp = rs.getString(12);
				String km = rs.getString(13);
				int trangthai = rs.getInt(14);
				String sl = rs.getString(15);
				int luotxem = rs.getInt(16);

				results = new SanPham(stt, hinhanh, ten, gia, manhinh, hdh, cpu, camera, pin, nhieuhon, hangsx, loaisp,
						km, trangthai, sl, luotxem);
			}
			rs.close();
			pst.close();

			if (results != null) {
				return results;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<SanPham> searchSanPham(String keyword) {
		ArrayList<SanPham> results = new ArrayList<>();
		try {
			String data = "REPLACE(CONCAT(loaisp, hangsx, ten), ' ', '')";
			String sql = "SELECT * FROM sanpham WHERE " + data + " LIKE REPLACE('%" + keyword + "%', ' ', '')";

			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int stt = rs.getInt(1);
				String hinhanh = rs.getString(2);
				String ten = rs.getString(3);
				int gia = rs.getInt(4);
				String manhinh = rs.getString(5);
				String hdh = rs.getString(6);
				String cpu = rs.getString(7);
				String camera = rs.getString(8);
				String pin = rs.getString(9);
				String nhieuhon = rs.getString(10);
				String hangsx = rs.getString(11);
				String loaisp = rs.getString(12);
				String km = rs.getString(13);
				int trangthai = rs.getInt(14);
				String sl = rs.getString(15);

				results.add(new SanPham(stt, hinhanh, ten, gia, manhinh, hdh, cpu, camera, pin, nhieuhon, hangsx,
						loaisp, km, trangthai, sl));
			}

			if (results.size() <= 0) {
				data = "REPLACE(CONCAT(loaisp, ten), ' ', '')";
				sql = "SELECT * FROM sanpham WHERE " + data + " LIKE REPLACE('%" + keyword + "%', ' ', '')";

				pst = con.prepareStatement(sql);
				rs = pst.executeQuery();

				while (rs.next()) {
					int stt = rs.getInt(1);
					String hinhanh = rs.getString(2);
					String ten = rs.getString(3);
					int gia = rs.getInt(4);
					String manhinh = rs.getString(5);
					String hdh = rs.getString(6);
					String cpu = rs.getString(7);
					String camera = rs.getString(8);
					String pin = rs.getString(9);
					String nhieuhon = rs.getString(10);
					String hangsx = rs.getString(11);
					String loaisp = rs.getString(12);
					String km = rs.getString(13);
					int trangthai = rs.getInt(14);
					String sl = rs.getString(15);

					results.add(new SanPham(stt, hinhanh, ten, gia, manhinh, hdh, cpu, camera, pin, nhieuhon, hangsx,
							loaisp, km, trangthai, sl));
				}
			}

			rs.close();
			pst.close();
			return results;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	@Override
	public ArrayList<SanPham> getTopSanPham() {
		String sql = "SELECT * FROM sanpham ORDER BY luotxem DESC LIMIT 40";

		int count = 0;

		ArrayList<SanPham> results = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int stt = rs.getInt(1);
				String hinhanh = rs.getString(2);
				String ten = rs.getString(3);
				int gia = rs.getInt(4);
				String manhinh = rs.getString(5);
				String hdh = rs.getString(6);
				String cpu = rs.getString(7);
				String camera = rs.getString(8);
				String pin = rs.getString(9);
				String nhieuhon = rs.getString(10);
				String hangsx = rs.getString(11);
				String loaisp = rs.getString(12);
				String km = rs.getString(13);
				int trangthai = rs.getInt(14);
				String sl = rs.getString(15);
				int luotxem = rs.getInt(16);

				if (!loaisp.equals("Phụ kiện")) {
					results.add(new SanPham(stt, hinhanh, ten, gia, manhinh, hdh, cpu, camera, pin, nhieuhon, hangsx,
							loaisp, km, trangthai, sl, luotxem));
					count++;
					if (count >= 12)
						break;
				}
			}
			rs.close();
			pst.close();

			if (results.size() > 0) {
				return results;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	@Override
	public ArrayList<SanPham> getNewSanPham() {
		String sql = "SELECT * FROM sanpham ORDER BY stt DESC LIMIT 200";

		ArrayList<SanPham> results = new ArrayList<>();
		try {

			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int stt = rs.getInt(1);
				String hinhanh = rs.getString(2);
				String ten = rs.getString(3);
				int gia = rs.getInt(4);
				String manhinh = rs.getString(5);
				String hdh = rs.getString(6);
				String cpu = rs.getString(7);
				String camera = rs.getString(8);
				String pin = rs.getString(9);
				String nhieuhon = rs.getString(10);
				String hangsx = rs.getString(11);
				String loaisp = rs.getString(12);
				String km = rs.getString(13);
				int trangthai = rs.getInt(14);
				String sl = rs.getString(15);
				int luotxem = rs.getInt(16);

				if (!loaisp.equals("Phụ kiện")) {
					results.add(new SanPham(stt, hinhanh, ten, gia, manhinh, hdh, cpu, camera, pin, nhieuhon, hangsx,
							loaisp, km, trangthai, sl, luotxem));
				}
			}
			rs.close();
			pst.close();

			if (results.size() > 0) {
				return results;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	public static void main(String[] args) {
		 SanPhamDAO dao = new SanPhamDAO();

		// for (SanPham i : dao.getAllSanPham(100000, 600000))
		// System.out.println(i.getTen());
		// for(SanPham i: dao.getSanPhamByLoai("Điện thoại"))
		// System.out.println(i.getTen());
		// System.out.println(dao.getSanPhamByStt(18).getTen());
		// for (SanPham i : dao.searchSanPham("samsung galaxy"))
		// System.out.println(i.getTen());
		// for (SanPham i : dao.getTopSanPham()) {
		// System.out.println(i.getTen());
		// }
		 for (SanPham i : dao.getNewSanPham()) {
		 System.out.println(i.getTen());
		 }

		// SanPham sp = dao.getSanPhamByStt(18);
		// System.out.println(sp);
		// sp.setLuotxem(sp.getLuotxem() + 1);
		// System.out.println(dao.update(sp));

		// System.out.println(dao.delete((long)110));
	}

}
