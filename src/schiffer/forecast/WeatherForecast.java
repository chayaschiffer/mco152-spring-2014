package schiffer.forecast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import com.google.gson.Gson;

public class WeatherForecast {
	private ForecastArray forecast;

	public WeatherForecast(String city) throws IOException {
		URL url = new URL("http://api.openweathermap.org/data/2.5/forecast?q="
				+ city + "&mode=json");
		URLConnection connection = url.openConnection();
		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		Gson gson = new Gson();
		forecast = gson.fromJson(reader, ForecastArray.class);
	}

	public ForecastArray getForecast() throws IOException {
		return forecast;
	}

}
