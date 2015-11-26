package org.module.client.presentation.ticketui;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import org.jdesktop.swingx.JXDatePicker;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class OutBoundListPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1763726376114638405L;
	private JTextField warehouse;
	private JTextField destination;
	//快递编号
	private JTextField CourierID;
	//货运编号
	private JTextField freightID;
	private final JXDatePicker timePicker;
	private String[] type = {"火车", "汽车", "飞机"};
	/**
	 * Create the panel.
	 */
	public OutBoundListPanel() {
		
		JLabel lblNewLabel = new JLabel("仓库名");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label = new JLabel("目的地");
		label.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_1 = new JLabel("装运形式");
		label_1.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_2 = new JLabel("快递编号");
		label_2.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_3 = new JLabel("货运编号");
		label_3.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_4 = new JLabel("入库时间");
		label_4.setFont(new Font("楷体", Font.PLAIN, 18));
		
		warehouse = new JTextField();
		warehouse.setFont(new Font("楷体", Font.PLAIN, 15));
		warehouse.setColumns(10);
		
		destination = new JTextField();
		destination.setFont(new Font("楷体", Font.PLAIN, 15));
		destination.setColumns(10);
		
		CourierID = new JTextField();
		CourierID.setFont(new Font("楷体", Font.PLAIN, 15));
		CourierID.setColumns(10);
		
		freightID = new JTextField();
		freightID.setFont(new Font("楷体", Font.PLAIN, 15));
		freightID.setColumns(10);
		
		timePicker = new JXDatePicker();
		timePicker.setDate(new Date());
		//timePicker = new JTextField();
		timePicker.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JComboBox<String> shipmentWay = new JComboBox<String>(type);
		//JComboBox comboBox = new JComboBox(type);
		
		JButton determine = new JButton("确定");
		determine.setFont(new Font("楷体", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(58)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(warehouse, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(CourierID, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(58)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(destination, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(freightID, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(58)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(shipmentWay, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(timePicker, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(189)
					.addComponent(determine, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(warehouse, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addComponent(label_2)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(CourierID, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(destination, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addComponent(label_3)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(freightID, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(shipmentWay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(label_4)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(timePicker, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addGap(38)
					.addComponent(determine, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
		);
		setLayout(groupLayout);

	}
}
