package schiffer.ufo;

import com.google.gson.annotations.SerializedName;

public class Sighting {

	private String description;
	@SerializedName("sighted_at")
	private String sightedAt;
	@SerializedName("reported_at")
	private String reportedAt;
	private String duration;
	private String shape;
	private String location;

	public String getDescription() {
		return description;
	}

	public String getSightedAt() {
		return sightedAt;
	}

	public String getReportedAt() {
		return reportedAt;
	}

	public String getDuration() {
		return duration;
	}

	public String getShape() {
		return shape;
	}

	public String getLocation() {
		return location;
	}

	@Override
	public String toString() {
		return "Sighting [location=" + location + ", sightedAt=" + sightedAt + "]";
	}
}
//this sighted at should be used with a different name
	//use annotation-
	//reflection-allows within your java code to look at the contents
	//of a class.
	//annotations are little notes you leave in code for 
	//when something is using reflection
	
