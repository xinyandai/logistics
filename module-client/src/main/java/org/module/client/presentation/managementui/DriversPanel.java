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

public class DriversPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	/**
	 * 司机编号（城市编号（电话号码区号南京025）+营业厅编号（000三位数字）+000三位数字、
	 * 姓名、
	 * 出生日期、
	 * 身份证号、
	 * 手机 、
	 * 性别、
	 * 行驶证期限
	 */
	Object[][] cellData = {{"row1-col1", "row1-col2","add", "row1-col2","add"},
			{"row1-col1", "row1-col2","add", "row1-col2","add"},
			{"row1-col1", "row1-col2","add", "row1-col2","add"},
			{"row1-col1", "row1-col2","add", "row1-col2","add"}};
	String[] columnNames = {"司机编号", "姓名","出生日期","身份证号","手机","性别","行驶证期限"};
	private JTable table;
	public DriversPanel() {
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
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(58)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button_3)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1)
						.addComponent(button_2)
						.addComponent(button_3))
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
				  ck.setHorizontalAlignment((int) 0.5f);
				 return ck;

			}
			
		});
		//table.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		//table.getColumn(0).setCellEditor(new DefaultCellEditor(new JCheckBox()));
		scrollPane.setViewportView(table);
	}

}
