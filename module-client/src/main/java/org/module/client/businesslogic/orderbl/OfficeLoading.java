package org.module.client.businesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.module.client.businesslogicservice.order.OfficeLoadingService;
import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.OfficeLoadingListVO;
import org.module.common.dataservice.orderdataservice.OfficeLoadingListService;
import org.module.common.po.OfficeLoadingListPO;
import org.module.common.po.State;

public class OfficeLoading implements OfficeLoadingService {
	private OfficeLoadingListService officeLoadingData ;
	public OfficeLoading() {
		officeLoadingData = new RmiClient().get(OfficeLoadingListService.class);
	}
	public boolean creat(OfficeLoadingListVO o) {
		// TODO Auto-generated method stub
		OfficeLoadingListPO newPO = new OfficeLoadingListPO(o.getLoadingDate(),o.getOfficeId()
				,o.getTrucksId(),o.getCity(),o.getLocation(),o.getCarId(),o.getSupervision(),o.getEscort()
				,o.getShippingId(),o.getPrice(),o.getState()); 
		try {
			return officeLoadingData.add(newPO);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<OfficeLoadingListVO> getAll(State s) {
		// TODO Auto-generated method stub
		ArrayList<OfficeLoadingListVO> newVOs = new ArrayList<OfficeLoadingListVO>();
		ArrayList<OfficeLoadingListPO> POs = null;
		try {
			 POs = officeLoadingData.getByState(s);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		for(int i =0;i<POs.size();i++){
			newVOs.add(new OfficeLoadingListVO(POs.get(i).getLoadingDate(),POs.get(i).getOfficeId()
					,POs.get(i).getTrucksId(),POs.get(i).getCity(),POs.get(i).getLocation(),POs.get(i).getCarId(),POs.get(i).getSupervision(),POs.get(i).getEscort()
					,POs.get(i).getShippingId(),POs.get(i).getPrice(),POs.get(i).getState().toString()));
		}
		return newVOs;
	}

}
