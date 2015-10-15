/*
 * Team 1
 * Task 8
 * 02/10/2015
 */
package controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.UploadFlickr;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databean.User;
import formbean.UploadPhotoForm;


public class UploadPhotoAction extends Action {
	private FormBeanFactory<UploadPhotoForm> formBeanFactory = FormBeanFactory.getInstance(UploadPhotoForm.class);

	public UploadPhotoAction() {
		
	}

	public String getName() { return "uploadPhoto.do"; }
    
    public String perform(HttpServletRequest request) {
        
    	System.out.println("entered perform of upload on flickr");

		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);

		try {
			// Set up user list for nav bar;
			User user = (User) request.getSession(false).getAttribute("user");

			UploadPhotoForm form = formBeanFactory.create(request);
			request.setAttribute("form", form);
			if (!form.isPresent()) {
				System.out.println("form is not present");
				return "uploadPhoto.jsp";
			}

			System.out.println("form is present");

			errors.addAll(form.getValidationErrors());
			if (errors.size() > 0)
				return "uploadPhoto.jsp";
	        String para = "-u yuexuanl -s haha " + form.getDir() + " -apiKey 992c097a02257b03f4e1b7fac88fab5e -secret 85aeacf925c41b39";
	        UploadFlickr.upload(para);
	        errors.add("Successfully uploaded!");
	        return "uploadPhoto.jsp";	        
        } catch (RollbackException e) {
        	errors.add(e.getMessage());
        	return "uploadPhoto.jsp";
        } catch (FormBeanException e) {
        	errors.add(e.getMessage());
        	return "uploadPhoto.jsp";
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "uploadPhoto.jsp";
		}
    }
}
