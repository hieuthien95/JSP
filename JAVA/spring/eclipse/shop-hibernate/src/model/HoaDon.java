package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HOADON")
public class HoaDon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ma_hoa_don = 0;
	@Column(name = "ma_khach_hang")
	private String ma_khach_hang;
	@Column(name = "dia_chi")
	private String dia_chi;
	@Column(name = "dien_thoai")
	private String dien_thoai;
	@Column(name = "ngay_lap")
	private Date ngay_lap;

	public HoaDon() {
		super();
	}

	public HoaDon(int ma_hoa_don, String ma_khach_hang, String dia_chi, String dien_thoai, Date ngay_lap) {
		super();
		this.ma_hoa_don = ma_hoa_don;
		this.ma_khach_hang = ma_khach_hang;
		this.dia_chi = dia_chi;
		this.dien_thoai = dien_thoai;
		this.ngay_lap = ngay_lap;
	}

	public int getMa_hoa_don() {
		return ma_hoa_don;
	}

	public void setMa_hoa_don(int ma_hoa_don) {
		this.ma_hoa_don = ma_hoa_don;
	}

	public String getMa_khach_hang() {
		return ma_khach_hang;
	}

	public void setMa_khach_hang(String ma_khach_hang) {
		this.ma_khach_hang = ma_khach_hang;
	}

	public String getDia_chi() {
		return dia_chi;
	}

	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}

	public String getDien_thoai() {
		return dien_thoai;
	}

	public void setDien_thoai(String dien_thoai) {
		this.dien_thoai = dien_thoai;
	}

	public Date getNgay_lap() {
		return ngay_lap;
	}

	public void setNgay_lap(Date ngay_lap) {
		this.ngay_lap = ngay_lap;
	}

	@Override
	public String toString() {
		return "HoaDon [ma_hoa_don=" + ma_hoa_don + ", ma_khach_hang=" + ma_khach_hang + ", dia_chi=" + dia_chi
				+ ", dien_thoai=" + dien_thoai + ", ngay_lap=" + ngay_lap + "]";
	}

}
