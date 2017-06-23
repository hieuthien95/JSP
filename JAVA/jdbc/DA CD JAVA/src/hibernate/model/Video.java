package hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "video")
public class Video {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stt;
	@Column(name = "ten")
	private String ten;
	@Column(name = "hinhanh")
	private String hinhanh;
	@Column(name = "trangthai")
	private int trangthai;
	@Column(name = "duongdan")
	private String duongdan;
	@Column(name = "noidung")
	private String noidung;

	public Video(int stt, String ten, String hinhanh, int trangthai, String duongdan, String noidung) {
		super();
		this.stt = stt;
		this.ten = ten;
		this.hinhanh = hinhanh;
		this.trangthai = trangthai;
		this.duongdan = duongdan;
		this.noidung = noidung;
	}

	public Video() {
		super();
	}

	public int getStt() {
		return stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getHinhanh() {
		return hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	public int getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}

	public String getDuongdan() {
		return duongdan;
	}

	public void setDuongdan(String duongdan) {
		this.duongdan = duongdan;
	}

	public String getNoidung() {
		return noidung;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}

	@Override
	public String toString() {
		return "[" + stt + ", " + ten + ", " + hinhanh + ", " + trangthai + "\n" + duongdan + ", " + noidung + "]";
	}

}
