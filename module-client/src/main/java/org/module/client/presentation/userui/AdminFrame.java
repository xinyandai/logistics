package org.module.client.presentation.userui;



import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import org.module.client.presentation.FontFactory;

public class AdminFrame extends FatherFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2413496219282034059L;
	private JPanel contentPane;
	private FontFactory fontFactory = new FontFactory() ;

	
	public AdminFrame() {
		 
		super();
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel labelOfManager = new JLabel("管理人员");
		labelOfManager.setFont(this.fontFactory.getTabelNameInput());
		panel.add(labelOfManager);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(this.fontFactory.getTabbeFont());
		tabbedPane.setOpaque(false);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new UserPanel();
		tabbedPane.addTab("账号管理", null, panel_1, null);
	}
	
}
