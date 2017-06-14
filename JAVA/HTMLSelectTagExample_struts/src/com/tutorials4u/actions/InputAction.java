package com.tutorials4u.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.util.LabelValueBean;

import com.tutorials4u.forms.CountryData;
import com.tutorials4u.forms.InputForm;

/**
 *
 * @author info@tutorials4u.net
 */
public class InputAction extends DispatchAction {
    
    private final static String SUCCESS = "success";
    private final static String DISPLAY = "display";
    
    public ActionForward populate(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	ArrayList countryList = new ArrayList();
        ArrayList stateList = new ArrayList();
        InputForm inputForm = (InputForm) form;

        countryList.add(new CountryData("United States", "United States"));
        countryList.add(new CountryData("Canada", "Canada"));
        countryList.add(new CountryData("Mexico", "Mexico"));

        stateList.add(new LabelValueBean("New York", "New York"));
        stateList.add(new LabelValueBean("California", "California"));
        stateList.add(new LabelValueBean("Los Angeles", "Los Angeles"));

        inputForm.setCountryList(countryList);
        inputForm.setStateList(stateList);

        return mapping.findForward(SUCCESS);
    }

    public ActionForward save(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {    	
    	return mapping.findForward(DISPLAY);
    }
}