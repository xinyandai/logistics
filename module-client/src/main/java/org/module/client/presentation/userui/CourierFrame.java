package org.module.client.presentation.userui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import org.module.client.presentation.FontFactory;
import org.module.client.presentation.logisticsui.LogisticsPanel;
import org.module.client.presentation.orderui.ListTableForMailingList;
import org.module.client.presentation.orderui.ListTableForReceive;

public class CourierFrame extends FatherFrame {


	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private FontFactory font = new FontFactory();
	
	

	public CourierFrame() {
		
		 
		super();
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("快递员");
		label.setFont(font.getStateFont());
		panel.add(label);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setOpaque(false);
		tabbedPane.setFont(font.getTabbeFont());
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new LogisticsPanel();
		panel_1.setOpaque(false);
		tabbedPane.addTab("物流查询", null, panel_1, "物流查询");
		
		JPanel panel_2 = new ListTableForMailingList();
		panel_2.setOpaque(false);
		tabbedPane.addTab("订单输入", null, panel_2, "订单输入");
		
		JPanel panel_3 = new ListTableForReceive();
		panel_3.setOpaque(false);
		tabbedPane.addTab("收件输入", null, panel_3, "收件输入");
	}

}
