package schiffer.mtamap;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import au.com.bytecode.opencsv.CSVReader;

public class Trips {
	private List<Trip> trips;

	public Trips() throws IOException {

		CSVReader reader = new CSVReader(new FileReader("./trips.txt"));
		reader.readNext(); // skip the title line

		String[] nextLine;
		trips = new ArrayList<Trip>();
		while ((nextLine = reader.readNext()) != null) {
			String routeId = nextLine[0];
			String tripId = nextLine[2];
			String shapeId = nextLine[6];
			Trip aTrip = new Trip(routeId, tripId, shapeId);
			this.trips.add(aTrip);
		}
		reader.close();
	}

	public Trip getTrip(String shapeId) {
		for(Trip t: trips){
			if(shapeId.equals(t.getShapeId())){
				return t;
			}
		}
		return null;
		

	}

}
