package btl.enums;

public enum DinhDang {
	DD("2D"), DDD("3D"), DDDDX("4DX");
	String s;

	DinhDang(String str) {
		s = str;
	}

	public String getS() {
		return s;
	}
};
