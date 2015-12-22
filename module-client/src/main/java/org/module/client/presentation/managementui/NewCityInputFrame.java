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
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("城市名");
		label.setFont(new Font("楷体", Font.PLAIN, 16));
		label.setBounds(100, 41, 71, 19);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("城市代码");
		label_1.setFont(new Font("楷体", Font.PLAIN, 16));
		label_1.setBounds(100, 85, 71, 19);
		contentPane.add(label_1);
		
		city = new JTextField();
		
		city.setFont(new Font("楷体", Font.PLAIN, 16));
		city.setBounds(198, 41, 154, 21);
		contentPane.add(city);
		city.setColumns(10);
		
		id = new JTextField();
		
		id.setFont(new Font("楷体", Font.PLAIN, 16));
		id.setColumns(10);
		id.setBounds(198, 85, 154, 21);
		contentPane.add(id);
		
		confirm = new JButton("确定");
		confirm.setBounds(142, 145, 71, 23);
		contentPane.add(confirm);
		
		JButton cancel = new JButton("取消");
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		cancel.setBounds(253, 145, 71, 23);
		contentPane.add(cancel);
		
		state = new JLabel("");
		state.setBounds(81, 10, 300, 15);
		contentPane.add(state);
		
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
