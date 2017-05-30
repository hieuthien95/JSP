package kethua.ql_giang_vien;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

@SuppressWarnings("deprecation")
public class QuanLyGiangVien implements Serializable {
	ArrayList<GiangVien> dsGiangVien;

	public ArrayList<GiangVien> getDsGiangVien() {
		return dsGiangVien;
	}

	public QuanLyGiangVien() {
		super();
		dsGiangVien = new ArrayList<>();
	}

	// 2
	public boolean themGiangVien(GiangVien gv) {
		for (GiangVien i : dsGiangVien)
			if (i.getMaSo().equals(gv.getMaSo()))
				return false;
		dsGiangVien.add(gv);
		return true;
	}

	// 7
	public ArrayList<GiangVien> layDSThinhGiangTS1() {
		ArrayList<GiangVien> dsGVTG = new ArrayList<>();
		Calendar cl = Calendar.getInstance();
		for (GiangVien i : dsGiangVien)
			if (i instanceof ThinhGiang)
				if (i.getHocVi().equals(HocVi.TIENSI.getS()) || i.getHocVi().equals(HocVi.GIAOSU.getS())
						|| i.getHocVi().equals(HocVi.PHOGIAOSU.getS()))
					if (cl.get(Calendar.YEAR) - (i.getNgayVaoTruong().getYear() + 1900) >= 1)
						dsGVTG.add(i);
		return dsGVTG;
	}

	// 8
	public ArrayList<GiangVien> layDSBanCoHuuThS3() {
		ArrayList<GiangVien> dsGVBCH = new ArrayList<>();
		Calendar cl = Calendar.getInstance();
		for (GiangVien i : dsGiangVien)
			if (i instanceof BanCoHuu)
				if (i.getHocVi().equals(HocVi.THACSI.getS()) || i.getHocVi().equals(HocVi.TIENSI.getS())
						|| i.getHocVi().equals(HocVi.GIAOSU.getS()) || i.getHocVi().equals(HocVi.PHOGIAOSU.getS()))
					if (cl.get(Calendar.YEAR) - (i.getNgayVaoTruong().getYear() + 1900) >= 3)
						dsGVBCH.add(i);
		return dsGVBCH;
	}

	// 9
	public ArrayList<GiangVien> layDSCoHuuNoThS() {
		ArrayList<GiangVien> dsGVCH = new ArrayList<>();
		for (GiangVien i : dsGiangVien)
			if (i instanceof CoHuu)
				if (i.getHocVi().equals(HocVi.CUNHAN.getS()))
					dsGVCH.add(i);
		return dsGVCH;
	}

	// 10
	public ArrayList<GiangVien> layDSThacSi() {
		ArrayList<GiangVien> dsTS = new ArrayList<>();
		for (GiangVien i : dsGiangVien)
			if (i.getHocVi().equals(HocVi.THACSI.getS()) || i.getHocVi().equals(HocVi.TIENSI.getS())
					|| i.getHocVi().equals(HocVi.GIAOSU.getS()) || i.getHocVi().equals(HocVi.PHOGIAOSU.getS()))
				dsTS.add(i);
		return dsTS;
	}

	// 11
	public ArrayList<GiangVien> layDSThacSiCoHuuN() {
		ArrayList<GiangVien> dsTSCHN = new ArrayList<>();
		for (GiangVien i : dsGiangVien)
			if (i instanceof CoHuu)
				if (i.getHocVi().equals(HocVi.THACSI.getS()) || i.getHocVi().equals(HocVi.TIENSI.getS())
						|| i.getHocVi().equals(HocVi.GIAOSU.getS()) || i.getHocVi().equals(HocVi.PHOGIAOSU.getS()))
					if (i.getTen().charAt(0) == 'N')
						dsTSCHN.add(i);
		return dsTSCHN;
	}

	// 12
	public ArrayList<GiangVien> sapXepCoHuuTheoLuong() {
		ArrayList<GiangVien> dsCH = new ArrayList<>();
		for (GiangVien i : dsGiangVien)
			if (i instanceof CoHuu)
				dsCH.add(i);

		Collections.sort(dsCH, new Comparator<GiangVien>() {
			@Override
			public int compare(GiangVien gv1, GiangVien gv2) {
				return (int) (((CoHuu) gv1).tinhLuong() - ((CoHuu) gv2).tinhLuong());
			}
		});
		return dsCH;
	}

	// 14
	public ArrayList<GiangVien> layDSCoHuu10() {
		ArrayList<GiangVien> dsCH = new ArrayList<>();
		Calendar cl = Calendar.getInstance();
		for (GiangVien i : dsGiangVien)
			if (i instanceof CoHuu)
				if (cl.get(Calendar.YEAR) - (i.getNgayVaoTruong().getYear() + 1900) >= 10)
					dsCH.add(i);
		return dsCH;

	}

	// 17
	public ArrayList<GiangVien> layDSKhongHoanThanh(int nghiavu, int nghiencuu) {
		ArrayList<GiangVien> dsgv = new ArrayList<>();
		for (GiangVien i : dsGiangVien)
			if (!i.ktHoanThanhNV(nghiavu, nghiencuu))
				dsgv.add(i);
		return dsgv;
	}

	// 18
	public void writeToFile() throws FileNotFoundException, IOException {
		ArrayList<GiangVien> dsGV = new ArrayList<GiangVien>();
		ArrayList<GiangVien> dsTmp = new ArrayList<GiangVien>();
		dsTmp = layDSThacSiCoHuuN();

		for (GiangVien i : dsTmp)
			dsGV.add(i);

		dsTmp = sapXepCoHuuTheoLuong();

		for (GiangVien i : dsTmp)
			dsGV.add(i);

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("input"));
		oos.writeObject(dsGV);
	}

}
