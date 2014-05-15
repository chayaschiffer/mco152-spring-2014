package schiffer.forecast;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WeatherPanel extends JPanel implements ActionListener {

	private JLabel enterCityLabel;
	private JTextField enterCity;
	private JButton select;
	private String location;
	private WeatherForecast weather;
	private DrawGraph graph;

	public WeatherPanel() {

		enterCityLabel = new JLabel(
				"Enter the name of a city and state/country");
		add(enterCityLabel);

		enterCity = new JTextField(20);
		add(enterCity);

		select = new JButton("Select");
		add(select);

		select.addActionListener(this);
	}

	public DrawGraph getGraph() {
		return graph;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		location = enterCity.getText();
		try {
			this.weather = new WeatherForecast(location);
			JFrame aframe = new JFrame();
			aframe.add(new DrawGraph(weather), BorderLayout.CENTER);

			aframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			aframe.pack();
			aframe.setLocationByPlatform(true);
			aframe.setVisible(true);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
