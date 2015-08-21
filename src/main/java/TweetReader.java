import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.twitter.api.reader.ConvertJsonToObject;
import com.twitter.api.reader.TextFileLoader;
import com.twitter.api.reader.Tweet;

public class TweetReader {
	public static List<Tweet> readTweets(String fileName, String root) throws IOException {
		String json = TextFileLoader.read(fileName, false).toString();
		
		if (root != null) {
			Map<String, Object> rootJson = ConvertJsonToObject.getFromJson(json, Map.class);
			String innerJson = ConvertJsonToObject.toJson(rootJson.get(root));
			
			return jsonToList(innerJson);
		}
		
		return jsonToList(json);
	}
	
	public static List<Tweet> readTweets(String fileName) throws IOException {
		return readTweets(fileName, null);
	}
	
	public static List<Tweet> jsonToList(String jsonString) {
		Tweet[] tweets = ConvertJsonToObject.getFromJson(jsonString, Tweet[].class);
		return Arrays.asList(tweets);
	}
	
	public static void main(String[] args) {
		try {
			for (Tweet tweet : readTweets("testFile.json", "dataArray")) {
				System.out.println(tweet);
			}
			
			System.out.println("");
			
			for (Tweet tweet : readTweets("testFileNoWrap.json")) {
				System.out.println(tweet);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
