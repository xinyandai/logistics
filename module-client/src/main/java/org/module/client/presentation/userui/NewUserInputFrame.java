package org.module.client.presentation.userui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.module.client.vo.UserVO;

public class NewUserInputFrame extends JFrame {

	
	private static final long serialVersionUID = 6508147843247956382L;
	private JPanel contentPane;
	private JTextField id;
	private JTextField password;
	private JTextField deparment;
	private JTextField nameOfUser;
	private JTextField type;
	private JTextField right;
	private JLabel cancel;
	private JLabel comfirm;
	
	public NewUserInputFrame() {
		init();
		addListeners();
	}
	public NewUserInputFrame(UserVO vo) {
		init();
		this.id.setText(vo.getId());
		this.password.setText(vo.getPassword());
		this.deparment.setText(vo.getDepartmeny());
		this.nameOfUser.setText(vo.getName());
		this.type.setText(vo.getRole());
		this.right.setText(vo.getAuthority());
		addListeners();
	}
	private void addListeners() {
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
	}
	private void init(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblState = new JLabel("state");
		lblState.setBounds(192, 10, 54, 15);
		contentPane.add(lblState);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 15));
		lblNewLabel.setBounds(45, 47, 79, 18);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("密码");
		label.setFont(new Font("楷体", Font.PLAIN, 15));
		label.setBounds(45, 75, 79, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("所属部门");
		label_1.setFont(new Font("楷体", Font.PLAIN, 15));
		label_1.setBounds(45, 103, 79, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("名字");
		label_2.setFont(new Font("楷体", Font.PLAIN, 15));
		label_2.setBounds(226, 49, 79, 18);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("工作类别");
		label_3.setFont(new Font("楷体", Font.PLAIN, 15));
		label_3.setBounds(226, 77, 79, 18);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("权限");
		label_4.setFont(new Font("楷体", Font.PLAIN, 15));
		label_4.setBounds(226, 105, 79, 18);
		contentPane.add(label_4);
		
		id = new JTextField();
		id.setFont(new Font("楷体", Font.PLAIN, 15));
		id.setBounds(133, 45, 66, 21);
		contentPane.add(id);
		id.setColumns(10);
		
		password = new JTextField();
		password.setFont(new Font("楷体", Font.PLAIN, 15));
		password.setColumns(10);
		password.setBounds(134, 73, 66, 21);
		contentPane.add(password);
		
		deparment = new JTextField();
		deparment.setFont(new Font("楷体", Font.PLAIN, 15));
		deparment.setColumns(10);
		deparment.setBounds(133, 101, 66, 21);
		contentPane.add(deparment);
		
		nameOfUser = new JTextField();
		nameOfUser.setFont(new Font("楷体", Font.PLAIN, 15));
		nameOfUser.setColumns(10);
		nameOfUser.setBounds(308, 45, 66, 21);
		contentPane.add(nameOfUser);
		
		type = new JTextField();
		type.setFont(new Font("楷体", Font.PLAIN, 15));
		type.setColumns(10);
		type.setBounds(308, 73, 66, 21);
		contentPane.add(type);
		
		right = new JTextField();
		right.setFont(new Font("楷体", Font.PLAIN, 15));
		right.setColumns(10);
		right.setBounds(308, 101, 66, 21);
		contentPane.add(right);
		
		comfirm = new JLabel("确定");
		comfirm.setFont(new Font("方正姚体", Font.PLAIN, 15));
		comfirm.setBounds(145, 182, 54, 15);
		contentPane.add(comfirm);
		
		cancel = new JLabel("取消");
		cancel.setFont(new Font("方正姚体", Font.PLAIN, 15));
		cancel.setBounds(226, 182, 54, 15);
		contentPane.add(cancel);
	}
	public String getPassword() {
		return password.getText();
	}
	public String getNameOfUser() {
		return nameOfUser.getText();
	}
	public String getDeparment() {
		return deparment.getText();
	}
	public String getRight() {
		return right.getText();
	}
	public String getTypeOfUser() {
		return type.getText();
	}
	public String getId() {
		return id.getText();
	}
	public JLabel getComfirm() {
		return comfirm;
	}
}
