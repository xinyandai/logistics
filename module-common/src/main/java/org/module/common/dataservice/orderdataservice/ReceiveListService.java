package org.module.common.dataservice.orderdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.module.common.dataservice.MyList;
import org.module.common.po.ReceivingListPO;
import org.module.common.po.State;


/**
 * 收件单
 * @author 
 *
 */
public interface ReceiveListService extends Remote{
	/**
	 * 前置：无
	 * 后置：返回所有PO
	 * @return
	 */
	public MyList<ReceivingListPO> getAll() throws RemoteException;
	/**
	 * 前置：不存在相同ID的收件单
	 * 后置：增加一个PO
	 * @return
	 */
    public boolean add(ReceivingListPO o) throws RemoteException;
    /**
	 * 前置：欲修改的PO存在
	 * 后置：更新PO信息
	 * @param old
	 * @param newone
	 * @return
	 */
	public boolean update(ReceivingListPO newone) throws RemoteException;
	
	/**
     * 根据状态查找
     * @param s
     * @return
     */
	public MyList<ReceivingListPO> getByState(State s) throws RemoteException;
    
}