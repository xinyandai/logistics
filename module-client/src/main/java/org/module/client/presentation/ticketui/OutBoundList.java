package org.module.client.presentation.ticketui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTable;

import org.module.client.businesslogic.ticketbl.OutBoundController;
import org.module.client.businesslogicservice.ticketBLservice.OutBoundBLService;
import org.module.client.presentation.Table;
import org.module.client.vo.OutBoundListVO;


public class OutBoundList extends AbstractAllList {

	
	
	private static final long serialVersionUID = -1673416299755256627L;

	protected String[] typeArray =  {
			"物流单号","出库日期","目的地","装车方式","单号","营业厅","状态"
	};;
	protected ArrayList<OutBoundListVO> listCell;
	
	protected OutBoundBLService controller ;
	

	public OutBoundList(){
		initData();
		init();
		addListeners();
		table =   new Table(this.listCell,this.typeArray);
		this.scrollPane.setViewportView(new JTable(table));
	}

	@Override
	protected void initData() {
		controller = new OutBoundController();
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
		final NewOutBoundInputFrame frame = new NewOutBoundInputFrame(
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
		final NewOutBoundInputFrame frame = new NewOutBoundInputFrame();
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
