package schiffer.mtamap;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import au.com.bytecode.opencsv.CSVReader;

public class Shapes {
	private List<Shape> shapes;
	private double maxLatitude = Double.MIN_VALUE;
	private double maxLongitude = -100;
	private double minLatitude = Double.MAX_VALUE;
	private double minLongitude = Double.MAX_VALUE;
	private double latitudeLength;
	private double longitudeLength;

	public Shapes() throws IOException {

		CSVReader reader = new CSVReader(new FileReader("./shapes.txt"));
		reader.readNext();
		String[] nextLine;
		this.shapes = new ArrayList<Shape>();
		while ((nextLine = reader.readNext()) != null) {
			String shapeId = nextLine[0];
			double latitude = Double.parseDouble(nextLine[1]);
			double longitude = Double.parseDouble(nextLine[2]);
			int sequence = Integer.parseInt(nextLine[3]);
			Shape ashape = new Shape(shapeId, latitude, longitude, sequence);
			
			this.shapes.add(ashape);
			
			this.maxLatitude = Math.max(this.maxLatitude, ashape.getLatitude());
			this.maxLongitude = Math.max(this.maxLongitude,
					ashape.getLongitude());
			this.minLatitude = Math.min(this.minLatitude, ashape.getLatitude());
			this.minLongitude = Math.min(this.minLongitude,
					ashape.getLongitude());
		}
		reader.close();
		this.latitudeLength = Math.abs(this.maxLatitude - this.minLatitude);
		this.longitudeLength = Math.abs(this.maxLongitude - this.minLongitude);
	}

	public List<String> getShapeIds() {
		ArrayList<String> shapesUnique = new ArrayList<String>();
		for (Shape s : shapes) {
			String shapeId = s.getShapeId();
			if (!shapesUnique.contains(shapeId))
				shapesUnique.add(shapeId);
		}
		return shapesUnique;
	}

	public List<Shape> getShapes(String shapeId) {
		List<Shape> listOfShapes = new ArrayList<Shape>();
		for(Shape s: shapes) {
			if (s.getShapeId().equals(shapeId)) {
				listOfShapes.add(s);
			}
		}
		return listOfShapes;
	}

	public double getMinimumLongitude() {
		return minLongitude;
	}

	public double getMinimumLatitude() {
		return minLatitude;
	}

	public double getLatitudeLength() {
		return latitudeLength;

	}

	public double getLongitudeLength() {
		return longitudeLength;
	}

}
