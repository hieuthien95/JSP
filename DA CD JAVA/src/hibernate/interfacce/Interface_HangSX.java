package hibernate.interfacce;

import java.util.ArrayList;

import hibernate.model.HangSanXuat;

public interface Interface_HangSX extends CRUD {

	public ArrayList<HangSanXuat> getAllHangSX();

	public HangSanXuat getHangSXByStt(int stt);

}
