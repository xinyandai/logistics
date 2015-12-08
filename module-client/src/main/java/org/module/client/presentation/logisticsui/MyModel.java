package org.module.client.presentation.logisticsui;

import javax.swing.AbstractListModel;

import org.module.client.vo.LogisticsVO;

public class MyModel extends AbstractListModel<Object>{

	private static final long serialVersionUID = -5734219240628343614L;
	private LogisticsVO vo;
	public MyModel(LogisticsVO vo) {
		this.vo = vo;
	}

	public int getSize() {
		return vo.getHistoryTime().length;
	}

	public Object getElementAt(int index) {
		String[] s = {vo.getHistoryLocation()[index], vo.getHistoryTime()[index++]};
		//String[] s = {vo.getLocation(),vo.getEstination()};
		return s;
	}
	
}