package presentation.mainui;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import presentation.userui.AdministratorUI;
import vo.UserVO;
import businesslogic.userbl.UserBLImpl;
import businesslogicservice.userBLservice.UserBLservice;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	UserBLservice user = new UserBLImpl();
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnNewButton;
	private JComboBox comboBox;
    private String[] array= {"用户","快递员","营业厅业务员","仓库管理员","中转中心业务员","财务人员","总经理","管理员"};
	private JFrame frame = this;

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("LOGIN\r\n");
	
		btnNewButton.setBounds(293, 177, 111, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(293, 114, 111, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(293, 145, 111, 21);
		contentPane.add(passwordField);
		
		comboBox = new JComboBox(array);
		comboBox.setBounds(293, 70, 76, 21);
		contentPane.add(comboBox);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				char[] ch = passwordField.getPassword();
				String s = "";
				for (char c : ch) {
					s+=c;
				}
				System.out.println( );
				if(user.login(new UserVO(textField.getText(),s,array[comboBox.getSelectedIndex()]))){
					System.out.println("success to login");
					frame.dispose();
					new AdministratorUI(user.allUsers()).setVisible(true);;

				}else{
					JOptionPane.showConfirmDialog(frame, "账号信息错误", "登录失败", JOptionPane.OK_CANCEL_OPTION);
				}
			}
		});
	}
	
}
