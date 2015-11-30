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
	 * 
	 * @param a PO
	 * @return
	 * @throws RemoteException
	 */
	public boolean setAccountSalary(AccountantSalaryPO a)throws RemoteException;
	public boolean setCourierSalary(CourierSalaryPO c)throws RemoteException;
	public boolean setDriverSalary(DriverSalaryPO d)throws RemoteException;
	public boolean setOfficeClerkSalary(OfficeClerkSalaryPO o)throws RemoteException;
	public boolean setTranCenterClerkSalary(TranCenterClerkSalaryPO t)throws RemoteException;
	public boolean setWarehouseSalary(WarehouseManagerSalaryPO w)throws RemoteException;
	
	public AccountantSalaryPO getAccountSalary( )throws RemoteException;
	public CourierSalaryPO getCourierSalary( )throws RemoteException;
	public DriverSalaryPO getDriverSalary( )throws RemoteException;
	public OfficeClerkSalaryPO getOfficeClerkSalary( )throws RemoteException;
	public TranCenterClerkSalaryPO getTranCenterClerkSalary( )throws RemoteException;
	public WarehouseManagerSalaryPO getWarehouseSalary( )throws RemoteException;
}
