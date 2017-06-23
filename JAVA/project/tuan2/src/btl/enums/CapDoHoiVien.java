package btl.enums;

public enum CapDoHoiVien {
	NORMAL("NORMAL"), VIP("VIP"), VVIP("VVIP");
	String s;

	CapDoHoiVien(String str) {
		s = str;
	}

	public String getS() {
		return s;
	}
};