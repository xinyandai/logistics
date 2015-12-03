package org.module.client.presentation.statisticui;

import java.awt.Font;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;
import org.module.client.businesslogic.statisticbl.CostAndIncomeController;
import org.module.client.businesslogicservice.statisticBLservice.CostAndIncomeBLService;

public class CostAndIncome extends JPanel {
	
	private static final long serialVersionUID = 1L;
	//利润
	private JTextField profits;
	private JTextField income;
	private JTextField spending;
	private JXDatePicker endTimePicker;
	private JXDatePicker startTimePicker;

	private CostAndIncomeBLService controller = new CostAndIncomeController();
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
		
		profits = new JTextField();
		profits.setEditable(false);
		profits.setFont(new Font("楷体", Font.PLAIN, 16));
		profits.setText("0元");
		profits.setBounds(145, 167, 95, 21);
		add(profits);
		profits.setColumns(10);
		
		income = new JTextField();
		income.setText("0元");
		income.setFont(new Font("楷体", Font.PLAIN, 16));
		income.setEditable(false);
		income.setColumns(10);
		income.setBounds(145, 130, 95, 21);
		add(income);
		
		spending = new JTextField();
		spending.setText("0元");
		spending.setFont(new Font("楷体", Font.PLAIN, 16));
		spending.setEditable(false);
		spending.setColumns(10);
		spending.setBounds(145, 93, 95, 21);
		add(spending);
		
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

		this.refresh();
	}

	public void refresh(){
		long startTime = this.startTimePicker.getDate().getTime();
		long endTime = this.endTimePicker.getDate().getTime();
		this.income.setText(this.controller.getIncome(startTime, endTime)+"");
		this.spending.setText(this.controller.getCost(startTime, endTime)+"");
		this.profits.setText(this.controller.getPureIncome(startTime, endTime)+"");
	}
}
