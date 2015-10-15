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

import org.json.JSONException;
import org.json.JSONObject;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import test.Twitter;
import formbean.TweetAuthForm;



public class TweetAuthAction extends Action {
	private FormBeanFactory<TweetAuthForm> formBeanFactory = FormBeanFactory.getInstance(TweetAuthForm.class);

	public TweetAuthAction() {

	}

	public String getName() { return "tweetAuth.do"; }
    
    public String perform(HttpServletRequest request) {
        HttpSession session = request.getSession();
         
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
        try {
        	
	    	TweetAuthForm form = formBeanFactory.create(request);
	        request.setAttribute("form",form);
	        
	        Twitter twitter = new Twitter();
	        
			String access_token = (String)session.getAttribute("access_token");
			String access_token_secret = (String)session.getAttribute("access_token_secret");
			if (access_token != null && access_token.length() > 0 
					&& access_token_secret != null 
					&& access_token_secret.length() > 0) {
				return "tweet.do";
			}
	        
	        String oauth_token = "";
	        
	        if (!form.isPresent()) {
	    		JSONObject authjson = twitter.startTwitterAuthentication();
	    		oauth_token = authjson.getString("oauth_token");
	    		session.setAttribute("oauth_token", oauth_token);
	    		System.out.println("OAuth Token: " + oauth_token);
	    		String authURL = "https://api.twitter.com/oauth/authenticate?oauth_token=" + oauth_token;
	    		request.setAttribute("authURL",authURL);
	    		System.out.println(authURL);
	            return "tweetAuth.jsp";
	        }
	        
	        errors.addAll(form.getValidationErrors());
	        if (errors.size() != 0) {
	        	return "tweetAuth.jsp";
	        }
	        
	        session.setAttribute("pin", form.getPin());
	        
	        return "tweet.do";        
        } catch (FormBeanException e) {
        	errors.add(e.getMessage());
        	return "tweetAuth.jsp";
        } catch (JSONException e) {
			// TODO Auto-generated catch block
        	e.printStackTrace();
			errors.add(e.getMessage());
			return "tweetAuth.jsp";
		}  
    }
}
