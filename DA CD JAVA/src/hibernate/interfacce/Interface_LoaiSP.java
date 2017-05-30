package hibernate.interfacce;

import java.util.ArrayList;

import hibernate.model.LoaiSanPham;

public interface Interface_LoaiSP  extends CRUD {

	public ArrayList<LoaiSanPham> getAllLoaiSanPham();
	
}
