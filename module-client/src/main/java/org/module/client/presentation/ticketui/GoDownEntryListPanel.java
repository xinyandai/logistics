package org.module.client.presentation.ticketui;

import java.awt.Font;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;
import org.module.client.businesslogic.ticketbl.GoDownEntryController;
import org.module.client.businesslogicservice.ticketBLservice.GoDownEntryBLService;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GoDownEntryListPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -425238968522959318L;
	private JTextField warehouseOfWhichTranCenter;
	private JTextField CourierID;
	private JTextField qu;
	private JTextField jia;
	private JXDatePicker timePicker;
	private JTextField destination;
	private JTextField pai;
	private JTextField wei;

	private GoDownEntryBLService controller = new GoDownEntryController();
	private JButton determine;
	/**
	 * Create the panel.
	 */
	public GoDownEntryListPanel() {
		init();
		addListenres();
	}
	private void addListenres() {
		determine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.createTicket(
						warehouseOfWhichTranCenter.getText(),
						CourierID.getText(), 
						timePicker.getDate().getTime()+"",
						destination.getText(), 
						qu.getText(), 
						pai.getText(), 
						jia.getText(), 
						wei.getText()
						);
			}
		});
		
	}
	private void init(){
		JLabel label = new JLabel("仓库名");
		label.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_1 = new JLabel("快递编号");
		label_1.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_2 = new JLabel("区号");
		label_2.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_3 = new JLabel("架号");
		label_3.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_4 = new JLabel("入库时间");
		label_4.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_5 = new JLabel("目的地");
		label_5.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_6 = new JLabel("排号");
		label_6.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_7 = new JLabel("位号");
		label_7.setFont(new Font("楷体", Font.PLAIN, 18));
		
		warehouseOfWhichTranCenter = new JTextField();
		warehouseOfWhichTranCenter.setFont(new Font("楷体", Font.PLAIN, 15));
		warehouseOfWhichTranCenter.setColumns(10);
		
		CourierID = new JTextField();
		CourierID.setFont(new Font("楷体", Font.PLAIN, 15));
		CourierID.setColumns(10);
		
		qu = new JTextField();
		qu.setFont(new Font("楷体", Font.PLAIN, 15));
		qu.setColumns(10);
		
		jia = new JTextField();
		jia.setFont(new Font("楷体", Font.PLAIN, 15));
		jia.setColumns(10);
		
		timePicker = new JXDatePicker();
		//timePicker = new JTextField();
		timePicker.setFont(new Font("楷体", Font.PLAIN, 15));
		timePicker.setDate(new Date());
		
		destination = new JTextField();
		destination.setFont(new Font("楷体", Font.PLAIN, 15));
		destination.setColumns(10);
		
		pai = new JTextField();
		pai.setFont(new Font("楷体", Font.PLAIN, 15));
		pai.setColumns(10);
		
		wei = new JTextField();
		wei.setFont(new Font("楷体", Font.PLAIN, 15));
		wei.setColumns(10);
		
		determine = new JButton("确定");
		
		determine.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel state = new JLabel("");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(warehouseOfWhichTranCenter, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
					.addGap(61)
					.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(timePicker, GroupLayout.PREFERRED_SIZE, 89, Short.MAX_VALUE)
					.addGap(37))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(CourierID, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
					.addGap(61)
					.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(destination, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
					.addGap(60))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(qu, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
					.addGap(61)
					.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(pai, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
					.addGap(60))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(jia, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
					.addGap(61)
					.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(wei, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
					.addGap(60))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(175)
					.addComponent(determine, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
					.addGap(182))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(194)
					.addComponent(state, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
					.addGap(202))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addComponent(state)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(warehouseOfWhichTranCenter, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addComponent(label_4)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(timePicker, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(CourierID, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addComponent(label_5)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(destination, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(qu, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addComponent(label_6)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(pai, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_3)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(jia, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addComponent(label_7)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(wei, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addGap(23)
					.addComponent(determine, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
		);
		setLayout(groupLayout);

	}
}
