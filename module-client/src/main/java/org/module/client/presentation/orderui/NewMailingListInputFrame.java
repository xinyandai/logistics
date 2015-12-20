package org.module.client.presentation.orderui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import org.module.client.businesslogicservice.orderBLservice.MailingBLService;
import org.module.client.main.Main;
import org.module.client.presentation.Numeric;
import org.module.client.vo.MailingListVO;
import org.module.common.po.State;

public class NewMailingListInputFrame extends JFrame {

	
	private static final long serialVersionUID = -2506113922132161119L;
	private JPanel contentPane;
	private JTextField senderName;
	private JTextField senderMobile;
	private JTextField receiveName;
	private JTextField receiveMobile;
	private JTextField volume;
	private JTextField senderCompany;
	private JTextField senderPhone;
	private JTextField receiveCompany;
	private JTextField receivePhone;
	private JTextField senderPosition;
	private JTextField receivePosition;
	private JTextField counts;
	private JTextField weight;
	private JLabel timeAndMoney;
	private JComboBox type;
	private JComboBox receiveCity;
	private JComboBox senderCity;

	private MailingBLService controller ;
	private String[] stringOfType = {"经济快递","标准快递","特快"};
	private String[] cities ;
	private JTextField nameOfGood;
	private JTextField id;
	private JComboBox costOfDecoration;
	
	private int time;
	private double money;
	
	private JLabel state;
	private JButton comfirm;
	private JButton cancel;
	
	/**
	 * @wbp.parser.constructor
	 */
	public NewMailingListInputFrame(MailingBLService controller) {
		this.controller = controller;
		this.cities = this.controller.getAllCitiesArray();
		init();
		addListeners();
		
	}
	public NewMailingListInputFrame(MailingListVO mailingListVO,MailingBLService controller) {
		this.controller = controller;
		this.cities = this.controller.getAllCitiesArray();
		init();
		senderName.setText(mailingListVO.getSenderName());
		senderCompany.setText(mailingListVO.getSenderCompany());
        senderMobile.setText(mailingListVO.getSenderMobile());
        senderPhone.setText(mailingListVO.getSenderPhone()); 
       senderCity.setSelectedItem(mailingListVO.getSenderCity()); 
        senderPosition.setText(mailingListVO.getSenderPosition());
        
        
       receiveName.setText(mailingListVO.getReceiveName());
       receiveCompany.setText(mailingListVO.getReceiveCompany());
       receiveMobile.setText(mailingListVO.getReceiveMobile()); 
        receivePhone.setText(mailingListVO.getReceivePhone()); 
       receiveCity.setSelectedItem(mailingListVO.getReceiveCity()); 
       receivePosition.setText(mailingListVO.getSenderPosition()); 
       
       nameOfGood.setText(mailingListVO.getNameOfGood()); 
       counts.setText(mailingListVO.getCounts()); 
        weight.setText(mailingListVO.getWeight()); 
        volume.setText(mailingListVO.getVolume()); 
         costOfDecoration.setSelectedItem(mailingListVO.getCostOfDecoration()); 
         type.setSelectedItem(mailingListVO.getType());
         id.setText(mailingListVO.getId());
         
         id.setEditable(false);
         
         addListeners();
	}
	
	private void setMessage(String s){
		state.setText(s);
	}
	
	public  boolean isDataUsable(){
		if(!Numeric.isRealNumber(volume.getText())){
			setMessage("！体积必须是数值");
		}else if(!Numeric.isRealNumber(weight.getText())){
			setMessage("！重量必须是数值");
		}else if(!Numeric.isNumeric(counts.getText())){
			setMessage("！数目必须是数值");
		}else if(!Numeric.isRealNumber(costOfDecoration.getSelectedItem().toString())){
			setMessage("！包装费用必须是数值");
		}else if(senderName.getText().length()<3){
			setMessage("！寄件人姓名不能少于两字节");
		}else if(!Numeric.isNumeric(senderMobile.getText()) || senderMobile.getText().length()!=11){
			setMessage("！寄件人手机不符合格式");
		}else if(senderPosition.getText().isEmpty()){
			setMessage("！寄件人地址不能为空");
		}else if(receiveName.getText().length()<2){
			setMessage("！收件人姓名不能少于两字节");
		}else if(!Numeric.isNumeric(receiveMobile.getText()) ||
				receiveMobile.getText().length()!=11){
			setMessage("！收件人手机不符合格式");
		}else if(receivePosition.getText().isEmpty()){
			setMessage("！收件人地址不能为空");
		}else if(id.getText().equals("")){
			setMessage("！订单号不能为空");
		}
		else{
			return true;
		}
		return false;
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
		costOfDecoration.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(!Numeric.isRealNumber(costOfDecoration.getSelectedItem().toString())){
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
				if(!Numeric.isRealNumber(counts.getText())){
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
				if(!Numeric.isRealNumber(weight.getText())){
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
				if(!Numeric.isRealNumber(volume.getText())){
					setMessage("！体积必须是数值");
				}else{
					setMessage("");
					handlePrice();
					setTimeAndMoney();
				}
			}
		});
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
	
		
		
	}
	private void init(){
		setBounds(100, 100, 450, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		state = new JLabel("");
		state.setHorizontalAlignment(SwingConstants.CENTER);
		state.setFont(new Font("楷体", Font.PLAIN, 15));
		state.setBounds(10, 10, 424, 15);
		contentPane.add(state);
		
		JLabel label = new JLabel("寄件人姓名*");
		label.setForeground(Color.RED);
		label.setFont(new Font("楷体", Font.PLAIN, 15));
		label.setBounds(10, 35, 83, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("寄件人手机*");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("楷体", Font.PLAIN, 15));
		label_1.setBounds(10, 63, 83, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("寄件人地址*");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("楷体", Font.PLAIN, 15));
		label_2.setBounds(10, 91, 83, 18);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("收件人姓名*");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("楷体", Font.PLAIN, 15));
		label_3.setBounds(10, 119, 83, 18);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("收件人手机*");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("楷体", Font.PLAIN, 15));
		label_4.setBounds(10, 147, 83, 18);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("收件人地址*");
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("楷体", Font.PLAIN, 15));
		label_5.setBounds(10, 175, 83, 18);
		contentPane.add(label_5);
		
		senderName = new JTextField();
		senderName.setFont(new Font("楷体", Font.PLAIN, 14));
		senderName.setColumns(10);
		senderName.setBounds(103, 35, 95, 22);
		contentPane.add(senderName);
		
		senderMobile = new JTextField();
		senderMobile.setFont(new Font("楷体", Font.PLAIN, 14));
		senderMobile.setColumns(10);
		senderMobile.setBounds(103, 62, 95, 22);
		contentPane.add(senderMobile);
		
		senderCity = new JComboBox(cities);
		senderCity.setBounds(103, 90, 71, 21);
		contentPane.add(senderCity);
		
		receiveCity = new JComboBox(cities);
		receiveCity.setBounds(103, 174, 71, 21);
		contentPane.add(receiveCity);
		
		JLabel label_6 = new JLabel("快递类型*");
		label_6.setForeground(Color.RED);
		label_6.setFont(new Font("楷体", Font.PLAIN, 15));
		label_6.setBounds(10, 220, 83, 18);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("体积*");
		label_7.setForeground(Color.RED);
		label_7.setFont(new Font("楷体", Font.PLAIN, 15));
		label_7.setBounds(10, 248, 83, 18);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("寄件人公司");
		label_8.setFont(new Font("楷体", Font.PLAIN, 15));
		label_8.setBounds(221, 35, 75, 18);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("寄件人电话");
		label_9.setFont(new Font("楷体", Font.PLAIN, 15));
		label_9.setBounds(221, 65, 75, 18);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("收件人公司");
		label_10.setFont(new Font("楷体", Font.PLAIN, 15));
		label_10.setBounds(221, 119, 75, 18);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("收件人电话");
		label_11.setFont(new Font("楷体", Font.PLAIN, 15));
		label_11.setBounds(221, 149, 75, 18);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("包装费用*");
		label_12.setForeground(Color.RED);
		label_12.setFont(new Font("楷体", Font.PLAIN, 15));
		label_12.setBounds(221, 220, 68, 18);
		contentPane.add(label_12);
		
		String[] prices = {"1","2","3","5","10","20"};
		costOfDecoration = new JComboBox(prices);
		costOfDecoration.setEditable(true);
		costOfDecoration.setFont(new Font("楷体", Font.PLAIN, 14));
		costOfDecoration.setEnabled(true);
		costOfDecoration.setBounds(313, 218, 95, 22);
		contentPane.add(costOfDecoration);
		
		type = new JComboBox(this.stringOfType);
		type.setBounds(103, 219, 71, 21);
		contentPane.add(type);
		
		receiveName = new JTextField();
		receiveName.setFont(new Font("楷体", Font.PLAIN, 14));
		receiveName.setColumns(10);
		receiveName.setBounds(103, 118, 95, 22);
		contentPane.add(receiveName);
		
		receiveMobile = new JTextField();
		receiveMobile.setFont(new Font("楷体", Font.PLAIN, 14));
		receiveMobile.setColumns(10);
		receiveMobile.setBounds(103, 146, 95, 22);
		contentPane.add(receiveMobile);
		
		volume = new JTextField();
		volume.setFont(new Font("楷体", Font.PLAIN, 14));
		volume.setColumns(10);
		volume.setBounds(103, 247, 95, 22);
		contentPane.add(volume);
		
		senderCompany = new JTextField();
		senderCompany.setFont(new Font("楷体", Font.PLAIN, 14));
		senderCompany.setColumns(10);
		senderCompany.setBounds(313, 35, 95, 22);
		contentPane.add(senderCompany);
		
		senderPhone = new JTextField();
		senderPhone.setFont(new Font("楷体", Font.PLAIN, 14));
		senderPhone.setColumns(10);
		senderPhone.setBounds(313, 61, 95, 22);
		contentPane.add(senderPhone);
		
		receiveCompany = new JTextField();
		receiveCompany.setFont(new Font("楷体", Font.PLAIN, 14));
		receiveCompany.setColumns(10);
		receiveCompany.setBounds(313, 118, 95, 22);
		contentPane.add(receiveCompany);
		
		receivePhone = new JTextField();
		receivePhone.setFont(new Font("楷体", Font.PLAIN, 14));
		receivePhone.setColumns(10);
		receivePhone.setBounds(313, 146, 95, 22);
		contentPane.add(receivePhone);
		
		senderPosition = new JTextField();
		senderPosition.setFont(new Font("楷体", Font.PLAIN, 14));
		senderPosition.setColumns(10);
		senderPosition.setBounds(196, 90, 212, 22);
		contentPane.add(senderPosition);
		
		receivePosition = new JTextField();
		receivePosition.setFont(new Font("楷体", Font.PLAIN, 14));
		receivePosition.setColumns(10);
		receivePosition.setBounds(196, 174, 212, 22);
		contentPane.add(receivePosition);
		
		JLabel label_13 = new JLabel("重量*");
		label_13.setForeground(Color.RED);
		label_13.setFont(new Font("楷体", Font.PLAIN, 15));
		label_13.setBounds(221, 250, 68, 18);
		contentPane.add(label_13);
		
		JLabel label_14 = new JLabel("数量*");
		label_14.setForeground(Color.RED);
		label_14.setFont(new Font("楷体", Font.PLAIN, 15));
		label_14.setBounds(10, 276, 83, 18);
		contentPane.add(label_14);
		
		counts = new JTextField();
		counts.setFont(new Font("楷体", Font.PLAIN, 14));
		counts.setColumns(10);
		counts.setBounds(103, 275, 95, 22);
		contentPane.add(counts);
		
		weight = new JTextField();
		weight.setFont(new Font("楷体", Font.PLAIN, 14));
		weight.setColumns(10);
		weight.setBounds(313, 246, 95, 22);
		contentPane.add(weight);
		
		comfirm = new JButton("确定");
		comfirm.setBounds(103, 376, 93, 23);
		contentPane.add(comfirm);
		
		cancel = new JButton("取消");
		cancel.setBounds(221, 376, 93, 23);
		contentPane.add(cancel);
		
		timeAndMoney = new JLabel("报价：0元       预计： 0 天后送达");
		timeAndMoney.setHorizontalAlignment(SwingConstants.CENTER);
		timeAndMoney.setFont(new Font("楷体", Font.PLAIN, 15));
		timeAndMoney.setBounds(10, 348, 414, 18);
		contentPane.add(timeAndMoney);
		
		JLabel label_15 = new JLabel("货物名*");
		label_15.setForeground(Color.RED);
		label_15.setFont(new Font("楷体", Font.PLAIN, 15));
		label_15.setBounds(221, 278, 75, 18);
		contentPane.add(label_15);
		
		nameOfGood = new JTextField();
		nameOfGood.setFont(new Font("楷体", Font.PLAIN, 14));
		nameOfGood.setColumns(10);
		nameOfGood.setBounds(313, 275, 95, 22);
		contentPane.add(nameOfGood);
		
		JLabel label_16 = new JLabel("订单号*");
		label_16.setForeground(Color.RED);
		label_16.setFont(new Font("楷体", Font.PLAIN, 15));
		label_16.setBounds(10, 307, 83, 18);
		contentPane.add(label_16);
		
		id = new JTextField();
		id.setFont(new Font("楷体", Font.PLAIN, 14));
		id.setColumns(10);
		id.setBounds(103, 307, 95, 22);
		contentPane.add(id);
	}

	private void setTimeAndMoney(){
		timeAndMoney.setText("报价："+money+"元  预计："+time+ " 天后送达");
	}
	private void handleTime(){
		int time = (int) controller.time(senderCity.getSelectedIndex(),
				receiveCity.getSelectedIndex());
		this.time = time;
	}
	private void handlePrice(){
		this.money = (double) controller.price(
				senderCity.getSelectedIndex(),
                receiveCity.getSelectedIndex(), 
                 costOfDecoration.getSelectedItem().toString()
				);
	}
	
	public MailingListVO getVO(){
		MailingListVO vo  = new MailingListVO(senderName.getText(), senderCompany.getText(),
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
                 costOfDecoration.getSelectedItem().toString(), 
                 type.getSelectedItem().toString(), 
                 id.getText(),State.SUBMITTED,
                Main.currentUser.getId() 
				);
		return vo;
	}
	public JButton getComfirm() {
		return comfirm;
	}
}
