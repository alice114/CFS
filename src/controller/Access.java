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
public class Access extends Action {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
       
	
	//private UserPhotoDAO userPhotoDAO;
	@SuppressWarnings("unused")
	private UserDAO  userDAO;
	
	public Access(Model model) {
   // 	userPhotoDAO = model.getUserPhotoDAO();
    	userDAO  = model.getUserDAO();
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "access.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub
		System.out.println("entered perform of access");
				
		String pin = request.getParameter("pin");
		request.getSession().setAttribute("pin", pin);
		Verifier v = new Verifier(pin);
		OAuthService service = (OAuthService) request.getSession().getAttribute("service");
		Token requestToken = (Token) request.getSession().getAttribute("requestToken");
		String service1 = request.getParameter("service");
		String requestToken1 = request.getParameter("requestToken");
		
		
		System.out.println("request token:"+requestToken);
		System.out.println("service:"+service);
		System.out.println("req string"+requestToken1);
		System.out.println("ser string:"+ service1);
		Token accessToken = service.getAccessToken(requestToken, v);
		
		System.out.println("access token: "+accessToken);
		request.getSession().setAttribute("accessToken", accessToken);
		String access_token = accessToken.getToken();
		String access_token_secret = accessToken.getSecret();
		request.getSession().setAttribute("access_token", access_token);
		request.getSession().setAttribute("access_token_secret", access_token_secret);
		
		return "viewTrends.do";
		
	}

}
