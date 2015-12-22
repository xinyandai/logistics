package org.module.client.presentation.statisticui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import org.jdesktop.swingx.JXDatePicker;
import org.module.client.main.Main;
import org.module.client.presentation.DateTransferHelper;
import org.module.client.presentation.Numeric;
import org.module.client.vo.ReceiptVO;
import org.module.common.po.State;

public class NewReceiptInputFrame extends JFrame {

	
	private static final long serialVersionUID = -1578161156620761205L;
	private JPanel contentPane;
	private JTextField money;
	private JTextField courier;
	private JXDatePicker datePicker;
	private JTextPane textPane;
	private JLabel state;
	private final int lengthOfID = 10;
	private JButton save;
	private JButton cancel;
	final private String id;
	/**
	 * 检查数据输入格式是否都正确
	 * @return
	 */
	public boolean isDataUsable(){
		return  this.shippingId()!=null 
				&&Numeric.isNumeric(courier.getText())
				&&courier.getText().length()==9;
	}
	/**
	 * 调用段先调用this.isDataUsable()
	 * 返回为true则继续调用此函数
	 * 返回VO
	 * @return
	 */
	public ReceiptVO getVO(){
		System.out.println(id);
		return new ReceiptVO(
				DateTransferHelper.getString( this.datePicker.getDate() ),
							this.money.getText() ,
							this.courier.getText() ,
							this.shippingId(),
							State.SUBMITTED,
							id,
							Main.currentUser.getId() );
	}
	public NewReceiptInputFrame(ReceiptVO vo) {
	    this.id = vo.getID();
		init();
		this.money.setText(vo.getMoney()+"");
		this.courier.setText(vo.getCourier());
		StringBuffer buffer = new StringBuffer();
		String[] strs = vo.getOrderId() ;
		for (String string : strs) {
			buffer.append(string);
			buffer.append("\r");
		}
		this.textPane.setText(buffer.toString());
		this.datePicker.setDate(DateTransferHelper.getDate(vo.getDate()));
		this.addListeners();
	}
	public NewReceiptInputFrame() {
	    this.id = new Date().getTime()+"";
		init();
		this.addListeners();
	}
	private void init(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 450, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("金额");
		label.setFont(new Font("楷体", Font.PLAIN, 18));
		
		state = new JLabel("");
		
		JLabel label_2 = new JLabel("收款快递员");
		label_2.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_3 = new JLabel("选择日期");
		label_3.setFont(new Font("楷体", Font.PLAIN, 18));
		
		money = new JTextField();
		money.setFont(new Font("楷体", Font.PLAIN, 15));
		money.setColumns(10);
		
		courier = new JTextField();
		courier.setFont(new Font("楷体", Font.PLAIN, 15));
		courier.setColumns(10);
		
		datePicker = new JXDatePicker();
		datePicker.setDate(new Date());
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label_4 = new JLabel("在下方输入快递单号");
		scrollPane.setColumnHeaderView(label_4);
		
		textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		
		save = new JButton("确定");
		cancel = new JButton("取消");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(86)
					.addComponent(state, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(36)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(money, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(36)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(courier, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(36)
					.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(36)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(95)
					.addComponent(save, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(cancel, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(state, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(money, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(courier, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(15)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(save)
						.addComponent(cancel)))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	
	private void addListeners() {
		
		this.money.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(!Numeric.isRealNumber(money.getText())){
					state.setText("!金额必须是有效数值");
				}
			}
		});
		this.courier.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(!Numeric.isNumeric(courier.getText() ) || 
						courier.getText().length()!=9){
					state.setText("!员工号必须是9位数值");
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
	protected String[] shippingId(){
		String[] shippingId = null;
		String   text = textPane.getText();
		while(text.charAt(text.length()-1)=='\r'  || text.charAt(text.length()-1)==' '
				||text.charAt(text.length()-1)=='\n' ){
			text = text.substring(0, text.length()-1);
		}
		shippingId = text.split("\r",0);
		for (String string : shippingId) {
			string = string.replace("\r", "");
			string = string.replace("\n", "");
			if(string.length()!=lengthOfID ){
				state.setText("托运单号请以空格或回车隔开");
				return null;
			}
		}
	    return shippingId;
}
	public JButton getComfirm() {
		return save;
	}
}
