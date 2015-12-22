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
import org.module.client.businesslogic.managementbl.Driver;
import org.module.client.businesslogic.orderbl.CalculateDriverCost;
import org.module.client.main.Main;
import org.module.client.presentation.DateTransferHelper;
import org.module.client.presentation.Numeric;
import org.module.client.vo.AbstractLoadingListVO;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

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
	protected JComboBox driver;
	protected JButton comfirm;
	protected JButton cancel;
	protected JTextPane textPane;
	protected JLabel state;

	protected int lengthOfID = 10;
	protected JXDatePicker timePicker;
	protected JComboBox origin;
	protected JComboBox target;

	protected String[] arrayOfCity;
	protected String[] arrayOfDrivers;
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
		this.driver.setSelectedItem(vo.getEscort());; 
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
		this.arrayOfDrivers = new Driver().getAllDriversArray();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 460, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("部门编号");
		label.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_1 = new JLabel("车辆代号");
		label_1.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_2 = new JLabel("监装员");
		label_2.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_3 = new JLabel("目的地");
		label_3.setFont(new Font("楷体", Font.PLAIN, 16));
		
		department = new JTextField();
		
		department.setColumns(10);
		department.setText(Main.currentUser.getDepartmeny());
		
		carID = new JTextField();
		
		carID.setColumns(10);
		
		supervision = new JTextField();
		
		supervision.setColumns(10);
		
		JLabel label_4 = new JLabel("汽运编号");
		label_4.setFont(new Font("楷体", Font.PLAIN, 16));
		
		label_5 = new JLabel("装车时间");
		label_5.setFont(new Font("楷体", Font.PLAIN, 16));
		
		label_6 = new JLabel("司机");
		label_6.setFont(new Font("楷体", Font.PLAIN, 16));
		
		label_7 = new JLabel("目的地");
		label_7.setFont(new Font("楷体", Font.PLAIN, 16));
		
		label_8 = new JLabel("运费");
		label_8.setFont(new Font("楷体", Font.PLAIN, 16));
		
		price = new JTextField();
		price.setText("0");
		price.setEditable(false);
		price.setColumns(10);
		
		trucksID = new JTextField();
		trucksID.setColumns(10);
		driver = new JComboBox(this.arrayOfDrivers);
		//driver.setColumns(10);
		origin = new JComboBox(this.arrayOfCity);
		target = new JComboBox(this.arrayOfCity);
		
		timePicker = new JXDatePicker();
		timePicker.setDate(new Date());
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel labelForInput = new JLabel("在下方填入本次装车所有托运单号");
		labelForInput.setFont(new Font("楷体", Font.PLAIN, 16));
		scrollPane.setColumnHeaderView(labelForInput);
		
		textPane = new JTextPane();
		
		scrollPane.setViewportView(textPane);
		
		comfirm = new JButton("确定");
		
		cancel = new JButton("取消");
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		state = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(102)
					.addComponent(state, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(76)
							.addComponent(department, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(trucksID, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
					.addGap(41))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(76)
							.addComponent(carID, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(timePicker, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
					.addGap(41))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(76)
							.addComponent(supervision, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(driver, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
					.addGap(41))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(76)
							.addComponent(origin, 0, 84, Short.MAX_VALUE)))
					.addGap(31)
					.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(target, 0, 84, Short.MAX_VALUE)
					.addGap(41))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(34)
					.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(price, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
					.addGap(240))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
					.addGap(5))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(130)
					.addComponent(comfirm, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(cancel, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
					.addGap(132))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(state, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(department, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(label_4))
						.addComponent(trucksID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(carID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(label_5))
						.addComponent(timePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(supervision, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(label_6))
						.addComponent(driver, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_3)
						.addComponent(origin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(label_7))
						.addComponent(target, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(label_8))
						.addComponent(price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cancel)
						.addComponent(comfirm)))
		);
		contentPane.setLayout(gl_contentPane);
		
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
		
		/*driver.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(!Numeric.isNumeric(driver.getText())||driver.getText().length()!=9){
					state.setText("！司机代号必须是9位数值");
				}else{
					state.setText("");
				}
			}
		});*/
		
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
		}/*else if(!Numeric.isNumeric(driver.getText())||driver.getText().length()!=9){
			
			state.setText("！司机代号必须是9位数值");
			return false;
		}*/
		else if(textPane.getText().isEmpty()){
			state.setText("！托运单号不能为空");
			return false;
		}
		
		return true;
	}
}
