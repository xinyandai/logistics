package org.module.client.businesslogic.managementbl.ticketAndOrder;

import java.rmi.RemoteException;
import java.util.Date;

import org.module.client.businesslogicservice.management.TicketAndorderVerify;
import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.LogisticsVO;
import org.module.client.vo.TranCenterArrivalListVO;
import org.module.common.dataservice.MyList;
import org.module.common.dataservice.orderdataservice.TranCenterArrivalListService;
import org.module.common.dataservice.orderdataservice.TransportListService;
import org.module.common.po.State;
import org.module.common.po.TranCenterArrivalListPO;

public class TranCenterArrivalVerify  implements TicketAndorderVerify{
	
	private TranCenterArrivalListService arrivalListDataGetter = new RmiClient().get(TranCenterArrivalListService.class);
	private TransportListService transportListDataGetter = new RmiClient().get(TransportListService.class);
	private MyList<TranCenterArrivalListVO> list ;
	private LogisticsState logistics = new LogisticsState();
	private DepartmentFinder departmentFinder = new DepartmentFinder();
	
	public MyList<TranCenterArrivalListVO> getAll(){
		list = new MyList<TranCenterArrivalListVO>();
		try {
			MyList<TranCenterArrivalListPO> pos = this.arrivalListDataGetter.getByState(State.SUBMITTED);
			for (TranCenterArrivalListPO arrivalListPO : pos) {
				list.add(new TranCenterArrivalListVO(arrivalListPO));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public boolean unpass(int[] index){
		if(this.list==null){
			this.list = this.getAll();
		}
			
		try {
			for(int i = index.length-1;  i>=0; i--){
				TranCenterArrivalListVO arrivalListVO = this.list.remove(index[i]);
				//单据状态更新
				this.arrivalListDataGetter.update(arrivalListVO.toPO(State.UNPASS));
				
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
			
		return true;
		
	}
	
	
	/**
	 * @see DepartmentFinder
	 * @param index
	 * @return
	 * @throws RemoteException
	 */
	public boolean pass(int[] index){
		if(this.list==null){
			this.list = this.getAll();
		}
			
		try {
			for(int i = index.length-1;  i>=0; i--){
				TranCenterArrivalListVO officeArrivalListVO = this.list.remove(index[i]);
				//单据状态更新
				this.arrivalListDataGetter.update(officeArrivalListVO.toPO(State.PASS));
				//更新物流
				this.updateLogistics(officeArrivalListVO);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
			
		return true;
		
	}
	
	/**
	 * 更新物流信息
	 * @param officeArrivalListVO
	 */
	private void updateLogistics(TranCenterArrivalListVO officeArrivalListVO){
		
		String departmentName = departmentFinder.getNameById( officeArrivalListVO.getDepartmentId() );
		String departmentLocation = this.departmentFinder.getCityById( officeArrivalListVO.getDepartmentId() );
		String date = new Date().toString();
		try {
			String[] allOrders = this.transportListDataGetter.findById(officeArrivalListVO.getTransportListId()).getShippingId();
			for (String order : allOrders) {
				LogisticsVO logisticsVO = this.logistics.find(order);
				logisticsVO.addLocationAndTime( departmentName, date);
				logisticsVO.setLocation(departmentLocation);
				this.logistics.update(logisticsVO);
			}
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		
		
	}
	
}
