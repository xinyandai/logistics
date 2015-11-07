package org.module.client.presentation.userui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import org.module.client.presentation.logisticsui.LogisticsPanel;
import org.module.client.presentation.orderui.MailingListPanel;
import org.module.client.presentation.orderui.ReceiveListPanel;
import org.module.client.presentation.ticketui.ReceiptPanel;

public class CourierFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourierFrame frame = new CourierFrame();
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
	public CourierFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("快递员");
		panel.add(label);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new LogisticsPanel();
		tabbedPane.addTab("物流查询", null, panel_1, null);
		
		JPanel panel_2 = new MailingListPanel();
		tabbedPane.addTab("订单输入", null, panel_2, null);
		
		JPanel panel_3 = new ReceiveListPanel();
		tabbedPane.addTab("收件输入", null, panel_3, null);
	}

}
