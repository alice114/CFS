/*
 * Team 1
 * Task 8
 * 02/10/2015
 */
package formbean;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class RegisterForm extends FormBean {
	private String username;
	private String password;
	private String confirmPassword;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}



	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (username == null || username.length() == 0) {
			errors.add("Username is required");
		}

		if (password == null || password.length() == 0) {
			errors.add("Password is required");
		}
		
		if (confirmPassword == null || confirmPassword.length() == 0) {
			errors.add("Confirm password is required");
		}
		
		if (errors.size() > 0) {
			return errors;
		}

		if (username.matches(".*[<>\"].*"))
			errors.add("Username may not contain special characters, angle brackets or quotes");
		
		if (password.matches(".*[<>\"].*"))
			errors.add("Password may not contain special characters, angle brackets or quotes");
		
		if (confirmPassword.matches(".*[<>\"].*"))
			errors.add("Confirm password may not contain special characters, angle brackets or quotes");
		
		if (!password.equals(confirmPassword)) {
			errors.add("Password should be the same as confirm password");
		}
		
		return errors;
	}
}
