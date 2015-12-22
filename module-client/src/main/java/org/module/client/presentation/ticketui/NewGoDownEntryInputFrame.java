package org.module.client.presentation.ticketui;

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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import org.jdesktop.swingx.JXDatePicker;
import org.module.client.businesslogic.deparmentbl.DeparmentCount;
import org.module.client.businesslogic.managementbl.QusCounter;
import org.module.client.presentation.DateTransferHelper;
import org.module.client.presentation.Numeric;
import org.module.client.vo.GoDownEntryVO;
import org.module.common.po.State;

public class NewGoDownEntryInputFrame extends JFrame {

	
	private static final long serialVersionUID = -898711516018506572L;
	private JPanel contentPane;
	private JComboBox warehouseID;
	private JTextField ID;
	private JComboBox qu;
	private JTextField jia;
	private JTextField target;
	private JTextField pai;
	private JTextField wei;
	private JButton comfirm;
	private JXDatePicker datePicker;


	private DeparmentCount departmentCount = new DeparmentCount("中转中心");
	private JLabel state;
	
	public NewGoDownEntryInputFrame(GoDownEntryVO vo) {
		
		this.init();
		this.warehouseID.setSelectedItem  (
				this.departmentCount.IdAndNameString(
						vo.getWarehouseOfWhichTranCenter()
						)
				);
		this.ID.setText(vo.getId());
		this.target.setText(vo.getDestination());
		this.pai.setText(vo.getPai());
		this.qu.setSelectedItem(vo.getQu());
		this.jia.setText(vo.getJia());
		this.wei.setText(vo.getWei());
		this.datePicker.setDate(DateTransferHelper.getDate(vo.getDate()));
		
		
	}
	
	public NewGoDownEntryInputFrame() {
		this.init();
	}
		
	
	
	
	
	public GoDownEntryVO getVO(){
		return new GoDownEntryVO(
				this.warehouseID.getSelectedItem().toString().substring(0, 6),
				this.ID.getText(),
				DateTransferHelper.getString( this.datePicker.getDate() ),
				this.target.getText(),
				this.qu.getSelectedItem().toString(),
				this.pai.getText(),
				this.jia.getText(),
				this.wei.getText(),
				State.SUBMITTED
				);
		
	}
	
	private void init(){
		setBounds(400, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("仓库名");
		label.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_1 = new JLabel("快递编号");
		label_1.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_2 = new JLabel("区号");
		label_2.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_3 = new JLabel("架号");
		label_3.setFont(new Font("楷体", Font.PLAIN, 18));
		
		warehouseID = new JComboBox(this.departmentCount.getIDWithName());
		warehouseID.setFont(new Font("楷体", Font.PLAIN, 15));
		
		ID = new JTextField();
		
		ID.setFont(new Font("楷体", Font.PLAIN, 15));
		ID.setColumns(10);
		
		qu = new JComboBox(new QusCounter().getQus());
		
		qu.setFont(new Font("楷体", Font.PLAIN, 15));
	//	qu.setColumns(10);
		
		jia = new JTextField();
		jia.setFont(new Font("楷体", Font.PLAIN, 15));
		jia.setColumns(10);
		
		JLabel label_4 = new JLabel("入库时间");
		label_4.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_5 = new JLabel("目的地");
		label_5.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_6 = new JLabel("排号");
		label_6.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_7 = new JLabel("位号");
		label_7.setFont(new Font("楷体", Font.PLAIN, 18));
		
		datePicker = new JXDatePicker();
		datePicker.setDate(new Date());
		datePicker.setFont(new Font("楷体", Font.PLAIN, 15));
		
		target = new JTextField();
		
		target.setFont(new Font("楷体", Font.PLAIN, 15));
		target.setColumns(10);
		
		pai = new JTextField();
		pai.setFont(new Font("楷体", Font.PLAIN, 15));
		pai.setColumns(10);
		
		wei = new JTextField();
		wei.setFont(new Font("楷体", Font.PLAIN, 15));
		wei.setColumns(10);
		
		comfirm = new JButton("确定");
		comfirm.setToolTipText("确定");
		comfirm.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JButton cancel = new JButton("取消");
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		cancel.setToolTipText("取消");
		cancel.setFont(new Font("楷体", Font.PLAIN, 18));
		
		state = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(42)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(warehouseID, 0, 90, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, 89, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(100)
							.addComponent(comfirm, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addComponent(cancel, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(42)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(jia, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(wei, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(qu, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(pai, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(ID, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(target)))
							.addGap(3)))
					.addGap(25))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(80)
					.addComponent(state, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(113, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(state)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(31)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(5)
									.addComponent(label_4))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(6)
									.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(33)
							.addComponent(warehouseID, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label_1)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(5)
									.addComponent(label_5))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(ID, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(target, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label_2)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(5)
									.addComponent(label_6))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(7)
							.addComponent(qu, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(7)
							.addComponent(pai, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label_3)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(5)
									.addComponent(label_7))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(8)
							.addComponent(jia, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(8)
							.addComponent(wei, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(comfirm, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(cancel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))))
		);
		contentPane.setLayout(gl_contentPane);
		
		
		ID.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if((!Numeric.isNumeric(ID.getText()))||ID.getText().length()!=10){
					state.setText("！快递编号必须是10位数值");
				}else{
					state.setText("");
				}
			}
		});
		target.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(target.getText().isEmpty()){
					state.setText("！目的地不能为空");
				}else{
					state.setText("");
				}
			}
		});
		
		pai.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(pai.getText().isEmpty()){
					state.setText("！排号不能为空");
				}else{
					state.setText("");
				}
			}
		});
		jia.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(jia.getText().isEmpty()){
					state.setText("！架号不能为空");
				}else{
					state.setText("");
				}
			}
		});
		wei.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(wei.getText().isEmpty()){
					state.setText("！位号不能为空");
				}else{
					state.setText("");
				}
			}
		});
	}
	
	public boolean isDataUsable(){
		if((!Numeric.isNumeric(ID.getText()))||ID.getText().length()!=10){
			state.setText("！快递编号必须是10位数值");
			return false;
		}else if(target.getText().isEmpty()){
			state.setText("！目的地不能为空");
			return false;
		}else if(pai.getText().isEmpty()){
			state.setText("！排号不能为空");
			return false;
		}else if(jia.getText().isEmpty()){
			state.setText("！架号不能为空");
			return false;
		}else if(wei.getText().isEmpty()){
			state.setText("！位号不能为空");
			return false;
		}
		
		return true;
	}
	
	public JButton getComfirm() {
		return comfirm;
	}
	
}
