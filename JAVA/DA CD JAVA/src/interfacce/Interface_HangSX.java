package interfacce;

import java.util.ArrayList;

import model.HangSanXuat;

public interface Interface_HangSX extends CRUD {

	public ArrayList<HangSanXuat> getAllHangSX();

	public HangSanXuat getHangSXByStt(int stt);

}
