package org.module.client.businesslogicservice.statistic;

import org.module.client.vo.salary.AccountantSalaryVO;
import org.module.client.vo.salary.CourierSalaryVO;
import org.module.client.vo.salary.DriverSalaryVO;
import org.module.client.vo.salary.OfficeClerkSalaryVO;
import org.module.client.vo.salary.TranCenterClerkSalaryVO;
import org.module.client.vo.salary.WarehouseManagerSalaryVO;


public interface SalaryService {
	public boolean setAccountSalary(AccountantSalaryVO a);
	public boolean setCourierSalary(CourierSalaryVO c);
	public boolean setDriverSalary(DriverSalaryVO d);
	public boolean setOfficeClerkSalary(OfficeClerkSalaryVO o);
	public boolean setTranCenterClerkSalary(TranCenterClerkSalaryVO t);
	public boolean setWarehouseSalary(WarehouseManagerSalaryVO w);
}
