package org.module.client.BL.statistic;

import org.module.client.businesslogicservice.statistic.SalaryService;
import org.module.client.vo.salary.AccountantSalaryVO;
import org.module.client.vo.salary.CourierSalaryVO;
import org.module.client.vo.salary.DriverSalaryVO;
import org.module.client.vo.salary.OfficeClerkSalaryVO;
import org.module.client.vo.salary.TranCenterClerkSalaryVO;
import org.module.client.vo.salary.WarehouseManagerSalaryVO;

public class SalaryMock implements SalaryService{

	public boolean setAccountSalary(AccountantSalaryVO a) {
		if(a.getBase()>0)
		return true;
		return false;
	}

	public boolean setCourierSalary(CourierSalaryVO c) {
		if(c.getBase()>0)
			return true;
		return false;
	}

	public boolean setDriverSalary(DriverSalaryVO d) {
		if(d.getBase()>0)
			return true;
		return false;
	}

	public boolean setOfficeClerkSalary(OfficeClerkSalaryVO o) {
		if(o.getBase()>0)
			return true;
		return false;
	}

	public boolean setTranCenterClerkSalary(TranCenterClerkSalaryVO t) {
		if(t.getBase()>0)
			return true;
		return false;
	}

	public boolean setWarehouseSalary(WarehouseManagerSalaryVO w) {
		if(w.getBase()>0)
			return true;
		return false;
	}

	public AccountantSalaryVO getAccountantSalaryVO() {
		// TODO Auto-generated method stub
		return null;
	}

	public CourierSalaryVO getCourierSalaryVO() {
		// TODO Auto-generated method stub
		return null;
	}

	public DriverSalaryVO getDriverSalaryVO() {
		// TODO Auto-generated method stub
		return null;
	}

	public OfficeClerkSalaryVO getOfficeClerkSalaryVO() {
		// TODO Auto-generated method stub
		return null;
	}

	public TranCenterClerkSalaryVO getTranCenterClerkSalaryVO() {
		// TODO Auto-generated method stub
		return null;
	}

	public WarehouseManagerSalaryVO getWarehouseManagerSalaryVO() {
		// TODO Auto-generated method stub
		return null;
	}

}
