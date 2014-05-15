package schiffer.clock;

public class ClockThread extends Thread {
	private Clock clock;
	
	public ClockThread(Clock clock){
		this.clock = clock;
	}
	
	@Override
	public void run() {
		super.run();
		while(true){
			clock.increaseSeconds();
			clock.repaint();
			
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
		}
	}
}
