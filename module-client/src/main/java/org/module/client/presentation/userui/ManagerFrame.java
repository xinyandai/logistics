package org.module.client.presentation.userui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import org.module.client.presentation.departmentui.DeparmentPanel;
import org.module.client.presentation.departmentui.StuffPanel;
import org.module.client.presentation.managementui.CityAndPrice;
import org.module.client.presentation.managementui.TicketManagePanel;
import org.module.client.presentation.statisticui.CostPanel;

public class ManagerFrame extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerFrame frame = new ManagerFrame();
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
	public ManagerFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("总经理");
		panel.add(label);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_5 = new StuffPanel();
		tabbedPane.addTab("成员管理", null, panel_5, null);
		
		JPanel panel_1 = new DeparmentPanel();
		tabbedPane.addTab("机构管理", null, panel_1, null);
		
		JPanel panel_2 = new CostPanel();
		tabbedPane.addTab("成本管理", null, panel_2, null);
		
		JPanel panel_3 = new CityAndPrice();
		tabbedPane.addTab("价格与距离", null, panel_3, null);
		
		JPanel panel_4 = new TicketManagePanel();
		tabbedPane.addTab("单据管理", null, panel_4, null);
	}

}
