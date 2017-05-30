package interfacce;

import java.util.ArrayList;

import model.BaiViet;

public interface Interface_BaiViet extends CRUD {

	public ArrayList<BaiViet> getAllBaiViet();

	public ArrayList<BaiViet> getBaiVietByLoai(String loai);

	public BaiViet getBaiVietById(int id);
}
