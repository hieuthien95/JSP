package btl.khachsan;

public class KhachTro {
	private String maKhach;
	private String hoTen;
	private long cmnd;
	private String diaChi;
	private String quocTich;

	public KhachTro() {
		super();
	}

	public KhachTro(String maKhach, String hoTen, long cmnd, String diaChi, String quocTich) {
		super();
		this.maKhach = maKhach;
		this.hoTen = hoTen;
		this.cmnd = cmnd;
		this.diaChi = diaChi;
		this.quocTich = quocTich;
	}

	public String getMaKhach() {
		return maKhach;
	}

	public String getHoTen() {
		return hoTen;
	}

	public long getCmnd() {
		return cmnd;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public String getQuocTich() {
		return quocTich;
	}

	@Override
	public String toString() {
		return "KhachTro [maKhach=" + maKhach + ", hoTen=" + hoTen + ", cmnd=" + cmnd + ", diaChi=" + diaChi
				+ ", quocTich=" + quocTich + "]";
	}

}
