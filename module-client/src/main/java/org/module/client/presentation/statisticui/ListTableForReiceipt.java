package org.module.client.presentation.statisticui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import org.module.client.businesslogic.statisticbl.ReceiptContoller;
import org.module.client.presentation.ResultFrame;
import org.module.client.presentation.orderui.ListTableForAll;
import org.module.client.vo.ReceiptVO;

public class ListTableForReiceipt extends ListTableForAll {

	
	private static final long serialVersionUID = -7389044960331158157L;

	private ReceiptContoller controller;
	protected ArrayList<ReceiptVO> listCell;
	@Override
	protected void initData() {
		this.controller = new ReceiptContoller();
		this.listCell = this.controller.getAll();
		String[] s = {
				"日期","金额","快递员","托运单号","状态"
		};
		this.typeArray = s;
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
		final NewReceiptInputFrame frame = new NewReceiptInputFrame(
				this.listCell.get(indexes[0]));
		frame.setVisible(true);
		frame.getComfirm().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(frame.isDataUsable()){
					if (controller.update(frame.getVO())){
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
		final NewReceiptInputFrame frame = new NewReceiptInputFrame();
		frame.setVisible(true);
		frame.getComfirm().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(frame.isDataUsable()){
					if( controller.add(frame.getVO())){
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
