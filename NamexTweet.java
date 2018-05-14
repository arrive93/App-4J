//unduh twitter4j di http://twitter4j.org/en/index.html
//masukkan ke project     
//twitter4j-async-a.b.c.jar
//    twitter4j-core-a.b.c.jar
//    twitter4j-media-support-a.b.c.jar
//    twitter4j-stream-a.b.c.jar
//ubah consumer key, consumer key secret, access token, access token secret sesuai akun twitter anda


import java.io.IOException;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class NamexTweet {
    private final static String CONSUMER_KEY = "ZaEi8pUsoUwmqYSEyAhxWelM9";
    private final static String CONSUMER_KEY_SECRET = "a5jMDPCr9Rl9Xr5Oj49RUa5Oeg9l2otF2ke7npoxV7IwBlmXOU";

    public void start() throws TwitterException, IOException {

	Twitter twitter = new TwitterFactory().getInstance();
	twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

	// here's the difference
	String accessToken = getSavedAccessToken();
	String accessTokenSecret = getSavedAccessTokenSecret();
	AccessToken oathAccessToken = new AccessToken(accessToken,
		accessTokenSecret);

	twitter.setOAuthAccessToken(oathAccessToken);
	// end of difference

	twitter.updateStatus("Program maning Program maning :D");

	System.out.println("\nMy Timeline:");

	// I'm reading your timeline
	ResponseList<Status> list = twitter.getHomeTimeline();
	for (Status each : list) {

	    System.out.println("Sent by: @" + each.getUser().getScreenName()
		    + " - " + each.getUser().getName() + "\n" + each.getText()
		    + "\n");
	}

    }

    private String getSavedAccessTokenSecret() {
	// consider this is method to get your previously saved Access Token
	// Secret
	return "PkJtci0BtYwEE4D5BR6ilsgrluGbT4Upycw0q4E7RT9PY";
    }

    private String getSavedAccessToken() {
	// consider this is method to get your previously saved Access Token
	return "95430546-KDDovS38PURN6ei7YRPxk8ktq0iiVO1vTF38yNZwQ";
    }

    public static void main(String[] args) throws Exception {
	new NamexTweet().start();
    }
}
