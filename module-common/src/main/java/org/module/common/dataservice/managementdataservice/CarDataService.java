package org.module.common.dataservice.managementdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.module.common.dataservice.MyList;
import org.module.common.po.CarPO;


/**
* 20151022
* 车辆信息
* @author 颜
*/
public interface CarDataService  extends Remote{
	/**
	 * 前置：无
	 * 后置：查找并返回所有汽车PO
	 * @param s
	 * @return
	 */
	public MyList<CarPO> getAll()throws RemoteException;
	/**
	 * 前置：数据文件中不存在相同ID值的PO
	 * 后置：增加一个PO，根据操作结果返回
	 * @param cp
	 * @return
	 */
	public boolean add(CarPO cp)throws RemoteException;
	/**
	 * 前置：数据库中已经存在相同ID值的PO
	 * 后置：删除一个PO，根据操作结果返回
	 * @param cp 欲删除掉PO的ID
	 * @return
	 */
	public boolean delete(String id)throws RemoteException;
	/**
	 * 前置：数据库中存在相同ID值的PO
	 * 后置：删除这些PO并保存，根据操作结果返回
	 * @return
	 */
	public boolean delete(MyList<String>  id)throws RemoteException;
	/**
	 * 前置：数据库中存在相同ID值的PO
	 * 后置：修改该PO并保存，根据操作结果返回
	 * @param newone
	 * @return
	 */
	public boolean update(CarPO newone)throws RemoteException;
}
