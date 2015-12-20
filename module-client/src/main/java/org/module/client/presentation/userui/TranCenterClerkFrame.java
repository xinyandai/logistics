package org.module.client.presentation.userui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import org.module.client.presentation.orderui.ListTableForTranCenterArrival;
import org.module.client.presentation.orderui.ListTableForTranCenterLoading;
import org.module.client.presentation.orderui.ListTableForTransport;

public class TranCenterClerkFrame extends FatherFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public TranCenterClerkFrame() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.setOpaque(false);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("中转中心业务员");
		panel.add(label);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setOpaque(false);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new ListTableForTranCenterArrival();
		panel_1.setOpaque(false);
		tabbedPane.addTab("中转接收", null, panel_1, null);
		
		JPanel panel_2 = new ListTableForTranCenterLoading();
		panel_2.setOpaque(false);
		tabbedPane.addTab("装车管理", null, panel_2, null);
		
		JPanel panel_3 = new ListTableForTransport();
		panel_3.setOpaque(false);
		tabbedPane.addTab("中转管理", null, panel_3, null);
	}

}
