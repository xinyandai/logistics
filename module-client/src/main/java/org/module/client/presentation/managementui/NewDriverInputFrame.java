package org.module.client.presentation.managementui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

import org.jdesktop.swingx.JXDatePicker;
import org.module.client.presentation.DateTransferHelper;
import org.module.client.presentation.Numeric;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class NewDriverInputFrame extends JFrame {

	
	private static final long serialVersionUID = -5319619762372703942L;
	private JPanel contentPane;
	private JTextField id;
	private JXDatePicker birthday;
	private JTextField phone;
	private JXDatePicker date;
	private JTextField drivername;
	private JTextField idCard;
	private JRadioButton gender;
	private JLabel state;
	private JButton confirm;
	private JButton cancel;

	
	
	public NewDriverInputFrame() {
		init();
	}
	private void init(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		state = new JLabel("");
		state.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_1 = new JLabel("编号");
		label_1.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_2 = new JLabel("生日");
		label_2.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_3 = new JLabel("姓名");
		label_3.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_4 = new JLabel("身份证");
		label_4.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_5 = new JLabel("手机");
		label_5.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_6 = new JLabel("男");
		label_6.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_7 = new JLabel("驾驶证期限");
		label_7.setFont(new Font("楷体", Font.PLAIN, 16));
		
		id = new JTextField();
		id.setFont(new Font("楷体", Font.PLAIN, 16));
		id.setColumns(10);
		
		birthday = new JXDatePicker();
		birthday.setFont(new Font("楷体", Font.PLAIN, 16));
		birthday.setDate(new Date());
	//	birthday.setColumns(10);
		
		phone = new JTextField();
		phone.setFont(new Font("楷体", Font.PLAIN, 16));
		phone.setColumns(10);
		
		date = new JXDatePicker();
		date.setFont(new Font("楷体", Font.PLAIN, 16));
		date.setDate(new Date());
//		date.setColumns(10);
		
		drivername = new JTextField();
		drivername.setFont(new Font("楷体", Font.PLAIN, 16));
		drivername.setColumns(10);
		
		idCard = new JTextField();
		idCard.setFont(new Font("楷体", Font.PLAIN, 16));
		idCard.setColumns(10);
		
		gender = new JRadioButton();
		gender.setFont(new Font("楷体", Font.PLAIN, 16));
	//	gender.setColumns(10);
		
		confirm = new JButton("确定");
		confirm.setFont(new Font("楷体", Font.PLAIN, 15));
		
		cancel = new JButton("取消");
		
		
		cancel.setFont(new Font("楷体", Font.PLAIN, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(48)
					.addComponent(state, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(id, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(drivername, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
					.addGap(48))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(idCard, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
					.addGap(48))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(101)
					.addComponent(confirm, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
					.addGap(26)
					.addComponent(cancel, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
					.addGap(111))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(birthday, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(gender, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addGap(4))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(phone, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(date, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(48))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(state, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1)
						.addComponent(id, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(label_3))
						.addComponent(drivername, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(birthday, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_2)
							.addComponent(label_6))
						.addComponent(gender))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_5)
						.addComponent(phone, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(date, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_7))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(idCard, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4))
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(confirm, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(cancel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);
		
		addListeners();
	}
	private void addListeners() {
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
		id.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if((!Numeric.isNumeric(id.getText()))||id.getText().length()!=9){
					state.setText("！汽车代号必须是9位数值");
				}else{
					state.setText("");
				}
			}
		});
		drivername.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(drivername.getText().isEmpty()){
					state.setText("！司机姓名不能为空");
				}else{
					state.setText("");
				}
			}
		});
		idCard.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if((!Numeric.isNumeric(idCard.getText()))||idCard.getText().length()!=18){
					state.setText("！身份证号必须是18位数值");
				}else{
					state.setText("");
				}
			}
		});
		phone.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if((!Numeric.isNumeric(phone.getText()))||phone.getText().length()!=11){
					state.setText("！手机号必须是11位数值");
				}else{
					state.setText("");
				}
			}
		});
	
		
		
	}
	

	public boolean isDataUsable(){
		if((!Numeric.isNumeric(id.getText()))||id.getText().length()!=9){
			state.setText("！司机代号必须是9位数值");
		}else if(drivername.getText().isEmpty()){
			state.setText("！司机姓名不能为空");
		}else if((!Numeric.isNumeric(idCard.getText()))||idCard.getText().length()!=9){
			state.setText("！身份证号必须是18位数值");
		}else if((!Numeric.isNumeric(phone.getText()))||phone.getText().length()!=9){
			state.setText("！手机号必须是11位数值");
		}else if(gender.getText().isEmpty()){
			state.setText("！性别不能为空");
		}else{
			return true;
		}
			
		return false;
	}
	
	public NewDriverInputFrame(String id, String name, String birthday, String idcard,
			String phone, String gender, String date) {
		this.init();
		this.id.setText(id);
		this.drivername.setText(name);
		this.birthday.setDate(DateTransferHelper.getDate(birthday));
		this.idCard.setText(idcard);
		this.phone.setText(phone);
		this.gender.setSelected(gender.equals("男"));
		this.date.setDate(DateTransferHelper.getDate(date));
	}
	public String getPhone() {
		return phone.getText();
	}
	public String getDrivername() {
		return drivername.getText();
	}
	public String getId() {
		return id.getText();
	}
	public String getDate() {
		return DateTransferHelper.getString(date.getDate());
	}
	public String getGender() {
		return gender.isSelected()? "男":"女";
	}
	public String getBirthday() {
		return DateTransferHelper.getString(birthday.getDate());
	}
	public String getIdCard() {
		return idCard.getText();
	}
	public JButton getConfirm() {
		return confirm;
	}
	
}
