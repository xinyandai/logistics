package org.module.client.presentation.statisticui;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JButton;

import org.jdesktop.swingx.JXDatePicker;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ReceiptPanel extends JPanel {
	
	private static final long serialVersionUID = -7750747233254196763L;
	private JTextField money;
	private JTextField Courier;
	private JLabel label_2;
//	private JTextField timePicker;

	/**
	 * Create the panel.
	 */
	public ReceiptPanel() {
		
		JLabel label = new JLabel("金额");
		label.setFont(new Font("楷体", Font.PLAIN, 18));
		
		money = new JTextField();
		money.setFont(new Font("楷体", Font.PLAIN, 15));
		money.setColumns(10);
		
		JLabel label_1 = new JLabel("快递单号");
		label_1.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel lblNewLabel = new JLabel("收款快递员");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 18));
		
		Courier = new JTextField();
		Courier.setColumns(10);
		
		label_2 = new JLabel("选择日期");
		label_2.setFont(new Font("楷体", Font.PLAIN, 18));
		
		final JXDatePicker timePicker = new JXDatePicker();
		timePicker.setDate(new Date());
		//timePicker.setColumns(10);
		
		JButton sava = new JButton("保存");
		sava.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JTextArea ID = new JTextArea();
		ID.setLineWrap(true);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
							.addGap(52)
							.addComponent(money, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addComponent(label_2)
							.addGap(35)
							.addComponent(timePicker, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(174)
							.addComponent(sava, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(ID, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(Courier, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addGap(41))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label))
						.addComponent(money, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(18))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(ID, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(Courier, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(timePicker, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addComponent(sava, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(39))
		);
		setLayout(groupLayout);

	}
}
