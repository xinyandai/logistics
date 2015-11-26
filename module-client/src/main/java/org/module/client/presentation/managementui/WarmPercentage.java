package org.module.client.presentation.managementui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class WarmPercentage extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField borderline;
	private JTextField currentLine;

	/**
	 * Create the panel.
	 */
	public WarmPercentage() {
		setLayout(null);
		
		JLabel label = new JLabel("选择分区");
		label.setFont(new Font("楷体", Font.PLAIN, 15));
		label.setBounds(69, 42, 67, 21);
		add(label);
		
//		JComboBox comboBox = new JComboBox();
		JComboBox<String> qu = new JComboBox<String>();
		qu.setFont(new Font("楷体", Font.PLAIN, 18));
		qu.setBounds(157, 40, 66, 21);
		add(qu);
		
		JLabel label_1 = new JLabel("警戒比例");
		label_1.setFont(new Font("楷体", Font.PLAIN, 15));
		label_1.setBounds(69, 104, 67, 21);
		add(label_1);
		
		borderline = new JTextField();
		borderline.setBounds(157, 104, 66, 21);
		add(borderline);
		borderline.setColumns(10);
		
		JButton save = new JButton("保存");
		save.setFont(new Font("楷体", Font.PLAIN, 18));
		save.setBounds(178, 157, 93, 23);
		add(save);
		
		JLabel label_2 = new JLabel("当前比例");
		label_2.setFont(new Font("楷体", Font.PLAIN, 15));
		label_2.setBounds(69, 73, 67, 21);
		add(label_2);
		
		currentLine = new JTextField();
		currentLine.setEditable(false);
		currentLine.setColumns(10);
		currentLine.setBounds(157, 71, 66, 21);
		add(currentLine);

	}

}
