package Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import control.AbstractDB;

public class LanThanhToan extends AbstractDB {
	private int maThanhToan;
	private String ngayThanhToan;
	private double soTienPhong;
	private double soTienDV;
	private int maLanThuePhong;

	public LanThanhToan(String ngayThanhToan, double soTienPhong, double soTienDV) {
		super();
		this.ngayThanhToan = ngayThanhToan;
		this.soTienPhong = soTienPhong;
		this.soTienDV = soTienDV;
	}
	
	public LanThanhToan(int maThanhToan, String ngayThanhToan, double soTienPhong, double soTienDV, int maLanThuePhong) {
		super();
		this.maThanhToan=maThanhToan;
		this.ngayThanhToan = ngayThanhToan;
		this.soTienPhong = soTienPhong;
		this.soTienDV = soTienDV;
		this.maLanThuePhong = maLanThuePhong;
	}

	public LanThanhToan() {
		super();
	}

	public int getMaThanhToan() {
		return maThanhToan;
	}

	public String getNgayThanhToan() {
		return ngayThanhToan;
	}

	public double getSoTienPhong() {
		return soTienPhong;
	}

	public double getSoTienDV() {
		return soTienDV;
	}
	
	public int getMaLanThuePhong() {
		return maLanThuePhong;
	}

	@Override
	public String toString() {
		return "LanThanhToan [ngayThanhToan=" + ngayThanhToan + ", soTienPhong=" + soTienPhong + ", soTienDV="
				+ soTienDV + "]";
	}
	
	public ArrayList<LanThanhToan> getDsLanThanhToan() {
		String sql = "SELECT * FROM LanThanhToan";
		Connection cnn = this.condb.getConnect();

		ArrayList<LanThanhToan> result = new ArrayList<LanThanhToan>();
		try {
			PreparedStatement pst = cnn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int maTT = rs.getInt(1);
				String ngayTT = rs.getString(2);
				int tienPhong = rs.getInt(3);
				int tienDV = rs.getInt(4);
				int maLanThuePhong = rs.getInt(5);
				LanThanhToan ltt = new LanThanhToan(maTT, ngayTT, tienPhong, tienDV, maLanThuePhong);
				result.add(ltt);
			}
			rs.close();
			pst.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean themLanThanhToan(LanThanhToan ltt) throws SQLException {
		Connection cnn = this.condb.getConnect();
		String sql = "INSERT INTO LanThanhToan VALUES(?,?,?,?)";

		PreparedStatement pst = cnn.prepareStatement(sql);
		pst.setString(1, ltt.getNgayThanhToan());
		pst.setDouble(2, ltt.getSoTienPhong());
		pst.setDouble(3, ltt.getSoTienDV());
		pst.setInt(4, ltt.getMaLanThuePhong());
		
		pst.executeUpdate();
		System.out.println("Thêm lần thanh toán thành công");

		pst.close();
		cnn.close();

		return true;
	}

}
