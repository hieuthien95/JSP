package btl.enums;

public enum TheLoai {
	HANHDONG("Hành động"), KINHDI("Kinh dị"), HAI("Hài"), TINHCAM("Tình cảm"), KHOAHOCVIENTUONG(
			"KH viễn tưởng"), COTRANG("Cổ trang"), HOATHINH("Hoạt hình"), TAMLY("Tâm lý");
	String s;

	TheLoai(String str) {
		s = str;
	}

	public String getS() {
		return s;
	}
};
