package khach_san;

import java.util.ArrayList;

public class Phong {
	private int soPhong;
	private int soGiuong;
	private double giaTheoGio;
	ArrayList<ThietBi> dsThietBi;

	public int getSoPhong() {
		return soPhong;
	}

	public void setSoPhong(int soPhong) {
		this.soPhong = soPhong;
	}

	public int getSoGiuong() {
		return soGiuong;
	}

	public void setSoGiuong(int soGiuong) {
		this.soGiuong = soGiuong;
	}

	public double getGiaTheoGio() {
		return giaTheoGio;
	}

	public void setGiaTheoGio(double giaTheoGio) {
		this.giaTheoGio = giaTheoGio;
	}

	public ArrayList<ThietBi> getDsThietBi() {
		return dsThietBi;
	}

	public void setDsThietBi(ArrayList<ThietBi> dsThietBi) {
		this.dsThietBi = dsThietBi;
	}

	public Phong() {
		super();
		dsThietBi = new ArrayList<ThietBi>();
	}

	public Phong(int soPhong, int soGiuong, double giaTheoGio) {
		super();
		this.soPhong = soPhong;
		this.soGiuong = soGiuong;
		this.giaTheoGio = giaTheoGio;
		dsThietBi = new ArrayList<ThietBi>();
	}

	@Override
	public String toString() {
		return "Phong [soPhong=" + soPhong + ", soGiuong=" + soGiuong
				+ ", giaTheoGio=" + giaTheoGio + ", dsThietBi=" + dsThietBi
				+ "]";
	}
	
	public boolean coTinhPhi(Phong p){
		boolean tp = false;
		for(ThietBi i: dsThietBi)
			if(i.isTinhPhi())
				tp = true;
		return tp;
		
	}

	public double tinhTienPhong(double sogio) {
		double tienphong = sogio * this.getGiaTheoGio();
		if (sogio < 2)
			return tienphong + tienphong * 16 / 100;
		else if (sogio > 2 && sogio <= 8)
			return tienphong * 73 / 100 + tienphong * 16 / 100;
		else if (sogio > 8 && sogio <= 12)
			return tienphong * 60 / 100 + tienphong * 16 / 100;
		else
			return 12 * this.getGiaTheoGio() + (sogio - 12)
					* this.getGiaTheoGio() * 20 / 100 + tienphong * 16 / 100;

	}
}
