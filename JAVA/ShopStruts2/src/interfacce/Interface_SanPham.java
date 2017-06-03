package interfacce;

import java.util.ArrayList;

import model.SanPham;

public interface Interface_SanPham extends CRUD {
	
	public ArrayList<SanPham> getAllSanPham();

	public ArrayList<SanPham> getSanPhamByLoai(String loai);

	public SanPham getSanPhamById(int id);

	public ArrayList<SanPham> searchSanPham(String keyword);

	public ArrayList<SanPham> getAllTopSanPham();

	public ArrayList<SanPham> getNewSanPham();

	ArrayList<SanPham> getAllSanPham(int min, int max);
}
