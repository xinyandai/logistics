package org.module.common.dataservice.managementdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.module.common.dataservice.MyList;
import org.module.common.po.WarehouseConfigPO;

public interface WarehouseConfigDataService extends Remote{
	/**
	 * 前置：无
	 * 后置：查找并返回所有WarehouseConfigPO
	 * @return 返回所有的仓库配置信息
	 * @throws RemoteException
	 */
	public MyList<WarehouseConfigPO> getAll()throws RemoteException;
	/**
	 * 前置：ID所指定的仓库配置信息PO存在
	 * 后置：查找并返回对应PO
	 * @param id 对应的中转中心ID （一个中转中心就一个仓库，故等同于仓库ID）
 	 * @return 
	 * @throws RemoteException
	 */
	public WarehouseConfigPO find(String id)throws RemoteException;
	
	/**
	 * 
	 * 前置：ID所指定的仓库配置信息PO存在
	 * 后置：更新PO,根据操作结果返回
	 * @param warehouseConfig ID在文件中存在的PO
	 * @return
	 * @throws RemoteException
	 */
	public boolean update(WarehouseConfigPO warehouseConfig)throws RemoteException;
	
	/**
	 * 前置： 相同仓库名的仓库配置PO不存在
	 * 后置： 增加一个PO，根据操作结果返回
	 * 当新增加一个中转中心
	 * 自动添加一个仓库
	 * 只有一个默认区
	 * 默认大小为100
	 * @param warehouseConfig
	 * @return
	 * @throws RemoteException
	 */
	public boolean add(WarehouseConfigPO warehouseConfig)throws RemoteException;
	
	
}
