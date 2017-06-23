package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "sdt")
	private String sdt;
	@Column(name = "password")
	private String password;

	@Column(name = "quyen")
	private int quyen;
	@Column(name = "hinhanh")
	private String hinhanh;
	@Column(name = "diem")
	private int diem;

	@Column(name = "remember_taken")
	private String remember_taken;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getQuyen() {
		return quyen;
	}

	public void setQuyen(int quyen) {
		this.quyen = quyen;
	}

	public String getHinhanh() {
		return hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	public int getDiem() {
		return diem;
	}

	public void setDiem(int diem) {
		this.diem = diem;
	}

	public String getRemember_taken() {
		return remember_taken;
	}

	public void setRemember_taken(String remember_taken) {
		this.remember_taken = remember_taken;
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

	public Users(int id, String name, String email, String sdt, String password, int quyen, String hinhanh, int diem,
			String remember_taken, String created_at, String updated_at) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.sdt = sdt;
		this.password = password;
		this.quyen = quyen;
		this.hinhanh = hinhanh;
		this.diem = diem;
		this.remember_taken = remember_taken;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", sdt=" + sdt + ", password=" + password
				+ ", quyen=" + quyen + ", hinhanh=" + hinhanh + ", diem=" + diem + ", remember_taken=" + remember_taken
				+ ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}

}
