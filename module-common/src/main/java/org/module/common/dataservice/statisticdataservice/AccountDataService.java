package org.module.common.dataservice.statisticdataservice;

import java.rmi.RemoteException;

import org.module.common.dataservice.MyList;
import org.module.common.po.AccountPO;




public interface AccountDataService {
	/**
	 * 前置：无
	 * 后置：返回所有PO
	 * @return 所有的列表信息
	 */
	public MyList<AccountPO> getAll() throws RemoteException;
	/**
	 * 前置：数据库中不含有相同ID的PO
	 * 后置：增加一个PO
	 * @param   欲增加的持久化对象
	 * @return  添加成功返回true
	 */
	public boolean add(AccountPO ticket) throws RemoteException;
	
	/**
	 * 前置：数据库中含有该PO
	 * 后置：删除一个PO
	 * @param   欲删除的持久化对象
	 * @return  添加成功返回true
	 */
	
	public boolean delete(String ticket) throws RemoteException;
	/**
	 * 前置：数据库中含有这些PO
	 * 后置：删除这些PO
	 * @param ticket
	 * @return
	 */
	public boolean delete(MyList<String> ticket) throws RemoteException;
	/**
	 * 前置：该PO存在于数据库
	 * 后置：修改一个PO
	 * @param user 修改成功返回true
	 * @return
	 */
	public boolean update(AccountPO newone) throws RemoteException;
	
	public MyList<AccountPO> fuzzusearch(String key) throws RemoteException;
}
