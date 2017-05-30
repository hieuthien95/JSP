package interfacce;

import java.util.ArrayList;

import model.HinhAnh;

public interface Interface_HinhAnh extends CRUD {
	public ArrayList<HinhAnh> getAllHinhAnh();
	
	public HinhAnh getHinhAnhByStt(int stt);

	public ArrayList<HinhAnh> getAllHinhAnhBySttSP(int sttSP);

}
