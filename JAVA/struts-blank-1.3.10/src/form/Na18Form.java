package form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class Na18Form extends ActionForm {
	private static final long serialVersionUID = 1L;

	private String userName;
	private String password;
	private String country;
	private String sex;
	private String age;
	private String contact;
	private String work;

	private String userName1;
	private String password1;
	private String country1;
	private String country2;

	public Na18Form() {
		super();
	}

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if (userName == null || userName.length() < 1) {
			errors.add("userName", new ActionMessage("error.userName.required"));
		}
		if (password == null || password.length() < 1) {
			errors.add("password", new ActionMessage("error.password.required"));
		}
		return errors;
	}

	public String getUserName() {
		System.out.println("Inside getter " + userName);
		return userName;
	}

	public void setUserName(String userName) {
		System.out.println("Inside setter " + userName);
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getUserName1() {
		return userName1;
	}

	public void setUserName1(String userName1) {
		this.userName1 = userName1;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getCountry1() {
		return country1;
	}

	public void setCountry1(String country1) {
		this.country1 = country1;
	}

	public String getCountry2() {
		return country2;
	}

	public void setCountry2(String country2) {
		this.country2 = country2;
	}

}
