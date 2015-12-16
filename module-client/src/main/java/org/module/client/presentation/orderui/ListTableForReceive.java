package org.module.client.presentation.orderui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import org.module.client.businesslogic.orderbl.ReceivingController;
import org.module.client.businesslogicservice.orderBLservice.ReceiveBLService;
import org.module.client.presentation.ResultFrame;
import org.module.client.vo.ReceivingListVO;

public class ListTableForReceive extends ListTableForAll {

	
	private static final long serialVersionUID = 7082912802103341792L;
	private ReceiveBLService controller;
	protected ArrayList<ReceivingListVO> listCell;

	@Override
	protected void initData() {
		controller = new ReceivingController();
		this.listCell = this.controller.getAll();
		if(this.listCell.size()>0){
			this.typeArray = listCell.get(0).names();
		}
	}

	@Override
	protected void refresh() {
		this.listCell = this.controller.getAll();
		if(this.listCell.size()>0){
			this.typeArray = listCell.get(0).names();
		}
		this.table.setList(listCell);
		this.table.setName(typeArray);
		this.table.fireTableDataChanged();
	}

	@Override
	protected void modify() {
		int[] ins = table.getCheckedIndexes();
		if(ins.length != 1){
			return ;
		}
		final ReceiveListPanel p = new ReceiveListPanel(this.listCell.get(ins[0]));
		p.getDetermine().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(p.isDataUsable()){
					if(controller.update(p.getVO())){
						p.dispose();
						new ResultFrame(true);
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
		final ReceiveListPanel p = new ReceiveListPanel();
		p.getDetermine().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(p.isDataUsable()){
					if(controller.creat(p.getVO())){
						p.dispose();
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
