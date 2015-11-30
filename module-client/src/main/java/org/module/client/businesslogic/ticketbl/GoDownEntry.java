package org.module.client.businesslogic.ticketbl;

import java.rmi.RemoteException;

import org.module.client.businesslogicservice.ticket.GoDownEntryService;
import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.GoDownEntryVO;
import org.module.common.dataservice.ticketdataservice.GoDownEntryListService;
import org.module.common.po.GoDownEntryListPO;
import org.module.common.po.State;

public class GoDownEntry implements GoDownEntryService {

	private GoDownEntryListService data;
	
	public GoDownEntry(){
		this.data = new RmiClient().get(GoDownEntryListService.class);
	}
	
	public boolean createTicket(GoDownEntryVO goDownEntryVO) {
		try {
			return data.add(
					new GoDownEntryListPO(
							goDownEntryVO.getWarehouseOfWhichTranCenter(),
							goDownEntryVO.getId(),
							goDownEntryVO.getDate(),
							goDownEntryVO.getDestination(),
							goDownEntryVO.getJia(),
							goDownEntryVO.getPai(),
							goDownEntryVO.getQu(),
							goDownEntryVO.getWei(),
							State.SUBMITTED
							)
					);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

}
