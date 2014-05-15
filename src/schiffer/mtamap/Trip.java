package schiffer.mtamap;

public class Trip {
	
	private String routeId;
	private String tripId;
	private String shapeId;

	public Trip(String routeId, String tripId, String shapeId) {
	
		this.routeId = routeId;
		this.tripId = tripId;
		this.shapeId = shapeId;
	}

	public String getTripId() {
		return tripId;
	}
	public String getRouteId(){
		return routeId;
	}
	public String getShapeId(){
		return shapeId;
	}
	@Override
	public String toString() {
		return "Trip [trip=" + tripId + ", routeId=" + routeId + ", shapeId="
				+ shapeId + "]";
	}

	

}
