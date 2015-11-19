package org.module.client.presentation.statisticui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.module.client.presentation.departmentui.DeparmentPanel;
import org.module.client.presentation.departmentui.StuffPanel;
import org.module.client.presentation.managementui.DriversPanel;

public class InitAccount extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public InitAccount() {
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setFont(new Font("楷体", Font.PLAIN, 15));
		add(tabbedPane, BorderLayout.CENTER);
		
		JPanel drivers = new DriversPanel();
		tabbedPane.addTab("司机初始化", null, drivers, null);
		
		JPanel department = new DeparmentPanel();
		tabbedPane.addTab("机构初始化", null, department, null);
		
		JPanel stuff = new StuffPanel();
		tabbedPane.addTab("人员初始化", null, stuff, null);
		
		JPanel account = new AccountPanel();
		tabbedPane.addTab("账户初始化", null, account, null);
		
		JPanel warehouse = new JPanel();
		tabbedPane.addTab("库存初始化", null, warehouse, null);

	}

}
