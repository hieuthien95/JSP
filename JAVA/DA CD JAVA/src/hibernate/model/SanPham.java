package hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sanpham")
public class SanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stt;
	@Column(name = "hinhanh")
	private String hinhanh;
	@Column(name = "ten")
	private String ten;
	@Column(name = "gia")
	private int gia;
	@Column(name = "manhinh")
	private String manhinh;
	@Column(name = "hdh")
	private String hdh;
	@Column(name = "cpu")
	private String cpu;
	@Column(name = "camera")
	private String camera;
	@Column(name = "pin")
	private String pin;
	@Column(name = "nhieuhon")
	private String nhieuhon;
	@Column(name = "hangsx")
	private String hangsx;
	@Column(name = "loaisp")
	private String loaisp;
	@Column(name = "km")
	private String km;
	@Column(name = "trangthai")
	private int trangthai;
	@Column(name = "sl")
	private String sl;
	@Column(name = "luotxem")
	private int luotxem;

	public int getStt() {
		return stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	public String getHinhanh() {
		return hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public String getManhinh() {
		return manhinh;
	}

	public void setManhinh(String manhinh) {
		this.manhinh = manhinh;
	}

	public String getHdh() {
		return hdh;
	}

	public void setHdh(String hdh) {
		this.hdh = hdh;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getCamera() {
		return camera;
	}

	public void setCamera(String camera) {
		this.camera = camera;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getNhieuhon() {
		return nhieuhon;
	}

	public void setNhieuhon(String nhieuhon) {
		this.nhieuhon = nhieuhon;
	}

	public String getHangsx() {
		return hangsx;
	}

	public void setHangsx(String hangsx) {
		this.hangsx = hangsx;
	}

	public String getLoaisp() {
		return loaisp;
	}

	public void setLoaisp(String loaisp) {
		this.loaisp = loaisp;
	}

	public String getKm() {
		return km;
	}

	public void setKm(String km) {
		this.km = km;
	}

	public int getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}

	public String getSl() {
		return sl;
	}

	public void setSl(String sl) {
		this.sl = sl;
	}

	public int getLuotxem() {
		return luotxem;
	}

	public void setLuotxem(int luotxem) {
		this.luotxem = luotxem;
	}

	public SanPham(int stt, String hinhanh, String ten, int gia, String manhinh, String hdh, String cpu, String camera,
			String pin, String nhieuhon, String hangsx, String loaisp, String km, int trangthai, String sl,
			int luotxem) {
		super();
		this.stt = stt;
		this.hinhanh = hinhanh;
		this.ten = ten;
		this.gia = gia;
		this.manhinh = manhinh;
		this.hdh = hdh;
		this.cpu = cpu;
		this.camera = camera;
		this.pin = pin;
		this.nhieuhon = nhieuhon;
		this.hangsx = hangsx;
		this.loaisp = loaisp;
		this.km = km;
		this.trangthai = trangthai;
		this.sl = sl;
		this.luotxem = luotxem;
	}
	
	public SanPham(int stt, String hinhanh, String ten, int gia, String manhinh, String hdh, String cpu, String camera,
			String pin, String nhieuhon, String hangsx, String loaisp, String km, int trangthai, String sl) {
		super();
		this.stt = stt;
		this.hinhanh = hinhanh;
		this.ten = ten;
		this.gia = gia;
		this.manhinh = manhinh;
		this.hdh = hdh;
		this.cpu = cpu;
		this.camera = camera;
		this.pin = pin;
		this.nhieuhon = nhieuhon;
		this.hangsx = hangsx;
		this.loaisp = loaisp;
		this.km = km;
		this.trangthai = trangthai;
		this.sl = sl;
	}

	public SanPham() {
		super();
	}

	@Override
	public String toString() {
		return "[" + stt + ", " + hinhanh + ", " + ten + ", " + gia + "\n" + manhinh + ", " + hdh + ", cpu=" + cpu
				+ ", camera=" + camera + "\n" + pin + ", " + nhieuhon + "\n" + hangsx + ", " + loaisp + ", " + km + ", "
				+ trangthai + ",  " + sl + "]";
	}

}
