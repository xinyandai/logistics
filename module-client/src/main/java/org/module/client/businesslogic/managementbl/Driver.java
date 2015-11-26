package org.module.client.businesslogic.managementbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.module.client.businesslogicservice.management.DriversManageService;
import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.DriverVO;
import org.module.common.dataservice.MyList;
import org.module.common.dataservice.managementdataservice.DriversDataService;
import org.module.common.po.DriverPO;

public class Driver implements DriversManageService{

	private DriversDataService data = new RmiClient().get(DriversDataService.class);
	public ArrayList<DriverVO> showAll() {
		ArrayList<DriverVO> vos = new ArrayList<DriverVO>();
		try {
			ArrayList<DriverPO> pos = this.data.getAll();
			for (DriverPO driverPO : pos) {
				vos.add(
						new DriverVO(
								driverPO.getId(),
								driverPO.getName(),
								driverPO.getBirthday(),
								driverPO.getIdcard(),
								driverPO.getPhone(),
								driverPO.getGender(),
								driverPO.getDate()
								));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return vos;
	}

	public boolean add(DriverVO driverVO) {
		DriverPO po =new DriverPO(
				driverVO.getId(),
				driverVO.getName(),
				driverVO.getBirthday(),
				driverVO.getIdcard(),
				driverVO.getPhone(),
				driverVO.getGender(),
				driverVO.getDate()
				);
		try {
			return this.data.add(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean modify(DriverVO driverVO) {
		DriverPO po =new DriverPO(
				driverVO.getId(),
				driverVO.getName(),
				driverVO.getBirthday(),
				driverVO.getIdcard(),
				driverVO.getPhone(),
				driverVO.getGender(),
				driverVO.getDate()
				);
		try {
			return this.data.update(po);
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

	public boolean delete(MyList<String> al) {
		try {
			return this.data.delete(al);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<DriverVO> fuzzySearch(String s) {
		return null;
	}

}
