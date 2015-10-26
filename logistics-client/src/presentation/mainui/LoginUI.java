

package presentation.mainui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import presentation.mainui.JWTeacherUI;
import presentation.mainui.PrincipalUI;
import presentation.mainui.RKTeacherUI;
import presentation.mainui.StudentUI;
import presentation.mainui.YXTeacherUI;
import vo.user.Identity;
import vo.user.login.LoginVO;
import JavaRMI.Client;
import JavaRMI.RMIFactory;
import businesslogicservice.userblservice.login.LoginBLService;

public class LoginUI extends JFrame {

	private static final long serialVersionUID = 1L;

	JPanel jp;
	JPasswordField jpw;// 密码框
	JComboBox<String> jc, jtjc;// 自动补全
	DefaultComboBoxModel<String> dftcbm;
	JTextField jt;
	JButton jb1,jb2;
	JRadioButton jrb;

	public LoginUI() {
		super("快递系统欢迎你");
		this.setBounds(400, 170, 555, 435);
		this.setLayout(null);
		setResizable(false);// 设置最大化不可用
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);// 关闭窗口停止程序运行

		jp = new JPanel();
		jp.setBounds(0, 0, 500, 400);
		setIcon();
		setComp();
		setPicture();
		add(jp);
		setVisible(true);
	}

	public void setIcon() {

		Toolkit kit = Toolkit.getDefaultToolkit();
		Image i = kit.getImage("image/登录.jpg");
		setIconImage(i);

	}

	public void setPicture() {

		ImageIcon bacgrd = new ImageIcon("image/1.jpg");
		JLabel imLabel = new JLabel(bacgrd);

		this.getLayeredPane().add(imLabel, new Integer(Integer.MIN_VALUE));

		final Container container1 = this.getContentPane();
		container1.setLayout(new BorderLayout());
		((JPanel) container1).setOpaque(false);
		 imLabel.setBounds(20,60,150,200);
//		 container1.add(imLabel);
		 
	}

	public void setComp() {

		this.setLayout(null);

		final Container container1 = this.getContentPane();
		JLabel tag = new JLabel("用户名");
		tag.setBounds(200, 130, 100, 30);
		tag.setFont(new Font("楷体", Font.BOLD, 18));
		jp.add(tag);
		container1.add(tag);

		JLabel tag2 = new JLabel("密码");
		tag2.setBounds(200, 180, 100, 30);
		tag2.setFont(new Font("楷体", Font.BOLD, 18));
		jp.add(tag2);
		container1.add(tag2);

		JLabel tag3 = new JLabel("身份");
		tag3.setBounds(200, 80, 100, 30);
		tag3.setFont(new Font("楷体", Font.BOLD, 18));
		jp.add(tag3);
		container1.add(tag3);

		jt = new JTextField();
		jt.setBounds(280, 130, 155, 30);
		jt.setForeground(Color.black);
		jt.setFont(new Font("楷体", Font.BOLD, 25));
		dftcbm = new DefaultComboBoxModel<String>();
		jtjc = new JComboBox<String>(dftcbm) {
			private static final long serialVersionUID = 1L;

			public Dimension getPreferredSize() {
				return new Dimension(super.getPreferredSize().width, 0);
			}
		};

		jt.getDocument().addDocumentListener(new DocumentListener() {

			public void insertUpdate(DocumentEvent e) {// 插入
				autofinish();
			}

			public void removeUpdate(DocumentEvent e) {// 移除
				autofinish();
			}

			public void changedUpdate(DocumentEvent e) {
				autofinish();
			}

		});

		jt.addKeyListener(new KeyAdapter(){

			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN){
					e.setSource(jtjc);
					jtjc.dispatchEvent(e);
					if(e.getKeyCode() == KeyEvent.VK_ENTER){
						jt.setText(jtjc.getSelectedItem().toString());
						jtjc.setPopupVisible(false);
						String userName = jt.getText();// 用户名
						String id = (String) jc.getSelectedItem();
						String password = readFile(userName, id, "file/account.txt");
						if (!password.equals("")) {
							jpw.setText(password);
							jrb.setSelected(true);
							jpw.requestFocus();
						}
					}
				}
				else if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
					jtjc.setPopupVisible(false);
				}
			}
		});
		
		jt.add(jtjc, BorderLayout.SOUTH);
		jtjc.setBounds(0, 30, 155, 0);

		jt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				enterButton();
			}

		});
		
		jtjc.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
			}
			
		});
		jp.add(jt);

		container1.add(jt);

		jpw = new JPasswordField();// 密码框
		jpw.setBounds(280, 180, 155, 30);
		jpw.setEchoChar('*');
		jpw.setFont(new Font("楷体", Font.BOLD, 25));
		jpw.addFocusListener(new FocusAdapter() {

			public void focusGained(FocusEvent e) {
				String userName = jt.getText();// 用户名
				String id = (String) jc.getSelectedItem();
				String password = readFile(userName, id, "file/account.txt");
				if (!password.equals("")) {
					jpw.setText(password);
					jrb.setSelected(true);
				}
			}

		});
		jpw.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				enterButton();
			}

		});
		jp.add(jpw);
		container1.add(jpw);

		String[] id = { "客户", "营业厅业务员", "快递员", "中转中心业务员","仓管", "管理员","总经理" };
		jc = new JComboBox<String>(id);
		jc.setBounds(280, 80, 155, 30);
		jc.setFont(new Font("楷体", Font.PLAIN, 18));
		jc.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					enterButton();
				}
			}

		});
		jp.add(jc);
		container1.add(jc);

		jb1 = new JButton("登录");
		jb1.setBounds(235, 280, 80, 35);
		jb1.setFont(new Font("楷体", Font.BOLD, 18));
		jb1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				enterButton();
			}

		});
		jp.add(jb1);
		container1.add(jb1);
		
		jb2=new JButton("取消");
		jb2.setBounds(335, 280, 80, 35);
		jb2.setFont(new Font("楷体", Font.BOLD, 18));
		jb2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				jt.setText("");
				jpw.setText("");
				jrb.setSelected(false);
			}
			
		});
		jp.add(jb2);
		container1.add(jb2);

		jrb = new JRadioButton("记住密码");
		jrb.setFont(new Font("楷体", Font.PLAIN, 15));
		jrb.setBounds(285, 230, 100, 30);
		jp.add(jrb);
		container1.add(jrb);

	}

	public void enterButton() {

		String userName = jt.getText();
		String password = new String(jpw.getPassword());

		if (userName.equals("")) {
			JOptionPane.showMessageDialog(null, "请输入用户名", "系统信息",
					JOptionPane.INFORMATION_MESSAGE);
		} else if (password.equals("")) {
			JOptionPane.showMessageDialog(null, "请输入密码", "系统信息",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			RMIFactory factory = Client.getFactory();
						try {
				if(factory!=null){
					LoginBLService lgservice = factory.getLoginService();
					String result = "";
					switch ((String) jc.getSelectedItem()) {
					case "客户":
						result = lgservice.login(new LoginVO(userName, password,
								Identity.Customer));
						break;
					case "营业厅业务员":
						result = lgservice.login(new LoginVO(userName, password,
								Identity.OfficeClerk));
						break;
					case "快递员":
						result = lgservice.login(new LoginVO(userName, password,
								Identity.Courier));
						break;
					case "中转中心业务员":
						result = lgservice.login(new LoginVO(userName, password,
								Identity.TranCenterClerk));
						break;
					case "仓管":
						result = lgservice.login(new LoginVO(userName, password,
								Identity.WarehouseManagement));
						break;
					case "管理员":
						result = lgservice.login(new LoginVO(userName, password,
								Identity.Administrator));
					case "总经理":
						result = lgservice.login(new LoginVO(userName, password,
								Identity.Manager));
						break;
					}
					if (result.equals("-1")) {// 用户名不存在
						JOptionPane.showMessageDialog(null, "用户名不存在", "系统信息",
								JOptionPane.INFORMATION_MESSAGE);
					} else if (result.equals("-2")) {
						JOptionPane.showMessageDialog(null, "密码错误", "系统信息",
								JOptionPane.INFORMATION_MESSAGE);
					} else {// 登录成功
						if (jrb.isSelected()) {
							writeFile(userName, password,(String) jc.getSelectedItem(),"file/account.txt");
							writeFile(userName, password,(String) jc.getSelectedItem(),"file/account2.txt");
						} else {// 把记住的密码删掉
							deleteRecord(userName, (String) jc.getSelectedItem());
						}
						switch ((int) jc.getSelectedIndex()) {
						case 0:
							new JWTeacherUI(result, userName);
							break;
						case 1:
							new YXTeacherUI(result.split(";")[0],
									result.split(";")[1], userName);
							break;
						case 2:
							new RKTeacherUI(result, userName);
							break;
						case 3:
							new StudentUI(result, userName);
							break;
						case 4:
							new AdministratorUI(result, userName);// 传入了账号
							break;
						case 5:
							new PrincipalUI(result, userName);
							break;
						}
						((Window) jb1.getTopLevelAncestor()).dispose();
				}
				}
			} catch (RemoteException e1) {
				JOptionPane.showMessageDialog(null, "无法连接到服务器，请检查网络连接", "系统信息",
						JOptionPane.INFORMATION_MESSAGE);
			}

		}

	}

	public void writeFile(String account, String password, String identity,
			String fileName) {
		File file = new File(fileName);
		try {
			FileWriter fr = new FileWriter(file, true);
			BufferedWriter bufr = new BufferedWriter(fr);
			if (readFile(account, identity, fileName).equals("")) {
				bufr.write(account + "%" + password + "%" + identity);
				bufr.newLine();
				bufr.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String readFile(String account, String identity, String fileName) {
		File file = new File(fileName);
		String password = "";
		try {
			FileReader fr = new FileReader(file);
			BufferedReader bufr = new BufferedReader(fr);
			String record = null;
			while ((record = bufr.readLine()) != null) {
				if (record.split("%")[0].equals(account)
						&& record.split("%")[2].equals(identity)) {
					password = record.split("%")[1];
					break;
				}
			}
			bufr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return password;
	}

	public void deleteRecord(String userName, String identity) {
		File file = new File("file/account.txt");
		try {
			FileReader fr = new FileReader(file);
			BufferedReader bufr = new BufferedReader(fr);

			String record = null;
			ArrayList<String> list = new ArrayList<String>();
			while ((record = bufr.readLine()) != null) {
				if (!record.split("%")[0].equals(userName)
						&& record.split("%")[2].equals(identity)) {
					list.add(record);
				}
			}
			bufr.close();
			FileWriter fw = new FileWriter(file);
			BufferedWriter bufw = new BufferedWriter(fw);
			for (int i = 0; i < list.size(); i++) {
				bufw.write(list.get(i));
				bufw.newLine();
				bufw.flush();
			}
			bufw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean updateList() {
		boolean vis = false;
		dftcbm.removeAllElements();// 先删再加
		String input = jt.getText();
		ArrayList<String> list = new ArrayList<String>();
		File file = new File("file/account2.txt");
		try {
			FileReader fr = new FileReader(file);
			BufferedReader bufr = new BufferedReader(fr);
			String record = null;
			while ((record = bufr.readLine()) != null) {
				if (record.startsWith(input)
						&& record.split("%")[2].equals(jc.getSelectedItem())) {
					list.add(record.split("%")[0]);
				}
			}
			if (list.size() > 0) {
				vis = true;
			}
			bufr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!input.isEmpty()) {
			for (String record : list) {// 加入符合要求的
				dftcbm.addElement(record);
				jtjc.setModel(dftcbm);
			}
		} else {
			vis = false;
		}
		return vis;
	}

	public void autofinish() {
		if (updateList()) {
			jtjc.setPopupVisible(true);
		} else {
			jtjc.setPopupVisible(false);
		}
	}

}