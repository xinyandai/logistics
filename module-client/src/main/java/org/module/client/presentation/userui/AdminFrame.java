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
	

	
	public AdminFrame() {
		  String path = "pic/bkg.png";
		  ImageIcon background = new ImageIcon(path);// 背景图片
		  JLabel label = new JLabel(background);// 把背景图片显示在一个标签里面
		  label.setBounds(0, 0, background.getIconWidth(),background.getIconHeight());
		  JPanel imagePanel = (JPanel) getContentPane();
		  imagePanel.setOpaque(false);
		  getLayeredPane().setLayout(null);
		  getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel labelOfManager = new JLabel("管理人员");
		panel.add(labelOfManager);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setOpaque(false);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new UserPanel();
		tabbedPane.addTab("账号管理", null, panel_1, null);
	}

}
