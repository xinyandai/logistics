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
import javax.swing.JComboBox;
import javax.swing.JLabel;

import org.jdesktop.swingx.JXDatePicker;

import java.awt.Font;
import java.util.Date;

public class OutAndInListPanel extends JPanel {

	/**
	 * 查看此时间段内的出/入库数量/金额，存储位置
	 */
	private String[] type = {"出库单","入库单","全部"};
	Object[][] cellData = {{"row1-col1", "row1-col2","add"},{"row2-col1", "row2-col2","add"},
			{"row1-col1", "row1-col2","add"},{"row1-col1", "row1-col2","add"}};
	String[] columnNames = {"单号", "目的地","区","排","架" ,"位","" };
	private JTable table;
	private JXDatePicker startTimePicker;
	private JXDatePicker endTimePicker;
	public OutAndInListPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		JButton button = new JButton("增");
		
		JButton button_1 = new JButton("删");
		
		JButton button_2 = new JButton("改");
		
		JButton button_3 = new JButton("同步");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(179, Short.MAX_VALUE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
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
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
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
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		
		JComboBox comboBox = new JComboBox(type);
		
		
		startTimePicker = new JXDatePicker();
		startTimePicker.setDate(new Date());
		
		endTimePicker = new JXDatePicker();
		endTimePicker.setDate(new Date());
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(startTimePicker, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(endTimePicker, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(162, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(startTimePicker)
						.addComponent(endTimePicker)))
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.SOUTH);
		
		JLabel label = new JLabel("合计：");
		label.setFont(new Font("楷体", Font.PLAIN, 14));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
					.addContainerGap(221, Short.MAX_VALUE)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addGap(14))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(7)
					.addComponent(label)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
	}
}
