package khach_san;

import java.util.ArrayList;

public class KhachSan {
	private String ten;
	private String diaChi;
	private String sdt;
	private String email;
	private ArrayList<Phong> dsPhong;

	public ArrayList<Phong> getDsPhong() {
		return dsPhong;
	}

	public void setDsPhong(ArrayList<Phong> dsPhongs) {
		this.dsPhong = dsPhongs;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public KhachSan() {
		super();
		dsPhong = new ArrayList<Phong>();
	}

	public KhachSan(String ten, String diaChi, String sdt, String email) {
		super();
		this.ten = ten;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.email = email;
		dsPhong = new ArrayList<Phong>();
	}

	@Override
	public String toString() {
		return "KhachSan [ten=" + ten + ", diaChi=" + diaChi + ", sdt=" + sdt
				+ ", email=" + email + "]";
	}

	public boolean themPhong(Phong p) {
		for (Phong i : dsPhong)
			if (i.getSoPhong() == p.getSoPhong())
				return false;
		dsPhong.add(p);
		return true;
	}

	public ArrayList<Phong> layDSPhongCoTBTinhPhi() {
		ArrayList<Phong> dstmp = new ArrayList<Phong>();
		for (Phong i : dsPhong)
			if(i.coTinhPhi(i)==true)
				dstmp.add(i); 
		return dstmp;

	}

}
