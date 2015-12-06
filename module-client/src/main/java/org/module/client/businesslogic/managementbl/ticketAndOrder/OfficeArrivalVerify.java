package org.module.client.businesslogic.managementbl.ticketAndOrder;

import java.rmi.RemoteException;
import java.util.Date;

import org.module.client.businesslogicservice.management.TicketAndorderVerify;
import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.LogisticsVO;
import org.module.client.vo.OfficeArrivalListVO;
import org.module.common.dataservice.MyList;
import org.module.common.dataservice.orderdataservice.OfficeArrivalListService;
import org.module.common.dataservice.orderdataservice.TransportListService;
import org.module.common.po.OfficeArrivalListPO;
import org.module.common.po.State;

public class OfficeArrivalVerify  implements TicketAndorderVerify{
	
	private OfficeArrivalListService officeArrivalListDataGetter = new RmiClient().get(OfficeArrivalListService.class);
	private TransportListService transportListDataGetter = new RmiClient().get(TransportListService.class);
	private MyList<OfficeArrivalListVO> list ;
	private LogisticsState logistics = new LogisticsState();
	private DepartmentFinder departmentFinder = new DepartmentFinder();
	
	
	
	public MyList<OfficeArrivalListVO> getAll(){
		list = new MyList<OfficeArrivalListVO>();
		try {
			MyList<OfficeArrivalListPO> pos = this.officeArrivalListDataGetter.getByState(State.SUBMITTED);
			for (OfficeArrivalListPO officeArrivalListPO : pos) {
				list.add(new OfficeArrivalListVO(officeArrivalListPO));
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
				OfficeArrivalListVO officeArrivalListVO = this.list.remove(index[i]);
				//单据状态更新
				this.officeArrivalListDataGetter.update(officeArrivalListVO.toPO(State.UNPASS));
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
	 */
	public boolean pass(int[] index) {
		if(this.list==null){
			this.list = this.getAll();
		}
		
		try {
			for(int i = index.length-1;  i>=0; i--){
				OfficeArrivalListVO officeArrivalListVO = this.list.remove(index[i]);
				//单据状态更新
				this.officeArrivalListDataGetter.update(officeArrivalListVO.toPO(State.PASS));
				//更新物流
				this.updateLogistics(officeArrivalListVO);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return true;
		
	}
	
	/**
	 * 更新物流信息
	 * @param officeArrivalListVO
	 */
	private void updateLogistics(OfficeArrivalListVO officeArrivalListVO){
		
		String departmentName = departmentFinder.getNameById( officeArrivalListVO.getDepartmentId() );
		String departmentLocation = this.departmentFinder.getCityById( officeArrivalListVO.getDepartmentId() );
		String date = new Date().toString();
		try {
			//默认为中转单
			//根据中转单查找所有物流单号
			//更新物流
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
