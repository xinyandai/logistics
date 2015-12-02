package org.module.common.dataservice.departmentdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.module.common.dataservice.MyList;
import org.module.common.po.DepartmentPO;


/**
 * 20151022
 * 部门信息
 * @author 颜
 */
public interface DepartmentDataService extends Remote{
	/**
	 * 前置：无
	 * 后置：返回所有的机构信息
	 * @return
	 */
	public MyList<DepartmentPO> getAll()throws RemoteException;
	/**
	 * 前置：同样ID的po在还未存在
	 * 后置：在数据中增加一个PO
	 * @param dp
	 * @return
	 */
	public boolean add(DepartmentPO dp)throws RemoteException;
	/**
	 * 前置：该PO已经存在于数据
	 * 后置：在数据中删除一个PO
	 * @param dp
	 * @return
	 */
	public boolean delete(String dp)throws RemoteException;
	/**
	 * 前置：这些PO已经存在于数据
	 * 后置：在数据中删除这些PO
	 * @param al
	 * @return
	 */
	public boolean delete(MyList<String> al)throws RemoteException;
	/**
	 * 前置：该PO已经存在于数据
	 * 后置：在数据中修改一个PO
	 * @param 
	 * @return
	 */
	public boolean update(DepartmentPO one)throws RemoteException;
	
	public MyList<DepartmentPO> fuzzusearch(String key)throws RemoteException;
}
