package org.module.client.BL.order;

import java.util.ArrayList;

import org.module.client.businesslogicservice.order.TransportService;
import org.module.client.vo.TransportListVO;

public class TransportMock implements TransportService {

	public TransportMock() {
		// TODO Auto-generated constructor stub
	}

	public boolean creat(TransportListVO o) {
		if(o!=null) return true;
		return false;
	}

	public ArrayList<TransportListVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
