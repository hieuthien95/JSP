package model;

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
	private int id;

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

	@Column(name = "created_at")
	private String created_at;
	@Column(name = "updated_at")
	private String updated_at;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public BaiViet(int id, String loaitin, String tieude, String tomtat, String hinhanh, String noidung, int trangthai,
			String created_at, String updated_at) {
		super();
		this.id = id;
		this.loaitin = loaitin;
		this.tieude = tieude;
		this.tomtat = tomtat;
		this.hinhanh = hinhanh;
		this.noidung = noidung;
		this.trangthai = trangthai;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public BaiViet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BaiViet [id=" + id + ", loaitin=" + loaitin + ", tieude=" + tieude + ", tomtat=" + tomtat + ", hinhanh="
				+ hinhanh + ", noidung=" + noidung + ", trangthai=" + trangthai + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + "]";
	}

}
