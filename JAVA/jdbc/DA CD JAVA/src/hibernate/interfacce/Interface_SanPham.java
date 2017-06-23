package hibernate.interfacce;

import java.util.ArrayList;

import hibernate.model.SanPham;

public interface Interface_SanPham extends CRUD {
	public ArrayList<SanPham> getAllSanPham();

	public ArrayList<SanPham> getSanPhamByLoai(String loai);

	public SanPham getSanPhamByStt(int stt);

	public ArrayList<SanPham> searchSanPham(String keyword);

	public ArrayList<SanPham> getTopSanPham();

	public ArrayList<SanPham> getNewSanPham();

	ArrayList<SanPham> getAllSanPham(int min, int max);
}
