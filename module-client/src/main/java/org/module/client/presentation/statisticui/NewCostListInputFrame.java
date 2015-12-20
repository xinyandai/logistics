package org.module.client.presentation.statisticui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import org.jdesktop.swingx.JXDatePicker;
import org.module.client.presentation.DateTransferHelper;
import org.module.client.presentation.Numeric;
import org.module.client.vo.CostListVO;
import org.module.common.po.State;

public class NewCostListInputFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5891171573116418980L;
	private JPanel contentPane;
	private JTextField payer;
	private JTextField money;
	private JTextField account;
	private JTextField note;
	private JXDatePicker datePicker;
	private JComboBox entry;
	private JButton comfirm;
	private JLabel state;

	private String id;
	
	public NewCostListInputFrame() {
		this.id = new Date().getTime()+"";
		init();
	}
	
	public NewCostListInputFrame( CostListVO vo) {
		this.id = vo.getID();
		init();
		this.payer.setText(vo.getPeople());
		this.money.setText(vo.getMoney()+"");
		this.account.setText(vo.getAccout());
		this.datePicker.setDate(DateTransferHelper.getDate(vo.getDate()));
		this.note.setText(vo.getNote());
		this.entry.setSelectedItem(vo.getEntry());
		
	}
		
	private void init(){
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		state = new JLabel("");
		state.setForeground(Color.RED);
		
		JLabel lblNewLabel = new JLabel("付款日期");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JLabel label = new JLabel("付款金额");
		label.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JLabel label_1 = new JLabel("付款账号");
		label_1.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JLabel label_2 = new JLabel("备注");
		label_2.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JLabel label_3 = new JLabel("付款人");
		label_3.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JLabel label_4 = new JLabel("条目");
		label_4.setFont(new Font("楷体", Font.PLAIN, 15));
		
		datePicker = new JXDatePicker();
		datePicker.setDate(new Date());
		
		String[] s = {"薪水","租金","利息","宣传","保险"};
		entry = new JComboBox(s);
		entry.setEditable(true);
		entry.setFont(new Font("宋体", Font.PLAIN, 15));
		
		payer = new JTextField();
		payer.setColumns(10);
		
		money = new JTextField();
		money.setColumns(10);
		
		account = new JTextField();
		account.setColumns(10);
		
		note = new JTextField();
		note.setColumns(10);
		
		comfirm = new JButton("确定");
		comfirm.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JButton cancel = new JButton("取消");
		cancel.setFont(new Font("楷体", Font.PLAIN, 15));
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(32)
					.addComponent(label)
					.addGap(10)
					.addComponent(money, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(56)
							.addComponent(entry, 0, 87, Short.MAX_VALUE)))
					.addGap(51))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(32)
					.addComponent(label_1)
					.addGap(10)
					.addComponent(account, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
					.addGap(51))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(32)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(note, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
					.addGap(51))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(118)
					.addComponent(comfirm, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
					.addGap(30)
					.addComponent(cancel, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
					.addGap(134))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(32)
					.addComponent(lblNewLabel)
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(state, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(datePicker, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
							.addGap(41)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(56)
									.addComponent(payer, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)))
							.addGap(51))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(state, GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(3)
									.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
								.addComponent(payer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(money, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(entry, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(account, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(note, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(comfirm, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(cancel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);
		
		
		payer.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(payer.getText().isEmpty()){
					state.setText("！付款人不能为空");
				}else{
					state.setText("");
				}
			}
		});
		
		money.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if((!Numeric.isRealNumber(money.getText()))){
					state.setText("！金额必须是数值");
				}else{
					state.setText("");
				}
			}
		});
		account.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if((!Numeric.isRealNumber(account.getText()))){
					state.setText("！账号必须是数值");
				}else{
					state.setText("");
				}
			}
		});
	}
	
	public boolean isDataUsable(){
		if(payer.getText().isEmpty()){
			state.setText("！付款人不能为空");
			return false;
		}else if((!Numeric.isRealNumber(money.getText()))){
			state.setText("！金额必须是数值");
			return false;
		}else if((!Numeric.isRealNumber(account.getText()))){
			state.setText("！账号必须是数值");
			return false;
		}
			
		return true;
	}
	
	public JButton getComfirm() {
		return comfirm;
	}
	
	public CostListVO getVO(){
		return new CostListVO(
				DateTransferHelper.getString( this.datePicker.getDate() ),
		this.money.getText(),
		this.payer.getText(),
		this.account.getText(),
		this.entry.getSelectedItem().toString(),
		this.note.getText(),
		State.SUBMITTED,
		id
		
		);
	}
}
