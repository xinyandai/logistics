package org.module.client.BL.statistic;

import junit.framework.TestCase;

import org.module.client.businesslogic.statisticbl.SalaryController;

public class SalarySettingTest extends TestCase {

	SalaryController salary ;
	protected void setUp() throws Exception {
		salary  = new SalaryController(new SalaryMock());
		super.setUp();
	}

	public void testSetAccountSalary() {
		assert(salary.setAccountSalary("500", "1"));
	}

	public void testSetCourierSalary() {
		assert(salary.setCourierSalary("200", "1", "1"));
	}

	public void testSetDriverSalary() {
		assert(salary.setDriverSalary("200", "1", "1"));
	}

	public void testSetOfficeClerkSalary() {
		assert(salary.setOfficeClerkSalary("200", "1", "1"));
	}

	public void testSetTranCenterClerkSalary() {
		assert(salary.setTranCenterClerkSalary("200", "1", "1"));
	}

	public void testSetWarehouseSalary() {
		assert(salary.setWarehouseSalary("200", "1", "1"));
	}

}
