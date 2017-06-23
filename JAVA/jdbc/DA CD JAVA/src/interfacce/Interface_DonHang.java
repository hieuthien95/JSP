package interfacce;

import java.util.ArrayList;

import model.DonHang;

public interface Interface_DonHang extends CRUD {
	public ArrayList<DonHang> getAllDonHang();

	public DonHang getDonHangByStt(int sott);
	
	public ArrayList<DonHang> getAllDonHangBySdt(String sdt);
}
