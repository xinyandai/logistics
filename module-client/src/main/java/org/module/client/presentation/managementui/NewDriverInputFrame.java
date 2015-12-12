package org.module.client.presentation.managementui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

import org.module.client.presentation.Numeric;

public class NewDriverInputFrame extends JFrame {

	
	private static final long serialVersionUID = -5319619762372703942L;
	private JPanel contentPane;
	private JTextField id;
	private JTextField birthday;
	private JTextField phone;
	private JTextField date;
	private JTextField drivername;
	private JTextField idCard;
	private JTextField gender;
	private JLabel state;
	private JButton confirm;
	private JButton cancel;

	
	
	public NewDriverInputFrame() {
		init();
	}
	private void init(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		state = new JLabel("");
		state.setBounds(53, 10, 296, 19);
		state.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_1 = new JLabel("编号");
		label_1.setBounds(38, 46, 81, 19);
		label_1.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_2 = new JLabel("生日");
		label_2.setBounds(38, 85, 81, 19);
		label_2.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_3 = new JLabel("姓名");
		label_3.setBounds(224, 49, 81, 19);
		label_3.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_4 = new JLabel("身份证");
		label_4.setBounds(224, 88, 81, 19);
		label_4.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_5 = new JLabel("手机");
		label_5.setBounds(38, 124, 81, 19);
		label_5.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_6 = new JLabel("性别");
		label_6.setBounds(224, 127, 81, 19);
		label_6.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_7 = new JLabel("驾驶证期限");
		label_7.setBounds(38, 160, 81, 19);
		label_7.setFont(new Font("楷体", Font.PLAIN, 16));
		
		id = new JTextField();
		
		id.setBounds(129, 46, 66, 21);
		id.setFont(new Font("楷体", Font.PLAIN, 16));
		id.setColumns(10);
		
		birthday = new JTextField();
		birthday.setBounds(129, 85, 66, 21);
		birthday.setFont(new Font("楷体", Font.PLAIN, 16));
		birthday.setColumns(10);
		
		phone = new JTextField();
		
		
		phone.setBounds(129, 124, 66, 21);
		phone.setFont(new Font("楷体", Font.PLAIN, 16));
		phone.setColumns(10);
		
		date = new JTextField();
		
		date.setBounds(129, 160, 66, 21);
		date.setFont(new Font("楷体", Font.PLAIN, 16));
		date.setColumns(10);
		
		drivername = new JTextField();
		
		drivername.setBounds(315, 46, 66, 21);
		drivername.setFont(new Font("楷体", Font.PLAIN, 16));
		drivername.setColumns(10);
		
		idCard = new JTextField();
		
		idCard.setBounds(315, 85, 66, 21);
		idCard.setFont(new Font("楷体", Font.PLAIN, 16));
		idCard.setColumns(10);
		
		gender = new JTextField();
		
		gender.setBounds(315, 124, 66, 21);
		gender.setFont(new Font("楷体", Font.PLAIN, 16));
		gender.setColumns(10);
		
		confirm = new JButton("确定");
		confirm.setBounds(106, 223, 93, 23);
		confirm.setFont(new Font("楷体", Font.PLAIN, 15));
		
		cancel = new JButton("取消");
		cancel.setBounds(225, 223, 93, 23);
		
		
		cancel.setFont(new Font("楷体", Font.PLAIN, 15));
		contentPane.setLayout(null);
		contentPane.add(state);
		contentPane.add(label_1);
		contentPane.add(label_2);
		contentPane.add(label_3);
		contentPane.add(label_4);
		contentPane.add(label_5);
		contentPane.add(label_6);
		contentPane.add(label_7);
		contentPane.add(id);
		contentPane.add(birthday);
		contentPane.add(phone);
		contentPane.add(date);
		contentPane.add(drivername);
		contentPane.add(idCard);
		contentPane.add(gender);
		contentPane.add(confirm);
		contentPane.add(cancel);
		
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
		gender.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(gender.getText().isEmpty()){
					state.setText("！性别不能为空");
				}else{
					state.setText("");
				}
			}
		});
		date.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(date.getText().isEmpty()){
					state.setText("！驾驶期限不能为空");
				}else{
					state.setText("");
				}
			}
		});
		
	}
	

	public boolean isDataUsable(){
		if((!Numeric.isNumeric(id.getText()))||id.getText().length()!=9){
			state.setText("！汽车代号必须是9位数值");
		}else if(drivername.getText().isEmpty()){
			state.setText("！司机姓名不能为空");
		}else if((!Numeric.isNumeric(idCard.getText()))||idCard.getText().length()!=9){
			state.setText("！身份证号必须是18位数值");
		}else if((!Numeric.isNumeric(phone.getText()))||phone.getText().length()!=9){
			state.setText("！手机号必须是11位数值");
		}else if(gender.getText().isEmpty()){
			state.setText("！性别不能为空");
		}else if(date.getText().isEmpty()){
			state.setText("！驾驶期限不能为空");
		}
			
		return true;
	}
	
	public NewDriverInputFrame(String id, String name, String birthday, String idcard,
			String phone, String gender, String date) {
		this.init();
		this.id.setText(id);
		this.drivername.setText(name);
		this.birthday.setText(birthday);
		this.idCard.setText(idcard);
		this.phone.setText(phone);
		this.gender.setText(gender);
		this.date.setText(date);
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
		return date.getText();
	}
	public String getGender() {
		return gender.getText();
	}
	public String getBirthday() {
		return birthday.getText();
	}
	public String getIdCard() {
		return idCard.getText();
	}
	public JButton getConfirm() {
		return confirm;
	}
	
}
