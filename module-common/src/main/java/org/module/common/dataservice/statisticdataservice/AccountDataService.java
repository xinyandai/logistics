package org.module.common.dataservice.statisticdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.module.common.dataservice.MyList;
import org.module.common.po.AccountPO;




public interface AccountDataService extends Remote {
	/**
	 * 前置：无
	 * 后置：返回所有PO组成的序列化列表
	 * @return 所有的列表信息
	 */
	public MyList<AccountPO> getAll() throws RemoteException;
	/**
	 * 前置：数据库中不含有相同ID的PO
	 * 后置：增加一个PO，根据操作结果返回
	 * @param   欲增加的持久化对象
	 * @return  添加成功返回true
	 */
	public boolean add(AccountPO ticket) throws RemoteException;
	
	/**
	 * 前置：数据库中含有相同ID值的PO
	 * 后置：删除一个PO，根据操作结果返回
	 * @param   欲删除的持久化对象
	 * @return  添加成功返回true
	 */
	
	public boolean delete(String ticket) throws RemoteException;
	/**
	 * 前置：数据库中含有相同ID值的PO
	 * 后置：删除这些PO，根据操作结果返回
	 * @param ticket ID的集合
	 * @return
	 */
	public boolean delete(MyList<String> ticket) throws RemoteException;
	/**
	 * 前置：相同ID的PO存在于数据库
	 * 后置：修改一个PO ，根据操作结果返回
	 * @param user 修改成功返回true
	 * @return
	 */
	public boolean update(AccountPO newone) throws RemoteException;
	/**
	 * 前置：关键字合法，与之匹配的PO在文件中 
	 * 后置：查找PO并组成序列化集合返回
	 * @param key 搜索关键字
	 * @return
	 * @throws RemoteException
	 */
	public MyList<AccountPO> fuzzusearch(String key) throws RemoteException;
	
	/**
	 * 前置：对应ID值的PO已经存在于数据文件中
	 * 后置：查找PO并返回
	 * @param s
	 * @return 为搜索到则返回NULL
	 */
	public AccountPO findById(String s) throws RemoteException;
}
