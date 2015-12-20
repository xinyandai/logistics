package org.module.client.presentation.ticketui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTable;

import org.module.client.businesslogic.ticketbl.GoDownEntryController;
import org.module.client.businesslogicservice.ticketBLservice.GoDownEntryBLService;
import org.module.client.presentation.ResultFrame;
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
		this.listCell = this.controller.getAll(this.startTime.getDate().getTime(),this.endTime.getDate().getTime());
		table =   new Table(this.listCell,this.typeArray);
		this.scrollPane.setViewportView(new JTable(table));
	}

	@Override
	protected void initData() {
		controller = new GoDownEntryController();
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
					if( controller.update(frame.getVO())){
						new ResultFrame(true);
						frame.dispose();
					}else{
						new ResultFrame(false);
					}
					table.fireTableDataChanged();
					
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
					if( controller.createTicket(frame.getVO()) ){
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

}
