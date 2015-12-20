package org.module.client.presentation.orderui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import org.module.client.businesslogic.orderbl.SendingController;
import org.module.client.businesslogicservice.orderBLservice.SendingBLService;
import org.module.client.presentation.ResultFrame;
import org.module.client.vo.SendingListVO;

public class ListTableForSending extends ListTableForAll {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2924001557039265431L;

	protected ArrayList<SendingListVO> listCell;
	private SendingBLService controller ;
	@Override
	protected void initData() {
		controller = new SendingController();
		this.listCell = this.controller.getAll();
		this.typeArray = new String[]{
					"派件时间","快递单号","派件人","单据状态"
			       };
	}

	@Override
	protected void refresh() {
		this.listCell = this.controller.getAll();
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
		final NewSendingListInputFrame frame = 
				new NewSendingListInputFrame(this.listCell.get(indexes[0]));
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
		final NewSendingListInputFrame frame = 
				new NewSendingListInputFrame();
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
