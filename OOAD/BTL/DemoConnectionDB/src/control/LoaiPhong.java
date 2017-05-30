package control;

public enum LoaiPhong {
	CaoCap("Cao cấp"), Thuong("Thường");
	String s;

	LoaiPhong(String str) {
		s = str;
	}

	public String getS() {
		return s;
	}
};