package com.twitter.api.reader;

public class Tweet {
	private long userId;
	private String user;
	private String location;
	private String text;
	private String date;
	private int retweetCount;
	private int favoriteCount;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getRetweetCount() {
		return retweetCount;
	}

	public void setRetweetCount(int retweetCount) {
		this.retweetCount = retweetCount;
	}

	public int getFavoriteCount() {
		return favoriteCount;
	}

	public void setFavoriteCount(int favoriteCount) {
		this.favoriteCount = favoriteCount;
	}

	@Override
	public String toString() {
		return "Tweet [userId=" + userId + ", user=" + user + ", location="
				+ location + ", text=" + text + ", date=" + date
				+ ", retweetCount=" + retweetCount + ", favoriteCount="
				+ favoriteCount + "]";
	}
}
