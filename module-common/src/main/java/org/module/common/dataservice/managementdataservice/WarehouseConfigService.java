package org.module.common.dataservice.managementdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.module.common.dataservice.MyList;
import org.module.common.po.WarehouseConfigPO;

public interface WarehouseConfigService extends Remote{
	/**
	 * 
	 * @return 返回所有的仓库配置信息
	 * @throws RemoteException
	 */
	public MyList<WarehouseConfigPO> getAll()throws RemoteException;
	/**
	 * 
	 * @param id 对应的中转中心ID （一个中转中心就一个仓库，故等同于仓库ID）
 	 * @return 
	 * @throws RemoteException
	 */
	public WarehouseConfigPO find(String id)throws RemoteException;
	
	/**
	 * 更新
	 * @param warehouseConfig ID在文件总存在的PO
	 * @return
	 * @throws RemoteException
	 */
	public boolean update(WarehouseConfigPO warehouseConfig)throws RemoteException;
	
	/**
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
