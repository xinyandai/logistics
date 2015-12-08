package org.module.client.presentation.ticketui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.JXDatePicker;
import org.module.client.presentation.DateTransferHelper;
import org.module.client.vo.OutBoundListVO;
import org.module.common.po.State;

public class NewOutBoundInputFrame extends JFrame {

	
	private static final long serialVersionUID = -6717991181868844078L;
	private JPanel contentPane;
	private JTextField warehouseID;
	private JTextField target;
	private JTextField ID;
	private JTextField transportID;
	private JButton comfirm;

	private String[] type = {"火车", "汽车", "飞机"};
	private JXDatePicker datePicker;
	private JComboBox typeOfWay;
	
	public NewOutBoundInputFrame() {
		init();
	}
	public NewOutBoundInputFrame(OutBoundListVO vo) {
		init();
		this.warehouseID.setText(vo.getWarehouseOfWhichTranCenter());
		this.target.setText(vo.getDestination());
		this.ID.setText(vo.getId());
		this.transportID.setText(vo.getTansportListId());
		this.typeOfWay.setSelectedItem(vo.getTypeOfLoading());
		this.datePicker.setDate(DateTransferHelper.getDate(vo.getDate()));
	}
	
	public boolean isDataUsable(){
		return true;
	}
	
	public OutBoundListVO getVO(){
		return new OutBoundListVO(
				this.ID.getText(),
				DateTransferHelper.getString(this.datePicker.getDate()),
				this.target.getText(),
				this.typeOfWay.getSelectedItem().toString(),
				this.transportID.getText(),
				this.warehouseID.getText(),
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
		label.setBounds(42, 27, 76, 21);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("目的地");
		label_1.setFont(new Font("楷体", Font.PLAIN, 18));
		label_1.setBounds(42, 58, 76, 21);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("装运形式");
		label_2.setFont(new Font("楷体", Font.PLAIN, 18));
		label_2.setBounds(42, 89, 76, 21);
		contentPane.add(label_2);
		
		warehouseID = new JTextField();
		warehouseID.setFont(new Font("楷体", Font.PLAIN, 15));
		warehouseID.setColumns(10);
		warehouseID.setBounds(128, 29, 81, 21);
		contentPane.add(warehouseID);
		
		target = new JTextField();
		target.setFont(new Font("楷体", Font.PLAIN, 15));
		target.setColumns(10);
		target.setBounds(128, 60, 81, 21);
		contentPane.add(target);
		
		typeOfWay = new JComboBox(this.type);
		typeOfWay.setBounds(128, 91, 81, 21);
		contentPane.add(typeOfWay);
		
		JLabel label_3 = new JLabel("快递编号");
		label_3.setFont(new Font("楷体", Font.PLAIN, 18));
		label_3.setBounds(239, 27, 76, 21);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("货运编号");
		label_4.setFont(new Font("楷体", Font.PLAIN, 18));
		label_4.setBounds(239, 58, 76, 21);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("入库时间");
		label_5.setFont(new Font("楷体", Font.PLAIN, 18));
		label_5.setBounds(239, 89, 76, 21);
		contentPane.add(label_5);
		
		ID = new JTextField();
		ID.setFont(new Font("楷体", Font.PLAIN, 15));
		ID.setColumns(10);
		ID.setBounds(325, 28, 81, 21);
		contentPane.add(ID);
		
		transportID = new JTextField();
		transportID.setFont(new Font("楷体", Font.PLAIN, 15));
		transportID.setColumns(10);
		transportID.setBounds(325, 59, 81, 21);
		contentPane.add(transportID);
		
		datePicker = new JXDatePicker();
		datePicker.setFont(new Font("楷体", Font.PLAIN, 15));
		datePicker.setBounds(325, 90, 109, 21);
		contentPane.add(datePicker);
		
		comfirm = new JButton("确定");
		comfirm.setFont(new Font("楷体", Font.PLAIN, 18));
		comfirm.setBounds(128, 150, 93, 23);
		contentPane.add(comfirm);
		
		JButton cancel = new JButton("取消");
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		cancel.setFont(new Font("楷体", Font.PLAIN, 18));
		cancel.setBounds(245, 152, 93, 23);
		contentPane.add(cancel);
	}
	
	
	

	public JButton getComfirm() {
		return comfirm;
	}
	
	
}
