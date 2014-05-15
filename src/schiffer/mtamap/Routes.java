package schiffer.mtamap;

import java.awt.Color;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import au.com.bytecode.opencsv.CSVReader;

public class Routes {
	private List<Route> routes;

	public Routes() throws IOException {
		CSVReader reader = new CSVReader(new FileReader("./routes.txt"));

		reader.readNext();

		String[] nextLine;
		this.routes = new ArrayList<Route>();

		while ((nextLine = reader.readNext()) != null) {
			String routeId = nextLine[0];
			if (!"".equals(nextLine[7])) {
				Route route = new Route(routeId, Color.decode("0x"+ nextLine[7]));
				this.routes.add(route);
			}

		}
		reader.close();
	}

	public Route getRoute(String routeId) {
		for (Route r : routes) {
			if (routeId.equals(r.getRouteId())){
				return r;
			}

		}
		return null;
	}

	public Color getColor(String routeId) {
		Route route = this.getRoute(routeId);
		if (route == null){
			return Color.GRAY;
		}
		return route.getColor();
	}
}