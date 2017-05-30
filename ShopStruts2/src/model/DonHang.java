package model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "donhang")
public class DonHang {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "gia")
	private long gia;

	@Column(name = "sdt")
	private String sdt;
	@Column(name = "ghichu")
	private String ghichu;
	@Column(name = "magiaodich")
	private String magiaodich;

	@Column(name = "created_at")
	private String created_at;
	@Column(name = "updated_at")
	private String updated_at;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getGia() {
		return gia;
	}

	public void setGia(long gia) {
		this.gia = gia;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}

	public String getMagiaodich() {
		return magiaodich;
	}

	public void setMagiaodich(String magiaodich) {
		this.magiaodich = magiaodich;
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

	public DonHang(long id, long gia, String sdt, String ghichu, String magiaodich, String created_at,
			String updated_at) {
		super();
		this.id = id;
		this.gia = gia;
		this.sdt = sdt;
		this.ghichu = ghichu;
		this.magiaodich = magiaodich;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	
	public DonHang(long id, long gia, String sdt, String ghichu) {
		super();
		this.id = id;
		this.gia = gia;
		this.sdt = sdt;
		this.ghichu = ghichu;
		
		this.magiaodich = "";
		this.created_at = new Timestamp(new Date().getTime()) + " ";
		this.updated_at = new Timestamp(new Date().getTime()) + " ";
	}

	public DonHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DonHang [id=" + id + ", gia=" + gia + ", sdt=" + sdt + ", ghichu=" + ghichu + ", magiaodich="
				+ magiaodich + ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}

}
