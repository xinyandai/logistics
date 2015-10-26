package presentation.userui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vo.UserVO;
import javax.swing.JTextPane;

public class AdministratorUI extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public AdministratorUI(ArrayList<UserVO> vos) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 10, 424, 207);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 1, 1));
		
		JTextPane textPane = new JTextPane();
		textPane.setText("\u589E\u5220\u6539\u529F\u80FD\u6682\u672A\u5B9E\u73B0");
		textPane.setBounds(53, 223, 200, 28);
		contentPane.add(textPane);
		
		for (UserVO userVO : vos) {
			String s =String.format("%10s", userVO.getId())+
			           " "+ String.format("%10s", userVO.getName())+
			           " "+ String.format("%15s", userVO.getPassword())+
					   " "+ String.format("authority:%2s", userVO.getAuthority());
			panel.add(new JLabel(s)) ;
		}
	}
}
