package org.module.client.presentation.logisticsui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.CompoundBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class LogisticsPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField ID;

	/**
	 * Create the panel.
	 */
	public LogisticsPanel() {
		setBorder(new CompoundBorder());
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		JLabel lblInputId = new JLabel("输入订单号");
		lblInputId.setFont(new Font("楷体", Font.PLAIN, 15));
		panel.add(lblInputId);
		
		ID = new JTextField();
		ID.setFont(new Font("楷体", Font.PLAIN, 13));
		panel.add(ID);
		ID.setColumns(10);
		
		JButton btnSearch = new JButton("搜索");
		panel.add(btnSearch);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		
		JLabel label = new JLabel("状态");
		label.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JLabel label_1 = new JLabel("当前位置");
		label_1.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JLabel lblNewLabel = new JLabel("发件地址");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1 = new JLabel("收件地址");
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JLabel state = new JLabel("状态");
		state.setFont(new Font("楷体", Font.PLAIN, 12));
		
		JLabel senderLocation = new JLabel("地址");
		senderLocation.setFont(new Font("楷体", Font.PLAIN, 12));
		
		JLabel receiptLocation = new JLabel("地址");
		receiptLocation.setFont(new Font("楷体", Font.PLAIN, 12));
		
		JLabel currentLocation = new JLabel("地址");
		currentLocation.setFont(new Font("楷体", Font.PLAIN, 12));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addComponent(state, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(10)
							.addComponent(senderLocation, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(10)
							.addComponent(receiptLocation, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(label_1)
							.addGap(10)
							.addComponent(currentLocation, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(state))
					.addGap(10)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(senderLocation))
					.addGap(10)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(receiptLocation))
					.addGap(10)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(currentLocation))
					.addGap(10)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);

	}
}
