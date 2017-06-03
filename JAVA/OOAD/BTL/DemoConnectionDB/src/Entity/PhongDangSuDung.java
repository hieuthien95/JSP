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

public class PhongDangSuDung extends AbstractDB {
	private String maPhongThue;
	private String ngayBatDau;
	private String ngayKetThuc;
	private long cmnd;

	public String getMaPhongThue() {
		return maPhongThue;
	}

	public void setMaPhongThue(String maPhongThue) {
		this.maPhongThue = maPhongThue;
	}

	public String getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(String ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public String getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(String ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public long getCmnd() {
		return cmnd;
	}

	public void setCmnd(long cmnd) {
		this.cmnd = cmnd;
	}

	public PhongDangSuDung() {
		super();
	}

	public PhongDangSuDung(String maPhongThue, String ngayBatDau, String ngayKetThuc, long cmnd) {
		super();
		this.maPhongThue = maPhongThue;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.cmnd = cmnd;
	}

	@Override
	public String toString() {
		return "PhongDangSuDung [maPhongThue=" + maPhongThue + ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc="
				+ ngayKetThuc + ", cmnd=" + cmnd + "]";
	}
	
	public ArrayList<PhongDangSuDung> getDsPhongDangSuDung() {
		String sql = "SELECT * FROM PhongDangSuDung";
		Connection cnn = this.condb.getConnect();

		ArrayList<PhongDangSuDung> result = new ArrayList<PhongDangSuDung>();
		try {
			PreparedStatement pst = cnn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String maPhongThue = rs.getString(1);
				String ngayBatDau = rs.getString(2);
				String ngayKetThuc = rs.getString(3);
				long cmnd = rs.getLong(4);
				PhongDangSuDung pdsd = new PhongDangSuDung(maPhongThue, ngayBatDau, ngayKetThuc, cmnd);
				result.add(pdsd);
			}
			rs.close();
			pst.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Collections.sort(result, new Comparator<PhongDangSuDung>() {

			@Override
			public int compare(PhongDangSuDung arg0, PhongDangSuDung arg1) {
				if(arg0.maPhongThue.compareTo(arg1.maPhongThue)==0)
					return arg0.ngayBatDau.compareTo(arg1.ngayBatDau);
				else 
					return arg0.maPhongThue.compareTo(arg1.maPhongThue);
			}
		});
		return result;
	}

	public boolean themPhongDangSuDung(PhongDangSuDung pdsd) throws SQLException {
		Connection cnn = this.condb.getConnect();
		String sql = "INSERT INTO PhongDangSuDung VALUES(?,?,?,?)";

		PreparedStatement pst = cnn.prepareStatement(sql);
		pst.setString(1, pdsd.getMaPhongThue());
		pst.setString(2, pdsd.getNgayBatDau());
		pst.setString(3, pdsd.getNgayKetThuc());
		pst.setLong(4, pdsd.getCmnd());

		pst.executeUpdate();
		System.out.println("Thêm phòng DSD thành công");

		pst.close();
		cnn.close();

		return true;
	}

	public boolean xoaPhongDSDSauThanhToan(String maPhong, String ngayBD) throws SQLException {
		String sql = "DELETE FROM PhongDangSuDung WHERE maphongthue=? AND ngaybatdau=?";
		Connection cnn = this.condb.getConnect();
		try {
			PreparedStatement pst = cnn.prepareStatement(sql);
			pst.setString(1, maPhong);
			pst.setString(2, ngayBD);

			int result = 0;

			if (getDsPhongDangSuDung().size() == 0) {
				JOptionPane.showMessageDialog(null, "CMND không khớp với người đã đặt phòng ngày");
				return false;
			}
			for (PhongDangSuDung i : getDsPhongDangSuDung())
				if (i.getMaPhongThue().equals(maPhong) && i.getNgayBatDau().equals(ngayBD)) {
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

	public boolean huyPhong(String maPhong, Long cmnd, String ngayBD) throws SQLException {
		String sql = "DELETE FROM PhongDangSuDung WHERE maphongthue=? AND cmnd=? AND ngaybatdau=?";
		Connection cnn = this.condb.getConnect();
		try {
			PreparedStatement pst = cnn.prepareStatement(sql);
			pst.setString(1, maPhong);
			pst.setLong(2, cmnd);
			pst.setString(3, ngayBD);

			int result = 0;

			for (PhongDangSuDung i : getDsPhongDangSuDung())
				if (i.getCmnd() == cmnd && i.getMaPhongThue().equals(maPhong)) {
					result = pst.executeUpdate();

					if (result > 0) {
						JOptionPane.showMessageDialog(null, "Hũy phòng " + maPhong + " thành công");
						String sql2 = "DELETE FROM LanThuePhong WHERE maphongthue=? AND ngaybatdau=?";
						PreparedStatement pst2 = cnn.prepareStatement(sql2);
						pst2.setString(1, maPhong);
						pst2.setString(2, ngayBD);
						int result2 = pst2.executeUpdate();
						cnn.close();
						pst.close();
						
						if (result2 > 0)
							return true;
						return false;
					}
					JOptionPane.showMessageDialog(null, "CMND không khớp với người đã đặt phòng ngày");
					return false;
				}
			JOptionPane.showMessageDialog(null, "Hũy phòng " + maPhong + " không thành công");
			cnn.close();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

}
