/*
 * Team 1
 * Task 7
 * 01/15/2015
 */
package formbean;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class SearchFlickrForm extends FormBean {
	private String keyword;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}


	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (keyword == null || keyword.length() == 0) {
			errors.add("Keyword is required");
		}
		
		if (errors.size() > 0) {
			return errors;
		}

		if (keyword.matches(".*[<>\"].*"))
			errors.add("Username may not contain special characters, angle brackets or quotes");

		return errors;
	}
}
