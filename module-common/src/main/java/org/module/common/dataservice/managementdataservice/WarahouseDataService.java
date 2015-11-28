package org.module.common.dataservice.managementdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.module.common.dataservice.MyList;
import org.module.common.po.BorderlinePO;
import org.module.common.po.WarehousePO;


/**
 * 20151022
 * 仓库信息
 * @author 颜
 */
public interface WarahouseDataService  extends Remote{
	/**
	 * 前置：无
	 * 后置：返回所有库存PO
	 * @return
	 */
	public ArrayList<WarehousePO> getAll()throws RemoteException;
	/**
	 * 前置：原PO不存在
	 * 后置：增加一个PO
	 * @param cp
	 * @return
	 */
	public boolean add(WarehousePO cp)throws RemoteException;
	/**
	 * 前置：原PO存在
	 * 后置：删除一个PO
	 * @param cp 快递单号
	 * @return
	 */
	public boolean delete(String cp)throws RemoteException;
    /**
     * 前置：原库存PO存在
     * 后置：修改一个PO
     * @param old
     * @param newone
     * @return
     */
	public boolean update(WarehousePO newone)throws RemoteException;
	/**
	 * 前置：无
	 * 后置：更新
	 * @param a
	 */
	public boolean setBorderline(BorderlinePO po)throws RemoteException; 
	/**
	 * 前置：无
	 * 后置：更新
	 * @param a
	 */
	public double getBorderline(BorderlinePO po)throws RemoteException; 
	/**
	 * 
	 * @return
	 */
	public MyList<BorderlinePO> getAllDorderline()throws RemoteException;
}

