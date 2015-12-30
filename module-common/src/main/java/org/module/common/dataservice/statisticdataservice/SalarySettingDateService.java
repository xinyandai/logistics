package org.module.common.dataservice.statisticdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.module.common.po.salary.AccountantSalaryPO;
import org.module.common.po.salary.CourierSalaryPO;
import org.module.common.po.salary.DriverSalaryPO;
import org.module.common.po.salary.OfficeClerkSalaryPO;
import org.module.common.po.salary.TranCenterClerkSalaryPO;
import org.module.common.po.salary.WarehouseManagerSalaryPO;



public interface SalarySettingDateService extends Remote {
	/**
	 * 前置： 持久化对象已经存在或者不存在均可
	 * 后置： 更新持久化对象，根据操作结果返回
	 * @param a PO
	 * @return
	 * @throws RemoteException
	 */
	public boolean setAccountSalary(AccountantSalaryPO a)throws RemoteException;
	
	/**
	 * 前置： 持久化对象已经存在或者不存在均可
	 * 后置： 更新持久化对象，根据操作结果返回
	 * @param a PO
	 * @return
	 * @throws RemoteException
	 */
	public boolean setCourierSalary(CourierSalaryPO c)throws RemoteException;
	
	
	 /**
		 * 前置： 持久化对象已经存在或者不存在均可
		 * 后置： 更新持久化对象，根据操作结果返回
		 * @param a PO
		 * @return
		 * @throws RemoteException
		 */
	 public boolean setDriverSalary(DriverSalaryPO d)throws RemoteException;
	
	 
	 /**
		 * 前置： 持久化对象已经存在或者不存在均可
		 * 后置： 更新持久化对象，根据操作结果返回
		 * @param a PO
		 * @return
		 * @throws RemoteException
		 */
	 public boolean setOfficeClerkSalary(OfficeClerkSalaryPO o)throws RemoteException;
	
		 
		 
		 /**
			 * 前置： 持久化对象已经存在或者不存在均可
			 * 后置： 更新持久化对象，根据操作结果返回
			 * @param a PO
			 * @return
			 * @throws RemoteException
			 */
	 public boolean setTranCenterClerkSalary(TranCenterClerkSalaryPO t)throws RemoteException;
	
			 /**
				 * 前置： 持久化对象已经存在或者不存在均可
				 * 后置： 更新持久化对象，根据操作结果返回
				 * @param a PO
				 * @return
				 * @throws RemoteException
				 */
			 
	 public boolean setWarehouseSalary(WarehouseManagerSalaryPO w)throws RemoteException;
	
	 
	/**
	 * 前置：无
	 * 后置：读取持久化对象返回
	 * @return
	 * @throws RemoteException
	 */
	public AccountantSalaryPO getAccountSalary( )throws RemoteException;
	
	/**
	 * 前置：无
	 * 后置：读取持久化对象返回
	 * @return
	 * @throws RemoteException
	 */
	public CourierSalaryPO getCourierSalary( )throws RemoteException;
	
	/**
	 * 前置：无
	 * 后置：读取持久化对象返回
	 * @return
	 * @throws RemoteException
	 */
	public DriverSalaryPO getDriverSalary( )throws RemoteException;
	
	
	/**
	 * 前置：无
	 * 后置：读取持久化对象返回
	 * @return
	 * @throws RemoteException
	 */
	public OfficeClerkSalaryPO getOfficeClerkSalary( )throws RemoteException;
	
	
	/**
	 * 前置：无
	 * 后置：读取持久化对象返回
	 * @return
	 * @throws RemoteException
	 */
	public TranCenterClerkSalaryPO getTranCenterClerkSalary( )throws RemoteException;
	
	
	/**
	 * 前置：无
	 * 后置：读取持久化对象返回
	 * @return
	 * @throws RemoteException
	 */
	public WarehouseManagerSalaryPO getWarehouseSalary( )throws RemoteException;
}
