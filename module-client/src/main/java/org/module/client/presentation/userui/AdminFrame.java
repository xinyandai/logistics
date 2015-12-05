package org.module.client.presentation.userui;



import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.api.SubstanceSkin;
import org.jvnet.substance.skin.AutumnSkin;
import org.jvnet.substance.skin.MagmaSkin;
import org.jvnet.substance.skin.MistAquaSkin;
import org.jvnet.substance.skin.SubstanceOfficeBlue2007LookAndFeel;

public class AdminFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2413496219282034059L;
	private JPanel contentPane;
	private ImageIcon background;
	 private String path = "pic/login.png";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					
					JFrame.setDefaultLookAndFeelDecorated(true);
					JDialog.setDefaultLookAndFeelDecorated(true);
					
					
					try  { 
						                
						        SubstanceSkin skin  =   new  MistAquaSkin();   
						       // UIManager.setLookAndFeel( new  SubstanceOfficeBlue2007LookAndFeel());    
						        SubstanceLookAndFeel.setSkin(skin);  //设置皮肤                      
						}  
					catch  (Exception ex) {      
						Logger.getLogger(AdminFrame. class .getName()).log(Level.SEVERE,  null , ex);       
					} 
					
					AdminFrame frame = new AdminFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminFrame() {
		
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
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel labelOfManager = new JLabel("管理人员");
		panel.add(labelOfManager);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new UserPanel();
		tabbedPane.addTab("账号管理", null, panel_1, null);
	}

}
