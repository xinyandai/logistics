package org.module.client.presentation.userui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image  bkgImg = new ImageIcon("pic/background.png").getImage();
	private int w;
	private int h;
	
	
	public BackgroundPanel(int w, int h) {
		super();
		this.w = w;
		this.h = h;
	}


	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(bkgImg, 0, 0, bkgImg.getWidth(null), bkgImg.getHeight(null), 
				            0, 0, w, h, null);
	}

}
