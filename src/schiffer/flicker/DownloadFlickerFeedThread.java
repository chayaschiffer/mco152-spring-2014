package schiffer.flicker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

/**
 * Retrieves the Flicker feed and calls frame.loadImages()
 */
public class DownloadFlickerFeedThread extends Thread {

	private static final String FEED_URL = "https://api.flickr.com/services/feeds/photos_public.gne?id=20952345@N03&format=json";
	private FlickerFeedFrame frame;
	
	public DownloadFlickerFeedThread(final FlickerFeedFrame frame) {
		// this downloads the json feed as a flicker feed object
		// in here you'll use gson, you'll connect to flicker,
		// you'll download the json feed as a flicker feed object
		// should call method in frame.
		this.frame = frame;
	}

	@Override
	public void run() {
		super.run();
		URL url;
		try {
			url = new URL(FEED_URL);
			URLConnection connection = url.openConnection();
			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			Gson gson = new Gson();
			final JsonReader jsonReader = new JsonReader(reader);
			jsonReader.setLenient(true);
			jsonReader.nextString();
			FlickerFeed feed = gson.fromJson(jsonReader, FlickerFeed.class);
			frame.loadImages(feed);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

}
