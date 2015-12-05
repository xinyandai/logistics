package org.module.client.presentation.userui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.module.client.vo.UserVO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class NewUserInputFrame extends JFrame {

	
	private static final long serialVersionUID = 6508147843247956382L;
	private JPanel contentPane;
	private JTextField id;
	private JTextField password;
	private JTextField deparment;
	private JTextField nameOfUser;
	private JComboBox type;
	private String[] typeArray = {"用户","快递员","营业厅业务员","仓库管理员","中转中心业务员","财务人员","总经理","管理员"};
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
		this.type.setSelectedItem(vo.getRole());
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
	//
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblState = new JLabel("state");
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JLabel label = new JLabel("密码");
		label.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JLabel label_1 = new JLabel("所属部门");
		label_1.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JLabel label_2 = new JLabel("名字");
		label_2.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JLabel label_3 = new JLabel("工作类别");
		label_3.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JLabel label_4 = new JLabel("权限");
		label_4.setFont(new Font("楷体", Font.PLAIN, 15));
		
		id = new JTextField();
		id.setFont(new Font("楷体", Font.PLAIN, 15));
		id.setColumns(10);
		
		password = new JTextField();
		password.setFont(new Font("楷体", Font.PLAIN, 15));
		password.setColumns(10);
		
		deparment = new JTextField();
		deparment.setFont(new Font("楷体", Font.PLAIN, 15));
		deparment.setColumns(10);
		
		nameOfUser = new JTextField();
		nameOfUser.setFont(new Font("楷体", Font.PLAIN, 15));
		nameOfUser.setColumns(10);
		
		type = new JComboBox(typeArray);
		type.setFont(new Font("楷体", Font.PLAIN, 15));
		
		right = new JTextField();
		right.setFont(new Font("楷体", Font.PLAIN, 15));
		right.setColumns(10);
		
		comfirm = new JLabel("确定");
		comfirm.setFont(new Font("方正姚体", Font.PLAIN, 15));
		
		cancel = new JLabel("取消");
		cancel.setFont(new Font("方正姚体", Font.PLAIN, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(187)
					.addComponent(lblState, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(140)
					.addComponent(comfirm, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(cancel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(deparment, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
							.addGap(27)
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addComponent(right, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(id, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
							.addGap(27)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addComponent(nameOfUser, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(password, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
							.addGap(26)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addComponent(type, 0, 91, Short.MAX_VALUE)))
					.addGap(30))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(lblState)
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(lblNewLabel))
						.addComponent(id, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(label_2))
						.addComponent(nameOfUser, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(label))
						.addComponent(password, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(label_3))
						.addComponent(type, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(2)
									.addComponent(label_1))
								.addComponent(deparment, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(4)
									.addComponent(label_4)))
							.addGap(59)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(comfirm, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
								.addComponent(cancel, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)))
						.addComponent(right, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);
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
		return type.getSelectedItem().toString();
	}
	public String getId() {
		return id.getText();
	}
	public JLabel getComfirm() {
		return comfirm;
	}
}
