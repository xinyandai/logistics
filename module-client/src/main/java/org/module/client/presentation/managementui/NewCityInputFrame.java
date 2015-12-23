package org.module.client.presentation.managementui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

import org.module.client.presentation.Numeric;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class NewCityInputFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8533775303565485538L;
	private JPanel contentPane;
	private JTextField id;
	private JTextField city;
	private JButton confirm;
	private JLabel state;
	
	public NewCityInputFrame() {
		init();
	}
	public NewCityInputFrame(String city,String id) {
		init();
		this.city.setText(city);
		this.id.setText(id);
	}
	private void init(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("城市名");
		label.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_1 = new JLabel("城市代码");
		label_1.setFont(new Font("楷体", Font.PLAIN, 16));
		
		city = new JTextField();
		
		city.setFont(new Font("楷体", Font.PLAIN, 16));
		city.setColumns(10);
		
		id = new JTextField();
		
		id.setFont(new Font("楷体", Font.PLAIN, 16));
		id.setColumns(10);
		
		confirm = new JButton("确定");
		
		JButton cancel = new JButton("取消");
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
		state = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(76)
					.addComponent(state, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(95)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(city, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
					.addGap(77))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(95)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(id, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
					.addGap(77))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(137)
					.addComponent(confirm, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
					.addGap(40)
					.addComponent(cancel, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
					.addGap(105))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(state, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(city, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1)
						.addComponent(id, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(confirm)
						.addComponent(cancel)))
		);
		contentPane.setLayout(gl_contentPane);
		
		city.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(city.getText().isEmpty()){
					state.setText("！城市名不能为空");
				}else{
					state.setText("");
				}
			}
		});
		id.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if((!Numeric.isNumeric(id.getText()))){
					state.setText("！城市代号必须是数值");
				}else{
					state.setText("");
				}
			}
		});
	}

	public boolean isDataUsable(){
		if(city.getText().isEmpty()){
			state.setText("！城市名不能为空");
		}else if((!Numeric.isNumeric(id.getText()))){
			state.setText("！城市代号必须是数值");
		}else{
			return true;
		}
		return false;
	}
	
	public String getId() {
		return id.getText();
	}
	public String getCity() {
		return city.getText();
	}
	public JButton getConfirm() {
		return confirm;
	}
}
