package schiffer.forecast;

public class ForecastArray {
	private Forecast[] list;
	
	
	public Forecast[] getForecastList(){
		return list;
	}
	@Override
	public String toString() {
		StringBuilder forecast = new StringBuilder();
		for (int i = 0; i < list.length; i++) {
			forecast.append(list[i].toString());
			forecast.append("\n");
		}
		return forecast.toString();
	}
	
}
