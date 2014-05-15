package schiffer.flicker;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Loads a single image from a url into a JLabel
 */
public class DownloadImageThread extends Thread {
	private JLabel label;
	private String url;
	
	public DownloadImageThread(final JLabel label, final String url) {
		//downloads one image and loads into jlabel
		//we'll need 20 of these threads.
		this.label = label;
		this.url = url;
	}
	
	@Override
	public void run(){
		URL theUrl;
		try {
			theUrl = new URL(url);
		
		ImageIcon imgThisImg = new ImageIcon(theUrl);
		label.setIcon(imgThisImg);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}