package schiffer.ufo;

public class Location {
	private String zip;
	private String city;
	private String state;

	public Location(String zip,String city, String state){
		this.zip = zip;
		
		this.city = city;
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	
	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}
	@Override
	public String toString() {
		return "Location [zip=" + zip + ", city=" + city + ", state="
				+ state + "]";
	}

	
}
