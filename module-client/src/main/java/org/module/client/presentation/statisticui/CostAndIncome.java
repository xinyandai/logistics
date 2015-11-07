package org.module.client.presentation.statisticui;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.util.Date;

import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

public class CostAndIncome extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JXDatePicker endTimePicker;
	private JXDatePicker startTimePicker;

	/**
	 * Create the panel.
	 */
	public CostAndIncome() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("开始时间");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 18));
		lblNewLabel.setBounds(49, 25, 78, 15);
		add(lblNewLabel);
		
		JLabel label = new JLabel("结束时间");
		label.setFont(new Font("楷体", Font.PLAIN, 18));
		label.setBounds(49, 60, 78, 15);
		add(label);
		
		JLabel label_1 = new JLabel("支出统计");
		label_1.setFont(new Font("楷体", Font.PLAIN, 18));
		label_1.setBounds(49, 95, 78, 15);
		add(label_1);
		
		JLabel label_2 = new JLabel("收入统计");
		label_2.setFont(new Font("楷体", Font.PLAIN, 18));
		label_2.setBounds(49, 131, 78, 15);
		add(label_2);
		
		JLabel label_3 = new JLabel("利润统计");
		label_3.setFont(new Font("楷体", Font.PLAIN, 18));
		label_3.setBounds(49, 168, 78, 15);
		add(label_3);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("楷体", Font.PLAIN, 16));
		textField.setText("0元");
		textField.setBounds(145, 167, 95, 21);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("0元");
		textField_1.setFont(new Font("楷体", Font.PLAIN, 16));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(145, 130, 95, 21);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("0元");
		textField_2.setFont(new Font("楷体", Font.PLAIN, 16));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(145, 93, 95, 21);
		add(textField_2);
		
		endTimePicker = new JXDatePicker();
		endTimePicker.setDate(new Date());
		//endTimePicker = new JTextField();
		//endTimePicker.setText("0元");
		endTimePicker.setFont(new Font("楷体", Font.PLAIN, 16));
		endTimePicker.setEditable(false);
		//endTimePicker.setColumns(10);
		endTimePicker.setBounds(145, 59, 95, 21);
		add(endTimePicker);
		
		startTimePicker = new JXDatePicker();
		startTimePicker.setDate(new Date());
		//startTimePicker.setText("0元");
		startTimePicker.setFont(new Font("楷体", Font.PLAIN, 16));
		startTimePicker.setEditable(false);
		//startTimePicker.setColumns(10);
		startTimePicker.setBounds(145, 23, 95, 21);
		add(startTimePicker);

	}

}
