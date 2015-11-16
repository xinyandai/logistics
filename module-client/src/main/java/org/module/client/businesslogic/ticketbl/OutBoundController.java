package org.module.client.businesslogic.ticketbl;

import org.module.client.businesslogicservice.ticket.OutBoundService;
import org.module.client.businesslogicservice.ticketBLservice.OutBoundBLService;
import org.module.client.vo.OutBoundListVO;

public class OutBoundController implements OutBoundBLService{

	private OutBoundService outBound ;
	public OutBoundController(OutBoundService outBound) {
		super();
		this.outBound = outBound;
	}

	public OutBoundController() {
		this.outBound = new OutBound();
	}
	
	public boolean createTicket(String courier, String date,
			String destination,String car, String tansportListId, String carId) {
		// TODO Auto-generated method stub
		return outBound.createTicket(new OutBoundListVO(courier, date,
				destination, car, tansportListId,carId));
	}

}
