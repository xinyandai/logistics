package org.module.client.presentation.orderui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import org.module.client.businesslogic.orderbl.OfficeLoadingController;
import org.module.client.businesslogicservice.orderBLservice.OfficeLoadingBLService;
import org.module.client.presentation.ResultFrame;
import org.module.client.vo.OfficeLoadingListVO;

public class ListTableForOfficeLoading extends ListTableForAll {

	
	private static final long serialVersionUID = 4230213619060711022L;

	private OfficeLoadingBLService controller;
	protected ArrayList<OfficeLoadingListVO> listCell;
	
	@Override
	protected void initData() {
		this.controller = new OfficeLoadingController();
		this.listCell = this.controller.getAll();
		this.typeArray = new String[]{
				"装车日期","营业厅","汽运编号","出发地","目的地","车号","监装员",
				"司机","物流单号","价格","状态"
	        	};
	}

	@Override
	protected void refresh() {
		this.listCell = this.controller.getAll();
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
		final NewOfficeLoadingrListInputFrame frame = new NewOfficeLoadingrListInputFrame(
				this.controller.getCityArray(),
				this.listCell.get(indexes[0]));
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
		final NewOfficeLoadingrListInputFrame frame = new NewOfficeLoadingrListInputFrame(
				this.controller.getCityArray());
		frame.setVisible(true);
		frame.getComfirm().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(frame.isDataUsable()){
					if(controller.creat(frame.getVO())){
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
