package hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stt;
	@Column(name = "username")
	private String username;
	@Column(name = "sdt")
	private String sdt;
	@Column(name = "email")
	private String email;
	@Column(name = "ten")
	private String ten;
	@Column(name = "quyen")
	private String quyen;
	@Column(name = "avatar")
	private String avatar;
	@Column(name = "password")
	private String password;
	@Column(name = "diemtichluy")
	private int diemTichTuy;

	public int getStt() {
		return stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getQuyen() {
		return quyen;
	}

	public void setQuyen(String quyen) {
		this.quyen = quyen;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getDiemTichTuy() {
		return diemTichTuy;
	}

	public void setDiemTichTuy(int diemTichTuy) {
		this.diemTichTuy = diemTichTuy;
	}

	public User(int stt, String username, String sdt, String email, String ten, String quyen, String avatar,
			String password, int diemTichTuy) {
		super();
		this.stt = stt;
		this.username = username;
		this.sdt = sdt;
		this.email = email;
		this.ten = ten;
		this.quyen = quyen;
		this.avatar = avatar;
		this.password = password;
		this.diemTichTuy = diemTichTuy;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [stt=" + stt + ", username=" + username + ", sdt=" + sdt + ", email=" + email + ", ten=" + ten
				+ ", quyen=" + quyen + ", avatar=" + avatar + ", password=" + password + ", diemTichTuy=" + diemTichTuy + "]";
	}

}