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
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

import org.module.client.presentation.Numeric;

public class NewCarsInputFrame extends JFrame {

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
	private JLabel state;

	
	public NewCarsInputFrame() {
		this.init();
	}
	public NewCarsInputFrame(String id,String license,String time) {
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
		
		state = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
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
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(115)
					.addComponent(confirm, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
					.addGap(37)
					.addComponent(cancel, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
					.addGap(86))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(state, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(105)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addComponent(id, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)))
					.addGap(73))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(state)
					.addGap(10)
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
		id.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if((!Numeric.isNumeric(id.getText()))||id.getText().length()!=9){
					state.setText("！汽车代号必须是9位数值");
				}else{
					state.setText("");
				}
			}
		});
		license.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(license.getText().isEmpty()){
					state.setText("！车牌号不能为空");
				}else{
					state.setText("");
				}
			}
		});
		time.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(time.getText().isEmpty()){
					state.setText("！服役时间不能为空");
				}else{
					state.setText("");
				}
			}
		});
		
	}

	public boolean isDataUsable(){
		if((!Numeric.isNumeric(id.getText()))||id.getText().length()!=9){
			state.setText("！汽车代号必须是9位数值");
			return false;
		}else if(license.getText().isEmpty()){
			state.setText("！车牌号不能为空");
			return false;
		}else if(time.getText().isEmpty()){
			state.setText("！服役时间不能为空");
		}
			
		return true;
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
