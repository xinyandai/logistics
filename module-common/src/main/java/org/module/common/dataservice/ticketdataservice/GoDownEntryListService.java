package org.module.common.dataservice.ticketdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.module.common.dataservice.MyList;
import org.module.common.dataservice.orderdataservice.AbstractOrderDataService;
import org.module.common.po.GoDownEntryListPO;
import org.module.common.po.State;



public interface GoDownEntryListService extends Remote,AbstractOrderDataService<GoDownEntryListPO>{
	/**
	 * 前置：无
	 * 后置：返回所有PO组成的序列化列表
	 * @return 所有的列表信息
	 */
	public MyList<GoDownEntryListPO> getAll()throws RemoteException;
	
	
	/**
	 * 前置：trancenterID所指向的中转中心已初始化
	 * 后置：返回所有PO组成的序列化列表
	 * @return 所有的列表信息
	 */
	public MyList<GoDownEntryListPO> getAll(String trancenterID)throws RemoteException; 
	/**
	 * 前置：数据库中不含有相同ID的PO
	 * 后置：增加一个PO，并根据操作结果返回
	 * @param   欲增加的持久化对象
	 * @return  添加成功返回true
	 */
	public boolean add(GoDownEntryListPO ticket)throws RemoteException;
	
	/**
	 * 前置：数据库中含有相同id值的PO
	 * 后置：删除一个PO，并根据操作结果返回
	 * @param   欲删除的持久化对象
	 * @return  添加成功返回true
	 */
	/*
	public boolean delete(GoDownEntryListPO ticket)throws RemoteException;*/
	
	/**
	 * 前置：相同ID值的PO存在于数据库
	 * 后置：修改一个PO，并根据操作结果返回
	 * @param user 修改成功返回true
	 * @return
	 */
	public boolean update(GoDownEntryListPO newone)throws RemoteException;
	/**
	 * 前置：对应状态合法
	 * 后置：查找对应状态PO，返回序列化列表
     * 根据状态查找
     * @param s
     * @return
	 * @throws RemoteException 
     */
	public MyList<GoDownEntryListPO> getByState(State s) throws RemoteException;
	
}
