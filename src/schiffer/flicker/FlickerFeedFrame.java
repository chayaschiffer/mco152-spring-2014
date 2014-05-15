package schiffer.flicker;

import java.awt.FlowLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;

public class FlickerFeedFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel[] labels;

	public FlickerFeedFrame() {
		setSize(800, 600);
		setTitle("PICTURES");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		labels = new JLabel[20];
		for (int i = 0; i < 20; i++) {
			labels[i] = new JLabel();
			this.add(labels[i]);
		}
	     JScrollBar bar=new JScrollBar(JScrollBar.HORIZONTAL, 40, 20, 0, 300);
	     this.add(bar);
	     
	}

	/**
	 * Runs a LoadImageThread for each image in the feed
	 * 
	 * @throws IOException
	 */
	public void loadImages(final FlickerFeed feed) throws IOException {
		Thread thread;
		String url;
		for (int i = 0; i < 20; i++) {
			url = feed.getItem(i).getMedia().getM();
			thread = new DownloadImageThread(labels[i], url);
			thread.start();
		}
	}

	public static void main(final String args[]) {
		FlickerFeedFrame frame = new FlickerFeedFrame();
		Thread thread = new DownloadFlickerFeedThread(frame);
		thread.start();
		frame.setVisible(true);
	}

}
