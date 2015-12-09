package org.module.client.businesslogic.statisticbl;

import org.module.client.businesslogicservice.statistic.SalaryService;
import org.module.client.businesslogicservice.statisticBLservice.SalarySettingBLService;
import org.module.client.vo.salary.AccountantSalaryVO;
import org.module.client.vo.salary.CourierSalaryVO;
import org.module.client.vo.salary.DriverSalaryVO;
import org.module.client.vo.salary.OfficeClerkSalaryVO;
import org.module.client.vo.salary.TranCenterClerkSalaryVO;
import org.module.client.vo.salary.WarehouseManagerSalaryVO;

public class SalaryController implements SalarySettingBLService {
	private SalaryService salary;
	
	public SalaryController(SalaryService salary) {
		super();
		this.salary = salary;
	}
	public SalaryController() {
		super();
		this.salary = new  Salary();
	}
	public boolean setAccountSalary(AccountantSalaryVO vo) {
		
		return salary.setAccountSalary(vo) ;
	}

	public boolean setCourierSalary(CourierSalaryVO vo) {
		return salary.setCourierSalary(vo);
	}

	public boolean setDriverSalary(DriverSalaryVO vo) {
		return salary.setDriverSalary(vo);
	}

	public boolean setOfficeClerkSalary(OfficeClerkSalaryVO vo) {
		return salary.setOfficeClerkSalary(vo);
	}

	public boolean setTranCenterClerkSalary(TranCenterClerkSalaryVO vo) {
		
		return salary.setTranCenterClerkSalary(vo);
	}

	public boolean setWarehouseSalary(WarehouseManagerSalaryVO vo) {
		
		return salary.setWarehouseSalary(vo);
	}
	public AccountantSalaryVO getAccountantSalaryVO() {
		return this.salary.getAccountantSalaryVO();
	}
	public CourierSalaryVO getCourierSalaryVO() {
		return this.salary.getCourierSalaryVO();
	}
	public DriverSalaryVO getDriverSalaryVO() {
		return this.salary.getDriverSalaryVO();
	}
	public OfficeClerkSalaryVO getOfficeClerkSalaryVO() {
		return this.salary.getOfficeClerkSalaryVO();
	}
	public TranCenterClerkSalaryVO getTranCenterClerkSalaryVO() {
		return this.salary.getTranCenterClerkSalaryVO();
	}
	public WarehouseManagerSalaryVO getWarehouseManagerSalaryVO() {
		return this.salary.getWarehouseManagerSalaryVO();
	}

}
