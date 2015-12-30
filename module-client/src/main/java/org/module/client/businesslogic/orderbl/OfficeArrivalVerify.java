package org.module.client.businesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.Date;

import org.module.client.businesslogic.deparmentbl.DepartmentFinder;
import org.module.client.businesslogic.logisticsbl.LogisticsState;
import org.module.client.businesslogicservice.management.TicketAndorderVerify;
import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.LogisticsVO;
import org.module.client.vo.OfficeArrivalListVO;
import org.module.common.dataservice.MyList;
import org.module.common.dataservice.orderdataservice.OfficeArrivalListService;
import org.module.common.dataservice.orderdataservice.TransportListService;
import org.module.common.po.OfficeArrivalListPO;
import org.module.common.po.State;
import org.module.common.po.TransportListPO;

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
		boolean re = true;
		try {
			for(int i = index.length-1;  i>=0; i--){
				OfficeArrivalListVO officeArrivalListVO = this.list.remove(index[i]);
				//单据状态更新
				re = re&&this.officeArrivalListDataGetter.update(officeArrivalListVO.toPO(State.UNPASS));
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
		boolean re = true;
		try {
			for(int i = index.length-1;  i>=0; i--){
				OfficeArrivalListVO officeArrivalListVO = this.list.get(index[i]);
				//更新物流
				re = re && this.updateLogistics(officeArrivalListVO);
				if(re){
					//单据状态更新
					this.list.remove(index[i]);
					re = re && this.officeArrivalListDataGetter.update(officeArrivalListVO.toPO(State.PASS));
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return re;
		
	}
	
	/**
	 * 更新物流信息
	 * @param officeArrivalListVO
	 */
	private boolean updateLogistics(OfficeArrivalListVO officeArrivalListVO){
		
		String departmentName = departmentFinder.getNameById( officeArrivalListVO.getDepartmentId() );
		String departmentLocation = this.departmentFinder.getLocationById( officeArrivalListVO.getDepartmentId() );
		String date = new Date().toString();
		try {
			//默认为中转单
			//根据中转单查找所有物流单号
			//更新物流
			boolean re = true;
			TransportListPO vo = this.transportListDataGetter.findById(officeArrivalListVO.getTransportListId());
			if(vo==null){
				return false;
			}
			String[] allOrders = vo.getShippingId();
			for (String order : allOrders) {
				LogisticsVO logisticsVO = this.logistics.find(order);
				if(logisticsVO!=null){
					logisticsVO.addLocationAndTime( "快递已到达"+departmentName, date);
					logisticsVO.setLocation(departmentLocation);
					this.logistics.update(logisticsVO);
				}else{
					re = false;
				}
				
			}
			return re;
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		return true;
		
		
	}
	
	
	
}
