package controller;

import javax.servlet.http.HttpServletRequest;

import model.Model;
import model.UserDAO;
//simport model.UserPhotoDAO;

import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

/**
 * Servlet implementation class Access
 */
public class MapsAction extends Action {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
       
	
	//private UserPhotoDAO userPhotoDAO;
	@SuppressWarnings("unused")
	private UserDAO  userDAO;
	
	public MapsAction(Model model) {
   // 	userPhotoDAO = model.getUserPhotoDAO();
    	userDAO  = model.getUserDAO();
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "maps.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		
		return "mapsrestaurant.jsp";
		
	}

}
