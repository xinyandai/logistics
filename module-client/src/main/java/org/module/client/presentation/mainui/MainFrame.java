package org.module.client.presentation.mainui;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.api.SubstanceSkin;
import org.jvnet.substance.skin.BusinessBlackSteelSkin;
import org.module.client.businesslogic.userbl.Login;
import org.module.client.businesslogic.userbl.LoginController;
import org.module.client.businesslogicservice.userBLservice.UserLoginBLService;
import org.module.client.presentation.userui.AccoutantFrame;
import org.module.client.presentation.userui.AdminFrame;
import org.module.client.presentation.userui.CourierFrame;
import org.module.client.presentation.userui.CustomerFrame;
import org.module.client.presentation.userui.ManagerFrame;
import org.module.client.presentation.userui.OfficeClerkFrame;
import org.module.client.presentation.userui.TranCenterClerkFrame;
import org.module.client.presentation.userui.WarehouseFrame;

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
	

	private Map<String,Class<? extends JFrame>> map = new HashMap<String,Class<? extends JFrame>>();
	
	private void init() {
		map.put(array[0], CustomerFrame.class);
		map.put(array[1], CourierFrame.class);
		map.put(array[2], OfficeClerkFrame.class);
		map.put(array[3], WarehouseFrame.class);
		map.put(array[4], TranCenterClerkFrame.class);
		map.put(array[5], AccoutantFrame.class);
		map.put(array[6], ManagerFrame.class);
		map.put(array[7], AdminFrame.class);
		
	}


	private void login(){
		char[] ch = passwordField.getPassword();
		String password = "";
		for (char c : ch) {
			password+=c;
		}
		String type = array[comboBox.getSelectedIndex()];
		if(longiner.login(textField.getText(),password,type)){
			System.out.println("success to login");
			frame.dispose();
			Class<? extends JFrame> cls = this.map.get(type);
			try {
				JFrame o = cls.newInstance();
				o.setVisible(true);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}

		}else{
			JOptionPane.showConfirmDialog(frame, "账号信息错误", "登录失败", JOptionPane.OK_CANCEL_OPTION);
		}
	}
	
	
	
	
	
	public MainFrame() {
		
		this.init();
		
		this.setSkin();
		this.setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - imgBackground.getWidth(null)) /2;
		int y = (d.height - imgBackground.getHeight(null))/2;
		setBounds(x, y, imgBackground.getWidth(null), imgBackground.getHeight(null));
		contentPane = new Panel();
		setContentPane(contentPane);
		
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
			}

			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					login();
				}
				
			}

			public void keyReleased(KeyEvent e) {
			}
			
		});
	}
	 
	
	
	
	
	
	private void setSkin(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//JFrame.setDefaultLookAndFeelDecorated(true);
					JDialog.setDefaultLookAndFeelDecorated(true);
					SubstanceSkin skin  =   new  BusinessBlackSteelSkin();  
					SubstanceLookAndFeel.setSkin(skin); 
				}//设置皮肤                      
				catch  (Exception ex) {      
						Logger.getLogger(AdminFrame. class .getName()).log(Level.SEVERE,  null , ex);       
				} 
			}		
		});
	}
	
	
	class Panel extends JPanel{

		Panel(){
			setOpaque(false);
			setBorder(new EmptyBorder(5, 5, 5, 5));
			setLayout(null);
		}
		private static final long serialVersionUID = 1L;
		@Override 
		public void paintComponent(Graphics g){
			super.paintComponent(g);
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
			
			g.drawImage(imgClose, 0, 0, imgClose.getWidth(null), imgClose.getHeight(null),
					         0, 0, closeBtnWidth,closeBtnHeight,null);
			
		}
	}

}
