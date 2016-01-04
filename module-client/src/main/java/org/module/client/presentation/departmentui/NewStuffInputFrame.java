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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;

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
	private final String[] array= {"快递员","营业厅业务员","仓库管理员",
			"中转中心业务员","财务人员","总经理","管理员",
			"司机","监装员","其他"};
	
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		state = new JLabel("");
		state.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label = new JLabel("年龄");
		label.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_1 = new JLabel("姓名");
		label_1.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_2 = new JLabel("员工号");
		label_2.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_3 = new JLabel("工作类别");
		label_3.setFont(new Font("楷体", Font.PLAIN, 16));
		
		age = new JTextField();
		
		age.setFont(new Font("楷体", Font.PLAIN, 16));
		age.setColumns(10);
		
		name = new JTextField();
		
		name.setFont(new Font("楷体", Font.PLAIN, 16));
		name.setColumns(10);
		
		id = new JTextField();
		
		id.setFont(new Font("楷体", Font.PLAIN, 16));
		id.setColumns(10);
		
		type = new JComboBox(array);
		type.setFont(new Font("楷体", Font.PLAIN, 16));
		
		comfirm = new JButton("确定");
		comfirm.setFont(new Font("方正姚体", Font.PLAIN, 15));
		
		cancel = new JButton("取消");
		
		cancel.setFont(new Font("方正姚体", Font.PLAIN, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(73)
					.addComponent(state, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(55)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(49)
							.addComponent(age, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)))
					.addGap(14)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addComponent(id, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
					.addGap(22))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(55)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(49)
							.addComponent(name, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(type, 0, 109, Short.MAX_VALUE)
					.addGap(22))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(131)
					.addComponent(comfirm, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
					.addGap(20)
					.addComponent(cancel, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
					.addGap(141))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(state, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(age, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
						.addComponent(id, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(name, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
						.addComponent(type, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(54)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(comfirm, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(cancel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);
		
		
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
