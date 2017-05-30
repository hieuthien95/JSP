package abs.qlnv;

public class HopDong extends NhanVien {
	private double thuLaoTheoGio;

	public double getThuLaoTheoGio() {
		return thuLaoTheoGio;
	}

	public void setThuLaoTheoGio(double thuLaoTheoGio) {
		this.thuLaoTheoGio = thuLaoTheoGio;
	}

	public HopDong(String ten, String cmnd, int namSinh, double thuLaoTheoGio) {
		super(ten, cmnd, namSinh);
		this.thuLaoTheoGio = thuLaoTheoGio;
	}

	public HopDong() {
		super();
	}

	@Override
	public String toString() {
		return "HopDong [thuLaoTheoGio=" + thuLaoTheoGio + "]";
	}

	
	public double tinhLuong(int gioLDThat) {
		System.out.println("luong hop dong");
		return 0;
	}
	
	

}
