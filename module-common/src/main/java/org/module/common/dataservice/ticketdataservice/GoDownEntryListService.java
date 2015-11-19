package org.module.common.dataservice.ticketdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.module.common.po.GoDownEntryListPO;
import org.module.common.po.State;



public interface GoDownEntryListService {
	/**
	 * 前置：无
	 * 后置：返回所有PO
	 * @return 所有的列表信息
	 */
	public ArrayList<GoDownEntryListPO> getAll()throws RemoteException;
	/**
	 * 前置：数据库中不含有相同ID的PO
	 * 后置：增加一个PO
	 * @param   欲增加的持久化对象
	 * @return  添加成功返回true
	 */
	public boolean add(GoDownEntryListPO ticket)throws RemoteException;
	
	/**
	 * 前置：数据库中含有该PO
	 * 后置：删除一个PO
	 * @param   欲删除的持久化对象
	 * @return  添加成功返回true
	 */
	/*
	public boolean delete(GoDownEntryListPO ticket)throws RemoteException;*/
	
	/**
	 * 前置：该PO存在于数据库
	 * 后置：修改一个PO
	 * @param user 修改成功返回true
	 * @return
	 */
	public boolean update(GoDownEntryListPO newone)throws RemoteException;
	/**
     * 根据状态查找
     * @param s
     * @return
     */
	public ArrayList<GoDownEntryListPO> getByState(State s);
}
