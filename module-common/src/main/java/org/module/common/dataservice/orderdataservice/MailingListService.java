package org.module.common.dataservice.orderdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.module.common.po.MailingListPO;
import org.module.common.po.State;


/**
 * 寄件单
 * @author 
 *
 */
public interface MailingListService extends Remote{
 
	/**
	 * 前置：无
	 * 后置：返回所有PO
	 * @return
	 * @throws RemoteException 
	 */
	public ArrayList<MailingListPO> getAll() throws RemoteException;
	/**
	 * 前置：无
	 * 后置：返回所有PO
	 * @return
	 * @throws RemoteException 
	 */
	public ArrayList<MailingListPO> getAll(String w) throws RemoteException;
	/**
	 * 前置：不存在相同ID的寄件单
	 * 后置：增加一个PO
	 * @return
	 */
    public boolean add(MailingListPO o) throws RemoteException;
    /**
	 * 前置：欲修改的PO存在
	 * 后置：更新PO信息
	 * @param old
	 * @param newone
	 * @return
	 */
	public boolean update(MailingListPO newone)  throws RemoteException;
	
    /**
     * 根据状态查找
     * @param s
     * @return
     */
	public ArrayList<MailingListPO> getByState(State s)   throws RemoteException;
  
}

