package hibernate.interfacce;

import java.util.ArrayList;

import hibernate.model.BaiViet;

public interface Interface_BaiViet extends CRUD {

	public ArrayList<BaiViet> getAllBaiViet();

	public ArrayList<BaiViet> getBaiVietByLoai(String loai);

	public BaiViet getBaiVietByStt(int stt);
}
