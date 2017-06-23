package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.AhihiForm;

public class AhihiAction extends Action {

	private final static String SUCCESS = "success";
	private final static String FAILURE = "failure";

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		AhihiForm loginForm = (AhihiForm) form;
//		if (loginForm.getUserName().equals(loginForm.getPassword())) {
//			return mapping.findForward(SUCCESS);
//		} else {
//			return mapping.findForward(FAILURE);
//		}
		request.setAttribute("para1", "ABC");
		return mapping.findForward(SUCCESS);
	}
}
