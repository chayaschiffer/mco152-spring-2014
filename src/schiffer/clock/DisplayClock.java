package schiffer.clock;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class DisplayClock extends JFrame {
	public DisplayClock(Clock clock) {
		setSize(800, 600);
		setTitle("CLOCK");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(clock, BorderLayout.CENTER);
		setVisible(true);
	}
	

	public static void main(String[] args) {
		Clock aclock = new Clock();
		DisplayClock clock = new DisplayClock(aclock);
		Thread thread = new ClockThread(aclock);
		thread.start();
	}
}
