package btl.enums;

public enum ChucVuNhanVien {
	NHANVIEN("Nhân viên"), QUANLY("Quản lý"), GIAMDOC("Giám đốc");
	String s;

	ChucVuNhanVien(String str) {
		s = str;
	}

	public String getS() {
		return s;
	}
};