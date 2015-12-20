package org.module.client.presentation.orderui;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

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
import org.module.client.vo.AbstractLoadingListVO;

public class NewLoadingrListInputFrame extends JFrame {

	
	private static final long serialVersionUID = 1517705171306679671L;
	protected JPanel contentPane;
	protected JTextField department;
	protected JTextField carID;
	protected JTextField supervision;
	protected JLabel label_5;
	protected JLabel label_6;
	protected JLabel label_7;
	protected JLabel label_8;
	protected JTextField price;
	protected JTextField trucksID;
	protected JTextField driver;
	protected JButton comfirm;
	protected JButton cancel;
	protected JTextPane textPane;
	protected JLabel state;

	protected int lengthOfID = 10;
	protected JXDatePicker timePicker;
	protected JComboBox origin;
	protected JComboBox target;

	protected String[] arrayOfCity;
	
	private CalculateDriverCost costCalculator = new CalculateDriverCost();
	/**
	 * @wbp.parser.constructor
	 */
	public NewLoadingrListInputFrame(String[] cities) {
		this.arrayOfCity = cities;
		init();
	}
	
	public NewLoadingrListInputFrame(String[] cities,AbstractLoadingListVO vo) {
		this.arrayOfCity = cities;
		init();
		this.timePicker.setDate(DateTransferHelper.getDate(vo.getLoadingDate()));
		this.department.setText(vo.getOfficeId());
		this.trucksID.setText(vo.getTrucksId());
		this.origin.setSelectedItem(vo.getCity());
		this.target.setSelectedItem(vo.getLocation());
		this.carID.setText(vo.getCarId());
		this.supervision.setText(vo.getSupervision());
		this.driver.setText(vo.getEscort());; 
		this.price.setText(vo.getPrice());
		
		String[] ss = vo.getShippingId();
		StringBuffer s = new StringBuffer("");
		for (String str : ss) {
			s.append(str);
			s.append("\r");
		}
		this.textPane.setText(s.toString());
	}
	
	protected void init(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("部门编号");
		label.setFont(new Font("楷体", Font.PLAIN, 16));
		label.setBounds(39, 37, 80, 19);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("车辆代号");
		label_1.setFont(new Font("楷体", Font.PLAIN, 16));
		label_1.setBounds(39, 66, 77, 19);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("监装员");
		label_2.setFont(new Font("楷体", Font.PLAIN, 16));
		label_2.setBounds(39, 95, 77, 19);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("目的地");
		label_3.setFont(new Font("楷体", Font.PLAIN, 16));
		label_3.setBounds(39, 124, 77, 19);
		contentPane.add(label_3);
		
		department = new JTextField();
		
		department.setColumns(10);
		department.setBounds(115, 37, 84, 21);
		department.setText(Main.currentUser.getDepartmeny());
		contentPane.add(department);
		
		carID = new JTextField();
		
		carID.setColumns(10);
		carID.setBounds(115, 66, 84, 21);
		contentPane.add(carID);
		
		supervision = new JTextField();
		
		supervision.setColumns(10);
		supervision.setBounds(115, 95, 84, 21);
		contentPane.add(supervision);
		
		JLabel label_4 = new JLabel("汽运编号");
		label_4.setFont(new Font("楷体", Font.PLAIN, 16));
		label_4.setBounds(236, 40, 71, 19);
		contentPane.add(label_4);
		
		label_5 = new JLabel("装车时间");
		label_5.setFont(new Font("楷体", Font.PLAIN, 16));
		label_5.setBounds(236, 69, 71, 19);
		contentPane.add(label_5);
		
		label_6 = new JLabel("司机");
		label_6.setFont(new Font("楷体", Font.PLAIN, 16));
		label_6.setBounds(236, 98, 71, 19);
		contentPane.add(label_6);
		
		label_7 = new JLabel("目的地");
		label_7.setFont(new Font("楷体", Font.PLAIN, 16));
		label_7.setBounds(230, 127, 77, 19);
		contentPane.add(label_7);
		
		label_8 = new JLabel("运费");
		label_8.setFont(new Font("楷体", Font.PLAIN, 16));
		label_8.setBounds(39, 157, 71, 19);
		contentPane.add(label_8);
		
		price = new JTextField();
		price.setText("0");
		price.setEditable(false);
		price.setColumns(10);
		price.setBounds(115, 153, 84, 21);
		contentPane.add(price);
		
		trucksID = new JTextField();
		
		trucksID.setColumns(10);
		trucksID.setBounds(314, 37, 84, 21);
		contentPane.add(trucksID);
		
		driver = new JTextField();
		
		driver.setColumns(10);
		driver.setBounds(314, 95, 84, 21);
		contentPane.add(driver);
		
		origin = new JComboBox(this.arrayOfCity);
		origin.setBounds(115, 124, 84, 21);
		contentPane.add(origin);
		
		target = new JComboBox(this.arrayOfCity);
		target.setBounds(314, 124, 84, 21);
		contentPane.add(target);
		
		timePicker = new JXDatePicker();
		timePicker.setDate(new Date());
		timePicker.setBounds(314, 65, 84, 23);
		contentPane.add(timePicker);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 186, 424, 173);
		contentPane.add(scrollPane);
		
		JLabel labelForInput = new JLabel("在下方填入本次装车所有托运单号");
		labelForInput.setFont(new Font("楷体", Font.PLAIN, 16));
		scrollPane.setColumnHeaderView(labelForInput);
		
		textPane = new JTextPane();
		
		scrollPane.setViewportView(textPane);
		
		comfirm = new JButton("确定");
		comfirm.setBounds(106, 387, 77, 23);
		contentPane.add(comfirm);
		
		cancel = new JButton("取消");
		cancel.setBounds(230, 387, 77, 23);
		contentPane.add(cancel);
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		state = new JLabel("");
		state.setBounds(107, 10, 226, 15);
		contentPane.add(state);
		
		trucksID.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(!Numeric.isNumeric(trucksID.getText())||trucksID.getText().length()!=19){
					state.setText("！汽运编号必须是19位数值");
				}else{
					state.setText("");
				}
			}
		});
		
		carID.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(!Numeric.isNumeric(carID.getText())||carID.getText().length()!=9){
					state.setText("！车辆代号必须是9位数值");
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
		
		driver.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(!Numeric.isNumeric(driver.getText())||driver.getText().length()!=9){
					state.setText("！司机代号必须是9位数值");
				}else{
					state.setText("");
				}
			}
		});
		
		textPane.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(textPane.getText().isEmpty()){
					state.setText("！托运单号不能为空");
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
	}
	
	protected void handlePrice() {
		double p = costCalculator.calculateDriverCostByCityName(origin.getSelectedItem().toString(), 
				target.getSelectedItem().toString());
	    this.price.setText(p+"");
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
			string = string.replace("\r", "");
			string = string.replace("\n", "");
			if(string.length()!=lengthOfID){
				System.out.println("1:"+string);
				System.out.println("2:"+string.length());
				state.setText("托运单号请以空格或回车隔开");
				return null;
			}else{
				
			}
			
		}
	    return shippingId;
	}
	
	
	
	public JButton getComfirm() {
		return comfirm;
	}
	
	public boolean isDataUsable(){
		if(!Numeric.isNumeric(trucksID.getText())||trucksID.getText().length()!=19){
			state.setText("！汽运编号必须是19位数值");
			return false;
		}else if(!Numeric.isNumeric(carID.getText())||carID.getText().length()!=9){
			state.setText("！车辆代号必须是9位数值");
			return false;
		}else if(supervision.getText().isEmpty()){
			state.setText("！监装员不能为空");
			return false;
		}else if(!Numeric.isNumeric(driver.getText())||driver.getText().length()!=9){
			
			state.setText("！司机代号必须是9位数值");
			return false;
		}else if(textPane.getText().isEmpty()){
			state.setText("！托运单号不能为空");
			return false;
		}
		
		return true;
	}
}
