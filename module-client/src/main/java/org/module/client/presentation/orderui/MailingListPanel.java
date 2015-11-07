package org.module.client.presentation.orderui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import org.module.client.businesslogic.orderbl.MailingListControl;
import org.module.client.businesslogicservice.orderBLservice.MailingBLService;

public class MailingListPanel extends JPanel {
	
	private MailingBLService inputMailingList = new MailingListControl();
	private String[] stringOfType = {"经济快递","标准快递","特快"};
	private String[] cities = {"南京","北京","上海","广州"};
	
	private JTextField senderName;
	private JTextField senderCompany;
	private JTextField senderMobile;
	private JTextField senderPhone;
	private JComboBox senderCity;
	//private JComboBox<String> senderCity;
	private JTextField senderPosition;
	private JTextField receiveName;
	private JTextField receiveCompany;
	private JTextField receiveMobile;
	private JTextField receivePhone;
	private JComboBox receiveCity;
	//private JComboBox<String> receiveCity;
	private JTextField receivePosition;
	private JTextField nameOfGood;
	private JTextField counts;
	private JTextField weight;
	private JTextField volume;
	private JTextField costOfDecoration;
	private JComboBox type;
	//private JComboBox<String> type;

	
	private JTextField id;
	private JLabel timeAndMoney;
	
	private int time;
	private int money;
	private JButton button;
	private JLabel massage;
	
	/**
	 * Create the panel.
	 */
	public MailingListPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		massage = new JLabel("");
		panel.add(massage);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		
		button = new JButton("保存");
		
		button.setFont(new Font("楷体", Font.PLAIN, 15));
		panel_1.add(button);
		
		timeAndMoney = new JLabel("报价：0元       预计： 0 天后送达");
		timeAndMoney.setFont(new Font("楷体", Font.PLAIN, 15));
		panel_1.add(timeAndMoney);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 1, 1, 1));
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_9 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_9.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_6.add(panel_9);
		
		JLabel lblNewLabel = new JLabel("寄件人姓名*");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 15));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		panel_9.add(lblNewLabel);
		
		senderName = new JTextField();
		senderName.setFont(new Font("楷体", Font.PLAIN, 14));
		panel_9.add(senderName);
		senderName.setColumns(10);
		
		JPanel panel_10 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_10.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_6.add(panel_10);
		
		JLabel lblNewLabel_1 = new JLabel("寄件人公司");
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 15));
		panel_10.add(lblNewLabel_1);
		
		senderCompany = new JTextField();
		senderCompany.setFont(new Font("楷体", Font.PLAIN, 14));
		panel_10.add(senderCompany);
		senderCompany.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_4.add(panel_7);
		panel_7.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel_11 = new JPanel();
		panel_7.add(panel_11);
		panel_11.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel_12 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_12.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_11.add(panel_12);
		
		JLabel label_1 = new JLabel("寄件人手机*");
		label_1.setFont(new Font("楷体", Font.PLAIN, 15));
		label_1.setForeground(new Color(255, 0, 0));
		panel_12.add(label_1);
		
		senderMobile = new JTextField();
		senderMobile.setFont(new Font("楷体", Font.PLAIN, 14));
		panel_12.add(senderMobile);
		senderMobile.setColumns(10);
		
		JPanel panel_13 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_13.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panel_11.add(panel_13);
		
		JLabel label_2 = new JLabel("寄件人电话");
		label_2.setFont(new Font("楷体", Font.PLAIN, 15));
		panel_13.add(label_2);
		
		senderPhone = new JTextField();
		senderPhone.setFont(new Font("楷体", Font.PLAIN, 14));
		panel_13.add(senderPhone);
		senderPhone.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_8.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		panel_4.add(panel_8);
		
		JLabel label_3 = new JLabel("寄件人地址*");
		label_3.setFont(new Font("楷体", Font.PLAIN, 15));
		label_3.setForeground(new Color(255, 0, 0));
		panel_8.add(label_3);
		
		senderCity = new JComboBox(cities);
		
		//receiveCity = new JComboBox<String>(cities);
		panel_8.add(senderCity);
		
		senderPosition = new JTextField();
		senderPosition.setFont(new Font("楷体", Font.PLAIN, 14));
		panel_8.add(senderPosition);
		senderPosition.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_14 = new JPanel();
		panel_3.add(panel_14);
		panel_14.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel_17 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_17.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		panel_14.add(panel_17);
		
		JLabel lblNewLabel_2 = new JLabel("收件人姓名*");
		lblNewLabel_2.setFont(new Font("楷体", Font.PLAIN, 15));
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		panel_17.add(lblNewLabel_2);
		
		receiveName = new JTextField();
		receiveName.setFont(new Font("楷体", Font.PLAIN, 14));
		panel_17.add(receiveName);
		receiveName.setColumns(10);
		
		JPanel panel_18 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_18.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		panel_14.add(panel_18);
		
		JLabel lblNewLabel_3 = new JLabel("收件人公司");
		lblNewLabel_3.setFont(new Font("楷体", Font.PLAIN, 15));
		panel_18.add(lblNewLabel_3);
		
		receiveCompany = new JTextField();
		receiveCompany.setFont(new Font("楷体", Font.PLAIN, 14));
		panel_18.add(receiveCompany);
		receiveCompany.setColumns(10);
		
		JPanel panel_15 = new JPanel();
		panel_3.add(panel_15);
		panel_15.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel_19 = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panel_19.getLayout();
		flowLayout_7.setAlignment(FlowLayout.LEFT);
		panel_15.add(panel_19);
		
		JLabel label_4 = new JLabel("收件人手机*");
		label_4.setFont(new Font("楷体", Font.PLAIN, 15));
		label_4.setForeground(new Color(255, 0, 0));
		panel_19.add(label_4);
		
		receiveMobile = new JTextField();
		receiveMobile.setFont(new Font("楷体", Font.PLAIN, 14));
		panel_19.add(receiveMobile);
		receiveMobile.setColumns(10);
		
		JPanel panel_20 = new JPanel();
		FlowLayout flowLayout_8 = (FlowLayout) panel_20.getLayout();
		flowLayout_8.setAlignment(FlowLayout.LEFT);
		panel_15.add(panel_20);
		
		JLabel label_5 = new JLabel("寄件人电话");
		label_5.setFont(new Font("楷体", Font.PLAIN, 15));
		panel_20.add(label_5);
		
		receivePhone = new JTextField();
		receivePhone.setFont(new Font("楷体", Font.PLAIN, 14));
		panel_20.add(receivePhone);
		receivePhone.setColumns(10);
		
		JPanel panel_16 = new JPanel();
		FlowLayout flowLayout_9 = (FlowLayout) panel_16.getLayout();
		flowLayout_9.setAlignment(FlowLayout.LEFT);
		panel_3.add(panel_16);
		
		JLabel label_6 = new JLabel("收件人地址*");
		label_6.setFont(new Font("楷体", Font.PLAIN, 15));
		label_6.setForeground(new Color(255, 0, 0));
		panel_16.add(label_6);
		
		//receiveCity = new JComboBox();
		receiveCity = new JComboBox<String>(cities);
		
		panel_16.add(receiveCity);
		
		receivePosition = new JTextField();
		receivePosition.setFont(new Font("楷体", Font.PLAIN, 14));
		panel_16.add(receivePosition);
		receivePosition.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_10 = (FlowLayout) panel_5.getLayout();
		flowLayout_10.setAlignment(FlowLayout.LEFT);
		panel_2.add(panel_5);
		
		JPanel panel_21 = new JPanel();
		panel_5.add(panel_21);
		
		JLabel lblNewLabel_6 = new JLabel("快递类型*");
		lblNewLabel_6.setFont(new Font("楷体", Font.PLAIN, 15));
		panel_21.add(lblNewLabel_6);
		lblNewLabel_6.setForeground(new Color(255, 0, 0));
		
		type = new JComboBox(stringOfType);
		
		//type = new JComboBox<String>(stringOfType);
		panel_21.add(type);
		//type.setColumns(10);
		
		JPanel panel_22 = new JPanel();
		panel_5.add(panel_22);
		
		JLabel lblNewLabel_5 = new JLabel("包装费用*");
		lblNewLabel_5.setFont(new Font("楷体", Font.PLAIN, 15));
		panel_22.add(lblNewLabel_5);
		lblNewLabel_5.setForeground(new Color(255, 0, 0));
		
		costOfDecoration = new JTextField();
		
		costOfDecoration.setFont(new Font("楷体", Font.PLAIN, 14));
		panel_22.add(costOfDecoration);
		costOfDecoration.setColumns(10);
		
		JPanel panel_23 = new JPanel();
		panel_5.add(panel_23);
		
		JLabel label_10 = new JLabel("体积*");
		label_10.setFont(new Font("楷体", Font.PLAIN, 15));
		panel_23.add(label_10);
		label_10.setForeground(new Color(255, 0, 0));
		
		volume = new JTextField();
		volume.setFont(new Font("楷体", Font.PLAIN, 14));
		panel_23.add(volume);
		volume.setColumns(10);
		
		JPanel panel_24 = new JPanel();
		panel_5.add(panel_24);
		
		JLabel label_9 = new JLabel("重量*");
		label_9.setFont(new Font("楷体", Font.PLAIN, 15));
		panel_24.add(label_9);
		label_9.setForeground(new Color(255, 0, 0));
		
		weight = new JTextField();
		weight.setFont(new Font("楷体", Font.PLAIN, 14));
		panel_24.add(weight);
		weight.setColumns(10);
		
		JPanel panel_25 = new JPanel();
		panel_5.add(panel_25);
		
		JLabel label_8 = new JLabel("数量*");
		label_8.setFont(new Font("楷体", Font.PLAIN, 15));
		panel_25.add(label_8);
		label_8.setForeground(new Color(255, 0, 0));
		
		counts = new JTextField();
		counts.setFont(new Font("楷体", Font.PLAIN, 14));
		panel_25.add(counts);
		counts.setColumns(10);
		
		JPanel panel_26 = new JPanel();
		panel_5.add(panel_26);
		
		JLabel lblNewLabel_4 = new JLabel("货物名*");
		lblNewLabel_4.setFont(new Font("楷体", Font.PLAIN, 15));
		panel_26.add(lblNewLabel_4);
		lblNewLabel_4.setForeground(new Color(255, 0, 0));
		
		nameOfGood = new JTextField();
		nameOfGood.setFont(new Font("楷体", Font.PLAIN, 14));
		panel_26.add(nameOfGood);
		nameOfGood.setColumns(10);
		
		JPanel panel_27 = new JPanel();
		panel_5.add(panel_27);
		
		JLabel label_7 = new JLabel("订单号*");
		label_7.setFont(new Font("楷体", Font.PLAIN, 15));
		panel_27.add(label_7);
		label_7.setForeground(new Color(255, 0, 0));
		
		id = new JTextField();
		id.setFont(new Font("楷体", Font.PLAIN, 14));
		panel_27.add(id);
		id.setColumns(10);
		
		this.addListeners();
		
		
		
		
		
	}

	private void addListeners(){
		type.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				handleTime();
				handlePrice();
				setTimeAndMoney();
			}
		});
		receiveCity.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				handleTime();
				handlePrice();
				setTimeAndMoney();
			}
		});	
		
		senderCity.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				handleTime();
				handlePrice();
				setTimeAndMoney();
			}
		});
		costOfDecoration.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
			//	handleTime();
				if(!Numeric.isNumeric(costOfDecoration.getText())){
					setMessage("！包装费用必须是数值");
				}else{
					setMessage("");
					handlePrice();
					setTimeAndMoney();
				}
				
			}
		});
		counts.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
			//	handleTime();
				if(!Numeric.isNumeric(counts.getText())){
					setMessage("！数目必须是数值");
				}else{
					setMessage("");
					handlePrice();
				    setTimeAndMoney();
				}
				
			}
		});
		weight.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
			//	handleTime();
				if(!Numeric.isNumeric(weight.getText())){
					setMessage("！重量必须是数值");
				}else{
					setMessage("");
					handlePrice();
					setTimeAndMoney();
				}
			}
		});
		volume.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
			//	handleTime();
				if(!Numeric.isNumeric(volume.getText())){
					setMessage("！体积必须是数值");
				}else{
					setMessage("");
					handlePrice();
					setTimeAndMoney();
				}
			}
		});
		
		
		button.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				 buttonHandler();
			}
			
		});
		
	}
	
	private void buttonHandler(){
		System.out.println("fd fd ");
		if(!Numeric.isNumeric(volume.getText())){
			setMessage("！体积必须是数值");
		}else if(!Numeric.isNumeric(weight.getText())){
			setMessage("！重量必须是数值");
		}else if(!Numeric.isNumeric(counts.getText())){
			setMessage("！数目必须是数值");
		}else if(!Numeric.isNumeric(costOfDecoration.getText())){
			setMessage("！包装费用必须是数值");
		}else if(senderName.getText().length()<3){
			setMessage("！寄件人姓名不能少于两字节");
		}else if(Numeric.isNumeric(senderMobile.getText()) || senderMobile.getText().length()!=11){
			setMessage("！寄件人手机不符合格式");
		}else if(senderPosition.getText().isEmpty()){
			setMessage("！寄件人地址不能为空");
		}else if(receiveName.getText().length()<3){
			setMessage("！收件人姓名不能少于两字节");
		}else if(!Numeric.isNumeric(receiveMobile.getText()) ||
				receiveMobile.getText().length()!=11){
			setMessage("！收件人手机不符合格式");
		}else if(receivePosition.getText().isEmpty()){
			setMessage("！收件人地址不能为空");
		}else if(id.getText().equals("")){
			setMessage("！订单号不能为空");
			System.out.print("id");
		}
		else{
			handleSave();
		}
	}
	
	private void setMessage(String s){
		massage.setText(s);
	}
	private void setTimeAndMoney(){
		timeAndMoney.setText("报价："+money+"元  预计："+time+ " 天后送达");
	}
	
	
	private void handleTime(){
		int time = (int) inputMailingList.time(senderCity.getSelectedItem().toString(),
				receiveCity.getSelectedItem().toString());
		this.time = time;
	}
	
	private void handlePrice(){
		this.money = (int) inputMailingList.price(
				senderCity.getSelectedItem().toString(),
                receiveCity.getSelectedItem().toString(), 
                counts.getText(), weight.getText(), 
                volume.getText(), costOfDecoration.getText(), 
                type.getSelectedItem().toString()
				);
		
		
	}
	
	private void handleSave(){
		boolean result = inputMailingList.handleMailingList(
				senderName.getText(), senderCompany.getText(),
                senderMobile.getText(),senderPhone.getText(), 
                senderCity.getSelectedItem().toString(), 
                senderPosition.getText(), 
               receiveName.getText(), receiveCompany.getText(),
               receiveMobile.getText(), 
                receivePhone.getText(), 
                receiveCity.getSelectedItem().toString(), 
               receivePosition.getText(), 
               nameOfGood.getText(), 
                counts.getText(), 
                weight.getText(), 
                volume.getText(), 
                 costOfDecoration.getText(), 
                 type.getSelectedItem().toString(), 
                 id.getText()
				);
				
	}
	
	

	
}
