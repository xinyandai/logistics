package org.module.client.presentation.orderui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.jdesktop.swingx.JXDatePicker;
import org.module.client.presentation.DateTransferHelper;
import org.module.client.vo.ReceivingListVO;
import org.module.common.po.State;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ReceiveListPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JFrame frame;
	
	private JButton determine;
	private JTextField ID;
	private JTextField receiver;
	private JXDatePicker timePicker1;
	private JButton cancel;
	public ReceiveListPanel() {
		super();
		initPanel();
	}
	
	public ReceiveListPanel(ReceivingListVO vo) {
		super();
		setLayout(null);
		initPanel();
		this.ID.setText(vo.getOrderId());
		this.receiver.setText(vo.getReceiver());
		this.timePicker1.setDate(DateTransferHelper.getDate(vo.getDate()));
	}

	public void initPanel() {
		
		final JLabel jdjll = new JLabel();
		jdjll.setHorizontalAlignment(SwingConstants.CENTER);
		jdjll.setBounds(30, 20, 70, 35);
		jdjll.setFont(new Font("楷体", Font.PLAIN, 18));
		
		final JLabel jp4jl1 = new JLabel("订单号");
		jp4jl1.setFont(new Font("楷体", Font.PLAIN, 16));
		// 设置标签上文字的对齐方式
		jp4jl1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		ID = new JTextField();
		ID.setFont(new Font("楷体", Font.PLAIN, 16));
		
		
		final JLabel jp4jl4 = new JLabel("收件人");
		jp4jl4.setFont(new Font("楷体", Font.PLAIN, 16));
		jp4jl4.setHorizontalAlignment(SwingConstants.RIGHT);
		
		receiver = new JTextField();
		receiver.setFont(new Font("楷体", Font.PLAIN, 16));
			
		
		final JLabel jp4jl7 = new JLabel("收件日期");
		jp4jl7.setFont(new Font("楷体", Font.PLAIN, 16));
		jp4jl7.setHorizontalAlignment(SwingConstants.RIGHT);
		
		timePicker1 = new JXDatePicker();
		timePicker1.setFont(new Font("楷体", Font.PLAIN, 18));
		timePicker1.setDate(new Date());
		
		
		determine = new JButton("确定");
		determine.setFont(new Font("楷体", Font.PLAIN, 18));
		
		cancel = new JButton("取消");
		cancel.setFont(new Font("楷体", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addComponent(jp4jl1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addComponent(ID, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
					.addGap(245))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addComponent(jp4jl4, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addComponent(receiver, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
					.addGap(245))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(5)
					.addComponent(jp4jl7, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addComponent(timePicker1, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
					.addGap(245))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(111)
					.addComponent(determine, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(49)
					.addComponent(cancel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(130, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(jp4jl1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(ID, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(jp4jl4, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(receiver, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(jp4jl7, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(timePicker1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(cancel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(determine, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(82))
		);
		setLayout(groupLayout);
		
		
		this.makeFrame();
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
	}

	private void makeFrame(){
		frame = new JFrame();
		JPanel contentPane;
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(this);
		frame.setContentPane(contentPane);
		frame.setVisible(true);
	}
	
	public JButton getDetermine() {
		return determine;
	}
	public ReceivingListVO getVO(){
		return new ReceivingListVO (
				DateTransferHelper.getString(timePicker1.getDate()),
				receiver.getText(),
                ID.getText(), State.SUBMITTED);
		
	}
	
	public boolean isDataUsable(){
		return true;
	}
	public void dispose(){
		frame.dispose();
	}
}
