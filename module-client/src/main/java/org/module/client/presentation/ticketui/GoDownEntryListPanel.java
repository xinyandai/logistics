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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JXDatePicker timePicker;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

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
		
		textField = new JTextField();
		textField.setFont(new Font("楷体", Font.PLAIN, 15));
		textField.setBounds(109, 46, 66, 21);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("楷体", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(109, 77, 66, 21);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("楷体", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(109, 108, 66, 21);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("楷体", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(109, 140, 66, 21);
		add(textField_3);
		
		timePicker = new JXDatePicker();
		//timePicker = new JTextField();
		timePicker.setFont(new Font("楷体", Font.PLAIN, 15));
		//timerPicker.setColumns(10);
		timePicker.setBounds(324, 46, 89, 21);
		timePicker.setDate(new Date());
		add(timePicker);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("楷体", Font.PLAIN, 15));
		textField_5.setColumns(10);
		textField_5.setBounds(324, 77, 66, 21);
		add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("楷体", Font.PLAIN, 15));
		textField_6.setColumns(10);
		textField_6.setBounds(324, 108, 66, 21);
		add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("楷体", Font.PLAIN, 15));
		textField_7.setColumns(10);
		textField_7.setBounds(324, 140, 66, 21);
		add(textField_7);
		
		JButton button = new JButton("确定");
		button.setFont(new Font("楷体", Font.PLAIN, 18));
		button.setBounds(175, 184, 93, 23);
		add(button);

	}

}
