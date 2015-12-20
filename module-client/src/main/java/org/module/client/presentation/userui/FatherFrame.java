package org.module.client.presentation.userui;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FatherFrame extends JFrame {

	private static final long serialVersionUID = -7658355329860590674L;
	public FatherFrame() {
		this.setBackground();
	}
    protected void setBackground(){
    	  
    	  String path = "pic/bkg.jpg";
    	  InputStream stream = this.getClass().getClassLoader().getResourceAsStream(path);
    	  try {
			   Image img = ImageIO.read(stream);
			   ImageIcon background = new ImageIcon(img);// 背景图片
			   JLabel back = new JLabel(background);// 把背景图片显示在一个标签里面
			   back.setBounds(0, 0, background.getIconWidth(),background.getIconHeight());
			   JPanel imagePanel = (JPanel) getContentPane();
			   imagePanel.setOpaque(false);
			   getLayeredPane().setLayout(null);
			   getLayeredPane().add(back, new Integer(Integer.MIN_VALUE));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
    }
}
