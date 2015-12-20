package org.module.client.presentation.userui;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.module.client.presentation.logisticsui.LogisticsPanel;

public class CustomerFrame extends JFrame {

	
	private static final long serialVersionUID = -1452749767128951688L;
	private JPanel contentPane;

	
	public CustomerFrame() {
		 String path = "pic/bkg.jpg";
		  ImageIcon background = new ImageIcon(path);// 背景图片
		  JLabel back = new JLabel(background);// 把背景图片显示在一个标签里面
		  back.setBounds(0, 0, background.getIconWidth(),background.getIconHeight());
		  JPanel imagePanel = (JPanel) getContentPane();
		  imagePanel.setOpaque(false);
		  getLayeredPane().setLayout(null);
		  getLayeredPane().add(back, new Integer(Integer.MIN_VALUE));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(new LogisticsPanel());
		contentPane.setOpaque(false);
		setContentPane(contentPane);
	}

}
