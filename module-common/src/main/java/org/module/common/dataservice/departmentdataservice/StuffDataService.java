package org.module.common.dataservice.departmentdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.module.common.dataservice.MyList;
import org.module.common.po.StuffPO;


/**
 * 20151022
 * 员工信息
 * @author 颜
 */
public interface StuffDataService extends Remote{
	
	/**
	 * 前置：无
	 * 后置：查找所有的员工PO信息，组成ArrayList的序列化形式并返回
	 * @return  序列化后的ArrayList
	 */
	public MyList<StuffPO> getAll()throws RemoteException;
	/**
	 * 前置：同样ID的po在还未存在
	 * 后置：在数据中增加一个PO，，根据操作 结果返回
	 * @param dp 增加的PO
	 * @return，根据操作 结果返回
	 */
	public boolean add(StuffPO dp)throws RemoteException;
	/**
	 * 前置：唯一标识符相同的PO已经存在于数据
	 * 后置：在数据中删除一个PO，根据操作 结果返回
	 * @param ID 欲删除的PO的唯一标识符
	 * @return，根据操作 结果返回
	 */
	public boolean delete(String id)throws RemoteException;
	/**
	 * 前置：唯一标识符相同的PO已经存在于数据
	 * 后置：在数据中删除这些PO，根据操作 结果返回
	 * @param al 欲删除的PO的位置标识符组成的序列化列表
	 * @return ，根据操作 结果返回
	 */
	public boolean delete(MyList<String> id)throws RemoteException;
	/**
	 * 前置：唯一标识符相同的PO已经存在于数据
	 * 后置：在数据中修改一个PO，根据操作 结果返回
	 * @param one更新后的
	 * @return，根据操作 结果返回
	 */
	public boolean update(StuffPO one)throws RemoteException;
	/**
	 * 模糊匹配查找
	 * 前置：无
	 * 后置：模糊查找对应PO，根据ID与key的匹配度，组成序列化列表返回
	 * @param key
	 * @return
	 * @throws RemoteException
	 */
	public MyList<StuffPO> fuzzusearch(String key)throws RemoteException;
	
}
