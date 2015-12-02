package org.module.client.presentation.managementui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.module.client.businesslogic.managementbl.WarehouseManageController;
import org.module.client.businesslogicservice.managementBLservice.WarehouseManageBLService;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class WarmPercentage extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField borderline;
	private JTextField size;

	private WarehouseManageBLService controller = new WarehouseManageController();
	private JButton save;
	private JTextField tranCenterID;
	private JComboBox textField_1;
	private JLabel state;
	
	public WarmPercentage() {
		
		JLabel label = new JLabel("中转中心");
		label.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JLabel label_1 = new JLabel("警戒比例");
		label_1.setFont(new Font("楷体", Font.PLAIN, 15));
		
		borderline = new JTextField();
		borderline.setColumns(10);
		
		save = new JButton("保存");
		
		save.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_2 = new JLabel("分区大小");
		label_2.setFont(new Font("楷体", Font.PLAIN, 15));
		
		size = new JTextField();
		size.setColumns(10);
		
		JLabel label_3 = new JLabel("选择分区");
		label_3.setFont(new Font("楷体", Font.PLAIN, 15));
		
		tranCenterID = new JTextField();
		tranCenterID.setColumns(10);
		
		textField_1 = new JComboBox();
		textField_1.setEditable(true);
		
		state = new JLabel("state");
		state.setFont(new Font("宋体", Font.PLAIN, 15));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(205)
					.addComponent(state, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(69)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addComponent(tranCenterID, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
					.addGap(33)
					.addComponent(label_3, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(textField_1, 0, 66, Short.MAX_VALUE)
					.addGap(51))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(69)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addComponent(size, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
					.addGap(33)
					.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(borderline, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
					.addGap(51))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(193)
					.addComponent(save, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
					.addGap(164))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(state, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
						.addComponent(tranCenterID)
						.addComponent(label_3, GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
						.addComponent(textField_1))
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 3, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(size))
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(borderline)
							.addGap(3)))
					.addGap(58)
					.addComponent(save, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(108))
		);
		setLayout(groupLayout);

		save.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			//	controller.setBorderline(currentline, qu.getSelectedItem().toString(), borderline.getText());
			}
		});
	}
}
