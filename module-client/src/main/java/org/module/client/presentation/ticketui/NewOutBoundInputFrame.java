package org.module.client.presentation.ticketui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.JXDatePicker;
import org.module.client.businesslogic.deparmentbl.DeparmentCount;
import org.module.client.presentation.DateTransferHelper;
import org.module.client.vo.OutBoundListVO;
import org.module.common.po.State;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class NewOutBoundInputFrame extends JFrame {

	
	private static final long serialVersionUID = -6717991181868844078L;
	private JPanel contentPane;
	private JComboBox warehouseID;
	private JTextField target;
	private JTextField ID;
	private JTextField transportID;
	private JButton comfirm;

	private String[] type = {"火车", "汽车", "飞机"};
	private JXDatePicker datePicker;
	private JComboBox typeOfWay;
	
	private DeparmentCount departmentCount = new DeparmentCount("中转中心");
	
	public NewOutBoundInputFrame() {
		init();
	}
	public NewOutBoundInputFrame(OutBoundListVO vo) {
		init();
		this.warehouseID.setSelectedItem(
				this.departmentCount.IdAndNameString(
						vo.getWarehouseOfWhichTranCenter())
				);
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
				this.warehouseID.getSelectedItem().toString().substring(0, 6),
				State.SUBMITTED
				);
		
	}
	
	
		
	private void init(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("仓库名");
		label.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_1 = new JLabel("目的地");
		label_1.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_2 = new JLabel("装运形式");
		label_2.setFont(new Font("楷体", Font.PLAIN, 18));
		
		warehouseID = new JComboBox(this.departmentCount.getIDWithName());
		warehouseID.setFont(new Font("楷体", Font.PLAIN, 15));
		
		target = new JTextField();
		target.setFont(new Font("楷体", Font.PLAIN, 15));
		target.setColumns(10);
		
		typeOfWay = new JComboBox(this.type);
		
		JLabel label_3 = new JLabel("快递编号");
		label_3.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_4 = new JLabel("货运编号");
		label_4.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_5 = new JLabel("入库时间");
		label_5.setFont(new Font("楷体", Font.PLAIN, 18));
		
		ID = new JTextField();
		ID.setFont(new Font("楷体", Font.PLAIN, 15));
		ID.setColumns(10);
		
		transportID = new JTextField();
		transportID.setFont(new Font("楷体", Font.PLAIN, 15));
		transportID.setColumns(10);
		
		datePicker = new JXDatePicker();
		datePicker.setDate(new Date());
		datePicker.setFont(new Font("楷体", Font.PLAIN, 15));
		
		comfirm = new JButton("确定");
		comfirm.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JButton cancel = new JButton("取消");
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		cancel.setFont(new Font("楷体", Font.PLAIN, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(37)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(warehouseID, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(ID, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
					.addGap(28))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(37)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(target, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(transportID, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
					.addGap(28))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(37)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(typeOfWay, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(datePicker, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(123)
					.addComponent(comfirm, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
					.addGap(24)
					.addComponent(cancel, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
					.addGap(91))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(22)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label)
								.addComponent(label_3)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(1)
									.addComponent(ID, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(24)
							.addComponent(warehouseID, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(8)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label_1)
								.addComponent(label_4)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(1)
									.addComponent(transportID, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(target, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(8)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label_2)
								.addComponent(label_5)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(1)
									.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(typeOfWay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(comfirm, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(cancel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	
	

	public JButton getComfirm() {
		return comfirm;
	}
	
	
}
