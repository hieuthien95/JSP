package interfacce;

import java.util.ArrayList;

import model.DanhMuc;

public interface Interface_DanhMuc extends CRUD {
	
	public ArrayList<DanhMuc> getAllDanhMuc();

	public ArrayList<DanhMuc> getAllDanhMucByParent(int parent);

	public DanhMuc getDanhMucById(int id);

}
