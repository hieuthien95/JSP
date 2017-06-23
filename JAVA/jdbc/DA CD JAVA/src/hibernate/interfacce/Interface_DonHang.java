package hibernate.interfacce;

import java.util.ArrayList;

import hibernate.model.DonHang;

public interface Interface_DonHang extends CRUD {
	public ArrayList<DonHang> getAllDonHang();

	public DonHang getDonHangByStt(long sott);
	
	public ArrayList<DonHang> getAllDonHangBySdt(String sdt);
}
