package org.module.client.businesslogic.ticketbl;

import java.rmi.RemoteException;

import org.module.client.businesslogicservice.ticket.OutBoundService;
import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.OutBoundListVO;
import org.module.common.dataservice.ticketdataservice.OutBoundListService;
import org.module.common.po.State;

public class OutBound implements OutBoundService {

	private OutBoundListService data;
	
	public OutBound(){
		this.data = new RmiClient().get(OutBoundListService.class);
	}
	
	public boolean createTicket(OutBoundListVO outBoundListVO) {
		try {
			return data.add(
					
							outBoundListVO.toPO(State.SUBMITTED)
							
					);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

}
