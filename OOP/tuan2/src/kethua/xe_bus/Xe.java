package kethua.xe_bus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Xe {
	private String soXe;
	private String loaiXe;
	private ArrayList<TaiXe> dsTaiXe;
	private ArrayList<TuyenDuong> dsTuyeDuong;

	public String getSoXe() {
		return soXe;
	}

	public void setSoXe(String soXe) {
		this.soXe = soXe;
	}

	public String getLoaiXe() {
		return loaiXe;
	}

	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}

	public ArrayList<TaiXe> getDsTaiXe() {
		return dsTaiXe;
	}

	public void setDsTaiXe(ArrayList<TaiXe> dsTaiXe) {
		this.dsTaiXe = dsTaiXe;
	}

	public ArrayList<TuyenDuong> getDsTuyeDuong() {
		return dsTuyeDuong;
	}

	public void setDsTuyeDuong(ArrayList<TuyenDuong> dsTuyeDuong) {
		this.dsTuyeDuong = dsTuyeDuong;
	}

	public Xe() {
		super();
		dsTaiXe = new ArrayList<TaiXe>();
		dsTuyeDuong = new ArrayList<TuyenDuong>();
	}

	public Xe(String soXe, String loaiXe) {
		super();
		this.soXe = soXe;
		this.loaiXe = loaiXe;
		dsTaiXe = new ArrayList<TaiXe>();
		dsTuyeDuong = new ArrayList<TuyenDuong>();

	}

	@Override
	public String toString() {
		return "Xe [soXe=" + soXe + ", loaiXe=" + loaiXe + ", dsTaiXe="
				+ dsTaiXe + ", dsTuyeDuong=" + dsTuyeDuong + "]";
	}

	public TuyenDuong layTuyeDuongGiaCaoNhat() {
		TuyenDuong max = dsTuyeDuong.get(0);
		for (TuyenDuong i : dsTuyeDuong)
			if (i.getGiaVe() > max.getGiaVe())
				max = i;
		return max;
	}

	public ArrayList<TuyenDuong> layDSTDGiaNhoHon(double gia) {
		ArrayList<TuyenDuong> dsTmp = new ArrayList<TuyenDuong>();
		for (TuyenDuong i : dsTuyeDuong)
			if (i.getGiaVe() < gia)
				dsTmp.add(i);
		return dsTmp;

	}

	public ArrayList<TuyenDuong> sapXepGiaTuyenDuong() {
		Collections.sort(dsTuyeDuong, new Comparator<TuyenDuong>() {
			@Override
			public int compare(TuyenDuong td1, TuyenDuong td2) {
				if (td1.getGiaVe() > td2.getGiaVe())
					return 1;
				else if (td1.getGiaVe() == td2.getGiaVe())
					return 0;
				else
					return -1;
			}
		});
		return dsTuyeDuong;
	}

	public ArrayList<TuyenDuong> layDSCoDiemBD(String diembd) {
		ArrayList<TuyenDuong> dsTmp = new ArrayList<TuyenDuong>();
		for (TuyenDuong i : dsTuyeDuong)
			if (i.getDiemBatDau().equals(diembd))
				dsTmp.add(i);
		return dsTmp;
	}
	
	// public ArrayList<TuyenDuong> sapXepGiaTuyenDuong() {
	// return TuyenDuong.sapXepGiaTuyenDuong();
	// }
}
