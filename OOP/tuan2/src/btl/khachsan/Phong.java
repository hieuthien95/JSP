package btl.khachsan;

public class Phong {
	private String maPhong;
	private String loaiPhong;
	private int sucChua;
	private double donGia;

	private String tinhTrang;

	public Phong() {
	}

	public Phong(String maPhong, String loaiPhong, int sucChua, double donGia, String tinhTrang) {
		super();
		this.maPhong = maPhong;
		this.loaiPhong = loaiPhong;
		this.sucChua = sucChua;
		this.donGia = donGia;
		this.tinhTrang = tinhTrang;
	}

	public String getMaPhong() {
		return maPhong;
	}

	public String getLoaiPhong() {
		return loaiPhong;
	}

	public int getSucChua() {
		return sucChua;
	}

	public double getDonGia() {
		return donGia;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	@Override
	public String toString() {
		return "Phong [maPhong=" + maPhong + ", loaiPhong=" + loaiPhong + ", sucChua=" + sucChua + ", donGia=" + donGia
				+ ", tinhTrang=" + tinhTrang + "]";
	}

}
