package kethua.ql_giang_vien;

public enum HocVi {
	CUNHAN("Cu Nhan"), THACSI("Thac si"), TIENSI("Tien si"), PHOGIAOSU("Pho giao su"), GIAOSU("Giao su");

	String s;

	HocVi(String s) {
		this.s = s;
	}

	String getS() {
		return s;
	}
}
