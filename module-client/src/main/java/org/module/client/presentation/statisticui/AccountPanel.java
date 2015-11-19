package org.module.client.presentation.statisticui;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JTable;
import javax.swing.JButton;


import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

import org.module.client.presentation.CheckBoxTableModelProxy;

public class AccountPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	Object[][] cellData = {{"row1-col1", "row1-col2","add"},{"row2-col1", "row2-col2","add"},
			{"row1-col1", "row1-col2","add"},{"row1-col1", "row1-col2","add"}};
	String[] columnNames = {"账号", "余额",""};
	private JTable table;
	private JTextField textField;
	public AccountPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		JButton button = new JButton("增");
		
		JButton button_1 = new JButton("删");
		
		JButton button_2 = new JButton("改");
		
		JButton button_3 = new JButton("同步");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton button_4 = new JButton("搜索");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(12)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(button_3))
						.addComponent(button_4))
					.addGap(6))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_3)
						.addComponent(button_2)
						.addComponent(button_1)
						.addComponent(button))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_4)))
		);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable(new DefaultTableModel(cellData,columnNames){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
		    }

		});
		CheckBoxTableModelProxy a = new CheckBoxTableModelProxy(table.getModel(), "check");
		scrollPane.setViewportView(new JTable(a));
	}
}
