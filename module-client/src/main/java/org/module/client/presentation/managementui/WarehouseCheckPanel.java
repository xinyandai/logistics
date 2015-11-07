package org.module.client.presentation.managementui;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class WarehouseCheckPanel extends JPanel {

	/**
	 * 快递编号、入库日期、目的地、区号、排号、架号、位号
	 */
	Object[][] cellData = {{"row1-col1", "row1-col2","add"},{"row2-col1", "row2-col2","add"},
			{"row1-col1", "row1-col2","add"},{"row1-col1", "row1-col2","add"}};
	String[] columnNames = {"快递编号", "入库日期","目的地","区号","排号","架号","位号",""};
	private JTable table;
	public WarehouseCheckPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		JButton button = new JButton("增");
		
		JButton button_1 = new JButton("删");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton button_2 = new JButton("改");
		
		JButton button_3 = new JButton("同步");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(112, Short.MAX_VALUE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(button_3))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_3)
						.addComponent(button_2)
						.addComponent(button_1)
						.addComponent(button))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		
		JButton button_4 = new JButton("导出");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_4.setFont(new Font("楷体", Font.PLAIN, 14));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(283, Short.MAX_VALUE)
					.addComponent(button_4))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(button_4)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
	}
}
