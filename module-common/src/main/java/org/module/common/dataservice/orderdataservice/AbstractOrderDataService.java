package org.module.common.dataservice.orderdataservice;

import java.rmi.RemoteException;

import org.module.common.dataservice.MyList;
import org.module.common.po.AbstractPO;
import org.module.common.po.State;

public interface AbstractOrderDataService<T extends AbstractPO> {
	 
		/**
		 * 前置：无
		 * 后置：返回所有PO组成的序列化列表
		 * @return
		 * @throws RemoteException 
		 */
		public MyList<T> getAll() throws RemoteException;
		/**
		 * 前置：w所指定的订单填写人有已填写订单
		 * 后置：查找并返回所有PO组成的序列化列表
		 * @return
		 * @throws RemoteException 
		 */
		public MyList<T> getAll(String w) throws RemoteException;
		/**
		 * 前置：文件中不存在相同ID的寄件单
		 * 后置：增加一个PO，根据操作结果返回
		 * @return
		 */
	    public boolean add(T o) throws RemoteException;
	    /**
		 * 前置：与欲修改的PO相同ID的PO存在
		 * 后置：更新PO信息，根据操作结果返回
		 * @param newone
		 * @return
		 */
		public boolean update(T newone)  throws RemoteException;
		
	    /**
	     * 前置：对应状态合法
		 * 后置：查找对应状态PO，返回序列化列表
	     * 根据状态查找
	     * @param s
	     * @return
	     */
		public MyList<T> getByState(State s)   throws RemoteException;
}
