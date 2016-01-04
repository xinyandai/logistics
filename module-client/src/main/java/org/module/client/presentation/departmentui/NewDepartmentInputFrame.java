package org.module.client.presentation.departmentui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import org.module.client.presentation.Numeric;

public class NewDepartmentInputFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3181948650860028594L;
	private JPanel contentPane;
	private JTextField ID;
	private JTextField name;
	private JComboBox category;
	private JTextField lcoation;
    private final String[] array= {"营业厅","中转中心"};
	
	private JButton button;
	private JLabel stateLabel;
	private JButton cancel;
	
	public NewDepartmentInputFrame() {
		this.init();
	}

	public NewDepartmentInputFrame(
			String name,String category,String location,String ID) {
		this.init();
		this.ID.setText(ID);
		this.name.setText(name);
		this.lcoation.setText(location);
		this.category.setSelectedItem(category);
		this.ID.setEditable(false);
		
	}
	
	
	
	public JButton getButton() {
		return button;
	}
	public String getID() {
		return ID.getText();
	}
	
	public String getName() {
		return name.getText();
	}
	public String getCategory() {
		return category.getSelectedItem().toString();
	}
	public String getLcoationOfInput() {
		return lcoation.getText();
	}
	public String getStateLabel() {
		return stateLabel.getText();
	}
	
	private void init(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		this.setAlwaysOnTop(true);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		stateLabel = new JLabel("");
		stateLabel.setFont(new Font("楷体", Font.PLAIN, 15));
		panel.add(stateLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JLabel label = new JLabel("编号");
		label.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JLabel label_1 = new JLabel("类别");
		label_1.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JLabel label_2 = new JLabel("姓名");
		label_2.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JLabel label_3 = new JLabel("地址");
		label_3.setFont(new Font("楷体", Font.PLAIN, 15));
		
		ID = new JTextField();
		
		ID.setFont(new Font("宋体", Font.PLAIN, 15));
		ID.setColumns(10);
		
		name = new JTextField();
		
		name.setFont(new Font("宋体", Font.PLAIN, 15));
		name.setColumns(10);
		
		category = new JComboBox(array);
		category.setFont(new Font("楷体", Font.PLAIN, 17));
		
		lcoation = new JTextField();
		
		lcoation.setFont(new Font("宋体", Font.PLAIN, 15));
		lcoation.setColumns(10);
		
		button = new JButton("确定");
		
		button.setFont(new Font("方正舒体", Font.PLAIN, 16));
		
		cancel = new JButton("取消");
		
		cancel.setFont(new Font("方正舒体", Font.PLAIN, 16));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(0)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(39)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(label)
								.addComponent(label_1)
								.addComponent(label_3))
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lcoation)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
										.addComponent(ID, Alignment.LEADING)
										.addComponent(category, Alignment.LEADING, 0, 124, Short.MAX_VALUE))
									.addGap(26)
									.addComponent(label_2)
									.addGap(18)
									.addComponent(name, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(127)
							.addComponent(button, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(58)
							.addComponent(cancel, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
							.addGap(71)))
					.addGap(38))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(ID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(category, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(lcoation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(cancel))
					.addGap(24))
		);
		panel_1.setLayout(gl_panel_1);
		addListeners();
		
	}
	
	private void addListeners(){
		
		ID.addCaretListener( new CaretListener() {
			public void caretUpdate(CaretEvent e) {
                if(!Numeric.isNumeric(ID.getText()) ){
                	setMessage("ID必须是数值");
				}else{
					setMessage("");
				}
			}
		} );
		
		
		name.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
                if(name.getText().trim().equals("")){
                	setMessage("姓名不能为空");
			    }else{
					setMessage("");
				}
                
			}
		});
		
		lcoation.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
                if(lcoation.getText().trim().equals("")){
                	setMessage("位置不能为空");
				}else{
					setMessage("");
				}
			}
		});
		
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
	}
	
	private void setMessage(String s){
		this.stateLabel.setText(s);
	}
	
	
	
}
