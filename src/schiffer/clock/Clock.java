package schiffer.clock;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JPanel;

public class Clock extends JPanel {
	private int seconds;
	private int minutes;
	private int hours;

	public Clock() {
		GregorianCalendar now = new GregorianCalendar();
		this.seconds = now.get(Calendar.SECOND);
		this.minutes = now.get(Calendar.MINUTE);
		this.hours = now.get(Calendar.HOUR);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int height = getHeight();
		int width = getWidth();
		int clockRadius = (int) (Math.min(width, height) * 0.8 * 0.5);
		int xCenter = getWidth() / 2;
		int yCenter = getHeight() / 2;
		// Draw circle
		g.setColor(Color.BLACK);
		g.fillOval(xCenter - clockRadius, yCenter - clockRadius,
				2 * clockRadius, 2 * clockRadius);
		g.setColor(Color.orange);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));
		g.setFont(new Font("default", Font.BOLD, 16));
		g.drawString("12", xCenter - 5, yCenter - clockRadius + 12);
		g.drawString("9", xCenter - clockRadius + 3, yCenter + 5);
		g.drawString("3", xCenter + clockRadius - 10, yCenter + 3);
		g.drawString("6", xCenter - 5, yCenter + clockRadius - 3);
		g2.setStroke(new BasicStroke(2));
		// Draw second hand
		int sLength = (int) (clockRadius * 0.8);
		int xSecond = (int) (xCenter + sLength
				* Math.sin(seconds * (2 * Math.PI / 60)));
		int ySecond = (int) (yCenter - sLength
				* Math.cos(seconds * (2 * Math.PI / 60)));
		g.setColor(Color.red);
		g.drawLine(xCenter, yCenter, xSecond, ySecond);

		// Draw minute hand
		int mLength = (int) (clockRadius * 0.75);
		int xMinute = (int) (xCenter + mLength
				* Math.sin(minutes * (2 * Math.PI / 60)));
		int yMinute = (int) (yCenter - mLength
				* Math.cos(minutes * (2 * Math.PI / 60)));
		g.setColor(Color.blue);
		g.drawLine(xCenter, yCenter, xMinute, yMinute);

		// Draw hour hand
		int hLength = (int) (clockRadius * 0.5);

		int xHour = (int) (xCenter + hLength
				* Math.sin((hours % 12 + minutes / 60.0) * (2 * Math.PI / 12)));
		int yHour = (int) (yCenter - hLength
				* Math.cos((hours % 12 + minutes / 60.0) * (2 * Math.PI / 12)));
		g.setColor(Color.yellow);
		g.drawLine(xCenter, yCenter, xHour, yHour);
	}

	public void increaseSeconds() {
		this.seconds++;
		if (this.seconds == 60) {
			this.seconds = 0;
			this.minutes++;
			if (this.minutes == 60) {
				this.minutes = 0;
				this.hours++;
				if (this.hours == 13) {
					this.hours = 1;

				}
			}
		}
	}

}
