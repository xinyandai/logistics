package org.module.client.presentation.orderui;

import java.awt.Font;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;
import org.module.client.businesslogic.orderbl.TransportController;
import org.module.client.businesslogicservice.orderBLservice.TransportBLService;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;

public class TransportListPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int lengthOfID = 9;
	private JXDatePicker loadingDate;
	private JTextField trains;
	private JTextField tranCenter;
	private JComboBox origin;
	private JComboBox destination;
	private JTextField monitor;
	private JTextField container;
	private JComboBox TransitWay;
	private String[] arrayOfTransitWay = {"火车","汽运","空运"};
	private String[] city = {"火车","汽运","空运"};
	private JButton button;
	private JLabel state;

	private TransportBLService controller= new TransportController();
	private JTextField price;
	private JTextPane textPane;
	/**
	 * Create the panel.
	 */
	public TransportListPanel() {
		this.getCity();
		this.getTransitWay();
		init();
		this.getPrice();
		addlisteners();
	}
	private void getCity(){
		
	}
	private void getTransitWay(){
	//	this.arrayOfTransitWay = {"火车","汽运","空运"};
	}
	private void getPrice(){
	//city = {};	
	}
	private void addlisteners() {
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] shippingId = shippingId(); 
				if(shippingId==null) {
					return ;
				}
				controller.creat(TransitWay.getSelectedItem().toString(), 
						loadingDate.getDate().getTime()+"", 
						tranCenter.getText(), 
						trains.getText(), 
						origin.getSelectedItem().toString(), 
						destination.getSelectedItem().toString(), 
						container.getText(), 
						monitor.getText(), 
						shippingId, 
						price.getText(), 
						"提交");
			}
		});
	}
	
	private String[] shippingId(){
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
			if(string.length()!=lengthOfID){
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
	private void init(){
		JLabel lblNewLabel = new JLabel("中转方式");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 18));
		
		TransitWay = new JComboBox(arrayOfTransitWay);
		TransitWay.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JLabel label = new JLabel("装车日期");
		label.setFont(new Font("楷体", Font.PLAIN, 18));
		//final JXDatePicker TimeChose = new JXDatePicker();
		
		loadingDate = new JXDatePicker();
		loadingDate.setDate(new Date());
		//loadingDate.setColumns(10);
		
		JLabel label_1 = new JLabel("车次");
		label_1.setFont(new Font("楷体", Font.PLAIN, 18));
		
		trains = new JTextField();
		trains.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("中转中心");
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 18));
		
		tranCenter = new JTextField();
		tranCenter.setColumns(10);
		
		JLabel label_2 = new JLabel("出发地");
		label_2.setFont(new Font("楷体", Font.PLAIN, 18));
		
		origin = new JComboBox(city);
	//	origin.setColumns(10);
		
		JLabel label_3 = new JLabel("目的地");
		label_3.setFont(new Font("楷体", Font.PLAIN, 18));
		
		destination = new JComboBox(city);
	//	destination.setColumns(10);
		
		JLabel label_4 = new JLabel("监装员");
		label_4.setFont(new Font("楷体", Font.PLAIN, 18));
		
		monitor = new JTextField();
		monitor.setColumns(10);
		
		JLabel label_6 = new JLabel("货柜号");
		label_6.setFont(new Font("楷体", Font.PLAIN, 18));
		
		container = new JTextField();
		container.setColumns(10);
		
		JPanel panel = new JPanel();
		
		state = new JLabel("");
		state.setFont(new Font("宋体", Font.PLAIN, 16));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(195)
					.addComponent(state)
					.addContainerGap(222, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(state)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		button = new JButton("确定");
		
		button.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label_5 = new JLabel("在下方填入所有订单号");
		scrollPane.setColumnHeaderView(label_5);
		
		JLabel label_7 = new JLabel("运费");
		label_7.setFont(new Font("楷体", Font.PLAIN, 18));
		
		price = new JTextField();
		price.setEditable(false);
		price.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(TransitWay, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
							.addGap(65)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addGap(19)
							.addComponent(loadingDate, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(trains, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addGap(22)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addGap(25)
							.addComponent(tranCenter, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(label_2)
							.addGap(27)
							.addComponent(origin, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addGap(22)
							.addComponent(label_3)
							.addGap(44)
							.addComponent(destination, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(222)
							.addComponent(button))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 461, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_4)
								.addComponent(label_7))
							.addGap(27)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(monitor, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
									.addGap(22)
									.addComponent(label_6)
									.addGap(44)
									.addComponent(container, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
								.addComponent(price, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(6, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(TransitWay, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(loadingDate, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(trains, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(tranCenter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(origin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(destination, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(monitor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(container, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_7)
						.addComponent(price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(button)
					.addContainerGap())
		);
		
		textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		setLayout(groupLayout);

	}
}
