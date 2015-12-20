package org.module.client.presentation.orderui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import org.module.client.businesslogic.orderbl.OfficeArrivalController;
import org.module.client.businesslogicservice.orderBLservice.OfficeArrivalBLService;
import org.module.client.presentation.ResultFrame;
import org.module.client.vo.OfficeArrivalListVO;

public class ListTableForOfficeArrival extends ListTableForAll{

	
	private static final long serialVersionUID = -8088668134510853117L;

	private OfficeArrivalBLService controller ;
	protected ArrayList<OfficeArrivalListVO> listCell;
	
	@Override
	protected void initData() {
		this.controller = new OfficeArrivalController();
		this.listCell = this.controller.getAll();
		this.typeArray = new String[] {
					"营业厅","到达日期","中转单","出发地","货物到达状态","单据状态"
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
		final NewOfficeArrivalListInputFrame frame = 
				new NewOfficeArrivalListInputFrame(this.listCell.get(indexes[0]));
		frame.setVisible(true);
		frame.getComfirmButton().addMouseListener(new MouseAdapter() {
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
		final NewOfficeArrivalListInputFrame frame = 
				new NewOfficeArrivalListInputFrame();
		frame.setVisible(true);
		frame.getComfirmButton().addMouseListener(new MouseAdapter() {
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
