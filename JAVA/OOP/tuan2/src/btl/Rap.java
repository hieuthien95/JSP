package btl;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import btl.enums.CapDoHoiVien;
import btl.enums.ChucVuNhanVien;
import btl.enums.TheLoai;

public class Rap implements Serializable {
	private ArrayList<Phim> dsPhim = new ArrayList<Phim>();
	private ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
	private ArrayList<HoiVien> dsHoiVien = new ArrayList<HoiVien>();

	private String ten;
	private String sdt;
	private String diaChi;

	public String getTen() {
		return ten;
	}

	public String getSdt() {
		return sdt;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public ArrayList<Phim> getDsPhim() {
		return dsPhim;
	}

	public ArrayList<NhanVien> getDsNhanVien() {
		return dsNhanVien;
	}

	public ArrayList<HoiVien> getDsHoiVien() {
		return dsHoiVien;
	}

	public Rap() {
		super();
		ten = "";
		sdt = "";
		diaChi = "";
		dsPhim = new ArrayList<Phim>();
		dsNhanVien = new ArrayList<NhanVien>();
		dsHoiVien = new ArrayList<HoiVien>();
	}

	public Rap(String ten, String sdt, String diaChi) {
		super();
		this.ten = ten;
		this.sdt = sdt;
		this.diaChi = diaChi;
		dsPhim = new ArrayList<Phim>();
		dsNhanVien = new ArrayList<NhanVien>();
		dsHoiVien = new ArrayList<HoiVien>();
	}

	@Override
	public String toString() {
		return ten + "," + sdt + "," + diaChi;
	}

	// 3
	public boolean themPhim(Phim p) throws IOException, ClassNotFoundException {
		for (Phim i : dsPhim)
			if (p.getMaSo() == i.getMaSo())
				return false;
		dsPhim.add(p);
		return true;
	}

	/*
	 * public boolean themPhimVaoFile(Phim p) throws IOException,
	 * ClassNotFoundException { FileOutputStream fos = new
	 * FileOutputStream("data.txt"); ObjectOutputStream oos = new
	 * ObjectOutputStream(fos); oos.writeObject(p); oos.close(); fos.close();
	 * 
	 * return true;
	 * 
	 * }
	 * 
	 * public boolean themAllPhimTuFile() throws IOException,
	 * ClassNotFoundException { FileInputStream fis = new
	 * FileInputStream("data.txt"); ObjectInputStream ios = new
	 * ObjectInputStream(fis);
	 * 
	 * Phim m = (Phim) ios.readObject();
	 * 
	 * System.out.println(m); dsPhim.add(m);
	 * 
	 * return true; }
	 */

	// 3
	public boolean themNhanVien(NhanVien nv) {
		for (NhanVien i : dsNhanVien)
			if (nv.getCmnd() == i.getCmnd())
				return false;
		dsNhanVien.add(nv);
		return true;
	}

	// 3
	public boolean themHoiVien(HoiVien hv) {
		for (HoiVien i : dsHoiVien)
			if (i.getCmnd() == hv.getCmnd())
				return false;
		dsHoiVien.add(hv);
		return true;
	}

	// 4
	public double tinhLuong(NhanVien nv) {
		return nv.tinhLuong();
	}

	// 5
	public void muaVe(HoiVien hv, Phim p) {
		hv.muaVe(p);
	}
	
	// 5
	public void muaVe(Phim p) {
		p.setDoanhThu(p.getDoanhThu() + p.getGiaVe());
	}

	// 6a
	public ArrayList<Phim> sapXepRatingPhim() {
		Collections.sort(dsPhim, new Comparator<Phim>() {
			@Override
			public int compare(Phim p1, Phim p2) {
				if (p1.getDanhGia() > p2.getDanhGia())
					return -1;
				else if (p1.getDanhGia() == p2.getDanhGia())
					return 0;
				else
					return 1;
			}
		});
		ArrayList<Phim> dstmp = new ArrayList<>();
		for (int i = 0; i < 5; i++)
			dstmp.add(dsPhim.get(i));
		return dstmp;
	}

	// 6b
	public ArrayList<Phim> sapXepDoanhThuPhim() {
		Collections.sort(dsPhim, new Comparator<Phim>() {
			@Override
			public int compare(Phim p1, Phim p2) {
				if (p1.getDoanhThu() > p2.getDoanhThu())
					return -1;
				else if (p1.getDoanhThu() == p2.getDoanhThu())
					return 0;
				else
					return 1;
			}
		});
		ArrayList<Phim> dstmp = new ArrayList<>();
		for (int i = 0; i < 5; i++)
			dstmp.add(dsPhim.get(i));
		return dstmp;
	}

	// 6c
	public ArrayList<Phim> layDSPhimHanhDong() {
		ArrayList<Phim> dsTmp = new ArrayList<Phim>();
		for (Phim i : dsPhim)
			if (i.getTheLoai().equals(TheLoai.HANHDONG.getS()))
				dsTmp.add(i);
		return dsTmp;
	}

	// 6d
	public ArrayList<NhanVien> layDSQuanLy() {
		ArrayList<NhanVien> dsTmp = new ArrayList<NhanVien>();
		for (NhanVien i : dsNhanVien)
			if (i.getChucVuNhanVien().equals(ChucVuNhanVien.QUANLY.getS()))
				dsTmp.add(i);
		return dsTmp;
	}

	// 6e
	public ArrayList<HoiVien> layDSHoiVienVVIP() {
		ArrayList<HoiVien> dsTmp = new ArrayList<HoiVien>();
		for (HoiVien i : dsHoiVien)
			if (i.getCapDoHoiVien().equals(CapDoHoiVien.VVIP.getS()))
				dsTmp.add(i);
		return dsTmp;
	}

	// 7a
	public static ArrayList<Phim> sapXepGiaPhim(ArrayList<Phim> dsp) {
		Collections.sort(dsp, new Comparator<Phim>() {
			@Override
			public int compare(Phim p1, Phim p2) {
				if (p1.getGiaVe() > p2.getGiaVe())
					return 1;
				else if (p1.getGiaVe() == p2.getGiaVe())
					return 0;
				else
					return -1;
			}
		});
		return dsp;
	}

	// 7b
	public static ArrayList<HoiVien> sapXepTangDiemHV(ArrayList<HoiVien> dsHV) {
		Collections.sort(dsHV, new Comparator<HoiVien>() {
			@Override
			public int compare(HoiVien hv1, HoiVien hv2) {
				return -(hv1.getDiemTichLuy() - hv2.getDiemTichLuy());
			}
		});
		return dsHV;
	}
}
