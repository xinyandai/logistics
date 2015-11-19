package org.module.client.presentation.statisticui;

import java.awt.BorderLayout;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.JXDatePicker;
import org.module.client.presentation.CheckBoxTableModelProxy;

import javax.swing.GroupLayout.Alignment;

public class IncomePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 * 单号
	 * 金额
	 * 日期
	 * 快递员
	 */
	Object[][] cellData = {{"row1-col1", "row1-col2","add"},{"row2-col1", "row2-col2","add"},
			{"row1-col1", "row1-col2","add"},{"row1-col1", "row1-col2","add"}};
	String[] columnNames = {"单号", "金额","日期","快递员",""};
	private JTable table;
	JXDatePicker startTimePicker;
	JXDatePicker endTimePicker;
	public IncomePanel() {
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
					.addContainerGap(150, Short.MAX_VALUE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
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
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("营业厅");
		
		JComboBox<String> comboBox = new JComboBox<String>();
		
		JLabel label = new JLabel("选择起止时间");
		
		
		
		startTimePicker = new JXDatePicker();
		startTimePicker.setDate(new Date());
		
		
		endTimePicker = new JXDatePicker();
		endTimePicker.setDate(new Date());
		
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(startTimePicker)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(endTimePicker)
					.addContainerGap(75, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addComponent(startTimePicker)
						.addComponent(endTimePicker)))
		);
		panel_2.setLayout(gl_panel_2);
	}

}
