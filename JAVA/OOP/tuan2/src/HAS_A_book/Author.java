package HAS_A_book;

enum GENDER {
	MALE("Male"), FEMALE("Female");
	String s;

	GENDER(String s) {
		this.s = s;
	}

	String getS() {
		return s;
	}
}

public class Author {
	private String name;
	private String email;
	private char gender;

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

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Author() {
		super();
	}

	public Author(String name, String email, char gender) {
		super();
		this.name = name;
		this.email = email;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return name + "(" + gender + ")" + email;
	}

}
