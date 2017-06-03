package abs.qlnv;

public class NhanVien {
	private String ten, cmnd;
	private int namSinh;

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public NhanVien(String ten, String cmnd, int namSinh) {
		super();
		this.ten = ten;
		this.cmnd = cmnd;
		this.namSinh = namSinh;
	}

	public NhanVien() {
		super();
	}

//	public double tinhLuong(int gioLDThat){
//		System.out.println("luong nv");
//		return 0;
//	}
	
	//public abstract String toString();
}
