package org.module.client.presentation.ticketui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTable;

import org.module.client.businesslogic.ticketbl.GoDownEntryController;
import org.module.client.businesslogicservice.ticketBLservice.GoDownEntryBLService;
import org.module.client.presentation.Table;
import org.module.client.vo.GoDownEntryVO;


public class GoDownEntryList extends AbstractAllList {

	
	private static final long serialVersionUID = -2681520431930569830L;

	protected String[] typeArray = {
			"中转中心","快递编号","入库日期","目的地","区号","排号","架号","位号","状态"
	};
	protected ArrayList<GoDownEntryVO> listCell ;
	protected GoDownEntryBLService controller;
	
	public GoDownEntryList(){
		initData();
		init();
		addListeners();
		table =   new Table(this.listCell,this.typeArray);
		this.scrollPane.setViewportView(new JTable(table));
	}

	@Override
	protected void initData() {
		controller = new GoDownEntryController();
		this.listCell = this.controller.getAll(new Date().getTime(),new Date().getTime());
	}


	@Override
	protected void refresh() {
		this.listCell = this.controller.getAll(this.startTime.getDate().getTime(),this.endTime.getDate().getTime());
		this.table.setList(listCell);
		this.table.setName(typeArray);
		this.table.fireTableDataChanged();;
	}


	@Override
	protected void modify() {
		int[] indexes = this.table.getCheckedIndexes();
		if(indexes.length!=1){
			return;
		}
		final NewGoDownEntryInputFrame frame = new NewGoDownEntryInputFrame(
				this.listCell.get(indexes[0]));
		frame.setVisible(true);
		frame.getComfirm().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(frame.isDataUsable()){
					controller.update(frame.getVO());
					table.fireTableDataChanged();
					frame.dispose();
				}
			}
		});
	}


	@Override
	protected void add() {
		final NewGoDownEntryInputFrame frame = new NewGoDownEntryInputFrame();
		frame.setVisible(true);
		frame.getComfirm().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(frame.isDataUsable()){
					controller.createTicket(frame.getVO());
					table.fireTableDataChanged();
					frame.dispose();
				}
			}
		});
	}

}
