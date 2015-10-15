package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import test.Twitter;
import databean.DisplayTweets;
import formbean.Location;
import formbean.TrendsForm;

/**
 * Servlet implementation class ViewTrendsAction
 */
public class TrendsAction extends Action {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "trends.do";
	}

	@SuppressWarnings({ "unused" })
	@Override
	public String perform(HttpServletRequest request) {
		Map<String,Integer> hashtag_map_count = new HashMap<String,Integer>();
		List<String> hashtags_list = new ArrayList<String>();
		// TODO Auto-generated method stub
		FormBeanFactory<TrendsForm> formBeanFactory = FormBeanFactory
				.getInstance(TrendsForm.class);
		HttpSession session = request.getSession();

		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		List<DisplayTweets> display_tweets_list = new ArrayList<DisplayTweets>();
		
		TrendsForm form;
		try {
			
			System.out.println("BALBALBALBALBALBALBALBALBALBALB");
			form = formBeanFactory.create(request);
			request.setAttribute("form", form);

			String access_token = (String) session.getAttribute("access_token");
			System.out.println("access token" + access_token);
			
	//		String access_token = "78393606-guQnJvrXy09ISr89qRIGqwaXo4J8AiEcxHyWVcYO0";
	//		String access_token_secret = "g6ywkkbf5V3hdUxzSMjCRUB2omHrOaohIyfdpoGFQ83yx";

			String access_token_secret = (String) session
					.getAttribute("access_token_secret");
			System.out.println("access token secret" + access_token_secret);
			request.setAttribute("form", form);

			Twitter twitter = new Twitter();

			if (!form.isPresent()) {
				return "trendsKeyword.jsp";
			}

			errors.addAll(form.getValidationErrors());
			if (errors.size() != 0) {
				return "trendsKeyword.jsp";
			}

			String keyword = form.getKeyword();
			System.out.println("***KEYWORD: " +  keyword);

			JSONObject tweets = twitter.searchTweetsPopular(keyword+" food", access_token,
					access_token_secret);
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
				//System.out.println("created_at: "+created_at);
				String text = innerObj.getString("text");
				display_tweet.setText(text);
				//System.out.println("text: "+text);
//				String retweet_count = innerObj.getString("retweet_count");
//				System.out.println("retweet_count: "+retweet_count);
				JSONObject user = (JSONObject) innerObj.getJSONObject("user");
				String name = user.getString("name");
				display_tweet.setName(name);
				//System.out.println("name: "+ name);
				String screen_name = user.getString("screen_name");
				display_tweet.setSreen_name(screen_name);
				//System.out.println("Screen_name: "+screen_name);
				String profile_image_url_https = user.getString("profile_image_url_https");
				display_tweet.setProfile_image_url_https(profile_image_url_https);
				//System.out.println(profile_image_url_https);
				String source = innerObj.getString("source");
				display_tweet.setSource(source);
				//System.out.println("SOurce: "+source);
				JSONObject entities = (JSONObject) innerObj.getJSONObject("entities");
				JSONArray urls = (JSONArray) entities.getJSONArray("urls");
				
				JSONArray hashtags = (JSONArray) entities.getJSONArray("hashtags");
				//int x = urls.length();
				
				System.out.println("Hshtags"+hashtags);
				
				for (int g = 0; g< hashtags.length(); g++){
					JSONObject innerObj2 = (JSONObject) hashtags.get(g);
					
					String text_tag  = innerObj2.getString("text");
					if(text_tag!=null)
					hashtags_list.add(text_tag);					
					
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
			
			
			
			for(String tag: hashtags_list){
				System.out.println("Tag# :" +tag);
				 if( !hashtag_map_count.containsKey( tag ) ){
			            hashtag_map_count.put( tag, 1);
			        } else { 
			            hashtag_map_count.put( tag, hashtag_map_count.get( tag ) + 1 );
			        }
				 
				 System.out.println("Hashmap tag: " +tag+"\t"+hashtag_map_count.get(tag));
			}
			
			
			
			System.out.println("Count: "+j);
			request.setAttribute("display_tweets_list", display_tweets_list);
			request.setAttribute("count", j);
			request.setAttribute("hashtag_map_count", hashtag_map_count);
			request.setAttribute("keyword", keyword);
			request.setAttribute("statuses", statuses);
			
			
			
			//CHANGE THE FILE NAME ACCORDING TO WHAT YOU WANT>>>CREATE A JSP AND DRAW A MAP LIKE YOU DID THE LAST TIME< WITH KEY ON X AXIS AND VALUE ON Z.
			
			return "hashtagTweetsGraph.jsp";
			
		} catch (FormBeanException e) {
			// TODO Auto-generated catch block
			errors.add(e.getMessage());
			return "trendsKeyword.jsp";
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
			errors.add(e.getMessage());
			return "trendsKeyword.jsp";
		}

		// twitter.searchTweets(q, access_token, access_token_secret)	

	}

}
