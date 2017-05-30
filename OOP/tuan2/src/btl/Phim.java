package btl;

import java.io.Serializable;
import java.util.ArrayList;

public class Phim implements Serializable {

	private int maSo;
	private String ten;
	private int danhGia;
	private int thoiLuong;
	private String moTa;
	private double giaVe;
	private double doanhThu;
	private ArrayList<String> dsTheLoai;
	private String dinhDang;

	public int getMaSo() {
		return maSo;
	}

	public String getTen() {
		return ten;
	}

	public int getDanhGia() {
		return danhGia;
	}

	public int getThoiLuong() {
		return thoiLuong;
	}

	public String getMoTa() {
		return moTa;
	}

	public double getGiaVe() {
		return giaVe;
	}

	public double getDoanhThu() {
		return doanhThu;
	}

	public void setDoanhThu(double doanhThu) {
		this.doanhThu = doanhThu;
	}

	public ArrayList<String> getTheLoai() {
		return dsTheLoai;
	}

	public String getDinhDang() {
		return dinhDang;
	}

	public Phim() {
		super();
		maSo = 0;
		ten = "";
		danhGia = 0;
		thoiLuong = 1;
		moTa = "";
		giaVe = 0;
		doanhThu = 0;
		dsTheLoai = new ArrayList<>();
		dinhDang = "";
	}

	public Phim(int maSo, String ten, int danhGia, int thoiLuong, String moTa, double giaVe, double doanhThu,
			ArrayList<String> aDsTheLoai, String dinhDang) {
		super();
		this.maSo = maSo;
		this.ten = ten;
		this.danhGia = danhGia;
		this.thoiLuong = thoiLuong;
		this.moTa = moTa;
		this.giaVe = giaVe;
		this.doanhThu = doanhThu;
		dsTheLoai = new ArrayList<>();
		this.dsTheLoai = aDsTheLoai;
		this.dinhDang = dinhDang;
	}

	public Phim(int maSo, String ten, int danhGia, int thoiLuong, String moTa, double giaVe,
			ArrayList<String> aDsTheLoai, String dinhDang) {
		super();
		this.maSo = maSo;
		this.ten = ten;
		this.danhGia = danhGia;
		this.thoiLuong = thoiLuong;
		this.moTa = moTa;
		this.giaVe = giaVe;
		this.doanhThu = 0;
		dsTheLoai = new ArrayList<>();
		this.dsTheLoai = aDsTheLoai;
		this.dinhDang = dinhDang;
	}

	@Override
	public String toString() {
		return maSo + "," + ten + "," + giaVe + "," + danhGia + "," + doanhThu + "," + dsTheLoai + "," + dinhDang;

	}

}
