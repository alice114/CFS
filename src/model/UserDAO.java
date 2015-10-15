/*
 * Team 1
 * Task 7
 * 01/15/2015
 */
package model;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.genericdao.Transaction;

import databean.User;

public class UserDAO extends GenericDAO<User> {
	public UserDAO(ConnectionPool cp, String tableName)
			throws DAOException, RollbackException {
		super(User.class, tableName, cp);
		
		// Write Initialize later!
		User[] list = match();
		if (list.length == 0) {
			init();
		}
	}

	public int getUserIdByUsername(String username)
			throws RollbackException {
		User[] user = match();
		for (int i = 0; i < user.length; i++) {
			if (user[i].getUsername().equals(username)) {
				return user[i].getUser_id();
			}
		}
		return -1;
	}

	public boolean isExisted(String username) throws RollbackException {
		User[] users = match(MatchArg.equals("username", username));
		if (users.length > 0) {
			return true;
		}
		return false;
	}

	public void setPassword(String username, String password)
			throws RollbackException {
		User user = read(getUserIdByUsername(username));

		if (user == null) {
			throw new RollbackException("User registered with \" "	+ username + " \" not exists");
		}
			user.setPassword(password);
			update(user);
	}
	
	public User[] getUsers() throws RollbackException {
		User[] users = match();
		//Arrays.sort(users);  // We want them sorted by last and first names (as per User.compareTo());
		return users;
	}

	public void init() throws RollbackException {
		User customer1 = new User();
		customer1.setUsername("user1");
		customer1.setPassword("123");
		create(customer1);

		User customer2 = new User();
		customer2.setUsername("user2");
		customer2.setPassword("123");
		create(customer2);

		User customer3 = new User();
		customer3.setUsername("user3");
		customer3.setPassword("123");
		create(customer3);
	}

}
