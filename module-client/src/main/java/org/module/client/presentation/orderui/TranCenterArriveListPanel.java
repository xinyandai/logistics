package org.module.client.presentation.orderui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;
import org.module.client.businesslogic.orderbl.TranCenterArrivalController;
import org.module.client.businesslogicservice.orderBLservice.TranCenterArrivalBLService;
import org.module.common.po.State;

public class TranCenterArriveListPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tranCenterID;
	private JTextField transportID;
	private JXDatePicker time;
	private JTextField origin;
	String[] arriveState = {"损坏","完整","丢失"};
	private JComboBox state;
	private JButton determine;
	
	private TranCenterArrivalBLService controller = new TranCenterArrivalController();
	/**
	 * Create the panel.
	 */
	public TranCenterArriveListPanel() {
		init();
		addListeners();
	}
	private void addListeners() {
		determine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			   controller.creat(tranCenterID.getText(), 
					   time.getDate().getTime()+"", 
					   transportID.getText(), 
					   origin.getText(), 
					   state.getSelectedItem().toString(), 
					   State.SUBMITTED.toString());
			}
		});
		
	}
	private void init(){
		JLabel label = new JLabel("中转中心编号");
		label.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_1 = new JLabel("中转单号");
		label_1.setFont(new Font("楷体", Font.PLAIN, 16));
		
		tranCenterID = new JTextField();
		tranCenterID.setColumns(10);
		
		transportID = new JTextField();
		transportID.setColumns(10);
		
		JLabel label_2 = new JLabel("到达时间");
		label_2.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_3 = new JLabel("到达状态");
		label_3.setFont(new Font("楷体", Font.PLAIN, 16));
		
		time = new JXDatePicker();
		//time.setColumns(10);
		
		state = new JComboBox();
		//JComboBox<String> state = new JComboBox<String>(arriveState);
		
		JLabel label_4 = new JLabel("出发地");
		label_4.setFont(new Font("楷体", Font.PLAIN, 16));
		
		origin = new JTextField();
		origin.setColumns(10);
		
		determine = new JButton("确定");
		
		determine.setFont(new Font("楷体", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(label)
					.addGap(15)
					.addComponent(tranCenterID, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
					.addGap(51)
					.addComponent(label_2)
					.addGap(10)
					.addComponent(time, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addComponent(label_1)
					.addGap(16)
					.addComponent(transportID, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
					.addGap(50)
					.addComponent(label_3)
					.addGap(10)
					.addComponent(state, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addComponent(origin, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(197)
					.addComponent(determine, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(tranCenterID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(time, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(transportID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(state, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(origin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addComponent(determine, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
		);
		setLayout(groupLayout);

	}
}
