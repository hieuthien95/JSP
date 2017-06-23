package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.DBConnect;
import interfacce.Interface_LoaiSP;
import model.LoaiSanPham;

public class LoaiSanPhamDAO implements Interface_LoaiSP {

	private Connection con;

	public LoaiSanPhamDAO() {
		super();
		con = DBConnect.getInstance();
	}

	@Override
	public boolean insert(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long stt) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<LoaiSanPham> getAllLoaiSanPham() {
		String sql = "SELECT * FROM loaisp ORDER BY stt ASC";

		ArrayList<LoaiSanPham> results = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int stt = rs.getInt(1);
				String tenloai = rs.getString(2);

				results.add(new LoaiSanPham(stt, tenloai));
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
		System.out.println(new LoaiSanPhamDAO().getAllLoaiSanPham());
	}

}
