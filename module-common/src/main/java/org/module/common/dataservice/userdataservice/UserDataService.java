package org.module.common.dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.module.common.dataservice.MyList;
import org.module.common.po.UserPO;



public interface UserDataService extends Remote{

	
	/**
	 * 前置：无
	 * 后置：返回所有PO组成的序列化列表
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
	 * 前置：id符合规范
	 * 后置：查找并返回对应PO
	 * @param id userPO唯一标识符
	 * @return PO
	 */
	public UserPO find(String id)throws RemoteException;
	/**
	 * 前置：存在相同ID的UserPO
	 * 后置：删除一个PO根据操作结果返回
	 * @param user
	 * @return
	 */
	public boolean delete(String id)throws RemoteException;
	/**
	 * 前置：存在相同id的PO
	 * 后置：更新一个PO并根据操作结果返回
	 * @param user 修改成功返回true
	 * @return
	 */
	public boolean update(UserPO old)throws RemoteException;
	/**
	 * 前置：存在相同ID的UserPO
	 * 后置：删除所有具有对应ID值的PO根据操作结果返回
	 * @param ids
	 * @return
	 */
	public boolean delete(MyList<String> ids)throws RemoteException;
}
