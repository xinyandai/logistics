package org.module.client.presentation.managementui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class NewCityFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1900280430164858596L;
	private JPanel contentPane;
	private JTextField id;
	private JTextField license;
	private JTextField time;
	private JButton confirm;
	private JButton cancel;

	
	public NewCityFrame() {
		this.init();
	}
	public NewCityFrame(String id,String license,String time) {
		this.init();
		this.id.setText(id);
		this.license.setText(license);
		this.time.setText(time);
	}
	private void init(){
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("汽车代号");
		label.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_1 = new JLabel("车牌号");
		label_1.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_2 = new JLabel("服役时间");
		label_2.setFont(new Font("楷体", Font.PLAIN, 16));
		
		id = new JTextField();
		id.setFont(new Font("楷体", Font.PLAIN, 17));
		id.setColumns(10);
		
		license = new JTextField();
		license.setFont(new Font("楷体", Font.PLAIN, 17));
		license.setColumns(10);
		
		time = new JTextField();
		time.setFont(new Font("楷体", Font.PLAIN, 17));
		time.setColumns(10);
		
		confirm = new JButton("确定");
		confirm.setFont(new Font("方正姚体", Font.PLAIN, 16));
		
		cancel = new JButton("取消");
		
		cancel.setFont(new Font("方正姚体", Font.PLAIN, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(105)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addComponent(id, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
					.addGap(73))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(105)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addComponent(license, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
					.addGap(73))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(105)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addComponent(time, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
					.addGap(73))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(115)
					.addComponent(confirm, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
					.addGap(37)
					.addComponent(cancel, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
					.addGap(86))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(label))
						.addComponent(id, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1)
						.addComponent(license, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2)
						.addComponent(time, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(confirm, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(cancel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);
		
		
		addListenrs();
	}

	private void addListenrs() {
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
	}

	public String getId() {
		return id.getText();
	}

	public String getLicense() {
		return license.getText();
	}

	public String getTime() {
		return time.getText();
	}

	public JButton getConfirm() {
		return confirm;
	}
	
	
	
}
