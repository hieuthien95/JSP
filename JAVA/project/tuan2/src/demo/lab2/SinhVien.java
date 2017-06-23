package demo.lab2;

public class SinhVien {

	private String ten;
	private int tuoi;
	private DiaChi diaChi;
	private BangDiem diem;
	
	public SinhVien(String ten, int tuoi, DiaChi diaChi, BangDiem diem) {
		super();
		this.ten = ten;
		this.tuoi = tuoi;
		this.diaChi = diaChi;
		this.diem = diem;
	}
	
	public SinhVien(String ten, int tuoi) {
		super();
		this.ten = ten;
		this.tuoi = tuoi;
	}
	
	public SinhVien(String ten, int tuoi, String d, String q, String sn, 
			double t, double l, double h) {
		super();
		this.ten = ten;
		this.tuoi = tuoi;
		this.diaChi = new DiaChi(d, q, sn);
		this.diem = new BangDiem(t, l, h);
	}
	
	public double tinhTongDiemC1() {
		double t = diem.getToan();
		double h = diem.getHoa();
		double l = diem.getLy();
		
		double tong = t + l + h;
		return tong;
	}
	
	public double tinhTongDiemC2() {
		return diem.tinhTong();
	}
	
	public boolean isPassed() {
		return diem.isPassed();
	}
	
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public DiaChi getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(DiaChi diaChi) {
		this.diaChi = diaChi;
	}
	public BangDiem getDiem() {
		return diem;
	}
	public void setDiem(BangDiem diem) {
		this.diem = diem;
	}
	
	
}
