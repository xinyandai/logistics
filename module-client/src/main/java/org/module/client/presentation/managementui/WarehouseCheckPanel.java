package org.module.client.presentation.managementui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.io.File;
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
import org.module.client.presentation.Button;
import org.module.client.presentation.FontFactory;
import org.module.client.presentation.ResultFrame;
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
	private JTable jtable;
	private JButton update;
	private JButton export;
	private JScrollPane scrollPane;
	private JButton modify;
	private JButton button;
	private FontFactory font;
	
	public WarehouseCheckPanel() {
		this.font = new FontFactory();
		init();
		this.listData = this.controller.getAll();
		table = new Table(this.listData,this.columnNames);
		this.jtable = new JTable(table);
		this.jtable.setFont(font.getTableElementFont());
		this.jtable.getTableHeader().setFont(font.getTabelNameInput());
		scrollPane.setViewportView(this.jtable);
		addListener();
	
	}
		
	
		
	private void addListener() {
		
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					jtable.print();
				} catch (PrinterException e1) {
					e1.printStackTrace();
				}
			}
		});
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
		int[] indexes = this.table.getCheckedIndexes();
		if(indexes.length!=1){
			return;
		}
		final ModifyWarehouseFrame frame = new ModifyWarehouseFrame(
				this.listData.get(indexes[0]));
		frame.setVisible(true);
		frame.getComfirm().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(frame.isDataUsable()){
					if(controller.modify(frame.getVO())){
						frame.dispose();
						new ResultFrame(true);
					}else{
						new ResultFrame(false);
					}
					table.fireTableDataChanged();
					
				}
			}
		});
	}



	protected void export() {
		File file = new PathGetter().getPath(this);
		if(file!=null){
			this.controller.export(table, file);
		}
	}



	protected void refresh() {
		this.listData = this.controller.getAll();
		this.table.setList(listData);
		this.table.fireTableDataChanged();
	}



	private void init(){
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		add(panel, BorderLayout.NORTH);
		update = new Button("refresh");
		modify = new Button("modify");
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(319, Short.MAX_VALUE)
					.addComponent(modify, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(update, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(modify, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(update, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		add(panel_1, BorderLayout.SOUTH);
		
		export = new JButton("导出");
		export.setFont(font.getInputFont());
		export.setFont(new Font("楷体", Font.PLAIN, 14));
		
		button = new JButton("打印");
		button.setFont(font.getInputFont());
		button.setToolTipText("打印表格");
		button.setFont(new Font("楷体", Font.PLAIN, 14));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(322, Short.MAX_VALUE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(export))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(export)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
	}
}
