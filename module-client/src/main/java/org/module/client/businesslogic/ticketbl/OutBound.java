package org.module.client.businesslogic.ticketbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.module.client.businesslogicservice.ticket.OutBoundService;
import org.module.client.javaRMI.RmiClient;
import org.module.client.main.Main;
import org.module.client.presentation.DateTransferHelper;
import org.module.client.vo.OutBoundListVO;
import org.module.common.dataservice.ticketdataservice.OutBoundListService;
import org.module.common.po.OutBoundListPO;

public class OutBound implements OutBoundService {

	private OutBoundListService data;
	
	public OutBound(){
		this.data = new RmiClient().get(OutBoundListService.class);
	}
	
	public boolean createTicket(OutBoundListVO outBoundListVO) {
		try {
			return data.add(
					
							outBoundListVO.toPO()
							
					);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(OutBoundListVO vo) {
		try {
			return this.data.update(vo.toPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<OutBoundListVO> getAll(long start , long end) {
		ArrayList<OutBoundListVO> re = new ArrayList<OutBoundListVO>();
		try {
			ArrayList<OutBoundListPO> pos = this.data.getAll(Main.currentUser.getDepartmeny());
			for (OutBoundListPO goDownEntryListPO : pos) {
				/**
				 * 把时间转换为毫秒比较
				 */
	            long time = DateTransferHelper.getDate(goDownEntryListPO.getDate()).getTime();
				if(time<=end && time>=start){
					re.add(new OutBoundListVO(goDownEntryListPO));
				}
				
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return re;
	}

}
