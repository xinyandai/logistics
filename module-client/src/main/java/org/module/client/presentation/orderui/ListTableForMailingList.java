package org.module.client.presentation.orderui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import org.module.client.businesslogic.orderbl.MailingControl;
import org.module.client.businesslogicservice.orderBLservice.MailingBLService;
import org.module.client.vo.MailingListVO;

public class ListTableForMailingList extends ListTableForAll {

	private static final long serialVersionUID = 83627053089339309L;
	protected ArrayList<MailingListVO> listCell;
	private MailingBLService controller = new MailingControl();
	@Override
	protected void initData() {
		if(this.controller ==null){
			controller = new MailingControl();
		}
		this.listCell = this.controller.getAll();
		if(listCell.size()>0){
			this.typeArray = this.listCell.get(0).names();
		}
	}

	@Override
	protected void refresh() {
		this.listCell = this.controller.getAll();
		if(this.listCell!=null){
			this.typeArray = this.listCell.get(0).names();
		}
		this.table.setList(listCell);
		this.table.setName(typeArray);
		this.table.fireTableDataChanged();
	}

	@Override
	protected void modify() {
		int[] indexes = this.table.getCheckedIndexes();
		if(indexes.length == 1){
			final MailingListPanel p = new MailingListPanel(this.listCell.get(0),controller);
			p.getFrame().addWindowListener(new WindowAdapter(){     
				//添加一个窗口监听     
				public void windowClosing(WindowEvent e) {    //这是窗口关闭事件         
					refresh();   
				}
			});
		}
	}

	@Override
	protected void add() {
		final MailingListPanel p = new MailingListPanel(controller);
		p.getFrame().addWindowListener(new WindowAdapter(){     
			//添加一个窗口监听     
			public void windowClosing(WindowEvent e) {    //这是窗口关闭事件         
				refresh();   
			}
		});
	}

}
