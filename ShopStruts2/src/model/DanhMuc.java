package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "danhmuc")
public class DanhMuc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "ten")
	private String ten;

	@Column(name = "tenkhongdau")
	private String tenkhongdau;

	@Column(name = "parent")
	private String parent;

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

	public String getTenkhongdau() {
		return tenkhongdau;
	}

	public void setTenkhongdau(String tenkhongdau) {
		this.tenkhongdau = tenkhongdau;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public DanhMuc(int id, String ten, String tenkhongdau, String parent) {
		super();
		this.id = id;
		this.ten = ten;
		this.tenkhongdau = tenkhongdau;
		this.parent = parent;
	}

	public DanhMuc() {
		super();
	}

	@Override
	public String toString() {
		return "DanhMuc [id=" + id + ", ten=" + ten + ", tenkhongdau=" + tenkhongdau + ", parent=" + parent + "]";
	}

}
