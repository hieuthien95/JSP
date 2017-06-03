package btl.khachsan;

public enum TinhTrangPhong {
	Con("Còn"), Het("Hết");
	String s;

	TinhTrangPhong(String str) {
		s = str;
	}

	public String getS() {
		return s;
	}
};