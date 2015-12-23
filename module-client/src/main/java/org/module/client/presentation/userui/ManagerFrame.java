package org.module.client.presentation.userui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import org.module.client.presentation.FontFactory;
import org.module.client.presentation.InOutPane;
import org.module.client.presentation.departmentui.DeparmentPanel;
import org.module.client.presentation.departmentui.StuffPanel;
import org.module.client.presentation.managementui.CityAndPrice;
import org.module.client.presentation.managementui.TicketManagePanel;
import org.module.client.presentation.statisticui.CostPanel;
import org.module.client.presentation.statisticui.SalaryPanel;

public class ManagerFrame extends FatherFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private FontFactory font = new FontFactory() ;
	
	public ManagerFrame() {
		super();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setOpaque(false);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("总经理");
		label.setFont(font.getStateFont());
		panel.add(label);
		
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setFont(font.getTabbeFont());
		tabbedPane.setOpaque(false);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_5 = new StuffPanel();
		panel_5.setOpaque(false);
		tabbedPane.addTab("成员管理", null, panel_5, "成员管理");
		
		JPanel panel_1 = new DeparmentPanel();
		panel_1.setOpaque(false);
		tabbedPane.addTab("机构管理", null, panel_1, "机构管理");
		
		JPanel panel_2 = new CostPanel();
		panel_2.setOpaque(false);
		tabbedPane.addTab("成本管理", null, panel_2, "成本管理");
		
		JPanel panel_3 = new CityAndPrice();
		panel_3.setOpaque(false);
		tabbedPane.addTab("价格与距离", null, panel_3, "价格与距离");
		
		JPanel panel_6 = new SalaryPanel();
		panel_6.setOpaque(false);
		tabbedPane.addTab("薪水策略", null, panel_6, "薪水策略");
		
		JPanel panel_4 = new TicketManagePanel();
		panel_4.setOpaque(false);
		tabbedPane.addTab("单据管理", null, panel_4, "单据管理");
	}

}
