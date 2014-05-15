package schiffer.mtamap;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.IOException;
import javax.swing.JFrame;

public class Map extends JFrame {
	public Map() {
		try {
			Trips trips = new Trips();
			Routes routes = new Routes();
			Shapes shapes = new Shapes();
			DrawMap map = new DrawMap(trips, routes, shapes);
			Container pane = getContentPane();
			pane.setLayout(new BorderLayout());
			pane.add(map, BorderLayout.CENTER);
			setSize(800, 600);
			setTitle("MTA MAP");
			this.setDefaultCloseOperation(3);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}