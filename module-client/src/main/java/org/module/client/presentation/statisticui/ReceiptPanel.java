package org.module.client.presentation.statisticui;

import java.awt.Font;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;
import org.module.client.businesslogic.statisticbl.IncomeManageController;
import org.module.client.businesslogicservice.statisticBLservice.IncomeManageBLService;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;

public class ReceiptPanel extends JPanel {
	
	private static final long serialVersionUID = -7750747233254196763L;
	private JTextField money;
	private JTextField courier;
	private JLabel label_2;

	private IncomeManageBLService controller = new IncomeManageController();
	private JXDatePicker timePicker;
	private JScrollPane scrollPane;
	private JButton sava;
	private int lengthOfID = 9;
	private JLabel state;
	private JTextPane textPane;
	
	
	public ReceiptPanel() {
		
		JLabel label = new JLabel("金额");
		label.setFont(new Font("楷体", Font.PLAIN, 18));
		
		money = new JTextField();
		money.setFont(new Font("楷体", Font.PLAIN, 15));
		money.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("收款快递员");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 18));
		
		courier = new JTextField();
		courier.setColumns(10);
		
		label_2 = new JLabel("选择日期");
		label_2.setFont(new Font("楷体", Font.PLAIN, 18));
		
		timePicker = new JXDatePicker();
		timePicker.setDate(new Date());
		//timePicker.setColumns(10);
		
		sava = new JButton("保存");
		
		sava.setFont(new Font("楷体", Font.PLAIN, 18));
		
		scrollPane = new JScrollPane();
		
		JLabel label_1 = new JLabel("在下方输入快递单号");
		scrollPane.setColumnHeaderView(label_1);
		
		state = new JLabel("state");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(money, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
					.addGap(64)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(courier)
					.addGap(24))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(label_2)
					.addGap(18)
					.addComponent(timePicker, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
					.addGap(254))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 401, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(186)
					.addComponent(sava, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(197)
					.addComponent(state)
					.addContainerGap(199, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(state)
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(label))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(money, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(courier, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(timePicker, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addGap(19)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(sava, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
		);
		
		textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		setLayout(groupLayout);

		addListeners();
	}


	private void addListeners() {
		sava.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] shippingId = shippingId(); 
				if(shippingId!=null){
					controller.add(timePicker.getDate().getTime()+"", money.getText(),
							courier.getText(),shippingId );
				}
				
			}
		});		
	}
	protected String[] shippingId(){
		String[] shippingId = null;
		
		String   text = textPane.getText();
		while(text.charAt(text.length()-1)=='\r'  || text.charAt(text.length()-1)==' '
				||text.charAt(text.length()-1)=='\n' ){
			text = text.substring(0, text.length()-1);
		}
		shippingId = text.split("\r",0);
		
		
		for (String string : shippingId) {
			System.out.println("-2:"+string);
			string = string.replace("\r", "");
			System.out.println("-1:"+string);
			string = string.replace("\n", "");
			System.out.println("0:"+string);
			if(string.length()!=lengthOfID ){
				System.out.println("1:"+string);
				System.out.println("2:"+string.length());
				state.setText("托运单号请以空格或回车隔开");
				return null;
			}else{
				System.out.println("3:"+string);
				System.out.println("4:"+string.length());
			}
			
		}
	    state.setText("格式正确");
	    return shippingId;
}
}
