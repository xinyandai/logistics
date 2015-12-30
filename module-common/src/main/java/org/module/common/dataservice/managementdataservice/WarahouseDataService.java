package org.module.common.dataservice.managementdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.module.common.dataservice.MyList;
import org.module.common.po.WarehousePO;

public interface  WarahouseDataService  extends Remote{
	
	/**
	 * 前置：id所指明的仓库名称符合格式并存在
	 * 后置：查找并返回所有库存的序列化列表
	 * @param id 仓库ID
	 * @return
	 * @throws RemoteException
	 */
	public MyList<WarehousePO> getAll(String id)throws RemoteException;
	
	/**
	 * 前置：与所增加的PO的唯一标识符相同的po不存在于数据文件中
	 * 后置：增加一个PO，根据操作结果返回PO
	 * @param cp 仓库库存PO
	 * @return
	 * @throws RemoteException
	 */
	public boolean add(WarehousePO cp)throws RemoteException;
	
	/**
	 * 前置： 所需要删除的PO相同唯一标识符的PO已经存在与数据文件中
	 * 后置：删除一个PO，根据操作结果返回PO
	 * @param cp 欲删除的PO
	 * @return
	 * @throws RemoteException
	 */
	public boolean delete(WarehousePO cp)throws RemoteException;
	
	/**
	 * 前置： 相同唯一标识符的PO已经存在于数据文件中
	 * 后置： 更新PO，根据操作结果返回PO
	 * @param newone 新的PO
	 * @return
	 * @throws RemoteException
	 */
	public boolean update(WarehousePO newone)throws RemoteException;
	
	/**
	 * 前置：tranCenterID所指明的仓库名称符合格式并存在,id所指明的物流单号在库存中存在
	 * 后置：查找并返回对应库存单号信息PO
	 * @param tranCenterID 仓库ID
	 * @param id 对应仓库库存中的物流单号
	 * @return
	 * @throws RemoteException
	 */
	public WarehousePO find(String tranCenterID,String id)throws RemoteException;
}
