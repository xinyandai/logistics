package org.module.client.presentation.userui;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import org.module.client.vo.UserVO;

public class AdministratorUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6952954342093229761L;
	private JPanel contentPane;

	 private ImageIcon background;
	 private String path = "pic/login.png";

	/**
	 * Create the frame.
	 */
	public AdministratorUI(ArrayList<UserVO> vos) {
		
		background = new ImageIcon(path);// 背景图片
		  JLabel label = new JLabel(background);// 把背景图片显示在一个标签里面
		  // 把标签的大小位置设置为图片刚好填充整个面板
		  label.setBounds(0, 0, background.getIconWidth(),background.getIconHeight());
		  // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
		  
		 JPanel imagePanel = (JPanel) getContentPane();
		  imagePanel.setOpaque(false);
		  // 内容窗格默认的布局管理器为BorderLayout
		 //imagePanel.setLayout(new FlowLayout());
		  //imagePanel.add(new JButton("测试按钮"));

		  getLayeredPane().setLayout(null);
		  // 把背景图片添加到分层窗格的最底层作为背景
		  getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(0, 10, 424, 207);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 1, 1));
		
		JTextPane textPane = new JTextPane();
		textPane.setText("\u589E\u5220\u6539\u529F\u80FD\u6682\u672A\u5B9E\u73B0");
		textPane.setBounds(53, 223, 200, 28);
		textPane.setOpaque(false);
		contentPane.add(textPane);
		
		for (UserVO userVO : vos) {
			String s =String.format("%10s", userVO.getId())+
			           " "+ String.format("%10s", userVO.getName())+
			           " "+ String.format("%15s", userVO.getPassword())+
					   " "+ String.format("authority:%2s", userVO.getAuthority());
			panel.add(new JLabel(s)) ;
		}
	}
}
