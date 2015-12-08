package org.module.client.businesslogic.ticketbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.module.client.businesslogicservice.ticket.GoDownEntryService;
import org.module.client.javaRMI.RmiClient;
import org.module.client.presentation.DateTransferHelper;
import org.module.client.vo.GoDownEntryVO;
import org.module.common.dataservice.ticketdataservice.GoDownEntryListService;
import org.module.common.po.GoDownEntryListPO;

public class GoDownEntry implements GoDownEntryService {

	private GoDownEntryListService data;
	
	public GoDownEntry(){
		this.data = new RmiClient().get(GoDownEntryListService.class);
	}
	
	public boolean createTicket(GoDownEntryVO goDownEntryVO) {
		try {
			return data.add(
					goDownEntryVO.toPO()
					);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<GoDownEntryVO> getAll(long start , long end) {
		ArrayList<GoDownEntryVO> re = new ArrayList<GoDownEntryVO>();
		try {
			ArrayList<GoDownEntryListPO> pos = this.data.getAll();
			for (GoDownEntryListPO goDownEntryListPO : pos) {
				/**
				 * 把时间转换为毫秒比较
				 */
	            long time = DateTransferHelper.getDate(goDownEntryListPO.getDate()).getTime();
				if(time<=end && time>=start){
					re.add(new GoDownEntryVO(goDownEntryListPO));
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return re;
	}

	public boolean update(GoDownEntryVO vo) {
		// TODO Auto-generated method stub
		try {
			return this.data.update(vo.toPO());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
