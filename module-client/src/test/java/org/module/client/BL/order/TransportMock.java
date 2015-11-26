package org.module.client.BL.order;

import java.util.ArrayList;

import org.module.client.businesslogicservice.order.TransportService;
import org.module.client.vo.TransportListVO;
import org.module.common.po.State;

public class TransportMock implements TransportService {

	public TransportMock() {
		// TODO Auto-generated constructor stub
	}

	public boolean creat(TransportListVO o) {
		if(o!=null) return true;
		return false;
	}

	public ArrayList<TransportListVO> getAll(State s) {
		// TODO Auto-generated method stub
		return null;
	}

}
