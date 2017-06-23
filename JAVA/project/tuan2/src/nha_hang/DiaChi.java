package nha_hang;

public class DiaChi {
	private String sonha;
	private String tenduong;
	private String tenquan;
	private String tentp;
	
	public String getSonha() {
		return sonha;
	}
	public void setSonha(String sonha) {
		this.sonha = sonha;
	}
	public String getTenduong() {
		return tenduong;
	}
	public void setTenduong(String tenduong) {
		this.tenduong = tenduong;
	}
	public String getTenquan() {
		return tenquan;
	}
	public void setTenquan(String tenquan) {
		this.tenquan = tenquan;
	}
	public String getTentp() {
		return tentp;
	}
	public void setTentp(String tentp) {
		this.tentp = tentp;
	}
	
	public DiaChi() {
		super();
		this.sonha = "";
		this.tenduong = "";
		this.tenquan = "";
		this.tentp = "";
	}
	
	public DiaChi(String sonha, String tenduong, String tenquan, String tentp) {
		super();
		this.sonha = sonha;
		this.tenduong = tenduong;
		this.tenquan = tenquan;
		this.tentp = tentp;
	}
	
	@Override
	public String toString() {
		return "DiaChi [sonha=" + sonha + ", tenduong=" + tenduong + ", tenquan=" + tenquan + ", tentp=" + tentp + "]";
	}	
}
