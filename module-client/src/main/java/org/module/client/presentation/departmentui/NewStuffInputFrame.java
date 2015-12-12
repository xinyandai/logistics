package org.module.client.presentation.departmentui;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import org.module.client.presentation.Numeric;
import org.module.client.vo.StuffVO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

public class NewStuffInputFrame extends JFrame {

	
	private static final long serialVersionUID = -1434641796573248537L;
	private JPanel contentPane;
	private JTextField age;
	private JTextField name;
	private JTextField id;
	private JComboBox type;
	private JLabel state;
	private JButton comfirm;
	private JButton cancel;
	private final String[] array= {"快递员","营业厅业务员","仓库管理员","中转中心业务员","财务人员","总经理","管理员"};
	
	public NewStuffInputFrame() {
		init();
		addListeners();
		
	}

	public NewStuffInputFrame(String name,String age,String id,String type) {
		init();
		addListeners();
		this.name.setText(name);
		this.age.setText(age);
		this.id.setText(id);
		this.type.setSelectedItem(type);
		
	}
	
	public NewStuffInputFrame(StuffVO stuffVO) {
		this(stuffVO.getName(),stuffVO.getAge(),stuffVO.getIdentity(),stuffVO.getCategory());
	}

	private void init(){ 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		state = new JLabel("");
		state.setBounds(78, 10, 308, 15);
		contentPane.add(state);
		
		JLabel label = new JLabel("年龄");
		label.setFont(new Font("楷体", Font.PLAIN, 16));
		label.setBounds(60, 43, 54, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("姓名");
		label_1.setFont(new Font("楷体", Font.PLAIN, 16));
		label_1.setBounds(60, 71, 54, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("员工号");
		label_2.setFont(new Font("楷体", Font.PLAIN, 16));
		label_2.setBounds(219, 46, 54, 18);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("工作类别");
		label_3.setFont(new Font("楷体", Font.PLAIN, 16));
		label_3.setBounds(219, 74, 69, 18);
		contentPane.add(label_3);
		
		age = new JTextField();
		
		age.setFont(new Font("楷体", Font.PLAIN, 16));
		age.setBounds(109, 43, 66, 21);
		contentPane.add(age);
		age.setColumns(10);
		
		name = new JTextField();
		
		name.setFont(new Font("楷体", Font.PLAIN, 16));
		name.setColumns(10);
		name.setBounds(109, 71, 66, 21);
		contentPane.add(name);
		
		id = new JTextField();
		
		id.setFont(new Font("楷体", Font.PLAIN, 16));
		id.setColumns(10);
		id.setBounds(298, 43, 66, 21);
		contentPane.add(id);
		
		type = new JComboBox(array);
		type.setFont(new Font("楷体", Font.PLAIN, 16));
		//type.setColumns(10);
		type.setBounds(298, 71, 109, 21);
		contentPane.add(type);
		
		comfirm = new JButton("确定");
		comfirm.setFont(new Font("方正姚体", Font.PLAIN, 15));
		comfirm.setBounds(136, 146, 66, 23);
		contentPane.add(comfirm);
		
		cancel = new JButton("取消");
		
		cancel.setFont(new Font("方正姚体", Font.PLAIN, 15));
		cancel.setBounds(222, 146, 66, 23);
		contentPane.add(cancel);
		
		
	}
	private void addListeners() {
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		age.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if((!Numeric.isNumeric(age.getText()))){
					state.setText("！年龄必须是数值");
				}else{
					state.setText("");
				}
			}
		});
		id.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if((!Numeric.isNumeric(id.getText()))||id.getText().length()!=9){
					state.setText("！员工号必须是9位数值");
				}else{
					state.setText("");
				}
			}
		});
		name.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(name.getText().isEmpty()){
					state.setText("！姓名不能为空");
				}else{
					state.setText("");
				}
			}
		});
		
	}
	
	public boolean isDataUsable(){
		if((!Numeric.isNumeric(age.getText()))){
			state.setText("！年龄必须是数值");
		}else if((!Numeric.isNumeric(id.getText()))||id.getText().length()!=9){
			state.setText("！员工号必须是9位数值");
		}else if(name.getText().isEmpty()){
			state.setText("！姓名不能为空");
		}
			
		return true;
	}
	
	public String getAge() {
		return age.getText();
	}
	public String getNameOfStuff() {
		return name.getText();
	}
	public String getId() {
		return id.getText();
	}
	public String getTypeOfStuff() {
		return type.getSelectedItem().toString();
	}
	public JButton getComfirm() {
		return comfirm;
	}
}
