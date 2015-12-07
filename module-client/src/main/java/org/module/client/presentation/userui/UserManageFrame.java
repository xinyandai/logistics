package org.module.client.presentation.userui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class UserManageFrame extends JFrame {

	
	private static final long serialVersionUID = 4846089717026308459L;
	private JPanel contentPane;

	
	public UserManageFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new UserPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
	}

}
