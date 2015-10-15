/*
 * Team 1
 * Task 8
 * 02/10/2015
 */
package controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import formbean.SearchFlickrForm;
import model.UserDAO;
import model.Model;


public class SearchFlickrAction extends Action {
	private FormBeanFactory<SearchFlickrForm> formBeanFactory = FormBeanFactory.getInstance(SearchFlickrForm.class);
	private UserDAO userDAO;

	public SearchFlickrAction(Model model) {
		userDAO = model.getUserDAO();
	}

	public String getName() { return "searchFlickr.do"; }
    
    public String perform(HttpServletRequest request) {
        HttpSession session = request.getSession();
         
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
        try {
//        	request.setAttribute("userList",userDAO.getUsers());
        	
	    	SearchFlickrForm form = formBeanFactory.create(request);
	        request.setAttribute("form",form);
	        
	        // If no params were passed, return with no errors so that the form will be
	        // presented (we assume for the first time).
	        if (!form.isPresent()) {
	            return "searchFlickr.jsp";
	        }

	        // Any validation errors?
	        errors.addAll(form.getValidationErrors());
	        if (errors.size() != 0) {
	            return "searchFlickr.jsp";
	        }
	        request.getSession().setAttribute("keyword", form.getKeyword());
	        return "resultFlickr.do";
        
        } catch (FormBeanException e) {
        	errors.add(e.getMessage());
        	return "searchFlickr.jsp";
        }
    }
}
