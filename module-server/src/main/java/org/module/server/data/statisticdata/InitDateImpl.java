package org.module.server.data.statisticdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.module.common.dataservice.MyList;
import org.module.common.dataservice.statisticdataservice.InitDateService;
import org.module.common.po.AccountPO;
import org.module.common.po.CarPO;
import org.module.common.po.DepartmentPO;
import org.module.common.po.StuffPO;
import org.module.common.po.WarehousePO;

public class InitDateImpl extends UnicastRemoteObject implements InitDateService {

	public InitDateImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 5130502560682465347L;

	

	public boolean init() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public MyList<CarPO> getInitCar() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public MyList<StuffPO> getInitStuff() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public MyList<DepartmentPO> getInitDepartment() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public MyList<AccountPO> getInitAccount() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public MyList<WarehousePO> getInitWarehouse() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
