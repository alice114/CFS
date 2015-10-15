/*
 * Team 1
 * Task 8
 * 02/10/2015
 */
package controller;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import test.Twitter;
import formbean.TweetForm;



public class TweetAction extends Action {
	private FormBeanFactory<TweetForm> formBeanFactory = FormBeanFactory.getInstance(TweetForm.class);

	public TweetAction() {

	}

	public String getName() { return "tweet.do"; }
    
    public String perform(HttpServletRequest request) {
        HttpSession session = request.getSession();
         
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
        try {
        	
	    	TweetForm form = formBeanFactory.create(request);
	        request.setAttribute("form",form);
	        
	        Twitter twitter = new Twitter();

	        if (!form.isPresent()) {
	            return "tweet.jsp";
	        }
	        
	        errors.addAll(form.getValidationErrors());
	        if (errors.size() != 0) {
	        	return "tweet.jsp";
	        }
	        
	        String access_token = "";
			String access_token_secret = "";
			String screen_name = "";
			String user_id = "";
			
			user_id = (String)session.getAttribute("user_id");
			access_token = (String)session.getAttribute("access_token");
			access_token_secret = (String)session.getAttribute("access_token_secret");
			screen_name = (String)session.getAttribute("screen_name");
			
			if (access_token == null || access_token_secret == null
					|| access_token.equals("") || access_token_secret.equals("")) {
				System.out.println("pin: " + session.getAttribute("pin"));
		        System.out.println("oauth_token: " + session.getAttribute("oauth_token"));
		        System.out.println("state: " + form.getTweet_state());
		        System.out.println("photo dir: " + form.getPhoto_dir());
		        
		        String pin = (String) session.getAttribute("pin");
		        String oauth_token = (String) session.getAttribute("oauth_token");
				
				JSONObject accessjson = twitter.getTwitterAccessTokenFromAuthorizationCode(pin, oauth_token);

				access_token = accessjson.getString("access_token");
				access_token_secret = accessjson.getString("access_token_secret");
				screen_name = accessjson.getString("screen_name");
				user_id = accessjson.getString("user_id");
				System.out.println(access_token);
				session.setAttribute("user_id", user_id);
				session.setAttribute("access_token", access_token);
				session.setAttribute("access_token_secret", access_token_secret);
				session.setAttribute("screen_name", screen_name);
				System.out.println(access_token_secret);
				System.out.println(screen_name);
				System.out.println(user_id);
			}
	        String tweet_state = form.getTweet_state();
	        String photo_dir = form.getPhoto_dir();      
	        
			twitter.updateStatusWithMedia(access_token, access_token_secret, tweet_state, new File(photo_dir));
	        
			errors.add("Update Completed!");
	        return "tweet.jsp";
        } catch (FormBeanException e) {
        	errors.add(e.getMessage());
        	return "tweet.jsp";
        } catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errors.add(e.getMessage());
        	return "tweet.jsp";
		}
    }
}
