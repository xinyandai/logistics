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
	}
		
		private void init(){
		setBounds(100, 100, 450, 300);
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
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("快递单号");
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(22, 21, 68, 15);
		panel.add(lblNewLabel_1);
		
		JLabel label = new JLabel("区");
		label.setFont(new Font("楷体", Font.PLAIN, 15));
		label.setBounds(22, 46, 68, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("架");
		label_1.setFont(new Font("楷体", Font.PLAIN, 15));
		label_1.setBounds(22, 71, 68, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("日期");
		label_2.setFont(new Font("楷体", Font.PLAIN, 15));
		label_2.setBounds(222, 21, 68, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("排");
		label_3.setFont(new Font("楷体", Font.PLAIN, 15));
		label_3.setBounds(222, 46, 68, 15);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("位");
		label_4.setFont(new Font("楷体", Font.PLAIN, 15));
		label_4.setBounds(222, 71, 68, 15);
		panel.add(label_4);
		
		ID = new JTextField();
		ID.setEditable(false);
		ID.setFont(new Font("楷体", Font.PLAIN, 15));
		ID.setBounds(100, 17, 112, 21);
		panel.add(ID);
		ID.setColumns(10);
		
		qu = new JComboBox( new QusCounter().getQus() );
		qu.setFont(new Font("楷体", Font.PLAIN, 15));
//		qu.setColumns(10);
		qu.setBounds(100, 42, 112, 21);
		panel.add(qu);
		
		jia = new JTextField();
		jia.setFont(new Font("楷体", Font.PLAIN, 15));
		jia.setColumns(10);
		jia.setBounds(100, 67, 112, 21);
		panel.add(jia);
		
		pai = new JTextField();
		pai.setFont(new Font("楷体", Font.PLAIN, 15));
		pai.setColumns(10);
		pai.setBounds(302, 42, 112, 21);
		panel.add(pai);
		
		wei = new JTextField();
		wei.setFont(new Font("楷体", Font.PLAIN, 15));
		wei.setColumns(10);
		wei.setBounds(302, 67, 112, 21);
		panel.add(wei);
		
		comfirm = new JButton("确定");
		comfirm.setBounds(121, 128, 93, 23);
		panel.add(comfirm);
		
		cancel = new JButton("取消");
		cancel.setBounds(233, 128, 93, 23);
		panel.add(cancel);
		
		datePicker = new JXDatePicker();
		datePicker.setFont(new Font("楷体", Font.PLAIN, 15));
		datePicker.setBounds(300, 17, 114, 21);
		panel.add(datePicker);
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
