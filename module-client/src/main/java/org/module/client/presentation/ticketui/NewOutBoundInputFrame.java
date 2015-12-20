package org.module.client.presentation.ticketui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
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
import org.module.client.main.Main;
import org.module.client.presentation.DateTransferHelper;
import org.module.client.presentation.Numeric;
import org.module.client.vo.OutBoundListVO;
import org.module.common.po.State;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

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
	private JLabel state;
	
	public NewOutBoundInputFrame() {
		init();
		this.warehouseID.setSelectedItem(Main.currentUser.getDepartmeny());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String dateString = formatter.format(new Date());
		String s = Main.currentUser.getDepartmeny() + dateString;
		this.transportID.setText(s);
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
		setBounds(100, 100, 471, 300);
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
		
		JLabel label_4 = new JLabel("中转单号");
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
		
		state = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(58)
					.addComponent(state, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(151)
					.addComponent(comfirm, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(cancel, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
					.addGap(69))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(transportID, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(typeOfWay, 0, 94, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, 92, Short.MAX_VALUE)
							.addGap(8))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(warehouseID, 0, 292, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(target, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(ID, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)))
							.addGap(8)))
					.addGap(22))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(state)
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(warehouseID, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addGap(8)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(target, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_3)
								.addComponent(ID, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))))
					.addGap(8)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(typeOfWay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_5)
								.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_4)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(transportID, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(comfirm, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(cancel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);
		
		target.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(target.getText().isEmpty()){
					state.setText("！目的地不能为空");
				}else{
					state.setText("");
				}
			}
		});
		ID.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if((!Numeric.isNumeric(ID.getText()))||ID.getText().length()!=10){
					state.setText("！快递编号必须是10位数值");
				}else{
					state.setText("");
				}
			}
		});
		transportID.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if((!Numeric.isNumeric(transportID.getText()))||transportID.getText().length()!=21){
					state.setText("！中转单号必须是21位数值");
				}else{
					state.setText("");
				}
			}
		});
	}
	
	public boolean isDataUsable(){
		if(target.getText().isEmpty()){
			state.setText("！目的地不能为空");
			return false;
		}else if((!Numeric.isNumeric(ID.getText()))||ID.getText().length()!=10){
			state.setText("！快递编号必须是10位数值");
			return false;
		}else if((!Numeric.isNumeric(transportID.getText()))||transportID.getText().length()!=21){
			state.setText("！中转单号必须是21位数值");
			return false;
		}
		
		
		return true;
	}
	

	public JButton getComfirm() {
		return comfirm;
	}
}
