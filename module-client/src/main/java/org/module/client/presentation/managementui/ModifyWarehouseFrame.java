package org.module.client.presentation.managementui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import org.jdesktop.swingx.JXDatePicker;
import org.module.client.businesslogic.managementbl.QusCounter;
import org.module.client.main.Main;
import org.module.client.presentation.DateTransferHelper;
import org.module.client.vo.WarehouseVO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class ModifyWarehouseFrame extends JFrame {

	
	private static final long serialVersionUID = 226508239429314937L;
	private JPanel contentPane;
	private JTextField ID;
	private JComboBox qu;
	private JTextField jia;
	private JTextField pai;
	private JTextField wei;
	private JButton comfirm;
	private JLabel state;
	private JXDatePicker datePicker;
	private JButton cancel;

	
	public ModifyWarehouseFrame(WarehouseVO vo) {
		init();
		addListenrs();
		this.ID.setText(vo.getNumber());
		this.qu.setSelectedItem(vo.getQu());
		this.pai.setText(vo.getPai());
		this.jia.setText(vo.getJia());
		this.wei.setText(vo.getWei());
		this.datePicker.setDate(DateTransferHelper.getDate(vo.getDate()));
	}
		
		private void init(){
		setBounds(100, 100, 470, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		state = new JLabel("");
		state.setFont(new Font("方正姚体", Font.PLAIN, 15));
		state.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(state, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("快递单号");
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JLabel label = new JLabel("区");
		label.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JLabel label_1 = new JLabel("架");
		label_1.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JLabel label_2 = new JLabel("日期");
		label_2.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JLabel label_3 = new JLabel("排");
		label_3.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JLabel label_4 = new JLabel("位");
		label_4.setFont(new Font("楷体", Font.PLAIN, 15));
		
		ID = new JTextField();
		ID.setEditable(false);
		ID.setFont(new Font("楷体", Font.PLAIN, 15));
		ID.setColumns(10);
		
		qu = new JComboBox( new QusCounter().getQus() );
		qu.setFont(new Font("楷体", Font.PLAIN, 15));
		
		jia = new JTextField();
		jia.setFont(new Font("楷体", Font.PLAIN, 15));
		jia.setColumns(10);
		
		pai = new JTextField();
		pai.setFont(new Font("楷体", Font.PLAIN, 15));
		pai.setColumns(10);
		
		wei = new JTextField();
		wei.setFont(new Font("楷体", Font.PLAIN, 15));
		wei.setColumns(10);
		
		comfirm = new JButton("确定");
		
		cancel = new JButton("取消");
		
		datePicker = new JXDatePicker();
		datePicker.setFont(new Font("楷体", Font.PLAIN, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(ID, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(datePicker, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
					.addGap(30))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(qu, 0, 112, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(pai, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
					.addGap(30))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(jia, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(wei, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
					.addGap(30))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(121)
					.addComponent(comfirm, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
					.addGap(19)
					.addComponent(cancel, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
					.addGap(118))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(ID, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(4)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(4)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(qu, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(4)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(pai, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(4)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(jia, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(4)
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(wei, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(comfirm)
						.addComponent(cancel)))
		);
		panel.setLayout(gl_panel);
	}
		
	private void addListenrs(){
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		pai.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(pai.getText().trim().equals("")){
					state.setText("!排号不能为空");
				}else{
					state.setText("");
				}
			}
		});
		jia.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(jia.getText().trim().equals("")){
					state.setText("!架号不能为空");
				}else{
					state.setText("");
				}
			}
		});
		wei.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(wei.getText().trim().equals("")){
					state.setText("!位号不能为空");
				} else{
					state.setText("");
				}
			}
		});
	}
	public JButton getComfirm() {
		return comfirm;
	}
	public boolean isDataUsable(){
		if(pai.getText().trim().equals("")){
			state.setText("!排号不能为空");
		}else if(jia.getText().trim().equals("")){
			state.setText("!架号不能为空");
		}else if(wei.getText().trim().equals("")){
			state.setText("!位号不能为空");
		} else{
			return true;
		}
		return false;
	}
	public WarehouseVO getVO(){
		return new WarehouseVO(
				this.ID.getText(),
				this.qu.getSelectedItem().toString(),
				this.pai.getText(),
				this.jia.getText(),
				this.wei.getText(),
				Main.currentUser.getDepartmeny(),
				DateTransferHelper.getString(this.datePicker.getDate())
				);
	}
}
