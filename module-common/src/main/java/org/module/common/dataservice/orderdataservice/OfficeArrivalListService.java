package org.module.common.dataservice.orderdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.module.common.dataservice.MyList;
import org.module.common.po.OfficeArrivalListPO;
import org.module.common.po.State;


public interface OfficeArrivalListService extends Remote{
	/**
	 * 前置：无
	 * 后置：返回所有PO
	 * @return
	 */
	public ArrayList<OfficeArrivalListPO> getAll()  throws RemoteException;
	/**
	 * 前置：无
	 * 后置：返回所有PO
	 * @return
	 */
	public ArrayList<OfficeArrivalListPO> getAll(String w)  throws RemoteException;
	/**
	 * 前置：不存在相同ID的寄件单
	 * 后置：增加一个PO
	 * @return
	 */
    public boolean add(OfficeArrivalListPO o) throws RemoteException;
    /**
	 * 前置：欲修改的PO存在
	 * 后置：更新PO信息
	 * @param old
	 * @param newone
	 * @return
	 */
	public boolean update(OfficeArrivalListPO newone) throws RemoteException;
	
	/**
     * 根据状态查找
     * @param s
     * @return
     */
	public MyList<OfficeArrivalListPO> getByState(State s)  throws RemoteException;
    
}
