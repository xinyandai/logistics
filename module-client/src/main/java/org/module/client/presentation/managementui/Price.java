package org.module.client.presentation.managementui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Price extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	String[] city = {"南京","北京","上海","广州"};
	/**
	 * Create the panel.
	 */
	public Price() {
		setLayout(null);
		
		JLabel label = new JLabel("选择城市1");
		label.setFont(new Font("楷体", Font.PLAIN, 18));
		label.setBounds(55, 39, 81, 21);
		add(label);
		
		JLabel label_1 = new JLabel("选择城市2");
		label_1.setFont(new Font("楷体", Font.PLAIN, 18));
		label_1.setBounds(55, 82, 81, 21);
		add(label_1);
		
		JComboBox<String> comboBox = new JComboBox<String>(city);
		comboBox.setBounds(165, 41, 61, 21);
		add(comboBox);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>(city);
		comboBox_1.setBounds(165, 82, 61, 21);
		add(comboBox_1);
		
		JLabel label_2 = new JLabel("输入距离");
		label_2.setFont(new Font("楷体", Font.PLAIN, 18));
		label_2.setBounds(55, 124, 81, 21);
		add(label_2);
		
		JLabel label_3 = new JLabel("输入运费");
		label_3.setFont(new Font("楷体", Font.PLAIN, 18));
		label_3.setBounds(55, 159, 81, 21);
		add(label_3);
		
		textField = new JTextField();
		textField.setFont(new Font("楷体", Font.PLAIN, 18));
		textField.setBounds(165, 126, 66, 21);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("楷体", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(165, 161, 66, 21);
		add(textField_1);
		
		JButton button = new JButton("确定");
		button.setFont(new Font("楷体", Font.PLAIN, 18));
		button.setBounds(182, 226, 93, 23);
		add(button);

	}
}
