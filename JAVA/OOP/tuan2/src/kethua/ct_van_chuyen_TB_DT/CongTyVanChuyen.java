package kethua.ct_van_chuyen_TB_DT;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class CongTyVanChuyen implements Serializable{
	private String maSo;
	private String ten;
	private ArrayList<MayTinh> dsMT;
	private ArrayList<DienThoai> dsDT;

	public String getMaSo() {
		return maSo;
	}

	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public ArrayList<MayTinh> getDsMT() {
		return dsMT;
	}

	public void setDsMT(ArrayList<MayTinh> dsMT) {
		this.dsMT = dsMT;
	}

	public ArrayList<DienThoai> getDsDT() {
		return dsDT;
	}

	public void setDsDT(ArrayList<DienThoai> dsDT) {
		this.dsDT = dsDT;
	}

	public CongTyVanChuyen(String maSo, String ten) {
		super();
		this.maSo = maSo;
		this.ten = ten;
		dsMT = new ArrayList<>();
		dsDT = new ArrayList<>();
	}

	public CongTyVanChuyen() {
		super();
		dsMT = new ArrayList<>();
		dsDT = new ArrayList<>();
	}

	public boolean themThietBi(MayTinh mt) {
		for (MayTinh i : dsMT)
			if (i.getMaSo().equals(mt.getMaSo()))
				return false;
		dsMT.add(mt);
		return true;
	}

	public boolean themThietBi(DienThoai dt) {
		for (DienThoai i : dsDT)
			if (i.getMaSo().equals(dt.getMaSo()))
				return false;
		dsDT.add(dt);
		return true;
	}

	public double tongChiPhi() {
		double tong = 0;
		for (MayTinh i : dsMT)
			if (i.getLoaiMay().equals(LoaiMay.XACHTAY.getS()))
				tong = tong + 50000;
			else
				tong = tong + 100000;
		for (DienThoai i : dsDT)
			tong = tong + i.getTrongLuong() * 15000;
		return tong;
	}

	public ArrayList<ThietBiDienTu> filterChiPhiVC(double minCP, double maxCP) {
		ArrayList<ThietBiDienTu> dsTB = new ArrayList<>();
		for (MayTinh i : dsMT)
			if (i.getPhiVanChuyen() >= minCP && i.getPhiVanChuyen() <= maxCP)
				dsTB.add(i);
		for (DienThoai i : dsDT)
			if (i.getPhiVanChuyen() >= minCP && i.getPhiVanChuyen() <= maxCP)
				dsTB.add(i);
		return dsTB;
	}

	public void writeToFile(String fileName, double minCP, double maxCP) throws IOException {
		ArrayList<ThietBiDienTu> dsTB = new ArrayList<ThietBiDienTu>();
		dsTB = filterChiPhiVC(minCP, maxCP);
		
		FileOutputStream f = new FileOutputStream(fileName);
		ObjectOutputStream oot = new ObjectOutputStream(f);
		oot.writeObject(dsTB);

	}

}
