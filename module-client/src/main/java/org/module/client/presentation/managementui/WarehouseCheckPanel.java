package org.module.client.presentation.managementui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.module.client.businesslogic.managementbl.WarehouseManageController;
import org.module.client.businesslogicservice.managementBLservice.WarehouseManageBLService;
import org.module.client.presentation.Table;
import org.module.client.vo.WarehouseVO;

public class WarehouseCheckPanel extends JPanel {

	
	private static final long serialVersionUID = 1L;
	/**
	 * 快递编号、入库日期、目的地、区号、排号、架号、位号
	 */
	ArrayList<WarehouseVO> listData ;
	String[] columnNames = {"快递编号","区号","排号","架号","位号", "入库日期"};
	
	private WarehouseManageBLService controller = new WarehouseManageController();
	private Table table;
	private JButton update;
	private JButton export;
	private JScrollPane scrollPane;
	private JButton modify;
	
	public WarehouseCheckPanel() {
		init();
		this.listData = this.controller.getAll();
		table = new Table(this.listData,this.columnNames);
		scrollPane.setViewportView(new JTable(table));
		addListener();
	
	}
		
	
		
	private void addListener() {
		update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				refresh();
			}
		});
		
		export.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				export();
			}
		});
		modify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modify();
			}
		});
	}



	protected void modify() {
	//	this.controller.modify(id, qu, pai, jia, wei, warehouseOfWhichTranCenter);
	}



	protected void export() {
		//wait the inplements
	}



	protected void refresh() {
		this.listData = this.controller.getAll();
		this.table.setList(listData);
		this.table.fireTableDataChanged();
	}



	private void init(){
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		update = new JButton("同步");
		modify = new JButton("改");
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(330, Short.MAX_VALUE)
					.addComponent(modify, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(update))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(update)
						.addComponent(modify))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		
		
		
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		
		export = new JButton("导出");
		export.setFont(new Font("楷体", Font.PLAIN, 14));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(283, Short.MAX_VALUE)
					.addComponent(export))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(export)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
	}
}
