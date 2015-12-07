package org.module.client.presentation.orderui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import org.module.client.businesslogic.orderbl.OfficeLoadingController;
import org.module.client.businesslogicservice.orderBLservice.OfficeLoadingBLService;
import org.module.client.vo.OfficeLoadingListVO;

public class ListTableForOfficeLoading extends ListTableForAll {

	
	private static final long serialVersionUID = 4230213619060711022L;

	private OfficeLoadingBLService controller;
	protected ArrayList<OfficeLoadingListVO> listCell;
	
	@Override
	protected void initData() {
		this.controller = new OfficeLoadingController();
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
		final NewOfficeLoadingrListInputFrame frame = new NewOfficeLoadingrListInputFrame(
				this.controller.getCityArray(),
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
		final NewOfficeLoadingrListInputFrame frame = new NewOfficeLoadingrListInputFrame(
				this.controller.getCityArray());
		frame.setVisible(true);
		frame.getComfirm().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(frame.isDataUsable()){
					controller.creat(frame.getVO());
					table.fireTableDataChanged();
					frame.dispose();
				}
			}
		});
	}

}
