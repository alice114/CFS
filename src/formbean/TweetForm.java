/*
 * Team 1
 * Task 7
 * 01/15/2015
 */
package formbean;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class TweetForm extends FormBean {
	private String tweet_state;
	private String photo_dir;
	
	public String getTweet_state() {
		return tweet_state;
	}
	public void setTweet_state(String tweet_state) {
		this.tweet_state = tweet_state;
	}
	public String getPhoto_dir() {
		return photo_dir;
	}
	public void setPhoto_dir(String photo_dir) {
		this.photo_dir = photo_dir;
	}

	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (tweet_state == null || tweet_state.length() == 0 ) {
			errors.add("State is required");
		}
		
		if (photo_dir == null || photo_dir.length() == 0 ) {
			errors.add("Photo Directory is required");
		}
		
		if (tweet_state.length() >= 140) {
			errors.add("Should be less than 140 characters!");
		}
		
		if (errors.size() > 0) {
			return errors;
		}

		if (tweet_state.matches(".*[<>\"].*"))
			errors.add("Username may not contain special characters, angle brackets or quotes");
		
		return errors;
	}
}
