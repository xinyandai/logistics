package org.module.client.presentation;

import java.awt.Image;
import java.awt.Insets;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Button extends JButton {
	private Image img;
	private static final long serialVersionUID = -7384345925676465454L;
	public Button(String type){
		
		this.setOpaque(false);
		 setMargin(new Insets(0,0,0,0));
	        setIconTextGap(0);
	        setBorderPainted(false);
	        setBorder(null);
	        setText(null);
		this.setSize(40, 40);
	//	String path = "pic"+File.separator+type+".png";
	//	img = new ImageIcon(path);
		InputStream stream = this.getClass().getClassLoader().getResourceAsStream("pic/"+type+".png");
		try {
			img = ImageIO.read(stream);
			img = (img.getScaledInstance( 
					this.getWidth()*2/3,this.getHeight()*2/3, Image.SCALE_DEFAULT));
			setIcon(new ImageIcon(img));
		} catch (IOException e) {
			this.setFont(new FontFactory().getStateFont());
			this.setText(type);
			e.printStackTrace();
		}
		
	}
}
