package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hinhanh")
public class HinhAnh {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "loaihinh")
	private String loaihinh;
	@Column(name = "idsp")
	private int idsp;
	@Column(name = "hinhanh")
	private String hinhanh;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoaihinh() {
		return loaihinh;
	}

	public void setLoaihinh(String loaihinh) {
		this.loaihinh = loaihinh;
	}

	public int getIdsp() {
		return idsp;
	}

	public void setIdsp(int idsp) {
		this.idsp = idsp;
	}

	public String getHinhanh() {
		return hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	public HinhAnh(int id, String loaihinh, int idsp, String hinhanh) {
		super();
		this.id = id;
		this.loaihinh = loaihinh;
		this.idsp = idsp;
		this.hinhanh = hinhanh;
	}

	public HinhAnh() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "HinhAnh [id=" + id + ", loaihinh=" + loaihinh + ", idsp=" + idsp + ", hinhanh=" + hinhanh + "]";
	}

}