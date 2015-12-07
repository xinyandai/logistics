package org.module.common.dataservice.managementdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.module.common.dataservice.MyList;
import org.module.common.po.WarehousePO;

public interface  WarahouseDataService  extends Remote{
	public MyList<WarehousePO> getAll(String id)throws RemoteException;
	public boolean add(WarehousePO cp)throws RemoteException;
	public boolean delete(WarehousePO cp)throws RemoteException;
	public boolean update(WarehousePO newone)throws RemoteException;
	public WarehousePO find(String tranCenterID,String id)throws RemoteException;
}
