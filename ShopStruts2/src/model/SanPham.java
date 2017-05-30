package model;

import javax.persistence.*;

@Entity
@Table(name="sanpham")
public class SanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "ten")
	private String ten;
	@Column(name = "tenkhongdau")
	private String tenkhongdau;

	@Column(name = "gia")
	private long gia;

	@Column(name = "loaisp")
	private String loaisp;
	@Column(name = "hangsx")
	private String hangsx;

	@Column(name = "hinhanh")
	private String hinhanh;

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
	@Column(name = "km")
	private String km;

	@Column(name = "trangthai")
	private int trangthai;
	@Column(name = "sl")
	private String sl;
	@Column(name = "luotxem")
	private int luotxem;

	@Column(name = "created_at")
	private String created_at;
	@Column(name = "updated_at")
	private String updated_at;

	public SanPham() {
		super();
	}

	public SanPham(int id, String ten, String tenkhongdau, long gia, String loaisp, String hangsx, String hinhanh,
			String manhinh, String hdh, String cpu, String camera, String pin, String nhieuhon, String km,
			int trangthai, String sl, int luotxem, String created_at, String updated_at) {
		super();
		this.id = id;
		this.ten = ten;
		this.tenkhongdau = tenkhongdau;
		this.gia = gia;
		this.loaisp = loaisp;
		this.hangsx = hangsx;
		this.hinhanh = hinhanh;
		this.manhinh = manhinh;
		this.hdh = hdh;
		this.cpu = cpu;
		this.camera = camera;
		this.pin = pin;
		this.nhieuhon = nhieuhon;
		this.km = km;
		this.trangthai = trangthai;
		this.sl = sl;
		this.luotxem = luotxem;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	
	public SanPham(String ten, String tenkhongdau, long gia, String loaisp, String hangsx, String hinhanh,
			String manhinh, String hdh, String cpu, String camera, String pin, String nhieuhon, String km,
			int trangthai, String sl) {
		super();
		this.id = 0;
		this.ten = ten;
		this.tenkhongdau = tenkhongdau;
		this.gia = gia;
		this.loaisp = loaisp;
		this.hangsx = hangsx;
		this.hinhanh = hinhanh;
		this.manhinh = manhinh;
		this.hdh = hdh;
		this.cpu = cpu;
		this.camera = camera;
		this.pin = pin;
		this.nhieuhon = nhieuhon;
		this.km = km;
		this.trangthai = trangthai;
		this.sl = sl;
		this.luotxem = 0;
		this.created_at = null;
		this.updated_at = null;
	}

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

	public long getGia() {
		return gia;
	}

	public void setGia(long gia) {
		this.gia = gia;
	}

	public String getLoaisp() {
		return loaisp;
	}

	public void setLoaisp(String loaisp) {
		this.loaisp = loaisp;
	}

	public String getHangsx() {
		return hangsx;
	}

	public void setHangsx(String hangsx) {
		this.hangsx = hangsx;
	}

	public String getHinhanh() {
		return hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
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

	@Override
	public String toString() {
		return "SanPham [id=" + id + ", ten=" + ten + ", tenkhongdau=" + tenkhongdau + ", gia=" + gia + ", loaisp="
				+ loaisp + ", hangsx=" + hangsx + ", hinhanh=" + hinhanh + ", manhinh=" + manhinh + ", hdh=" + hdh
				+ ", cpu=" + cpu + ", camera=" + camera + ", pin=" + pin + ", nhieuhon=" + nhieuhon + ", km=" + km
				+ ", trangthai=" + trangthai + ", sl=" + sl + ", luotxem=" + luotxem + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + "]";
	}

}
