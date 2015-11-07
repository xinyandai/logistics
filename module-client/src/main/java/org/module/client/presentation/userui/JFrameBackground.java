package org.module.client.presentation.userui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JFrameBackground {

 private JFrame frame = new JFrame("背景图片测试");
 private JPanel imagePanel;

 
 private ImageIcon background;
 private String path = "pic/login.png";
 
 public static void main(String[] args) {
  new JFrameBackground();
 }

 public JFrameBackground() {
	  background = new ImageIcon(path);// 背景图片
	  JLabel label = new JLabel(background);// 把背景图片显示在一个标签里面
	  // 把标签的大小位置设置为图片刚好填充整个面板
	  label.setBounds(0, 0, background.getIconWidth(),background.getIconHeight());
	  // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
	  
	 imagePanel = (JPanel) frame.getContentPane();
	  imagePanel.setOpaque(false);
	  // 内容窗格默认的布局管理器为BorderLayout
	 //imagePanel.setLayout(new FlowLayout());
	  //imagePanel.add(new JButton("测试按钮"));

	  frame.getLayeredPane().setLayout(null);
	  // 把背景图片添加到分层窗格的最底层作为背景
	  frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  
	  frame.setSize(background.getIconWidth(), background.getIconHeight());
	  frame.setResizable(false);
	  frame.setVisible(true);
 }
}
