package schiffer.primeNumbers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PrimeNumber extends JFrame implements ActionListener, Runnable {
	private JTextArea area;
	private JButton button;

	public PrimeNumber() {

		area = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(area);
		this.getContentPane().add(scrollPane);
		button = new JButton("START");

		setSize(800, 600);
		setLocation(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(button, BorderLayout.SOUTH);
		add(area, BorderLayout.CENTER);

		button.addActionListener(this);
	}

	public static void main(String[] args) {
		PrimeNumber gui = new PrimeNumber();
		gui.setVisible(true);
	}

	@Override
	public void run() {
		for (int i = 1; i < 10000000; i += 2) {
			for (int j =2; j < i; j++) {
				if (i % j != 0 && j + 1 == i) {
					area.append(String.valueOf(i) + "\n");
				}
			}

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Thread t = new Thread(this);
		t.start();

	}
}