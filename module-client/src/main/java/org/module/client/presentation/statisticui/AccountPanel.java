package org.module.client.presentation.statisticui;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.GridLayout;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JTextField;

public class AccountPanel extends JPanel {

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
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
		    }

		});
		table.getColumnModel().getColumn(columnNames.length-1).setCellRenderer(new TableCellRenderer(){

			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				// 创建用于返回的渲染组件
				JCheckBox ck = new JCheckBox();
				 // 使具有焦点的行对应的复选框选中
				  ck.setSelected(isSelected);
				 // 设置单选box.setSelected(hasFocus);
				  // 使复选框在单元格内居中显示
				// ck.setHorizontalAlignment((int) 0.5f);
				 return ck;

			}
			
		});
		//table.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		//table.getColumn(0).setCellEditor(new DefaultCellEditor(new JCheckBox()));
		scrollPane.setViewportView(table);
	}
}
