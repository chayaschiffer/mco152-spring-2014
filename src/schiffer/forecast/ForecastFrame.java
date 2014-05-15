package schiffer.forecast;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;

public class ForecastFrame extends JFrame{
	public ForecastFrame() throws IOException{
		setSize(700,400);
	
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setTitle("WEATHER FORECAST 5 DAY");
	WeatherPanel panel = new WeatherPanel();
	add(panel, BorderLayout.NORTH);
	
	}
	
	public static void main(String[] args){
		ForecastFrame frame;
		try {
			frame = new ForecastFrame();
			frame.setVisible(true);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


}
