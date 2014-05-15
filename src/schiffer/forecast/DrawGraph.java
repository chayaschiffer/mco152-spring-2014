package schiffer.forecast;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class DrawGraph extends JPanel {
	private final int MAX_TEMP = 400;
	private final int PREF_W = 800;
	private final int PREF_H = 650;
	private final int border_gap = 30;
	private final Color GRAPH_COLOR = Color.green;
	private final Color GRAPH_POINT_COLOR = new Color(150, 50, 50, 180);
	private final Stroke GRAPH_STROKE = new BasicStroke(3f);
	private final int GRAPH_POINT_WIDTH = 7;
	private final int Y_HATCH_CNT = 10;
	private int[] temps;

	public DrawGraph(WeatherForecast forecast) throws IOException {
		temps = new int[35];
		for (int i = 0; i < forecast.getForecast().getForecastList().length; i++) {
			temps[i] = (int) forecast.getForecast().getForecastList()[i]
					.getMain().getTemp();
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		double xScale = ((double) getWidth() - 2 * border_gap)
				/ (temps.length - 1);
		double yScale = ((double) getHeight() - 2 * border_gap)
				/ (MAX_TEMP - 1);
		List<Point> graphPoints = new ArrayList<Point>();
		for (int i = 0; i < temps.length; i++) {
			int x1 = (int) (i * xScale + border_gap);
			int y1 = (int) ((MAX_TEMP - temps[i]) * yScale + border_gap);
			graphPoints.add(new Point(x1, y1));
		}

		g2.drawLine(border_gap, getHeight() - border_gap, border_gap,
				border_gap);
		g2.drawLine(border_gap, getHeight() - border_gap, getWidth()
				- border_gap, getHeight() - border_gap);

		for (int i = 0; i < Y_HATCH_CNT; i++) {
			int x0 = border_gap;
			int x1 = GRAPH_POINT_WIDTH + border_gap;
			int y0 = getHeight()
					- (((i + 1) * (getHeight() - border_gap * 2)) / Y_HATCH_CNT + border_gap);
			int y1 = y0;
			g2.drawLine(x0, y0, x1, y1);
		}

		
		for (int i = 0; i < temps.length - 1; i++) {
			int x0 = (i + 1) * (getWidth() - border_gap * 2)
					/ (temps.length - 1) + border_gap;
			int x1 = x0;
			int y0 = getHeight() - border_gap;
			int y1 = y0 - GRAPH_POINT_WIDTH;
			g2.drawLine(x0, y0, x1, y1);
		}
		Stroke oldStroke = g2.getStroke();
		g2.setColor(GRAPH_COLOR);
		g2.setStroke(GRAPH_STROKE);
		for (int i = 0; i < graphPoints.size() - 1; i++) {
			int x1 = graphPoints.get(i).x;
			int y1 = graphPoints.get(i).y;
			int x2 = graphPoints.get(i + 1).x;
			int y2 = graphPoints.get(i + 1).y;
			g2.drawLine(x1, y1, x2, y2);
		}

		g2.setStroke(oldStroke);
		g2.setColor(GRAPH_POINT_COLOR);
		for (int i = 0; i < graphPoints.size(); i++) {
			int x = graphPoints.get(i).x - GRAPH_POINT_WIDTH / 2;
			int y = graphPoints.get(i).y - GRAPH_POINT_WIDTH / 2;
			;
			int ovalW = GRAPH_POINT_WIDTH;
			int ovalH = GRAPH_POINT_WIDTH;
			g2.fillOval(x, y, ovalW, ovalH);
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(PREF_W, PREF_H);
	}

}
