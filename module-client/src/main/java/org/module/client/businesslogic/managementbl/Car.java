package org.module.client.businesslogic.managementbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.module.client.businesslogicservice.management.CarsManageService;
import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.CarVO;
import org.module.common.dataservice.MyList;
import org.module.common.dataservice.managementdataservice.CarDataService;
import org.module.common.po.CarPO;

public class Car implements CarsManageService{
	private CarDataService data = new RmiClient().get(CarDataService.class);;
	public ArrayList<CarVO> showAll() {
		ArrayList<CarVO> vos = new ArrayList<CarVO>();
		ArrayList<CarPO> pos;
		try {
			pos = this.data.getAll();
			for (CarPO carPO : pos) {
				vos.add(new CarVO(carPO.getId(), carPO.getLicense(), carPO.getTime()));
		    }
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return vos;
	}

	public boolean add(CarVO carVO) {
		
		try {
			return data.add(new CarPO(carVO.getId(), carVO.getLicense(), carVO.getTime()));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean modify(CarVO carVO) {
		try {
			return this.data.update( new CarPO(carVO.getId(), carVO.getLicense(), carVO.getTime()));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(String id) {
		
		try {
			return this.data.delete(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(MyList<String> id) {
		try {
			return this.data.delete(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<CarVO> fuzzySearch(String s) {
		return null;
	}

	

}
