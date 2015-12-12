package org.module.client.presentation.orderui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.JXDatePicker;
import org.module.client.presentation.DateTransferHelper;
import org.module.client.presentation.Numeric;
import org.module.client.vo.TransportListVO;
import org.module.common.po.State;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

public class NewTransportListInputFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8466565608895376121L;
	private JPanel contentPane;
	private JTextField trucksID;
	private JTextField price;
	private JTextField supervision;
	private JTextField transportList;
	private JTextField counterID;
	private JButton comfirm;
	private JButton cancel;
	
	
	private JComboBox way;
	private JComboBox origin;
	private JComboBox target;
	private JXDatePicker datePicker;
	private JTextPane textPane;
	private JLabel state;
	private int lengthOfID = 9;
	private String[] array;
	
	/**
	 * @wbp.parser.constructor
	 */
	public NewTransportListInputFrame(String[] ary) {
		this.array = ary;
		init();
	}	
	public NewTransportListInputFrame(String[] ary,TransportListVO vo) {
		this.array = ary;
		init();
		
		this.way.setSelectedItem(vo.getCar());
		this.datePicker.setDate(DateTransferHelper.getDate(vo.getLoadingDate()));
		this.transportList.setText(vo.getTransId());
		this.trucksID.setText(vo.getCar());
		this.origin.setSelectedItem(vo.getOrigin());
		this.target.setSelectedItem(vo.getArrival());
		this.counterID.setText(vo.getCounterId());
		this.supervision.setText(vo.getSupervision());
		this.price.setText(vo.getPrice());
		
		String[] ss = vo.getShippingId();
		StringBuffer s = new StringBuffer("");
		for (String str : ss) {
			s.append(str);
			s.append("\r");
		}
		this.textPane.setText(s.toString());
	}	
	
	private void init(){
		setBounds(100, 100, 474, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("中转方式");
		label.setFont(new Font("楷体", Font.PLAIN, 18));
		label.setBounds(34, 31, 79, 15);
		contentPane.add(label);
		
		state = new JLabel("");
		state.setBounds(133, 10, 215, 15);
		contentPane.add(state);
		
		JLabel label_1 = new JLabel("车次");
		label_1.setFont(new Font("楷体", Font.PLAIN, 18));
		label_1.setBounds(34, 59, 79, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("出发地");
		label_2.setFont(new Font("楷体", Font.PLAIN, 18));
		label_2.setBounds(34, 84, 79, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("监装员");
		label_3.setFont(new Font("楷体", Font.PLAIN, 18));
		label_3.setBounds(34, 109, 79, 15);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("运费");
		label_4.setFont(new Font("楷体", Font.PLAIN, 18));
		label_4.setBounds(34, 134, 79, 15);
		contentPane.add(label_4);
		
		String[] wayArray = {"火车","飞机","轮船"};
		way = new JComboBox(wayArray);
		way.setFont(new Font("宋体", Font.PLAIN, 15));
		way.setBounds(117, 30, 94, 21);
		contentPane.add(way);
		
		trucksID = new JTextField();
		
		trucksID.setColumns(10);
		trucksID.setBounds(117, 58, 109, 21);
		contentPane.add(trucksID);
		
		price = new JTextField();
		price.setEditable(false);
		price.setColumns(10);
		price.setBounds(117, 134, 109, 21);
		contentPane.add(price);
		
		supervision = new JTextField();
		
		supervision.setColumns(10);
		supervision.setBounds(117, 108, 109, 21);
		contentPane.add(supervision);
		
		JLabel label_5 = new JLabel("装车日期");
		label_5.setFont(new Font("楷体", Font.PLAIN, 18));
		label_5.setBounds(237, 31, 79, 15);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("中转单号");
		label_6.setFont(new Font("楷体", Font.PLAIN, 18));
		label_6.setBounds(236, 61, 79, 15);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("目的地");
		label_7.setFont(new Font("楷体", Font.PLAIN, 18));
		label_7.setBounds(237, 86, 79, 15);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("货柜号");
		label_8.setFont(new Font("楷体", Font.PLAIN, 18));
		label_8.setBounds(236, 111, 79, 15);
		contentPane.add(label_8);
		
		transportList = new JTextField();
		
		transportList.setColumns(10);
		transportList.setBounds(325, 58, 109, 21);
		contentPane.add(transportList);
		
		counterID = new JTextField();
		
		counterID.setColumns(10);
		counterID.setBounds(325, 108, 109, 21);
		contentPane.add(counterID);
		
		origin = new JComboBox(this.array );
		origin.setFont(new Font("宋体", Font.PLAIN, 15));
		origin.setBounds(117, 84, 94, 21);
		contentPane.add(origin);
		
		target = new JComboBox(this.array);
		target.setFont(new Font("宋体", Font.PLAIN, 15));
		target.setBounds(326, 83, 94, 21);
		contentPane.add(target);
		
		comfirm = new JButton("确定");
		comfirm.setBounds(154, 353, 72, 23);
		contentPane.add(comfirm);
		
		cancel = new JButton("取消");
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		cancel.setBounds(237, 353, 72, 23);
		contentPane.add(cancel);
		
		datePicker = new JXDatePicker();
		datePicker.setBounds(326, 29, 109, 21);
		contentPane.add(datePicker);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 176, 438, 167);
		contentPane.add(scrollPane);
		
		JLabel label_9 = new JLabel("在下方填入所有订单号");
		scrollPane.setColumnHeaderView(label_9);
		
		textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		
		
		
		trucksID.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if((!Numeric.isRealNumber(trucksID.getText()))||trucksID.getText().length()!=9){
					state.setText("！车辆代号必须是9位数值");
				}else{
					state.setText("");
				}
			}		
		});
		
		transportList.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if((!Numeric.isRealNumber(transportList.getText()))||transportList.getText().length()!=21){
					state.setText("！中转单号必须是21位数值");
				}else{
					state.setText("");
				}
			}
		});
		
		supervision.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(supervision.getText().isEmpty()){
					state.setText("！监装员不能为空");
				}else{
					state.setText("");
				}
			}
		});
		
		counterID.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(counterID.getText().isEmpty()){
					state.setText("！监装员不能为空");
				}else{
					state.setText("");
				}
			}
		});
	}
	public JButton getComfirm() {
		return comfirm;
	}
	
	public boolean isDataUsable(){
		if((!Numeric.isRealNumber(trucksID.getText()))||trucksID.getText().length()!=9){
			state.setText("！车辆代号必须是9位数值");
			return false;
		}else if((!Numeric.isRealNumber(transportList.getText()))||transportList.getText().length()!=21){
			state.setText("！中转单号必须是21位数值");
			return false;
		}else if(supervision.getText().isEmpty()){
			state.setText("！监装员不能为空");
			return false;
		}else if(counterID.getText().isEmpty()){
			state.setText("！监装员不能为空");
			return false;
		}
		
		
		String[] ids = this.shippingId();
		return (ids !=null) ;
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
	
	public TransportListVO getVO(){
		String[] ids = this.shippingId();
		if(ids ==null) return null;
		
		return new TransportListVO(
				this.way.getSelectedItem().toString(),
				DateTransferHelper.getString( this.datePicker.getDate() ),
				this.transportList.getText(),
				this.trucksID.getText(),
				this.origin.getSelectedItem().toString(),
				this.target.getSelectedItem().toString(),
				this.counterID.getText(),
				this.supervision.getText(),
				ids,
				this.price.getText(),
				State.SUBMITTED
				);
	}
}
