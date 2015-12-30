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
		 * 后置：查找所有物流信息组成序列化列表并返回
		 * @return
		 */
		public MyList<LogisticsPO> getAll()throws RemoteException;
		/**
		 * 前置：相同ID值的订单号PO存在
		 * 后置：查找相同ID的订单PO，返回订单PO
		 * @return
		 */
		public LogisticsPO getOrder(String id)throws RemoteException;
		/**
		 * 前置：欲修改的相同ID值的PO存在
		 * 后置：更新PO信息，根据操作结果返回
		 * @param newone 更新后的PO
		 * @return 
		 */
		public boolean updata(LogisticsPO newone)throws RemoteException;
		
		/**
		 * 创建新的可查询的物流
		 * 前置：相同ID值的PO在数据文件中不存在
		 * 后置：创建新的 PO并存储，根据操作结果返回
		 * @param newone 新的PO
		 * @return 
		 * @throws RemoteException
		 */
		public boolean add(LogisticsPO newone)throws RemoteException;
}
