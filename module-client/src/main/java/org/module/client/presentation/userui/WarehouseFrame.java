package org.module.client.presentation.userui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import org.module.client.presentation.managementui.WarehouseCheckPanel;
import org.module.client.presentation.managementui.WarmPercentage;
import org.module.client.presentation.ticketui.GoDownEntryList;
import org.module.client.presentation.ticketui.OutBoundList;

public class WarehouseFrame extends FatherFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public WarehouseFrame() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("仓库管理员");
		panel.add(label);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setOpaque(false);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_1_1 = new GoDownEntryList();
		panel_1_1.setOpaque(false);
		tabbedPane.addTab("入库单", null, panel_1_1, null);
		
		JPanel panel_1_2 = new OutBoundList();
		panel_1_2.setOpaque(false);
		tabbedPane.addTab("出库单", null, panel_1_2, null);
		
		JPanel panel_2 = new WarehouseCheckPanel();
		panel_2.setOpaque(false);
		tabbedPane.addTab("盘点调整", null, panel_2, null);
		
		
		JPanel panel_5 = new WarmPercentage();
		panel_5.setOpaque(false);
		tabbedPane.addTab("库存比例", null, panel_5, null);
		

	}

}
