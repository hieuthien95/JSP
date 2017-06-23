package interfacce;

import java.util.ArrayList;

import interfacce.CRUD;
import model.HinhAnh;

public interface Interface_HinhAnh extends CRUD {
	public ArrayList<HinhAnh> getAllHinhAnh();
	
	public HinhAnh getHinhAnhById(int id);

	public ArrayList<HinhAnh> getAllHinhAnhByIdSP(int idSP);

}
