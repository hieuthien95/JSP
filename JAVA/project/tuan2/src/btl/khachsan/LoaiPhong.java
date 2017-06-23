package btl.khachsan;

public enum LoaiPhong {
	CaoCap("Cao Cấp"), Thuong("Thường");
	String s;

	LoaiPhong(String str) {
		s = str;
	}

	public String getS() {
		return s;
	}
};