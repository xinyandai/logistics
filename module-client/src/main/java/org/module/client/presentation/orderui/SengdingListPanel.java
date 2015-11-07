package org.module.client.presentation.orderui;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.jdesktop.swingx.JXDatePicker;

public class SengdingListPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public SengdingListPanel() {
		
		JLabel lblNewLabel = new JLabel("派件单号");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 18));
		
		textField = new JTextField();
		textField.setFont(new Font("楷体", Font.PLAIN, 18));
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("派件员");
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 18));
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("楷体", Font.PLAIN, 18));
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("收件日期");
		label.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JButton button = new JButton("确定");
		button.setFont(new Font("楷体", Font.PLAIN, 20));
		
		final JXDatePicker TimeChose = new JXDatePicker();
		TimeChose.setDate(new Date());
		GroupLayout groupLayout = new GroupLayout(this);
		
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(TimeChose))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(167)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(textField))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addGap(33)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)))))
					.addGap(190))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(23)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
								.addComponent(TimeChose)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(23)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addGap(98)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
		);
		setLayout(groupLayout);

	}
}
