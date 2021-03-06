package hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "donhang")
public class DonHang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long stt;
	@Column(name = "gia")
	private long gia;
	@Column(name = "sdt")
	private String sdt;
	@Column(name = "ghichu")
	private String ghiChu;
	@Column(name = "magiaodich")
	private String maGiaoDich;
	@Column(name = "thoigian")
	private String thoiGian;

	public long getStt() {
		return stt;
	}

	public void setStt(long stt) {
		this.stt = stt;
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

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public String getMaGiaoDich() {
		return maGiaoDich;
	}

	public void setMaGiaoDich(String maGiaoDich) {
		this.maGiaoDich = maGiaoDich;
	}

	public String getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}

	public DonHang() {
		super();
	}

	public DonHang(long stt, long gia, String sdt, String ghiChu, String maGiaoDich, String thoiGian) {
		super();
		this.stt = stt;
		this.gia = gia;
		this.sdt = sdt;
		this.ghiChu = ghiChu;
		this.maGiaoDich = maGiaoDich;
		this.thoiGian = thoiGian;
	}

	@Override
	public String toString() {
		return "DonHang [stt=" + stt + ", gia=" + gia + ", sdt=" + sdt + ", ghiChu=" + ghiChu + ", maGiaoDich="
				+ maGiaoDich + ", thoiGian=" + thoiGian + "]";
	}

}
