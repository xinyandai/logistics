package org.module.client.presentation.mainui;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.module.client.businesslogic.userbl.Login;
import org.module.client.businesslogic.userbl.LoginController;
import org.module.client.businesslogicservice.userBLservice.UserLoginBLService;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private UserLoginBLService longiner = new LoginController(new Login());
	
	private Image imgBackground = new ImageIcon("pic/login.png").getImage();
	private Image imgClose = new ImageIcon("pic/close.png").getImage();
	private CloseButton closeBtn;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnNewButton;
	private JComboBox<String> comboBox;
    private final String[] array= {"用户","快递员","营业厅业务员","仓库管理员","中转中心业务员","财务人员","总经理","管理员"};
	private JFrame frame = this;

	private int closeBtnWidth = 40;
	private int closeBtnHeight = 40;
	
	/**
	 * Create the frame.
	 */
	public MainFrame() {
		this.setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - imgBackground.getWidth(null)) /2;
		int y = (d.height - imgBackground.getHeight(null))/2;
		setBounds(x, y, imgBackground.getWidth(null), imgBackground.getHeight(null));
		contentPane = new Panel();
		//contentPane.setOpaque(false);
		//contentPane.setBackground(new Color(176, 224, 230));
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//contentPane.setLayout(null);
		
		btnNewButton = new JButton("LOGIN\r\n");
	
		btnNewButton.setBounds(262, 179, 68, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(140, 156, 119, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(140, 180, 119, 21);
		contentPane.add(passwordField);
		
		comboBox = new JComboBox<String>(array);
		comboBox.setBounds(140, 125, 100, 21);
		contentPane.add(comboBox);
		
		closeBtn = new CloseButton();
		closeBtn.setBounds(imgBackground.getWidth(null)-closeBtnWidth,0,closeBtnWidth,closeBtnHeight);
		contentPane.add(closeBtn);
		closeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login();
			}
		});
		btnNewButton.addKeyListener(new KeyListener(){

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					login();
				}
				
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	 
	
	private void login(){
		char[] ch = passwordField.getPassword();
		String s = "";
		for (char c : ch) {
			s+=c;
		}
		if(longiner.login(textField.getText(),s,array[comboBox.getSelectedIndex()])){
			System.out.println("success to login");
			frame.dispose();
	//		new AdministratorUI(user.allUsers()).setVisible(true);;

		}else{
			JOptionPane.showConfirmDialog(frame, "账号信息错误", "登录失败", JOptionPane.OK_CANCEL_OPTION);
		}
	}
	
	class Panel extends JPanel{

		Panel(){
			setOpaque(false);
			//contentPane.setBackground(new Color(176, 224, 230));
			setBorder(new EmptyBorder(5, 5, 5, 5));
			//setContentPane(contentPane);
			setLayout(null);
		}
		private static final long serialVersionUID = 1L;
		@Override 
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			
			//if(new File("pic/login.png").exists()) System.out.println("fff");
			g.drawImage(imgBackground, 0, 0, imgBackground.getWidth(null), imgBackground.getHeight(null),
					         0, 0, imgBackground.getWidth(null), imgBackground.getHeight(null),null);
			
		}
		
	}
    
	class CloseButton extends JButton{

		private static final long serialVersionUID = 1L;
		CloseButton(){
			setOpaque(false);
			setBorder(null);
			setLayout(null);
		}
		@Override 
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			
			//if(new File("pic/close.png").exists()) System.out.println("fff");
			g.drawImage(imgClose, 0, 0, imgClose.getWidth(null), imgClose.getHeight(null),
					         0, 0, closeBtnWidth,closeBtnHeight,null);
			
		}
	}

}
