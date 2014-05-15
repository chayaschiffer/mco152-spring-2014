package schiffer.smiley;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class SmileyFace extends JComponent {

	@Override
	public void paintComponent(Graphics g) {
		/*g.setColor(new Color(-1166034));
		g.drawLine(0,0,this.getWidth(),this.getHeight());
		g.drawLine(0, getHeight(), getWidth(), 0);
		g.fillOval(getWidth()/2-50,getHeight()/2-50,100,100);
		//first 2 paramters are the location 300, 300
		*/
		g.setColor(Color.black);;
		g.fillRect(0, 0, 400, 400);
		g.setColor(Color.yellow);
		g.fillOval(0, 0, 400, 400);
		g.setColor(Color.black);
		g.fillOval(100, 100, 50, 50);
		g.fillOval(250, 100, 50, 50);
		g.drawArc(150, 250, 100, 100, 180, 180);
		g.drawArc(150, 250, 100, 100, 0, 180);
	}

}
