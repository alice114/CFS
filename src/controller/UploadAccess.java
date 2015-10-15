package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.TwitterApi;
import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;

import model.Model;
import model.UserDAO;
//import model.UserPhotoDAO;

/**
 * Servlet implementation class UploadAccess
 */
public class UploadAccess extends Action {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

//	@SuppressWarnings("unused")
//	private UserPhotoDAO userPhotoDAO;
	@SuppressWarnings("unused")
	private UserDAO  userDAO;
	private final static String consumerKey = "vG85s0Iiv3d5qKYPsaVWu2d7K";
	private final static String consumerSecret = "OEEJb6Py3xHpIdGCFpTf1h9wCq20oOvpCWAB9fcbvUrykjEI1M";
	public UploadAccess(Model model) {
 //s   	userPhotoDAO = model.getUserPhotoDAO();
    	userDAO  = model.getUserDAO();
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "getToken.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		System.out.println("entered perform");
		if(request.getSession().getAttribute("access_token")!=null){
			return "viewTrends.do";
		}
		//new org.scribe.builder.ServiceBuilder().provider(TwitterApi.SSL.class).apiKey(consumerKey).apiSecret(consumerSecret).callback("http://128.237.185.64/:8080/Task8-3/upload.do").build();
		OAuthService service = new ServiceBuilder().provider(TwitterApi.SSL.class).apiKey(consumerKey).apiSecret(consumerSecret).build();
		Token requestToken = service.getRequestToken();
		//return "upload.do";
		String authUrl = service.getAuthorizationUrl(requestToken);
		
		request.setAttribute("authUrl", authUrl);
		HttpSession session = request.getSession(false);
		request.setAttribute("service", service);
		request.setAttribute("requestToken", requestToken);
		session.setAttribute("service", service);
		session.setAttribute("requestToken", requestToken);
		return "url.jsp";
		
	}
	
}
