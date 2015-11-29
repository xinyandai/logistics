package org.module.client.presentation.orderui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.jdesktop.swingx.JXDatePicker;
import org.module.client.businesslogic.orderbl.ReceivingController;
import org.module.client.businesslogicservice.orderBLservice.ReceiveBLService;
import org.module.common.po.State;


public class ReceiveListPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ReceiveBLService controller = new ReceivingController();
	private JButton determine;
	private JTextField ID;
	private JTextField receiver;
	private JXDatePicker timePicker1;
	public ReceiveListPanel() {
		super();
		setLayout(null);
		initPanel();
		addListeners();
	}

	public void initPanel() {
		// TODO 自动生成的方法存根
		removeAll();
		//消息提示框
		final JLabel jdjll = new JLabel();
		jdjll.setHorizontalAlignment(SwingConstants.CENTER);
		jdjll.setBounds(30, 20, 70, 35);
		jdjll.setFont(new Font("楷体", Font.PLAIN, 18));
		
		final JLabel jp4jl1 = new JLabel("订单号");
		jp4jl1.setBounds(5, 22, 100, 35);
		jp4jl1.setFont(new Font("楷体", Font.PLAIN, 16));
		// 设置标签上文字的对齐方式
		jp4jl1.setHorizontalAlignment(SwingConstants.RIGHT);
		add(jp4jl1);
		
		ID = new JTextField();
		ID.setBounds(105, 25, 100, 30);
		ID.setFont(new Font("楷体", Font.PLAIN, 16));
		add(ID);
		
		
		final JLabel jp4jl4 = new JLabel("收件人");
		jp4jl4.setBounds(5, 72, 100, 35);
		jp4jl4.setFont(new Font("楷体", Font.PLAIN, 16));
		jp4jl4.setHorizontalAlignment(SwingConstants.RIGHT);
		add(jp4jl4);
		
		receiver = new JTextField();
		receiver.setBounds(105, 75, 100, 30);
		receiver.setFont(new Font("楷体", Font.PLAIN, 16));
		add(receiver);
			
		
		final JLabel jp4jl7 = new JLabel("收件日期");
		jp4jl7.setBounds(5, 122, 100, 35);
		jp4jl7.setFont(new Font("楷体", Font.PLAIN, 16));
		jp4jl7.setHorizontalAlignment(SwingConstants.RIGHT);
		add(jp4jl7);
		
		timePicker1 = new JXDatePicker();
		timePicker1.setFont(new Font("楷体", Font.PLAIN, 18));
		timePicker1.getEditor().setText("YY-MM-DD");
		timePicker1.setBounds(105, 125, 100, 30);
		add(timePicker1);
		
		
		determine = new JButton("确定");
		
		determine.setBounds(188, 186, 80, 32);
		determine.setFont(new Font("楷体", Font.PLAIN, 18));
		add(determine);
		
		/*final JButton jp4jb2 = new JButton("取消");
		jp4jb2.setBounds(310, 273, 80, 32);
		jp4jb2.setFont(new Font("楷体", Font.PLAIN, 18));
		add(jp4jb2);*/
		
		
	}

	private void  addListeners(){
		determine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.creat(timePicker1.getDate().getTime()+"", receiver.getText(),
                   ID.getText(), State.SUBMITTED);
			}
		});
	}
}
