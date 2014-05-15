package schiffer.mtamap;

public class Shape {
	private String shapeId;
	private double latitude;
	private double longitude;
	private int sequence;
	
	public Shape(String shapeId, double latitude, double longitude, int sequence) {

		this.shapeId = shapeId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.sequence = sequence;
	}

	public String getShapeId() {
		return shapeId;
	}
	public double getLatitude(){
		return latitude;
	}
	public double getLongitude(){
		return longitude;
	}
	public int getSequence(){
		return sequence;
	}
	public String toString() {
		return "Shape [shapeId=" + shapeId + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
	}

}