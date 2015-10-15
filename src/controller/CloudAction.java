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

import model.GetTweets;
import model.Model;
import model.UserDAO;

import org.mybeans.form.FormBeanFactory;

import databean.TweetBean;
import formbean.LoginForm;


public class CloudAction extends Action {
	private FormBeanFactory<LoginForm> formBeanFactory = FormBeanFactory.getInstance(LoginForm.class);
	private UserDAO userDAO;

	public CloudAction(Model model) {
		userDAO = model.getUserDAO();
	}

	public String getName() { return "hashcloud.do"; }
    
    public String perform(HttpServletRequest request) {
        HttpSession session = request.getSession();
            	
    	// If user is already logged in, redirect to todolist.do
        if (session.getAttribute("user") != null) {
        	return "manage.jsp";//change
        }
        
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);

	        TweetBean[] tweetBeanArray = GetTweets.performGetHashTags("pittsburgh" , "food");
	        session.setAttribute("tweetBeanArray", tweetBeanArray);
			return "hashcloud.jsp";
        }

    }

