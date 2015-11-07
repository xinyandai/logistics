package org.module.client.presentation.userui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import org.module.client.presentation.statisticui.AccountPanel;
import org.module.client.presentation.statisticui.CostAndIncome;
import org.module.client.presentation.statisticui.CostPanel;
import org.module.client.presentation.statisticui.IncomePanel;
import org.module.client.presentation.statisticui.InitAccount;

public class AccoutantFrame extends JFrame {

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
					AccoutantFrame frame = new AccoutantFrame();
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
	public AccoutantFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("财务人员");
		panel.add(label);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new AccountPanel();
		tabbedPane.addTab("账户管理", null, panel_1, null);
		
		JPanel panel_2 = new InitAccount();
		tabbedPane.addTab("期初建账", null, panel_2, null);
		
		JPanel panel_3 = new CostPanel();
		tabbedPane.addTab("成本管理", null, panel_3, null);
		
		JPanel panel_4 = new IncomePanel();
		tabbedPane.addTab("收益查看", null, panel_4, null);
		
		JPanel panel_5 = new CostAndIncome();
		tabbedPane.addTab("成本收益表", null, panel_5, null);
	}

}
