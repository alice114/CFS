package formbean;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class TrendsForm extends FormBean {
	private String keyword;
	private String submit;
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword.trim();
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit.trim();
	}
	
	public List<String> getValidationErrors() {
	List<String> errors = new ArrayList<String>();
	
	if (keyword == null || keyword.length() == 0) {
		errors.add("Search keyword is required");
	}

	if (submit == null || submit.length() == 0) {
		errors.add("Submit button is required");
	}
	
	
		return errors;
		
	}
	
}
