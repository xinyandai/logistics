package org.module.common.dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.module.common.dataservice.MyList;
import org.module.common.po.UserPO;



public interface UserDataService extends Remote{

	
	/**
	 * 前置：无
	 * 后置：返回所有PO
	 * @return 所有的用户信息
	 */
	public MyList<UserPO> allUsers()throws RemoteException;
	/**
	 * 前置：不存在该PO的ID
	 * 后置：增加一个PO
	 * @param user 欲增加的用户
	 * @return  添加成功返回true
	 */
	public boolean add(UserPO user)throws RemoteException;
	/**
	 * 前置：无
	 * 后置：返回用户信息
	 * @param id
	 * @return PO
	 */
	public UserPO find(String id)throws RemoteException;
	/**
	 * 前置：存在该UserPO
	 * 后置：删除一个PO
	 * @param user
	 * @return
	 */
	public boolean delete(String id)throws RemoteException;
	/**
	 * 前置：存在该PO的id
	 * 后置：更新一个PO
	 * @param user 修改成功返回true
	 * @return
	 */
	public boolean update(UserPO old)throws RemoteException;
	/**
	 * 
	 * @param ids
	 * @return
	 */
	public boolean delete(MyList<String> ids)throws RemoteException;
}
