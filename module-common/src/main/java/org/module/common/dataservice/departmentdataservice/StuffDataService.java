package org.module.common.dataservice.departmentdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.module.common.dataservice.MyList;
import org.module.common.po.StuffPO;


/**
 * 20151022
 * 员工信息
 * @author 颜
 */
public interface StuffDataService extends Remote{
	
	/**
	 * 前置：无
	 * 后置：返回所有的员工PO信息
	 * @return 
	 */
	public MyList<StuffPO> getAll()throws RemoteException;
	/**
	 * 前置：同样ID的po在还未存在
	 * 后置：在数据中增加一个PO
	 * @param dp
	 * @return
	 */
	public boolean add(StuffPO dp)throws RemoteException;
	/**
	 * 前置：该PO已经存在于数据
	 * 后置：在数据中删除一个PO
	 * @param dp
	 * @return
	 */
	public boolean delete(String id)throws RemoteException;
	/**
	 * 前置：这些PO已经存在于数据
	 * 后置：在数据中删除这些PO
	 * @param al
	 * @return
	 */
	public boolean delete(MyList<String> id)throws RemoteException;
	/**
	 * 前置：该PO已经存在于数据
	 * 后置：在数据中修改一个PO
	 * @param 
	 * @return
	 */
	public boolean update(StuffPO one)throws RemoteException;
	/**
	 * 模糊匹配查找
	 * @param key
	 * @return
	 * @throws RemoteException
	 */
	public MyList<StuffPO> fuzzusearch(String key)throws RemoteException;
	
}
