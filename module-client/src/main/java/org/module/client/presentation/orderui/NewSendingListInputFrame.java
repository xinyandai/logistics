package org.module.client.presentation.orderui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;
import org.module.client.presentation.DateTransferHelper;
import org.module.client.presentation.Numeric;
import org.module.client.vo.SendingListVO;
import org.module.common.po.State;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

public class NewSendingListInputFrame extends JFrame {

	
	private static final long serialVersionUID = 1761973661952706783L;
	private JPanel contentPane;
	private JTextField ID;
	private JTextField sender;
	private JXDatePicker datePicker;
	private JButton comfirm;
	private JButton cancel;
	private JLabel state;

	

	
	public NewSendingListInputFrame() {
		init();
	}
	public NewSendingListInputFrame(SendingListVO sendingVO) {
		init();
		this.ID.setText(sendingVO.getShippingId());
		this.datePicker.setDate(DateTransferHelper.getDate(sendingVO.getDate()));
		this.sender.setText(sendingVO.getSendMember());
	}
	private void init(){
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("派件单号");
		label.setFont(new Font("楷体", Font.PLAIN, 18));
		label.setBounds(67, 28, 77, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("派件员");
		label_1.setFont(new Font("楷体", Font.PLAIN, 18));
		label_1.setBounds(67, 68, 77, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("派件日期");
		label_2.setFont(new Font("楷体", Font.PLAIN, 18));
		label_2.setBounds(67, 107, 77, 15);
		contentPane.add(label_2);
		
		ID = new JTextField();
		
		ID.setFont(new Font("楷体", Font.PLAIN, 18));
		ID.setColumns(10);
		ID.setBounds(176, 27, 121, 21);
		contentPane.add(ID);
		
		sender = new JTextField();
		
		sender.setFont(new Font("楷体", Font.PLAIN, 18));
		sender.setColumns(10);
		sender.setBounds(176, 67, 121, 21);
		contentPane.add(sender);
		
		datePicker = new JXDatePicker();
		datePicker.setBounds(176, 105, 121, 23);
		contentPane.add(datePicker);
		
		comfirm = new JButton("确定");
		comfirm.setBounds(114, 178, 65, 23);
		contentPane.add(comfirm);
		
		cancel = new JButton("取消");
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		cancel.setBounds(229, 178, 65, 23);
		contentPane.add(cancel);
		
		state = new JLabel("");
		state.setBounds(93, 0, 251, 21);
		contentPane.add(state);
		
		
		ID.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if((!Numeric.isNumeric(ID.getText()))||ID.getText().length()!=10){
					state.setText("！快递单号必须是10位数值");
				}else{
					state.setText("");
				}
			}
		});
		
		sender.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if((!Numeric.isNumeric(sender.getText()))||sender.getText().length()!=9){
					state.setText("！派件员必须是9位数值");
				}else{
					state.setText("");
				}
			}
		});
	}
	
	public JButton getComfirm() {
		return comfirm;
	}
	
	public boolean isDataUsable(){
		if((!Numeric.isNumeric(ID.getText()))||ID.getText().length()!=10){
			state.setText("！快递单号必须是10位数值");
			return false;
		}else if((!Numeric.isNumeric(sender.getText()))||sender.getText().length()!=9){
			state.setText("！派件员必须是9位数值");
			return false;
		}
		
		return true;
		
	}
	
	public SendingListVO getVO(){
		return new SendingListVO(
				DateTransferHelper.getString(this.datePicker.getDate()),
				this.ID.getText(),
				this.sender.getText(),
				State.SUBMITTED
				);
	}
}
