package org.module.client.presentation.orderui;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import org.jdesktop.swingx.JXDatePicker;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class TransportListPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JXDatePicker loadingDate;
	private JTextField trains;
	private JTextField tranCenter;
	private JTextField origin;
	private JTextField destination;
	private JTextField monitor;
	private JTextField container;
	private JComboBox<String> TransitWay;
	private JTextField textField;
	private JButton button;
	private JLabel lblNewLabel_2;

	/**
	 * Create the panel.
	 */
	public TransportListPanel() {
		init();
		addlisteners();
	}
	private void addlisteners() {
		
	}
	private void init(){
		JLabel lblNewLabel = new JLabel("中转方式");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 18));
		
		TransitWay = new JComboBox<String>();
		TransitWay.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JLabel label = new JLabel("装车日期");
		label.setFont(new Font("楷体", Font.PLAIN, 18));
		//final JXDatePicker TimeChose = new JXDatePicker();
		
		loadingDate = new JXDatePicker();
		loadingDate.setDate(new Date());
		//loadingDate.setColumns(10);
		
		JLabel label_1 = new JLabel("车次");
		label_1.setFont(new Font("楷体", Font.PLAIN, 18));
		
		trains = new JTextField();
		trains.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("中转中心");
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 18));
		
		tranCenter = new JTextField();
		tranCenter.setColumns(10);
		
		JLabel label_2 = new JLabel("出发地");
		label_2.setFont(new Font("楷体", Font.PLAIN, 18));
		
		origin = new JTextField();
		origin.setColumns(10);
		
		JLabel label_3 = new JLabel("目的地");
		label_3.setFont(new Font("楷体", Font.PLAIN, 18));
		
		destination = new JTextField();
		destination.setColumns(10);
		
		JLabel label_4 = new JLabel("监装员");
		label_4.setFont(new Font("楷体", Font.PLAIN, 18));
		
		monitor = new JTextField();
		monitor.setColumns(10);
		
		JLabel label_6 = new JLabel("货柜号");
		label_6.setFont(new Font("楷体", Font.PLAIN, 18));
		
		container = new JTextField();
		container.setColumns(10);
		
		JPanel panel = new JPanel();
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(195)
					.addComponent(lblNewLabel_2)
					.addContainerGap(222, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel_2)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		button = new JButton("确定");
		button.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label_5 = new JLabel("在下方填入所有订单号");
		scrollPane.setColumnHeaderView(label_5);
		
		textField = new JTextField();
		scrollPane.setViewportView(textField);
		textField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(TransitWay, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addGap(65)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addGap(19)
					.addComponent(loadingDate, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(trains, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addGap(22)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addComponent(tranCenter, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(label_2)
					.addGap(27)
					.addComponent(origin, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addGap(22)
					.addComponent(label_3)
					.addGap(44)
					.addComponent(destination, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(label_4)
					.addGap(27)
					.addComponent(monitor, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addGap(22)
					.addComponent(label_6)
					.addGap(44)
					.addComponent(container, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 461, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(225)
					.addComponent(button))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(TransitWay, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(loadingDate, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(trains, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(tranCenter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(origin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(destination, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(monitor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(container, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addComponent(button))
		);
		setLayout(groupLayout);

	}
}
