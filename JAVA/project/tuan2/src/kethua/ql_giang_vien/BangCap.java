package kethua.ql_giang_vien;

public class BangCap {
	private String tenTruongCap;
	private String hocVi;
	private int namCap;

	public String getTenTruongCap() {
		return tenTruongCap;
	}

	public void setTenTruongCap(String tenTruongCap) {
		this.tenTruongCap = tenTruongCap;
	}

	public String getHocVi() {
		return hocVi;
	}

	public void setHocVi(String hocVi) {
		this.hocVi = hocVi;
	}

	public int getNamCap() {
		return namCap;
	}

	public void setNamCap(int namCap) {
		this.namCap = namCap;
	}

	public BangCap() {
		super();
	}

	public BangCap(String tenTruongCap, String hocVi, int namCap) {
		super();
		this.tenTruongCap = tenTruongCap;
		this.hocVi = hocVi;
		this.namCap = namCap;
	}

	@Override
	public String toString() {
		return "BangCap [tenTruongCap=" + tenTruongCap + ", hocVi=" + hocVi + ", namCap=" + namCap + "]";
	}

}
