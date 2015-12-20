package org.module.client.presentation;
import java.awt.*;

public class InOutPane extends TransitionTabbedPane {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1982906839811118172L;

	public void paintTransition(Graphics2D g2, int state,
            Rectangle size, Image prev) {
        
        int length = getAnimationLength();
        int half = length/2;
        
        double scale = size.getHeight()/length;
        int offset = 0;
        // calculate the fade out part
        if(state >= 0 && state < half) {
            // draw the saved version of the old tab component
            if(prev != null) {
                g2.drawImage(prev,(int)size.getX(),(int)size.getY(),null);
            }
            offset = (int)((10-state)*scale);
        }
        
        // calculate the fade in part
        if(state >= half && state < length) {
            g2.setColor(Color.white);
            offset = (int)((state-10)*scale);
        }
        
        
        // do the drawing
        g2.setColor(Color.white);
        Rectangle area = new Rectangle((int)(size.getX()+offset),
            (int)(size.getY()+offset),
            (int)(size.getWidth()-offset*2),
            (int)(size.getHeight()-offset*2));
        g2.fill(area);
    }
}
