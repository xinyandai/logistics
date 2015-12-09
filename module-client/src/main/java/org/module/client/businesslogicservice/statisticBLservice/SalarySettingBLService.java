package org.module.client.businesslogicservice.statisticBLservice;

import org.module.client.vo.salary.AccountantSalaryVO;
import org.module.client.vo.salary.CourierSalaryVO;
import org.module.client.vo.salary.DriverSalaryVO;
import org.module.client.vo.salary.OfficeClerkSalaryVO;
import org.module.client.vo.salary.TranCenterClerkSalaryVO;
import org.module.client.vo.salary.WarehouseManagerSalaryVO;

public interface SalarySettingBLService {

	/**
	 * 
	 * @param base  底薪
	 * @param bonus 提成 
	 * 
	 * @return
	 */
	public boolean setAccountSalary(AccountantSalaryVO vo);
	public boolean setCourierSalary(CourierSalaryVO vo);
	public boolean setDriverSalary(DriverSalaryVO vo);
	public boolean setOfficeClerkSalary(OfficeClerkSalaryVO vo);
	public boolean setTranCenterClerkSalary(TranCenterClerkSalaryVO vo);
	public boolean setWarehouseSalary(WarehouseManagerSalaryVO vo);

	
	public AccountantSalaryVO getAccountantSalaryVO();
	public CourierSalaryVO getCourierSalaryVO();
	public DriverSalaryVO getDriverSalaryVO();
	public OfficeClerkSalaryVO getOfficeClerkSalaryVO();
	public TranCenterClerkSalaryVO getTranCenterClerkSalaryVO();
	public WarehouseManagerSalaryVO getWarehouseManagerSalaryVO();
	
}
