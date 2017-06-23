package Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LanThuePhong extends PhongDangSuDung {
	private int maLanThuePhong;
	private String maPhongThue;
	private String ngayBatDau;
	private String ngayKetThuc;
	private long cmnd;
	private ArrayList<KhachTro> dsThanhVien;

	public int getMaLanThuePhong() {
		return maLanThuePhong;
	}

	public String getMaPhongThue() {
		return super.getMaPhongThue();
	}

	public String getNgayBatDau() {
		return super.getNgayBatDau();
	}

	public String getNgayKetThuc() {
		return super.getNgayKetThuc();
	}

	public long getCmnd() {
		return super.getCmnd();
	}

	public ArrayList<KhachTro> getDsThanhVien() {
		return dsThanhVien;
	}

	public LanThuePhong() {
		super();
	}

	public LanThuePhong(String maPhongThue, String ngayBatDau, String ngayKetThuc, long cmnd) {
		super(maPhongThue, ngayBatDau, ngayKetThuc, cmnd);
	}
	
	public LanThuePhong(int maLanThuePhong, String maPhongThue, String ngayBatDau, String ngayKetThuc, long cmnd) {
		super(maPhongThue, ngayBatDau, ngayKetThuc, cmnd);
		this.maLanThuePhong = maLanThuePhong;
	}

	@Override
	public String toString() {
		return "LanThuePhong [maPhongThue=" + maPhongThue + ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc="
				+ ngayKetThuc + ", cmnd=" + cmnd + ", dsThanhVien=" + dsThanhVien + "]";
	}
	
	public ArrayList<LanThuePhong> getDsLanThuePhong() {
		String sql = "SELECT * FROM LanThuePhong";
		Connection cnn = this.condb.getConnect();

		ArrayList<LanThuePhong> result = new ArrayList<LanThuePhong>();
		try {
			PreparedStatement pst = cnn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int maThuePhong = rs.getInt(1);
				String maPhongThue = rs.getString(2);
				String ngayBatDau = rs.getString(3);
				String ngayKetThuc = rs.getString(4);
				long cmnd = rs.getLong(5);
				LanThuePhong ltp = new LanThuePhong(maThuePhong, maPhongThue, ngayBatDau, ngayKetThuc, cmnd);
				result.add(ltp);
			}
			rs.close();
			pst.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean themLanThuePhong(LanThuePhong ltp) throws SQLException {
		Connection cnn = this.condb.getConnect();
		String sql = "INSERT INTO LanThuePhong VALUES(?,?,?,?)";

		PreparedStatement pst = cnn.prepareStatement(sql);
		pst.setString(1, ltp.getMaPhongThue());
		pst.setString(2, ltp.getNgayBatDau());
		pst.setString(3, ltp.getNgayKetThuc());
		pst.setLong(4, ltp.getCmnd());

		pst.executeUpdate();
		System.out.println("Thêm lần thuê phòng thành công");

		pst.close();
		cnn.close();

		return true;
	}

	public boolean huyLanThuePhong(String maPhong, String ngayBD) throws SQLException {		
		String sql = "DELETE FROM LanThuePhong WHERE maphongthue=? AND ngaybatdau=?";
		Connection cnn = this.condb.getConnect();
		try {
			PreparedStatement pst = cnn.prepareStatement(sql);
			pst.setString(1, maPhong);
			pst.setString(2, ngayBD);

			int result = 0;

			for (LanThuePhong i : getDsLanThuePhong())
				if (i.getMaPhongThue().equals(maPhong)) {
					result = pst.executeUpdate();

					cnn.close();
					pst.close();

					return result > 0;
				}
			cnn.close();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}


}
