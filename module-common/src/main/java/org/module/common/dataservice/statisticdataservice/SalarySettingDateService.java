package org.module.common.dataservice.statisticdataservice;

import org.module.common.po.salary.AccountantSalaryPO;
import org.module.common.po.salary.CourierSalaryPO;
import org.module.common.po.salary.DriverSalaryPO;
import org.module.common.po.salary.OfficeClerkSalaryPO;
import org.module.common.po.salary.TranCenterClerkSalaryPO;
import org.module.common.po.salary.WarehouseManagerSalaryPO;



public interface SalarySettingDateService {
	public boolean setAccountSalary(AccountantSalaryPO a);
	public boolean setCourierSalary(CourierSalaryPO c);
	public boolean setDriverSalary(DriverSalaryPO d);
	public boolean setOfficeClerkSalary(OfficeClerkSalaryPO o);
	public boolean setTranCenterClerkSalary(TranCenterClerkSalaryPO t);
	public boolean setWarehouseSalary(WarehouseManagerSalaryPO w);
	
	public AccountantSalaryPO getAccountSalary( );
	public CourierSalaryPO getCourierSalary( );
	public DriverSalaryPO getDriverSalary( );
	public OfficeClerkSalaryPO getOfficeClerkSalary( );
	public TranCenterClerkSalaryPO getTranCenterClerkSalary( );
	public WarehouseManagerSalaryPO getWarehouseSalary( );
}
