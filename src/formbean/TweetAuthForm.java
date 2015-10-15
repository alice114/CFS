/*
 * Team 1
 * Task 7
 * 01/15/2015
 */
package formbean;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class TweetAuthForm extends FormBean {
	private String pin;

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (pin == null || pin.length() == 0) {
			errors.add("Keyword is required");
		}
		
		if (errors.size() > 0) {
			return errors;
		}

		if (pin.matches(".*[<>\"].*"))
			errors.add("Username may not contain special characters, angle brackets or quotes");

		return errors;
	}
}
