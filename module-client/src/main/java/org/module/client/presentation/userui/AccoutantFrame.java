package org.module.client.presentation.userui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import org.module.client.main.Main;
import org.module.client.presentation.FontFactory;
import org.module.client.presentation.statisticui.AccountPanel;
import org.module.client.presentation.statisticui.CostAndIncome;
import org.module.client.presentation.statisticui.CostPanel;
import org.module.client.presentation.statisticui.IncomePanel;
import org.module.client.presentation.statisticui.InitAccountPanel;

public class AccoutantFrame extends FatherFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private FontFactory font = new FontFactory();
	
	public AccoutantFrame() {
		
		  
		
		super();
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("财务人员");
	    label.setFont(font.getTabelNameInput());
		panel.add(label);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(font.getTabbeFont());
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		if(Main.currentUser.getAuthority().equals("1")){
			JPanel panel_1 = new AccountPanel();
			panel_1.setOpaque(false);
			tabbedPane.addTab("账户管理", null, panel_1, "账户管理");
		}
		
		
		JPanel panel_2 = new InitAccountPanel();
		panel_2.setOpaque(false);
		tabbedPane.addTab("期初建账", null, panel_2, "期初建账");
		
		JPanel panel_3 = new CostPanel();
		panel_3.setOpaque(false);
		tabbedPane.addTab("成本管理", null, panel_3, "成本管理");
		
		JPanel panel_4 = new IncomePanel();
		panel_4.setOpaque(false);
		tabbedPane.addTab("收益查看", null, panel_4, "收益查看");
		
		JPanel panel_5 = new CostAndIncome();
		panel_5.setOpaque(false);
		tabbedPane.addTab("成本收益表", null, panel_5, "成本收益表");
	}

}
