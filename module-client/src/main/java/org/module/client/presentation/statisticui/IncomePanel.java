package org.module.client.presentation.statisticui;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.jdesktop.swingx.JXDatePicker;
import org.module.client.businesslogic.statisticbl.IncomeManageController;
import org.module.client.businesslogicservice.statisticBLservice.IncomeManageBLService;
import org.module.client.presentation.Table;
import org.module.client.vo.ReceiptVO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
	 * 
	 * 单号
	 * 金额
	 * 日期
	 * 快递员
	 */
public class IncomePanel extends JPanel {


	private static final long serialVersionUID = 1L;
	
	private ArrayList<ReceiptVO> listData ;
	private String[] columnNames = {"单号", "金额","日期","快递员"};
	private String[] officeArray = {};
	private Table table;
	private JXDatePicker startTimePicker;
	private JXDatePicker endTimePicker;
	private IncomeManageBLService controller  = new IncomeManageController();
	private JScrollPane scrollPane;
	private JComboBox<String> office;
	private JButton update;
	
	
	public IncomePanel() {
		this.officeArray = this.controller.getAllOffice();
		this.init();
		if(this.officeArray.length > 0){
			this.listData = this.controller.showIncomeList(office.getSelectedItem().toString(), this.startTimePicker.getDate().getTime(), 
				this.endTimePicker.getDate().getTime());
		}
		table = new Table(listData,columnNames);
		scrollPane.setViewportView(new JTable(table));
		
		addListeners();
	}
	
	private void addListeners(){
		update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 refresh();
			}
		});
		
		office.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				 refresh();
			}
		});
		
		startTimePicker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 refresh();
			}
		});
		endTimePicker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 refresh();
			}
		});
		
	}
	
	private void refresh(){
		this.listData = this.controller.showIncomeList(office.getSelectedItem().toString(), this.startTimePicker.getDate().getTime(), 
				this.endTimePicker.getDate().getTime());
		table.setList(listData);
		table.fireTableDataChanged();
	}
	
	private void init(){
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		update = new JButton("同步");
		
		update.setToolTipText("同步");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(393, Short.MAX_VALUE)
					.addComponent(update))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(update)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		panel_1.add(scrollPane);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("营业厅");
		
		office = new JComboBox(officeArray);
		
		JLabel label = new JLabel("选择起止时间");
		
		startTimePicker = new JXDatePicker();
		startTimePicker.setDate(new Date());
		
		endTimePicker = new JXDatePicker();
		endTimePicker.setDate(new Date());
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(office, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(startTimePicker)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(endTimePicker)
					.addContainerGap(75, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
						.addComponent(office, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addComponent(startTimePicker)
						.addComponent(endTimePicker)))
		);
		panel_2.setLayout(gl_panel_2);
	}

}
