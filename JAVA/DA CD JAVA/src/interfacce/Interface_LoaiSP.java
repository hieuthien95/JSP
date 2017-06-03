package interfacce;

import java.util.ArrayList;

import model.LoaiSanPham;

public interface Interface_LoaiSP  extends CRUD {

	public ArrayList<LoaiSanPham> getAllLoaiSanPham();
	
}
