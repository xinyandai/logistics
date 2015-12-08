package org.module.client.presentation.ticketui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.JXDatePicker;
import org.module.client.presentation.DateTransferHelper;
import org.module.client.vo.GoDownEntryVO;
import org.module.common.po.State;

public class NewGoDownEntryInputFrame extends JFrame {

	
	private static final long serialVersionUID = -898711516018506572L;
	private JPanel contentPane;
	private JTextField warehouseID;
	private JTextField ID;
	private JTextField qu;
	private JTextField jia;
	private JTextField target;
	private JTextField pai;
	private JTextField wei;
	private JButton comfirm;
	private JXDatePicker datePicker;


	public NewGoDownEntryInputFrame(GoDownEntryVO vo) {
		
		this.init();
		this.warehouseID.setText(vo.getWarehouseOfWhichTranCenter());
		this.ID.setText(vo.getId());
		this.target.setText(vo.getDestination());
		this.pai.setText(vo.getPai());
		this.qu.setText(vo.getQu());
		this.jia.setText(vo.getJia());
		this.wei.setText(vo.getWei());
		this.datePicker.setDate(DateTransferHelper.getDate(vo.getDate()));
		
		
	}
	
	public NewGoDownEntryInputFrame() {
		this.init();
	}
		
	
	
	public boolean isDataUsable(){
		return true;
	}
	
	public GoDownEntryVO getVO(){
		return new GoDownEntryVO(
				this.warehouseID.getText(),
				this.ID.getText(),
				DateTransferHelper.getString( this.datePicker.getDate() ),
				this.target.getText(),
				this.qu.getText(),
				this.pai.getText(),
				this.jia.getText(),
				this.wei.getText(),
				State.SUBMITTED
				);
		
	}
	
	private void init(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("仓库名");
		label.setFont(new Font("楷体", Font.PLAIN, 18));
		label.setBounds(47, 36, 73, 21);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("快递编号");
		label_1.setFont(new Font("楷体", Font.PLAIN, 18));
		label_1.setBounds(47, 67, 73, 21);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("区号");
		label_2.setFont(new Font("楷体", Font.PLAIN, 18));
		label_2.setBounds(47, 98, 73, 21);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("架号");
		label_3.setFont(new Font("楷体", Font.PLAIN, 18));
		label_3.setBounds(47, 127, 73, 21);
		contentPane.add(label_3);
		
		warehouseID = new JTextField();
		warehouseID.setFont(new Font("楷体", Font.PLAIN, 15));
		warehouseID.setColumns(10);
		warehouseID.setBounds(132, 38, 66, 21);
		contentPane.add(warehouseID);
		
		ID = new JTextField();
		ID.setFont(new Font("楷体", Font.PLAIN, 15));
		ID.setColumns(10);
		ID.setBounds(130, 69, 66, 21);
		contentPane.add(ID);
		
		qu = new JTextField();
		qu.setFont(new Font("楷体", Font.PLAIN, 15));
		qu.setColumns(10);
		qu.setBounds(130, 100, 66, 21);
		contentPane.add(qu);
		
		jia = new JTextField();
		jia.setFont(new Font("楷体", Font.PLAIN, 15));
		jia.setColumns(10);
		jia.setBounds(130, 129, 66, 21);
		contentPane.add(jia);
		
		JLabel label_4 = new JLabel("入库时间");
		label_4.setFont(new Font("楷体", Font.PLAIN, 18));
		label_4.setBounds(232, 41, 73, 21);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("目的地");
		label_5.setFont(new Font("楷体", Font.PLAIN, 18));
		label_5.setBounds(232, 72, 73, 21);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("排号");
		label_6.setFont(new Font("楷体", Font.PLAIN, 18));
		label_6.setBounds(232, 103, 73, 21);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("位号");
		label_7.setFont(new Font("楷体", Font.PLAIN, 18));
		label_7.setBounds(232, 132, 73, 21);
		contentPane.add(label_7);
		
		datePicker = new JXDatePicker();
		datePicker.setFont(new Font("楷体", Font.PLAIN, 15));
		datePicker.setBounds(315, 42, 89, 21);
		contentPane.add(datePicker);
		
		target = new JTextField();
		target.setFont(new Font("楷体", Font.PLAIN, 15));
		target.setColumns(10);
		target.setBounds(315, 69, 66, 21);
		contentPane.add(target);
		
		pai = new JTextField();
		pai.setFont(new Font("楷体", Font.PLAIN, 15));
		pai.setColumns(10);
		pai.setBounds(315, 100, 66, 21);
		contentPane.add(pai);
		
		wei = new JTextField();
		wei.setFont(new Font("楷体", Font.PLAIN, 15));
		wei.setColumns(10);
		wei.setBounds(315, 129, 66, 21);
		contentPane.add(wei);
		
		comfirm = new JButton("确定");
		comfirm.setToolTipText("确定");
		comfirm.setFont(new Font("楷体", Font.PLAIN, 18));
		comfirm.setBounds(105, 197, 93, 23);
		contentPane.add(comfirm);
		
		JButton cancel = new JButton("取消");
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		cancel.setToolTipText("取消");
		cancel.setFont(new Font("楷体", Font.PLAIN, 18));
		cancel.setBounds(233, 199, 93, 23);
		contentPane.add(cancel);
	}
	public JButton getComfirm() {
		return comfirm;
	}
	
}
