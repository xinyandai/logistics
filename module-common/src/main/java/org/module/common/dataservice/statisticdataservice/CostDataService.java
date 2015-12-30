package org.module.common.dataservice.statisticdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.module.common.dataservice.MyList;
import org.module.common.po.CostListPO;
import org.module.common.po.State;



public interface CostDataService extends Remote{

	/**
	 * 前置：数据库中不存在该PO的ID
	 * 后置：增加一个PO，根据操作结果返回
	 * @param c
	 * @return
	 */
	public boolean addCostList(CostListPO c)throws RemoteException;
	/**
	 * 前置：无
	 * 后置：返回所有PO组成的序列化列表
	 * @return
	 */
	public MyList<CostListPO> getAll()throws RemoteException;
	/**
	 *前置：对应状态合法
	 *后置：查找对应状态PO，返回序列化列表
	 * @return 所有的列表信息
	 */
	public MyList<CostListPO> getAllBySatte(State state)throws RemoteException;
	/**
	 * 更新未审批或者审批未通过的单据
	 * 前置： 该PO的ID相同的PO已经存在于文件中
	 * 后置：更新文件中PO，，根据操作结果返回
	 * @param newone
	 * @return
	 * @throws RemoteException
	 */
	public boolean update(CostListPO newone)throws RemoteException;
}
