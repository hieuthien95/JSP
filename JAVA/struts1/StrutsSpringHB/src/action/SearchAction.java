package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import bean.Customer;
import bo.CustomerBo;
import form.SearchForm;

public class SearchAction extends ActionSupport {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		SearchForm loginForm = (SearchForm) form;
		
		CustomerBo customerBo = (CustomerBo) getWebApplicationContext().getBean("customerBo");
		
		List<Customer> customers = customerBo.getAllCustomer();
		
		loginForm.setCustomers(customers);
		
    	return mapping.findForward("search");
	}
}
