package org.module.client.main;

import java.awt.EventQueue;

import org.module.client.presentation.mainui.MainFrame;
import org.module.client.vo.UserVO;



public class Main {

	public static UserVO currentUser ;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
