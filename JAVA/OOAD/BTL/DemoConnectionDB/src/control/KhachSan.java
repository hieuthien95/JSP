package control;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

import Entity.LanThanhToan;
import Entity.LanThuePhong;
import Entity.Phong;
import Entity.PhongDangSuDung;

public class KhachSan extends AbstractDB {

	public KhachSan() {
	}

	public boolean datPhong(long cmnd, String maPhong, String ngayBD, String ngayKT)
			throws SQLException, ParseException {
		PhongDangSuDung pdsd = new PhongDangSuDung();
		LanThuePhong ltp = new LanThuePhong();

		final SimpleDateFormat sdf_ddMMyy = new SimpleDateFormat("hh:mm aa dd/MM/yy");

		if (sdf_ddMMyy.parse(ngayBD).compareTo(sdf_ddMMyy.parse(ngayKT)) >= 0) {
			JOptionPane.showMessageDialog(null, "Nhập ngày sai");
			return false;
		}

		ArrayList<Date> dsXemNgayBD = new ArrayList<Date>();
		for (PhongDangSuDung i : pdsd.getDsPhongDangSuDung())
			if (i.getMaPhongThue().equals(maPhong))
				dsXemNgayBD.add(sdf_ddMMyy.parse(i.getNgayBatDau()));

		if (dsXemNgayBD.size() == 0) {
			ltp.themLanThuePhong(new LanThuePhong(maPhong, ngayBD, ngayKT, cmnd));
			pdsd.themPhongDangSuDung(new PhongDangSuDung(maPhong, ngayBD, ngayKT, cmnd));
			JOptionPane.showMessageDialog(null, "Đặt thành công" + "\nCMND khách hàng: " + cmnd + "\nPhòng: " + maPhong
					+ "\nNgày bắt đầu: " + ngayBD + "\nNgày kết thúc: " + ngayKT);
			return true;
		}

		for (PhongDangSuDung i : pdsd.getDsPhongDangSuDung()) {
			if (i.getMaPhongThue().equals(maPhong))
				if (ngayBD.compareTo(i.getNgayBatDau()) == 0 || ngayKT.compareTo(i.getNgayKetThuc()) == 0
						|| ngayKT.compareTo(i.getNgayBatDau()) == 0 || ngayBD.compareTo(i.getNgayKetThuc()) == 0) {
					JOptionPane.showMessageDialog(null, "Có lịch làm gián đoạn 1");
					return false;
				} else if (sdf_ddMMyy.parse(ngayBD).compareTo(sdf_ddMMyy.parse(i.getNgayBatDau())) > 0
						&& sdf_ddMMyy.parse(ngayBD).compareTo(sdf_ddMMyy.parse(i.getNgayKetThuc())) < 0
						|| sdf_ddMMyy.parse(ngayKT).compareTo(sdf_ddMMyy.parse(i.getNgayBatDau())) > 0
								&& sdf_ddMMyy.parse(ngayKT).compareTo(sdf_ddMMyy.parse(i.getNgayKetThuc())) < 0) {
					JOptionPane.showMessageDialog(null, "Có lịch làm gián đoạn 2");
					return false;
				}
		}

		Date maxBD = sdf_ddMMyy.parse("00:00 AM 01/01/2000");
		Date minKT = sdf_ddMMyy.parse("00:00 AM 01/01/2025");

		for (PhongDangSuDung i : pdsd.getDsPhongDangSuDung())
			if (i.getMaPhongThue().equals(maPhong)) {
				if (sdf_ddMMyy.parse(i.getNgayKetThuc()).compareTo(maxBD) > 0
						&& sdf_ddMMyy.parse(i.getNgayKetThuc()).compareTo(sdf_ddMMyy.parse(ngayBD)) < 0)
					maxBD = sdf_ddMMyy.parse(i.getNgayKetThuc());
				if (sdf_ddMMyy.parse(i.getNgayBatDau()).compareTo(minKT) < 0
						&& sdf_ddMMyy.parse(i.getNgayBatDau()).compareTo(sdf_ddMMyy.parse(ngayBD)) > 0)
					minKT = sdf_ddMMyy.parse(i.getNgayBatDau());
			}

		System.out.println(maxBD + "   -   " + minKT);
		if (sdf_ddMMyy.parse(ngayBD).compareTo(maxBD) > 0 && sdf_ddMMyy.parse(ngayKT).compareTo(minKT) < 0) {
			ltp.themLanThuePhong(new LanThuePhong(maPhong, ngayBD, ngayKT, cmnd));
			pdsd.themPhongDangSuDung(new PhongDangSuDung(maPhong, ngayBD, ngayKT, cmnd));
			JOptionPane.showMessageDialog(null, "Đặt thành công" + "\nCMND khách hàng: " + cmnd + "\nPhòng: " + maPhong
					+ "\nNgày bắt đầu: " + ngayBD + "\nNgày kết thúc: " + ngayKT);
			return true;
		}

		JOptionPane.showMessageDialog(null, "Có lịch làm gián đoạn 3");

		return false;
	}
	
	public boolean kiemTra(String maPhong, String ngayBD, String ngayKT)
			throws SQLException, ParseException {
		PhongDangSuDung pdsd = new PhongDangSuDung();
		LanThuePhong ltp = new LanThuePhong();

		final SimpleDateFormat sdf_ddMMyy = new SimpleDateFormat("hh:mm aa dd/MM/yy");

		if (sdf_ddMMyy.parse(ngayBD).compareTo(sdf_ddMMyy.parse(ngayKT)) >= 0) {
			JOptionPane.showMessageDialog(null, "Nhập ngày sai");
			return false;
		}

		ArrayList<Date> dsXemNgayBD = new ArrayList<Date>();
		for (PhongDangSuDung i : pdsd.getDsPhongDangSuDung())
			if (i.getMaPhongThue().equals(maPhong))
				dsXemNgayBD.add(sdf_ddMMyy.parse(i.getNgayBatDau()));

		if (dsXemNgayBD.size() == 0) {
			JOptionPane.showMessageDialog(null, "Có thể đặt phòng này");
			return true;
		}

		for (PhongDangSuDung i : pdsd.getDsPhongDangSuDung()) {
			if (i.getMaPhongThue().equals(maPhong))
				if (ngayBD.compareTo(i.getNgayBatDau()) == 0 || ngayKT.compareTo(i.getNgayKetThuc()) == 0
						|| ngayKT.compareTo(i.getNgayBatDau()) == 0 || ngayBD.compareTo(i.getNgayKetThuc()) == 0) {
					JOptionPane.showMessageDialog(null, "Có lịch làm gián đoạn 1");
					return false;
				} else if (sdf_ddMMyy.parse(ngayBD).compareTo(sdf_ddMMyy.parse(i.getNgayBatDau())) > 0
						&& sdf_ddMMyy.parse(ngayBD).compareTo(sdf_ddMMyy.parse(i.getNgayKetThuc())) < 0
						|| sdf_ddMMyy.parse(ngayKT).compareTo(sdf_ddMMyy.parse(i.getNgayBatDau())) > 0
								&& sdf_ddMMyy.parse(ngayKT).compareTo(sdf_ddMMyy.parse(i.getNgayKetThuc())) < 0) {
					JOptionPane.showMessageDialog(null, "Có lịch làm gián đoạn 2");
					return false;
				}
		}

		Date maxBD = sdf_ddMMyy.parse("00:00 AM 01/01/2000");
		Date minKT = sdf_ddMMyy.parse("00:00 AM 01/01/2025");

		for (PhongDangSuDung i : pdsd.getDsPhongDangSuDung())
			if (i.getMaPhongThue().equals(maPhong)) {
				if (sdf_ddMMyy.parse(i.getNgayKetThuc()).compareTo(maxBD) > 0
						&& sdf_ddMMyy.parse(i.getNgayKetThuc()).compareTo(sdf_ddMMyy.parse(ngayBD)) < 0)
					maxBD = sdf_ddMMyy.parse(i.getNgayKetThuc());
				if (sdf_ddMMyy.parse(i.getNgayBatDau()).compareTo(minKT) < 0
						&& sdf_ddMMyy.parse(i.getNgayBatDau()).compareTo(sdf_ddMMyy.parse(ngayBD)) > 0)
					minKT = sdf_ddMMyy.parse(i.getNgayBatDau());
			}

		System.out.println(maxBD + "   -   " + minKT);
		if (sdf_ddMMyy.parse(ngayBD).compareTo(maxBD) > 0 && sdf_ddMMyy.parse(ngayKT).compareTo(minKT) < 0) {
			JOptionPane.showMessageDialog(null, "Có thể đặt phòng này");
			return true;
		}

		JOptionPane.showMessageDialog(null, "Có lịch làm gián đoạn 3");

		return false;
	}

	public double thanhToan(String maPhong, String ngayDat, double tienDV, int thoiGianThue, int maLanThuePhong)
			throws SQLException, ParseException {
		PhongDangSuDung pdsd = new PhongDangSuDung();
		Phong p = new Phong();
		LanThanhToan ltt = new LanThanhToan();

		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);

		for (PhongDangSuDung i : pdsd.getDsPhongDangSuDung())
			if (i.getMaPhongThue().equals(maPhong) && i.getNgayBatDau().equals(ngayDat)) {
				double tienPhong = 0;
				for (Phong j : p.getDsPhong()) {
					if (j.getMaPhong().equals(maPhong)) {
						tienPhong = thoiGianThue * j.getDonGia();

						String ngayThanhToan = hour + ":" + minute + " " + day + "/" + (month + 1) + "/" + year;

						ltt.themLanThanhToan(new LanThanhToan(ngayThanhToan, tienPhong, tienDV));
						pdsd.xoaPhongDSDSauThanhToan(maPhong, i.getNgayBatDau());

						double tien = tienPhong + tienDV;

						JOptionPane.showMessageDialog(null,
								"Thanh toán thành công" + "\nPhòng: " + i.getMaPhongThue() + "\nCMND khách hàng: "
										+ i.getCmnd() + "\nNgày bắt đầu: " + i.getNgayBatDau() + "\nNgày kết thúc: "
										+ i.getNgayKetThuc() + "\nTiền phòng: " + tienPhong + "\nTiền DV: " + tienDV);
						return tien;
					}

				}
			}
		System.out.println("Thanh toán không thành công");
		return 0;
	}

	@SuppressWarnings("deprecation")
	public ArrayList<LanThanhToan> thongKeTienPhong(int thang, int nam) throws ParseException {
		LanThanhToan ltt = new LanThanhToan();
		ArrayList<LanThanhToan> dsLtt = new ArrayList<>();
		
		SimpleDateFormat hhmm_ddMMyy = new SimpleDateFormat("hh:mm dd/MM/yy");
		Date time = null;
		for (LanThanhToan i : ltt.getDsLanThanhToan()) {
			time = hhmm_ddMMyy.parse(i.getNgayThanhToan());
			System.out.println(time.getYear());
			if (time.getMonth() + 1 == thang && time.getYear() + 1900 == nam)
				dsLtt.add(i);
		}
		return dsLtt;
	}

}
