package org.module.client.presentation.orderui;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import org.jdesktop.swingx.JXDatePicker;
import org.module.client.businesslogic.orderbl.CalculateDriverCost;
import org.module.client.main.Main;
import org.module.client.presentation.DateTransferHelper;
import org.module.client.presentation.Numeric;
import org.module.client.vo.TransportListVO;
import org.module.common.po.State;

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
	private int lengthOfID = 10;
	private String[] array;
	
	private CalculateDriverCost costCalculator = new CalculateDriverCost();
	
	/**
	 * @wbp.parser.constructor
	 */
	public NewTransportListInputFrame(String[] ary) {
		this.array = ary;
		init();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String dateString = formatter.format(new Date());
		String s = Main.currentUser.getDepartmeny() + dateString;
		this.transportList.setText(s);
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
		setBounds(400, 200, 474, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("中转方式");
		label.setFont(new Font("楷体", Font.PLAIN, 18));
		
		state = new JLabel("");
		
		JLabel label_1 = new JLabel("车次");
		label_1.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_2 = new JLabel("出发地");
		label_2.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_3 = new JLabel("监装员");
		label_3.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_4 = new JLabel("运费");
		label_4.setFont(new Font("楷体", Font.PLAIN, 18));
		
		String[] wayArray = {"火车","飞机","轮船"};
		way = new JComboBox(wayArray);
		way.setFont(new Font("宋体", Font.PLAIN, 15));
		
		trucksID = new JTextField();
		
		trucksID.setColumns(10);
		
		price = new JTextField();
		price.setEditable(false);
		price.setColumns(10);
		
		supervision = new JTextField();
		
		supervision.setColumns(10);
		
		JLabel label_5 = new JLabel("装车日期");
		label_5.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_6 = new JLabel("中转单号");
		label_6.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_7 = new JLabel("目的地");
		label_7.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_8 = new JLabel("货柜号");
		label_8.setFont(new Font("楷体", Font.PLAIN, 18));
		
		transportList = new JTextField();
		transportList.setColumns(10);
		counterID = new JTextField();
		counterID.setColumns(10);
		origin = new JComboBox(this.array );
		origin.setFont(new Font("宋体", Font.PLAIN, 15));
		target = new JComboBox(this.array);
		target.setFont(new Font("宋体", Font.PLAIN, 15));
		comfirm = new JButton("确定");
		cancel = new JButton("取消");
		datePicker = new JXDatePicker();
		datePicker.setDate(new Date());
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label_9 = new JLabel("在下方填入所有订单号");
		scrollPane.setColumnHeaderView(label_9);
		
		textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(128)
					.addComponent(state, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(way, 0, 109, Short.MAX_VALUE)
					.addGap(11)
					.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(datePicker, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
					.addGap(18))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(transportList, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
					.addGap(19))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(origin, 0, 109, Short.MAX_VALUE)
					.addGap(11)
					.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(target, 0, 108, Short.MAX_VALUE)
					.addGap(19))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(supervision, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(counterID, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
					.addGap(19))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(trucksID, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
					.addGap(11)
					.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(price, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
					.addGap(19))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
					.addGap(5))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(149)
					.addComponent(comfirm, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
					.addGap(11)
					.addComponent(cancel, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
					.addGap(144))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(state, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(way, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(transportList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(origin, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(target, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(3)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(supervision, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(counterID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(trucksID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(comfirm)
						.addComponent(cancel)))
		);
		contentPane.setLayout(gl_contentPane);
		
		
		
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
		
		origin.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				handlePrice();
			}
		});
		
		target.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				handlePrice();
			}
		});
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
	}
	protected void handlePrice() {
		double p = costCalculator.calculateDriverCostByCityName(origin.getSelectedItem().toString(), 
				target.getSelectedItem().toString());
	    this.price.setText(p+"");
	}
	public JButton getComfirm() {
		return comfirm;
	}
	
	public boolean isDataUsable(){
		if((!Numeric.isNumeric(trucksID.getText()))||trucksID.getText().length()!=9){
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
				State.SUBMITTED,
				Main.currentUser.getId() 
				);
	}
}
