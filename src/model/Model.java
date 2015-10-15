/*
 * Team 1
 * Task 7
 * 01/15/2015
 */
package model;

import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.RollbackException;

public class Model {
	private UserDAO userDAO;
///	private UserPhotoDAO userPhotoDAO;

	private boolean requireSSL;

	public Model(ServletConfig config) throws ServletException, SQLException {
		requireSSL = new Boolean(config.getInitParameter("requireSSL"));

		String jdbcDriver = config.getInitParameter("jdbcDriverName");
		String jdbcURL = config.getInitParameter("jdbcURL");

		try {
			ConnectionPool pool = new ConnectionPool(jdbcDriver, jdbcURL);

			userDAO = new UserDAO(pool, "User");
		} catch (DAOException e) {
			throw new ServletException(e);
		} catch (RollbackException e) {
			throw new ServletException(e);
		}
	}

	public boolean getRequireSSL() {
		return requireSSL;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}
	
//	public UserPhotoDAO getUserPhotoDAO() {
//		return userPhotoDAO;
//	}


}
