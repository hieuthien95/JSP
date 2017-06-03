package btl.khachsan;

import java.util.Date;

public class LanThanhToan {
	private Date ngayThanhToan;
	private double soTienPhong;
	private double soTienDV;

	public LanThanhToan(Date ngayThanhToan, double soTienPhong, double soTienDV) {
		super();
		this.ngayThanhToan = ngayThanhToan;
		this.soTienPhong = soTienPhong;
		this.soTienDV = soTienDV;
	}

	public LanThanhToan() {
		super();
	}

	public Date getNgayThanhToan() {
		return ngayThanhToan;
	}

	public double getSoTienPhong() {
		return soTienPhong;
	}

	public double getSoTienDV() {
		return soTienDV;
	}

	@Override
	public String toString() {
		return "LanThanhToan [ngayThanhToan=" + ngayThanhToan + ", soTienPhong=" + soTienPhong + ", soTienDV="
				+ soTienDV + "]";
	}

}
