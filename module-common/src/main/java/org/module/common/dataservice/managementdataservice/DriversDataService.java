package org.module.common.dataservice.managementdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.module.common.dataservice.MyList;
import org.module.common.po.DriverPO;


public interface DriversDataService  extends Remote{
	/**
	 * 前置：无
	 * 后置：查找并返回所有司机PO
	 * @param s
	 * @return
	 */
	public MyList<DriverPO> getAll()throws RemoteException;
	/**
	 * 前置：数据库中不存在相同ID值的PO
	 * 后置：增加一个PO，根据操作结果返回
	 * @param cp 司机PO
	 * @return
	 */
	public boolean add(DriverPO cp)throws RemoteException;
	/**
	 * 前置：数据库中已经存在相同ID值的PO
	 * 后置：删除一个PO，根据操作结果返回
	 * @param cp 司机PO的唯一标识符
	 * @return
	 */
	public boolean delete(String id)throws RemoteException;
	/**
	 * 前置：数据库中存在相同ID值的PO
	 * 后置：删除这些PO，根据操作结果返回
	 * @return 司机PO组成的唯一标识符组成的序列化列表
	 */
	public boolean delete(MyList<String> al)throws RemoteException;
	/**
	 * 前置：数据库中存在相同ID值的PO
	 * 后置：修改该PO，根据操作结果返回
	 * @param 司机PO
	 * @return
	 */
	public boolean update(DriverPO newone)throws RemoteException;
}

