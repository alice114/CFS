/*
 * Team 1
 * Task 8
 * 02/10/2015
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;
import databean.User;

public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		Model model = null;
		try {
			model = new Model(getServletConfig());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (model != null) {
			Action.add(new SearchFlickrAction(model));
			Action.add(new ResultFlickrAction());
			Action.add(new TweetAuthAction());
			Action.add(new TweetAction());
			Action.add(new Access(model));
			Action.add(new UploadAccess(model));
			Action.add(new ViewTrendsAction());
			Action.add(new UploadPhotoAction());
			Action.add(new TrendsAction());
			Action.add(new MapsAction(model));
			Action.add(new CloudAction(model));
			Action.add(new MapPhoto(model));
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextPage = performTheAction(request);
		sendToNextPage(nextPage, request, response);
	}

	/*
	 * Extracts the requested action and (depending on whether the user is
	 * logged in) perform it (or make the user login).
	 * 
	 * @param request
	 * 
	 * @return the next page (the view)
	 */
	@SuppressWarnings("unused")
	private String performTheAction(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		String servletPath = request.getServletPath();
		String action = getActionName(servletPath);

		if ((action.equals("searchFlickr.do")
				|| action.equals("uploadPhoto.do")
				|| action.equals("viewTrends.do")
				|| action.equals("resultFlickr.do")
				|| action.equals("trends.do")
				|| action.equals("maps.do")
				|| action.equals("mapsPhoto.do")
				|| action.equals("hashcloud.do")
				|| action.equals("trendsAuth.do") || action.equals("tweet.do")
				|| action.equals("access.do") || action.equals("getToken.do")
				|| action.equals("tweetAuth.do") || action.equals("logout.do"))) {
			return Action.perform(action, request);
		}

		// Ignore unauthorized action
		List<String> errors = new ArrayList<String>();
		errors.add("You tried to access an unauthorized page");
		request.setAttribute("errors", errors);
		return Action.perform("unauthorized.do", request);
	}

	/*
	 * If nextPage is null, send back 404 If nextPage ends with ".do", redirect
	 * to this page. If nextPage ends with ".jsp", dispatch (forward) to the
	 * page (the view) This is the common case
	 */
	private void sendToNextPage(String nextPage, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		if (nextPage == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND,
					request.getServletPath());
			return;
		}

		if (nextPage.endsWith(".do")) {
			response.sendRedirect(nextPage);
			return;
		}

		if (nextPage.endsWith(".jsp")) {
			RequestDispatcher d = request.getRequestDispatcher("WEB-INF/"
					+ nextPage);
			d.forward(request, response);
			return;
		}

		// throw new ServletException(Controller.class.getName()
		// + ".sendToNextPage(\"" + nextPage + "\"): invalid extension.");
	}

	/*
	 * Returns the path component after the last slash removing any "extension"
	 * if present.
	 */
	private String getActionName(String path) {
		// We're guaranteed that the path will start with a slash
		int slash = path.lastIndexOf('/');
		return path.substring(slash + 1);
	}
}
