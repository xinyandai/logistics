package org.module.common.dataservice.statisticdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.module.common.dataservice.MyList;
import org.module.common.po.CostListPO;



public interface CostDataService extends Remote{

	/**
	 * 前置：数据库中不存在该PO的ID
	 * 后置：增加一个PO
	 * @param c
	 * @return
	 */
	public boolean addCostList(CostListPO c)throws RemoteException;
	/**
	 * 前置：无
	 * 后置：返回所有IO
	 * @return
	 */
	public MyList<CostListPO> getAll()throws RemoteException;
}
