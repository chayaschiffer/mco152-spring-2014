package schiffer.pi;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class GUI extends JFrame implements ActionListener, Runnable{
	private JTextArea area;
	private JButton button;

	public GUI() {

		area = new JTextArea();
		button = new JButton("START");

		setSize(800, 600);
		setLocation(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(button, BorderLayout.SOUTH);
		add(area, BorderLayout.CENTER);

		button.addActionListener(this);
	}
	

	public static void main(String[] args) {
		GUI gui = new GUI();
		gui.setVisible(true);
	}
	
	@Override 
	public void run(){
		double pi=0;
		for (int i = 1; i < 1000000000; i++) {
			pi += 4 *  Math.pow(-1, i + 1) / (2 * i - 1);
		area.setText(String.valueOf(pi));
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Thread t = new Thread(this);
		t.start();
		
	}
}

//can either create a thread by 
//1) creating a separate class 
//2) Thread t = new Thread(new Runnable(){
/*		@Override
		public void run(){
		put pi calculations here
	}
)};
*/