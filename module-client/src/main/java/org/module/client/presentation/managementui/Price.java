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
	private JTextField distance;
	private JTextField carriage;

	String[] city = {"南京","北京","上海","广州"};
	
	
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
		
		JComboBox<String> cityA = new JComboBox<String>(city);
		cityA.setBounds(165, 41, 61, 21);
		add(cityA);
		
		JComboBox<String> cityB = new JComboBox<String>(city);
		cityB.setBounds(165, 82, 61, 21);
		add(cityB);
		
		JLabel label_2 = new JLabel("输入距离");
		label_2.setFont(new Font("楷体", Font.PLAIN, 18));
		label_2.setBounds(55, 124, 81, 21);
		add(label_2);
		
		JLabel label_3 = new JLabel("输入运费");
		label_3.setFont(new Font("楷体", Font.PLAIN, 18));
		label_3.setBounds(55, 159, 81, 21);
		add(label_3);
		
		distance = new JTextField();
		distance.setFont(new Font("楷体", Font.PLAIN, 18));
		distance.setBounds(165, 126, 66, 21);
		add(distance);
		distance.setColumns(10);
		
		carriage = new JTextField();
		carriage.setFont(new Font("楷体", Font.PLAIN, 18));
		carriage.setColumns(10);
		carriage.setBounds(165, 161, 66, 21);
		add(carriage);
		
		JButton determine = new JButton("确定");
		determine.setFont(new Font("楷体", Font.PLAIN, 18));
		determine.setBounds(182, 226, 93, 23);
		add(determine);

	}
}
