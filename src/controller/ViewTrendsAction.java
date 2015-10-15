package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databean.DisplayTweets;
import test.Twitter;
import formbean.Location;

/**
 * Servlet implementation class ViewTrendsAction
 */
public class ViewTrendsAction extends Action {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "viewTrends.do";
	}

	@SuppressWarnings({ "unused" })
	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub
		FormBeanFactory<Location> formBeanFactory = FormBeanFactory
				.getInstance(Location.class);
		HttpSession session = request.getSession();

		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		List<DisplayTweets> display_tweets_list = new ArrayList<DisplayTweets>();
		
		Location form;
		try {
			form = formBeanFactory.create(request);
			request.setAttribute("form", form);

			String access_token = (String) session.getAttribute("access_token");
			System.out.println("access token" + access_token);

			String access_token_secret = (String) session
					.getAttribute("access_token_secret");
			System.out.println("access token secret" + access_token_secret);
			request.setAttribute("form", form);

			Twitter twitter = new Twitter();

			if (!form.isPresent()) {
				return "enterLocation.jsp";
			}

			errors.addAll(form.getValidationErrors());
			if (errors.size() != 0) {
				return "enterLocation.jsp";
			}
			JSONObject tweets = new JSONObject();
			String keyword = form.getKeyword();
			if (form.getOption().equalsIgnoreCase("popular")){
				tweets = twitter.searchTweetsPopular(keyword + " food", access_token,
						access_token_secret);
			}
			
			if (form.getOption().equalsIgnoreCase("recent")){
			tweets = twitter.searchTweets(keyword + " food", access_token,
					access_token_secret);
			}
			// System.out.println("tweets: json object: "+tweets);

			JSONObject twitter_jo = tweets.getJSONObject("twitter_jo");

			JSONArray statuses = (JSONArray) twitter_jo
					.getJSONArray("statuses");
			JSONObject search_metadata = twitter_jo
					.getJSONObject("search_metadata");

			 System.out.println(statuses+"statuses");
			// System.out.println(search_metadata+"search_metadata");

//			String count = search_metadata.getString("count");
//			String query = search_metadata.getString("query");
//
//			System.out.println("Count : " + count);
//			System.out.println("query: " + query);

			// Iterator i = statuses.iterator();

			
			int length = statuses.length();
			//Iterator i = statuses.iterator();
			int j = 0;
			

			for(int i = 0; i<length ;i++) {
				DisplayTweets display_tweet = new DisplayTweets();
				j++;
				JSONObject innerObj = (JSONObject) statuses.get(i);
				String created_at = innerObj.getString("created_at");
				display_tweet.setCreated_at(created_at);
				System.out.println("created_at: "+created_at);
				String text = innerObj.getString("text");
				display_tweet.setText(text);
				System.out.println("text: "+text);
//				String retweet_count = innerObj.getString("retweet_count");
//				System.out.println("retweet_count: "+retweet_count);
				JSONObject user = (JSONObject) innerObj.getJSONObject("user");
				String name = user.getString("name");
				display_tweet.setName(name);
				System.out.println("name: "+ name);
				String screen_name = user.getString("screen_name");
				display_tweet.setSreen_name(screen_name);
				System.out.println("Screen_name: "+screen_name);
				String profile_image_url_https = user.getString("profile_image_url_https");
				display_tweet.setProfile_image_url_https(profile_image_url_https);
				System.out.println(profile_image_url_https);
				String source = innerObj.getString("source");
				display_tweet.setSource(source);
				System.out.println("SOurce: "+source);
				JSONObject entities = (JSONObject) innerObj.getJSONObject("entities");
				JSONArray urls = (JSONArray) entities.getJSONArray("urls");
				
				if (entities.has("media")){
					JSONArray media = (JSONArray) entities.getJSONArray("media");
					//int x = urls.length();
					String media_url_https = null;
					for (int g = 0; g< media.length(); g++){
						JSONObject innerObj2 = (JSONObject) media.get(g);
						
						media_url_https = innerObj2.getString("media_url");
						
						
						System.out.println(" media url: "+ media_url_https);
						display_tweet.setMedia_url_https(media_url_https);
					}
				}
				
				
				
				boolean isURL = false;
				if(urls.length()>0){
					isURL = true;
					
				}
				
				display_tweet.setURL(String.valueOf(isURL));
				
				System.out.println("Is URL: "+isURL);
				
				
				String display_url = "";
				String expanded_url = "";
				String url = "";
				
				if(!isURL){
					display_url="";
					expanded_url="";
					url="";
				}
				
			//	int g = urls.length();
				for (int g = 0; g< urls.length(); g++){
					JSONObject innerObj2 = (JSONObject) urls.get(g);
					display_url = innerObj2.getString("display_url");
					expanded_url = innerObj2.getString("expanded_url");
					url = innerObj2.getString("url");
					
					System.out.println("Display url: "+display_url);
					
					System.out.println("Expanded: url :"+expanded_url);
					System.out.println("url: "+url);
					
				}
				
				display_tweet.setDisplay_url(display_url);
				display_tweet.setExpanded_url(expanded_url);
				display_tweet.setUrl(url);
				
				System.out.println("\n");
				
				display_tweets_list.add(display_tweet);
			}
			
			System.out.println("Count: "+j);
			request.setAttribute("display_tweets_list", display_tweets_list);
			request.setAttribute("count", j);
			request.setAttribute("keyword", keyword);
			request.setAttribute("statuses", statuses);
			return "resultTweets.jsp";
			
		} catch (FormBeanException e) {
			// TODO Auto-generated catch block
			errors.add(e.getMessage());
			return "enterLocation.jsp";
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
			errors.add(e.getMessage());
			return "enterLocation.jsp";
		}

		// twitter.searchTweets(q, access_token, access_token_secret)	

	}

}
