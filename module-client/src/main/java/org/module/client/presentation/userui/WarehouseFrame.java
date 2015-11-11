package org.module.client.presentation.userui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import org.module.client.presentation.managementui.OutAndInListPanel;
import org.module.client.presentation.managementui.TicketManagePanel;
import org.module.client.presentation.managementui.WarehouseCheckPanel;
import org.module.client.presentation.managementui.WarmPercentage;
import org.module.client.presentation.statisticui.AccountPanel;
import org.module.client.presentation.statisticui.CostPanel;
import org.module.client.presentation.statisticui.IncomePanel;
import org.module.client.presentation.statisticui.InitAccount;
import org.module.client.presentation.ticketui.GoDownEntryListPanel;
import org.module.client.presentation.ticketui.OutBoundListPanel;

public class WarehouseFrame extends JFrame {

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
					WarehouseFrame frame = new WarehouseFrame();
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
	public WarehouseFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("仓库管理员");
		panel.add(label);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new OutAndInListPanel();
		tabbedPane.addTab("库存查看", null, panel_1, null);
		
		JPanel panel_2 = new WarehouseCheckPanel();
		tabbedPane.addTab("盘点调整", null, panel_2, null);
		
		JPanel panel_3 = new OutBoundListPanel();
		tabbedPane.addTab("出库管理", null, panel_3, null);
		
		JPanel panel_4 = new GoDownEntryListPanel();
		tabbedPane.addTab("入库管理", null, panel_4, null);
		
		JPanel panel_5 = new WarmPercentage();
		tabbedPane.addTab("库存比例", null, panel_5, null);
		
		JPanel panel_6 = new TicketManagePanel();
		tabbedPane.addTab("单据状态", null, panel_6, null);
	}

}
