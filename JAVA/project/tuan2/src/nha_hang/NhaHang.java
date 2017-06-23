package nha_hang;

import java.util.ArrayList;

public class NhaHang {
	private String ten;
	private DiaChi diachi;
	private ArrayList<MonAn> dsMonAn;

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public DiaChi getDiachi() {
		return diachi;
	}

	public void setDiachi(DiaChi diachi) {
		this.diachi = diachi;
	}

	public ArrayList<MonAn> getDsMonAn() {
		return dsMonAn;
	}

	public void setDsMonAn(ArrayList<MonAn> dsMonAn) {
		this.dsMonAn = dsMonAn;
	}

	public NhaHang() {
		super();
		this.ten = "";
		this.diachi = null;
		this.dsMonAn = new ArrayList<MonAn>();
	}

	public NhaHang(String ten, DiaChi diachi) {
		super();
		this.ten = ten;
		this.diachi = diachi;
		this.dsMonAn = new ArrayList<MonAn>();
	}

	public boolean kiemTraMonAnTonTai(String s) {
		for (MonAn i : this.dsMonAn)
			if (s.equals(i.getMota()))
				return true;
		return false;
	}

	public double tinhTien(ArrayList<MonAn> ds) {
		double tongtien = 0;
		for (MonAn i : ds)
			for (MonAn j : dsMonAn)
				if (i.getMaso() == j.getMaso())
					tongtien = tongtien + i.getGia();
		return tongtien;
	}

	@Override
	public String toString() {
		return "NhaHang [ten=" + ten + ", diachi=" + diachi + ", dsMonAn="
				+ dsMonAn + "]";
	}

	public boolean themMonAn(MonAn a) {
		for (MonAn i : this.getDsMonAn())
			if (i.getMaso() == a.getMaso())
				return false;
		this.dsMonAn.add(a);
		return true;
	}

}
