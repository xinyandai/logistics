package org.module.client.presentation;
import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.image.*;

public class TransitionTabbedPane extends JTabbedPane 
    implements ChangeListener, Runnable {
    
	private static final long serialVersionUID = -2556929094913600418L;
	protected int step;
    protected BufferedImage buf = null;
    protected int previous_tab = -1;
    protected int animation_length = 20;

    public TransitionTabbedPane() {
        super();
        this.addChangeListener(this);
    }
    
    public void paintChildren(Graphics g) {
        super.paintChildren(g);
        
        if(step != -1) {
            Rectangle size = this.getComponentAt(0).getBounds();
            Graphics2D g2 = (Graphics2D)g;
            paintTransition(g2, step, size, buf);
        }
    }
    
    public int getAnimationLength() {
        return this.animation_length;
    }
    
    public void setAnimationLength(int length) {
        this.animation_length = length;
    }
    
    public void paintTransition(Graphics2D g2, int step,
            Rectangle size, Image prev) {
    }
    
    
    // threading code
    public void stateChanged(ChangeEvent evt) {
        new Thread(this).start();
    }
    

    public void run() {
        step = 0;
        
        // save the previous tab
        if(previous_tab != -1) {
            Component comp = this.getComponentAt(previous_tab);
            buf = new BufferedImage(comp.getWidth(),
                comp.getHeight(),
                BufferedImage.TYPE_4BYTE_ABGR);
            comp.paint(buf.getGraphics());
        }
        
        for(int i=0; i<animation_length; i++) {
            step = i;
            repaint();
            try {
				Thread.sleep(50);
            } catch (Exception ex) {
                p("ex: " + ex);
            }
        }
        
        step = -1;
        previous_tab = this.getSelectedIndex();
        repaint();
    }
    
    
    public static void p(String s) {
        System.out.println(s);
    }
}
