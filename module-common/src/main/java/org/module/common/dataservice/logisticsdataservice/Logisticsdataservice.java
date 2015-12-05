package org.module.common.dataservice.logisticsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.module.common.dataservice.MyList;
import org.module.common.po.LogisticsPO;

/**
	 * 20151022
	 * 物流信息
	 * @author 颜
	 */
public interface Logisticsdataservice  extends Remote{
	
	

		/**
		 * 前置：无
		 * 后置：返回所有物流信息
		 * @return
		 */
		public MyList<LogisticsPO> getAll()throws RemoteException;
		/**
		 * 前置：订单号存在
		 * 后置：返回订单信息
		 * @return
		 */
		public LogisticsPO getOrder(String id)throws RemoteException;
		/**
		 * 前置：欲修改的PO存在
		 * 后置：更新PO信息
		 * @param newone
		 * @return
		 */
		public boolean updata(LogisticsPO newone)throws RemoteException;
		

		public boolean add(LogisticsPO newone)throws RemoteException;
}
