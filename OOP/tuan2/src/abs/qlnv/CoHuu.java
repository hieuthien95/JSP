package abs.qlnv;

public class CoHuu extends NhanVien {
	private double gioTieuChuan;

	public double getGioTieuChuan() {
		return gioTieuChuan;
	}

	public void setGioTieuChuan(double gioTieuChuan) {
		this.gioTieuChuan = gioTieuChuan;
	}

	public CoHuu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CoHuu(String ten, String cmnd, int namSinh, int gioTieuChuan) {
		super(ten, cmnd, namSinh);
		this.gioTieuChuan = gioTieuChuan;
	}

	
	public double tinhLuong(int gioLDThat) {
		System.out.println("luong co huu");
		return 0;
	}

	@Override
	public String toString() {
		return "CoHuu [gioTieuChuan=" + gioTieuChuan + "]";
	}

}
