package org.module.common.dataservice.statisticdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.module.common.dataservice.MyList;
import org.module.common.po.ReceiptPO;
import org.module.common.po.State;


/**
 * 20151022
 * @author 颜
 *
 */
public interface ReceiptListService extends Remote{

	
	/**
	 * 前置：无
	 * 后置：返回所有PO
	 * @return 所有的列表信息
	 */
	public MyList<ReceiptPO> getAll()throws RemoteException;
	

	/**
	 * 前置：无
	 * 后置：返回所有PO
	 * @return 所有的列表信息
	 */
	public MyList<ReceiptPO> getAll(String w)throws RemoteException;
	
	/**
	 * 前置：对应状态合法
	 * 后置：查找对应状态PO，返回序列化列表
	 * @return 所有的列表信息
	 */
	public MyList<ReceiptPO> getAllBySatte(State state)throws RemoteException;
	/**
	 * 前置：数据库中不含有相同ID的PO
	 * 后置：增加一个PO，根据操作结果返回
	 * @param   欲增加的持久化对象
	 * @return  添加成功返回true
	 */
	public boolean add(ReceiptPO ticket)throws RemoteException;
	
	/**
	 * 前置：数据库中含有相同ID的PO
	 * 后置：删除一个PO，根据操作结果返回
	 * @param   欲删除的持久化对象
	 * @return  添加成功返回true
	 */
	
	public boolean delete(String ticket)throws RemoteException;

	/**
	 * 前置：相同ID的PO存在于数据库
	 * 后置：修改一个PO，根据操作结果返回
	 * @param user 修改成功返回true
	 * @return
	 */
	public boolean update(ReceiptPO newone)throws RemoteException;
}
