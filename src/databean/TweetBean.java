package databean;


public class TweetBean{
	private String text;
	private long favourites_count;
	private String tag;
	private String url;
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public long getFavourites_count() {
		return favourites_count;
	}
	public void setFavourites_count(long favourites_count) {
		this.favourites_count = favourites_count;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
