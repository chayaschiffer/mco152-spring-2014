package schiffer.flicker;

import java.io.IOException;

import javax.swing.Icon;
import javax.swing.JLabel;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class DownloadFlickerFeedThreadTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCallsDownloadFlickerFeed() throws IOException {
		// mock frame
		FlickerFeedFrame frame = Mockito.mock(FlickerFeedFrame.class);
		DownloadFlickerFeedThread thread = new DownloadFlickerFeedThread(frame);

		thread.run();
		// here we call run because we want to execute this code in the same
		// thread that the test is currently running.
		// we don't want code to execute new thread.
		// don't do this in real code
		// verify that on frame, the method loadImages() was called
		Mockito.verify(frame, Mockito.times(1)).loadImages(Mockito.any(FlickerFeed.class));
	}
	@Test 
	public void testCallLoadImages()throws IOException{
		final JLabel label = Mockito.mock(JLabel.class);
		final DownloadImageThread thread = new DownloadImageThread(label, "https://farm2.static.flickr.com/2902/14179574494_91cfe3247a_m.jpg");
		Mockito.verify(label, Mockito.never()).setIcon(Mockito.any(Icon.class));
		thread.run();
		Mockito.verify(label, Mockito.times(1)).setIcon(Mockito.any(Icon.class));
	}
}
