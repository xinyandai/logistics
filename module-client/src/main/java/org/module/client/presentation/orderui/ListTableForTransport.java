package org.module.client.presentation.orderui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import org.module.client.businesslogic.orderbl.TransportController;
import org.module.client.businesslogicservice.orderBLservice.TransportBLService;
import org.module.client.presentation.ResultFrame;
import org.module.client.vo.TransportListVO;

public class ListTableForTransport extends ListTableForAll{

	
	private static final long serialVersionUID = 4297040531877933600L;
	private TransportBLService controller;
	protected ArrayList< TransportListVO> listCell;
	@Override
	protected void initData() {
		this.controller = new  TransportController();
		this.listCell = this.controller.getAll();
		if(this.listCell.size()>0){
			this.typeArray = this.listCell.get(0).names();
		}
	}

	@Override
	protected void refresh() {
		this.listCell = this.controller.getAll();
		if(this.listCell.size()>0){
			this.typeArray = this.listCell.get(0).names();
		}
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
		final NewTransportListInputFrame frame = new NewTransportListInputFrame(
				this.controller.getCityArray(),
				this.listCell.get(indexes[0]) );
		frame.setVisible(true);
		frame.getComfirm().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(frame.isDataUsable()){
					if(controller.update(frame.getVO())){
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

	@Override
	protected void add() {
		final NewTransportListInputFrame frame = new NewTransportListInputFrame(
				this.controller.getCityArray()
				 );
		frame.setVisible(true);
		frame.getComfirm().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(controller.creat(frame.getVO())){
					frame.dispose();
					new ResultFrame(true);
				}else{
					new ResultFrame(false);
				}
				table.fireTableDataChanged();
			}
		});
	}

}
