package org.module.client.presentation.statisticui;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.jdesktop.swingx.JXDatePicker;
import org.module.client.businesslogic.statisticbl.CostManageController;
import org.module.client.businesslogicservice.statisticBLservice.CostManageBLService;
import org.module.client.presentation.Table;
import org.module.client.vo.CostListVO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
	 * 付款日期、
	 * 付款金额、
	 * 付款人、
	 * 付款账号、
	 * 条目（租金（按年收）运费（按次计算）人员工资（按月统计）奖励（一次性）），
	 * 备注（租金年份、运单号、标注工资月份）
	 */
public class CostPanel extends JPanel {

	
	private static final long serialVersionUID = 1L;
	
	ArrayList<CostListVO> listData ;
	String[] columnNames = {"付款日期", "付款金额","付款人","付款账号","条目","备注"};
	private Table table;
	private JButton add;
	private JXDatePicker startTimePicker;
	private JXDatePicker endTimePicker;
	private JButton update;
	
	
	private CostManageBLService controller = new CostManageController();
	private JButton modify;
	public CostPanel() {
		init();
		addListeners();
	}
		
		
	private void init(){
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		add = new JButton("增");
		update = new JButton("同步");
		
		startTimePicker = new JXDatePicker();
		startTimePicker.setDate(new Date());
		
		endTimePicker = new JXDatePicker();
		endTimePicker.setDate(new Date());
		
		modify = new JButton("改");
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(startTimePicker, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(endTimePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
					.addComponent(add, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(modify, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(update))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(update)
						.addComponent(startTimePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(endTimePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(modify)
						.addComponent(add))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		
		this.listData = controller.showAll(startTimePicker.getDate().getTime(), endTimePicker.getDate().getTime());
		table = new Table(listData,columnNames);
		scrollPane.setViewportView(new JTable(table));
	}
	
	
	
	protected void modify() {
		int[] index = this.table.getCheckedIndexes();
		if(index.length!=1) {
			return ;
		}
		final NewCostListInputFrame frame = new NewCostListInputFrame( this.listData.get(index[0]) );
		frame.setVisible(true);
		frame.getComfirm().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(frame.isDataUsable()){
					controller.add(frame.getVO());
					frame.dispose();
				}
			}
		});
	}


	protected void add() {
		final NewCostListInputFrame frame = new NewCostListInputFrame();
		frame.setVisible(true);
		frame.getComfirm().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(frame.isDataUsable()){
					controller.add(frame.getVO());
					frame.dispose();
				}
			}
		});
	}


	private void refresh(){
		this.listData = controller.showAll(startTimePicker.getDate().getTime(), 
				endTimePicker.getDate().getTime());
		this.table.setList(listData);
		this.table.fireTableDataChanged();
	}
	
	private void addListeners(){
		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				add();
			}
		});
		update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				refresh();
			}
		});
		
		modify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modify();
			}
		});
		
	}
}
