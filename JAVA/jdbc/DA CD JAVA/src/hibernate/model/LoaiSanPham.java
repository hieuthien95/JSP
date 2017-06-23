package hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loaisp")
public class LoaiSanPham {@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stt;
	@Column(name = "tenloai")
	private String tenloai;

	public int getStt() {
		return stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	public String getTenloai() {
		return tenloai;
	}

	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}

	public LoaiSanPham() {
		super();
	}

	public LoaiSanPham(int stt, String tenloai) {
		super();
		this.stt = stt;
		this.tenloai = tenloai;
	}

	@Override
	public String toString() {
		return "[" + stt + ", " + tenloai + "]";
	}

}
