//package twitter4j.examples.signin;
//
//import twitter4j.Query;
//import twitter4j.Twitter;
//import twitter4j.TwitterException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//
//public class SearchTweetServlet extends HttpServlet {
////    private static final long serialVersionUID = 2132731135996613711L;
//    public String getName() { return "searchtweet.do"; }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
//        String text = request.getParameter("text");
//        Query query = new Query(text);
//        Twitter twitter = (Twitter)request.getSession().getAttribute("twitter");
//        try {
//            twitter.search(query);
//        } catch (TwitterException e) {
//            throw new ServletException(e);
//        }
//        response.sendRedirect(request.getContextPath()+ "/");
//    }
//}
