package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.Na19Form;

public class Na19Action extends Action {

	private final static String SUCCESS = "success";
	private final static String FAILURE = "failure";

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		Na19Form loginForm = (Na19Form) form;
//		if (loginForm.getUserName().equals(loginForm.getPassword())) {
//			return mapping.findForward(SUCCESS);
//		} else {
//			return mapping.findForward(FAILURE);
//		}
		return mapping.findForward(SUCCESS);
	}
}
