package form;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class Na14Form extends ActionForm {
	private static final long serialVersionUID = 1L;

	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String email;
	private String phone;

	private String check;

	private String num;

	public Na14Form() {
		super();
	}
	
	@Override
	public void reset(ActionMapping arg0, ServletRequest arg1) {
		super.reset(arg0, arg1);
	}

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if (num == null || num.equals("")) {
			errors.add("num", new ActionMessage("errors.byte", num));
		} else {
			try {
				Integer.parseInt(num);
			} catch (Exception e) {
				errors.add("num", new ActionMessage("errors.byte", num));
			}
		}

		return errors;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Na14Form [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", password="
				+ password + ", email=" + email + ", phone=" + phone + ", check=" + check + ", num=" + num + "]";
	}

}
