package schiffer.mtamap;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.List;
import javax.swing.JComponent;

public class DrawMap extends JComponent {

	private final Trips trips;
	private final Routes routes;
	private final Shapes shapes;

	public DrawMap(Trips trips, Routes routes, Shapes shapes)
			throws IOException {
		this.trips = trips;
		this.routes = routes;
		this.shapes = shapes;
	}

	@Override
	public void paintComponent(Graphics g2) {
		super.paintComponent(g2);
		Graphics2D g = (Graphics2D) g2;
		int widthOfWindow = getWidth();
		int heightOfWindow = getHeight();
		int dimension = Math.min(widthOfWindow, heightOfWindow);
		double minimumLat = this.shapes.getMinimumLatitude();
		double minimumLon = this.shapes.getMinimumLongitude();
		double latitudeLength = this.shapes.getLatitudeLength();
		double longitudeLength = this.shapes.getLongitudeLength();

		List<String> shapeIds = this.shapes.getShapeIds();
		
		for (String shapeById : shapeIds) {
			List<Shape> allShapesWithThisId = this.shapes.getShapes(shapeById);
			Trip trip = this.trips.getTrip(shapeById);
			if(trip!=null){
					Color color = this.routes.getColor(trip.getRouteId());
					g.setColor(color);
					for (int i = 1; i < allShapesWithThisId.size(); i++) {
						Shape first = (Shape) allShapesWithThisId.get(i - 1);
						Shape second = (Shape) allShapesWithThisId.get(i);
						int PixelX1 = (int) ((first.getLatitude() - minimumLat)
								* dimension / latitudeLength);
						int PixelY1 = (int) ((first.getLongitude() - minimumLon)
								* dimension / longitudeLength);
						int PixelX2 = (int) ((second.getLatitude() - minimumLat)
								* dimension / latitudeLength);
						int PixelY2 = (int) ((second.getLongitude() - minimumLon)
								* dimension / longitudeLength);
						if(PixelX1 != PixelX2 || PixelY1!= PixelY2){
							g.drawLine(PixelX1, PixelY1, PixelX2, PixelY2);
						}
					}	
				}

			}

		}

}

	

