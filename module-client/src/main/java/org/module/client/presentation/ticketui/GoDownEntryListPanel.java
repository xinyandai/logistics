package org.module.client.presentation.ticketui;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JButton;

import org.jdesktop.swingx.JXDatePicker;

public class GoDownEntryListPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -425238968522959318L;
	private JTextField warehouse;
	private JTextField CourierID;
	private JTextField qu;
	private JTextField jia;
	private JXDatePicker timePicker;
	private JTextField destination;
	private JTextField pai;
	private JTextField wei;

	/**
	 * Create the panel.
	 */
	public GoDownEntryListPanel() {
		setLayout(null);
		
		JLabel label = new JLabel("仓库名");
		label.setFont(new Font("楷体", Font.PLAIN, 18));
		label.setBounds(26, 44, 73, 21);
		add(label);
		
		JLabel label_1 = new JLabel("快递编号");
		label_1.setFont(new Font("楷体", Font.PLAIN, 18));
		label_1.setBounds(26, 75, 73, 21);
		add(label_1);
		
		JLabel label_2 = new JLabel("区号");
		label_2.setFont(new Font("楷体", Font.PLAIN, 18));
		label_2.setBounds(26, 106, 73, 21);
		add(label_2);
		
		JLabel label_3 = new JLabel("架号");
		label_3.setFont(new Font("楷体", Font.PLAIN, 18));
		label_3.setBounds(26, 138, 73, 21);
		add(label_3);
		
		JLabel label_4 = new JLabel("入库时间");
		label_4.setFont(new Font("楷体", Font.PLAIN, 18));
		label_4.setBounds(236, 44, 73, 21);
		add(label_4);
		
		JLabel label_5 = new JLabel("目的地");
		label_5.setFont(new Font("楷体", Font.PLAIN, 18));
		label_5.setBounds(236, 75, 73, 21);
		add(label_5);
		
		JLabel label_6 = new JLabel("排号");
		label_6.setFont(new Font("楷体", Font.PLAIN, 18));
		label_6.setBounds(236, 106, 73, 21);
		add(label_6);
		
		JLabel label_7 = new JLabel("位号");
		label_7.setFont(new Font("楷体", Font.PLAIN, 18));
		label_7.setBounds(236, 138, 73, 21);
		add(label_7);
		
		warehouse = new JTextField();
		warehouse.setFont(new Font("楷体", Font.PLAIN, 15));
		warehouse.setBounds(109, 46, 66, 21);
		add(warehouse);
		warehouse.setColumns(10);
		
		CourierID = new JTextField();
		CourierID.setFont(new Font("楷体", Font.PLAIN, 15));
		CourierID.setColumns(10);
		CourierID.setBounds(109, 77, 66, 21);
		add(CourierID);
		
		qu = new JTextField();
		qu.setFont(new Font("楷体", Font.PLAIN, 15));
		qu.setColumns(10);
		qu.setBounds(109, 108, 66, 21);
		add(qu);
		
		jia = new JTextField();
		jia.setFont(new Font("楷体", Font.PLAIN, 15));
		jia.setColumns(10);
		jia.setBounds(109, 140, 66, 21);
		add(jia);
		
		timePicker = new JXDatePicker();
		//timePicker = new JTextField();
		timePicker.setFont(new Font("楷体", Font.PLAIN, 15));
		//timerPicker.setColumns(10);
		timePicker.setBounds(324, 46, 89, 21);
		timePicker.setDate(new Date());
		add(timePicker);
		
		destination = new JTextField();
		destination.setFont(new Font("楷体", Font.PLAIN, 15));
		destination.setColumns(10);
		destination.setBounds(324, 77, 66, 21);
		add(destination);
		
		pai = new JTextField();
		pai.setFont(new Font("楷体", Font.PLAIN, 15));
		pai.setColumns(10);
		pai.setBounds(324, 108, 66, 21);
		add(pai);
		
		wei = new JTextField();
		wei.setFont(new Font("楷体", Font.PLAIN, 15));
		wei.setColumns(10);
		wei.setBounds(324, 140, 66, 21);
		add(wei);
		
		JButton determine = new JButton("确定");
		determine.setFont(new Font("楷体", Font.PLAIN, 18));
		determine.setBounds(175, 184, 93, 23);
		add(determine);

	}

}
