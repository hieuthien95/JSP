package model;

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
	private int id;
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

	public Video(int id, String ten, String hinhanh, int trangthai, String duongdan, String noidung, String created_at,
			String updated_at) {
		super();
		this.id = id;
		this.ten = ten;
		this.hinhanh = hinhanh;
		this.trangthai = trangthai;
		this.duongdan = duongdan;
		this.noidung = noidung;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", ten=" + ten + ", hinhanh=" + hinhanh + ", trangthai=" + trangthai + ", duongdan="
				+ duongdan + ", noidung=" + noidung + ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}

}
