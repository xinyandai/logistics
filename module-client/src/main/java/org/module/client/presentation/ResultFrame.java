package org.module.client.presentation;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ResultFrame extends JFrame {

	private static final long serialVersionUID = 2662773949256159161L;
	private JPanel contentPane;
	private String path;
	private ImageIcon background;
	private int w ;
	private int h ; 
	
	public ResultFrame(boolean isSuccess,Component c) {
		   this.path = "pic"+File.separator +
				(isSuccess? "success" : "fail" ) + ".png";
		//   InputStream stream = this.getClass().getClassLoader().getResourceAsStream(path);
		   background = new ImageIcon(path);// 背景图片
		   JLabel label = new JLabel(background);// 把背景图片显示在一个标签里面
		   this.w = this.background.getIconWidth();
		   this.h = this.background.getIconHeight();
		   
		   label.setBounds(0, 0,w ,h);
		   getLayeredPane().setLayout(null);
		   getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		
		if(c==null ){
			setBounds(100, 100, w, h);
		}else{
			//setBounds(parent.getWidth()/2-w/2, parent.getHeight()/2 - h/2, w, h);
			/*setBounds(
					c.getX()
					//+ (c.getWidth() - w)/2
					,
					c.getY()
					//+( c.getHeight() + h)/2
					,
					w ,h);*/
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			
			setBounds(d.width/2-w/2, d.height/2-h/2, w, h);
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setOpaque(false);
		this.setUndecorated(true);
		this.getLayeredPane().setOpaque(false);
		setContentPane(contentPane);
		this.start();
	}
	public ResultFrame(boolean isSuccess) {
		   this.path = "pic"+File.separator +
				(isSuccess? "success" : "fail" ) + ".png";
		
		   background = new ImageIcon(path);// 背景图片
		   JLabel label = new JLabel(background);// 把背景图片显示在一个标签里面
		   this.w = this.background.getIconWidth();
		   this.h = this.background.getIconHeight();
		   
		   label.setBounds(0, 0,w ,h);
		   getLayeredPane().setLayout(null);
		   getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			setBounds(d.width/2-w/2, d.height/2-h/2, w, h);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setOpaque(false);
		this.setUndecorated(true);
		this.getLayeredPane().setOpaque(false);
		setContentPane(contentPane);
		this.start();
	}
	public void start(){
		setVisible(true);
		new Thread(new Runnable() {
			public void run() {
				try {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();;
	}
	
	public static void main(String[] args ){
		new ResultFrame(true, null);
	}
}
