package interfacce;

import java.util.ArrayList;

import model.DonHang;

public interface Interface_DonHang extends CRUD {
	public ArrayList<DonHang> getAllDonHang();

	public DonHang getDonHangById(long id);

	public ArrayList<DonHang> getAllDonHangBySdt(String sdt);

}
