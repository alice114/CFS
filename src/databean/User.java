/*
 * Team 1
 * Task 8
 * 02/10/2015
 */
package databean;

import org.genericdao.PrimaryKey;

@PrimaryKey("user_id")
public class User {
	
	private int user_id;
	private String username;
	private String password;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
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
			
	

}
