package schiffer.smiley;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class SmileyFrame extends JFrame {
	public SmileyFrame() {
		setSize(800, 600);

		setTitle("A SMILEY FACE");

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLayout(new BorderLayout());

		add(new SmileyFace(), BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		SmileyFrame aframe = new SmileyFrame();
		aframe.setVisible(true);
	}
}
