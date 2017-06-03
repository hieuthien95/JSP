package interfacce;

import java.util.ArrayList;

import model.SanPham;

public interface Interface_SanPham extends CRUD {

	public ArrayList<SanPham> getAllSanPham();

	ArrayList<SanPham> getAllSanPham(int min, int max);

	public ArrayList<SanPham> getSanPhamByLoai(String loai);

	public SanPham getSanPhamByStt(int stt);

	public ArrayList<SanPham> searchSanPham(String keyword);

	public ArrayList<SanPham> getTopSanPham();

	public ArrayList<SanPham> getNewSanPham();
}
