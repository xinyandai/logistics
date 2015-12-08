package org.module.client.businesslogic.managementbl.warehouseTicket;

import java.rmi.RemoteException;

import org.module.client.businesslogicservice.management.TicketAndorderVerify;
import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.GoDownEntryVO;
import org.module.common.dataservice.MyList;
import org.module.common.dataservice.ticketdataservice.GoDownEntryListService;
import org.module.common.po.GoDownEntryListPO;
import org.module.common.po.State;

public class GoDownEntryVerify  implements TicketAndorderVerify{
	
	private MyList<GoDownEntryVO> list;
	private GoDownEntryListService goDownEntry = new RmiClient().get(GoDownEntryListService.class);
	private WarehouseAdjust warehouse = new WarehouseAdjust();
	
	public MyList<GoDownEntryVO> getAll(){
		this.list = new MyList<GoDownEntryVO>();
		try {
			MyList<GoDownEntryListPO> pos = this.goDownEntry.getByState(State.SUBMITTED);
			for (GoDownEntryListPO goDownEntryListPO : pos) {
				list.add(new GoDownEntryVO(goDownEntryListPO));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return this.list;
	}
	
	public boolean pass(int[] indexes){
		try{
			for(int i = indexes.length-1; i>=0; i--){
				GoDownEntryVO vo = this.list.remove(indexes[i]);
				vo.setState(State.PASS);
				this.goDownEntry.update( vo.toPO() );
				this.warehouse.goDown(vo);
			}
		}catch (RemoteException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean unpass(int[] indexes){
		try{
			for(int i = indexes.length-1; i>=0; i--){
				GoDownEntryVO vo = this.list.remove(indexes[i]);
				vo.setState(State.UNPASS);
				this.goDownEntry.update( vo.toPO() );
			}
		}catch (RemoteException e) {
			e.printStackTrace();
		}
		return true;
	}
}
