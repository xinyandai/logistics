package org.module.client.presentation.orderui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import org.module.client.businesslogic.orderbl.TranCenterArrivalController;
import org.module.client.businesslogicservice.orderBLservice.TranCenterArrivalBLService;
import org.module.client.vo.TranCenterArrivalListVO;

public class ListTableForTranCenterArrival extends ListTableForAll {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7153348124509119710L;

	private TranCenterArrivalBLService controller ;
	protected ArrayList<TranCenterArrivalListVO> listCell;
	
	@Override
	protected void initData() {
		controller = new TranCenterArrivalController();
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
		this.table.fireTableDataChanged();
	}

	@Override
	protected void modify() {
		int[] indexes = this.table.getCheckedIndexes();
		if(indexes.length!=1){
			return;
		}
		final NewTranCenterArrivalListInputFrame frame = 
				new NewTranCenterArrivalListInputFrame(this.listCell.get(indexes[0]));
		frame.setVisible(true);
		frame.getComfirmButton().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(frame.isDataUsable()){
					controller.update(frame.getVO());
					table.fireTableDataChanged();
				}
			}
		});
	}

	@Override
	protected void add() {
		final NewTranCenterArrivalListInputFrame frame = 
				new NewTranCenterArrivalListInputFrame();
		frame.setVisible(true);
		frame.getComfirmButton().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(frame.isDataUsable()){
					controller.creat(frame.getVO());
					table.fireTableDataChanged();
				}
			}
		});
	}

}
