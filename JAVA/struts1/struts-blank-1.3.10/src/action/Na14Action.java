package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import dao.UserRegisterDAO;

public class Na14Action extends DispatchAction {

	private final static String SUCCESS = "success";
	private final static String FAILURE = "failure";

	// public ActionForward execute(ActionMapping mapping, ActionForm form,
	// HttpServletRequest request,
	// HttpServletResponse response) throws Exception {
	// System.out.println("aaaaaaaaa");
	//
	// String sNumPage = request.getParameter("num");
	// int numPage = 0;
	// if (sNumPage != null) {
	// numPage = Integer.parseInt(sNumPage);
	// }
	// request.setAttribute("list_user", new
	// UserRegisterDAO().getData(numPage));
	//
	// System.out.println(SUCCESS);
	// return mapping.findForward(SUCCESS);
	// }

	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("You are in add function.");
		return mapping.findForward("add");
	}

	public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception

	{

		System.out.println("You are in edit function.");
		return mapping.findForward("edit");

	}

	public ActionForward search(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("You are in search function");

		String sNumPage = request.getParameter("num");
		int numPage = 0;
		if (sNumPage != null) {
			numPage = Integer.parseInt(sNumPage);
		}
		request.setAttribute("list_user", new UserRegisterDAO().getData(numPage));
		
		return mapping.findForward("search");

	}

	public ActionForward office(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("You are in office function");
		return mapping.findForward("office");
	}
}
