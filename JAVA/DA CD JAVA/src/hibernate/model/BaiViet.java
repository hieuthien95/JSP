package hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "baiviet")
public class BaiViet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stt;
	@Column(name = "loaitin")
	private String loaitin;
	@Column(name = "tieude")
	private String tieude;
	@Column(name = "tomtat")
	private String tomtat;
	@Column(name = "hinhanh")
	private String hinhanh;
	@Column(name = "noidung")
	private String noidung;
	@Column(name = "trangthai")
	private int trangthai;

	public BaiViet() {
		super();
	}

	public BaiViet(int stt, String loaitin, String tieude, String tomtat, String hinhanh, String noidung,
			int trangthai) {
		super();
		this.stt = stt;
		this.loaitin = loaitin;
		this.tieude = tieude;
		this.tomtat = tomtat;
		this.hinhanh = hinhanh;
		this.noidung = noidung;
		this.trangthai = trangthai;
	}

	public int getStt() {
		return stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	public String getLoaitin() {
		return loaitin;
	}

	public void setLoaitin(String loaitin) {
		this.loaitin = loaitin;
	}

	public String getTieude() {
		return tieude;
	}

	public void setTieude(String tieude) {
		this.tieude = tieude;
	}

	public String getTomtat() {
		return tomtat;
	}

	public void setTomtat(String tomtat) {
		this.tomtat = tomtat;
	}

	public String getHinhanh() {
		return hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	public String getNoidung() {
		return noidung;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}

	public int getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}

	@Override
	public String toString() {
		return "[" + stt + ", " + loaitin + ", " + tieude + "\n" + tomtat + ", " + hinhanh + ", " + trangthai + "\n"
				+ noidung + "]";
	}

}
