package com.twitter.api.reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConvertJsonToObject {
	private static Gson gson = new GsonBuilder().create();

	public static final <T> T getFromJson(String json, Class<T> clazz) {
		return gson.fromJson(json, clazz);
	}

	public static final <T> String toJson(T clazz) {
		return gson.toJson(clazz);
	}
}