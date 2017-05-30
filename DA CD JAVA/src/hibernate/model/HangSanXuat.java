package hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hangsx")
public class HangSanXuat {
	@Id
	private int stt;
	@Column(name = "mahang")
	private String maHang;
	@Column(name = "tenhang")
	private String tenHang;
	@Column(name = "sttloaisp")
	private String sttloaisp;

	public int getStt() {
		return stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	public String getMaHang() {
		return maHang;
	}

	public void setMaHang(String maHang) {
		this.maHang = maHang;
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}

	public String getSttloaisp() {
		return sttloaisp;
	}

	public void setSttloaisp(String sttloaisp) {
		this.sttloaisp = sttloaisp;
	}

	public HangSanXuat(int stt, String maHang, String tenHang, String sttloaisp) {
		super();
		this.stt = stt;
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.sttloaisp = sttloaisp;
	}

	public HangSanXuat() {
		super();
	}

	@Override
	public String toString() {
		return "HangSanXuat [stt=" + stt + ", maHang=" + maHang + ", tenHang=" + tenHang + ", sttloaisp=" + sttloaisp
				+ "]";
	}

}
