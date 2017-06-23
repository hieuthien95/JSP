package ct_may_tinh;

enum BanOrTang {
	BAN("ban"), TANG_KEM("Tang kem");

	String s;

	BanOrTang(String str) {
		s = str;
	}

	public String getS() {
		return s;
	}
}

public class PhuKien {
	private String mapk;
	private String tenpk;
	private String banorkemtheo;

	public String getMapk() {
		return mapk;
	}

	public void setMapk(String mapk) {
		this.mapk = mapk;
	}

	public String getTenpk() {
		return tenpk;
	}

	public void setTenpk(String tenpk) {
		this.tenpk = tenpk;
	}

	public String getBanorkemtheo() {
		return banorkemtheo;
	}

	public void setBanorkemtheo(BanOrTang banorkemtheo) {
		this.banorkemtheo = banorkemtheo.getS();
	}

	public PhuKien() {
		super();
		this.mapk = "";
		this.tenpk = "";
		this.banorkemtheo = "";
	}

	public PhuKien(String mapk, String tenpk, BanOrTang banorkemtheo) {
		super();
		this.mapk = mapk;
		this.tenpk = tenpk;
		this.banorkemtheo = banorkemtheo.getS();
	}

	@Override
	public String toString() {
		return "PhuKien [mapk=" + mapk + ", tenpk=" + tenpk + ", banorkemtheo="
				+ banorkemtheo + "]";
	}

}
