package kethua.qlsv;

import java.io.Serializable;

public class DiaChi implements Serializable {
	private String tenDuong;
	private String tenQuan;
	private String soNha;

	public String getTenDuong() {
		return tenDuong;
	}

	public void setTenDuong(String tenDuong) {
		this.tenDuong = tenDuong;
	}

	public String getTenQuan() {
		return tenQuan;
	}

	public void setTenQuan(String tenQuan) {
		this.tenQuan = tenQuan;
	}

	public String getSoNha() {
		return soNha;
	}

	public void setSoNha(String soNha) {
		this.soNha = soNha;
	}

	public DiaChi() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DiaChi(String tenDuong, String tenQuan, String soNha) {
		super();
		this.tenDuong = tenDuong;
		this.tenQuan = tenQuan;
		this.soNha = soNha;
	}

	@Override
	public String toString() {
		return "DiaChi [tenDuong=" + tenDuong + ", tenQuan=" + tenQuan + ", soNha=" + soNha + "]";
	}

}
