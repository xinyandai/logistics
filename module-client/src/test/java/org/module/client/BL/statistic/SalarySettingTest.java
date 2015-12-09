package org.module.client.BL.statistic;

import junit.framework.TestCase;

import org.module.client.businesslogic.statisticbl.SalaryController;
import org.module.client.vo.salary.AccountantSalaryVO;
import org.module.client.vo.salary.CourierSalaryVO;
import org.module.client.vo.salary.DriverSalaryVO;
import org.module.client.vo.salary.OfficeClerkSalaryVO;
import org.module.client.vo.salary.TranCenterClerkSalaryVO;
import org.module.client.vo.salary.WarehouseManagerSalaryVO;

public class SalarySettingTest extends TestCase {

	SalaryController salary ;
	protected void setUp() throws Exception {
		salary  = new SalaryController(new SalaryMock());
		super.setUp();
	}

	public void testSetAccountSalary() {
		assert(salary.setAccountSalary(new AccountantSalaryVO(500, 1)));
	}

	public void testSetCourierSalary() {
		assert(salary.setCourierSalary(new CourierSalaryVO(200, 1, 1)));
	}

	public void testSetDriverSalary() {
		assert(salary.setDriverSalary(new DriverSalaryVO(200, 1, 1)));
	}

	public void testSetOfficeClerkSalary() {
		assert(salary.setOfficeClerkSalary(new OfficeClerkSalaryVO(200, 1, 1)));
	}

	public void testSetTranCenterClerkSalary() {
		assert(salary.setTranCenterClerkSalary(new TranCenterClerkSalaryVO(200, 1, 1)));
	}

	public void testSetWarehouseSalary() {
		assert(salary.setWarehouseSalary(new WarehouseManagerSalaryVO(200, 1, 1)));
	}

}
