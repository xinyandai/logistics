package org.module.client.BL.management;

import java.util.ArrayList;

import org.module.client.businesslogic.managementbl.DriversManageController;
import org.module.client.businesslogicservice.managementBLservice.DriversManageBLService;

import junit.framework.TestCase;

public class DriverManageTest extends TestCase {
	private DriversManageBLService driver;
	
	protected void setUp() throws Exception {
		super.setUp();
		driver = new DriversManageController(new DriverMock());
	}
	
	public void testshowAll(){
		assert(driver.showAll().get(0).getId()=="10086");
	}
	
	public void testAdd() {
		assert(driver.add("10086","name","0401","342401199001010000",
				"13812345678","男","2015"));
	}
	
	public void testModify() {
		assert(driver.modify("10086","name","0401","342401199001010000",
				"13812345678","男","2015"));
	}
	
	public void testDeleteString() {
		assert(driver.delete("10086"));
	}

	public void testDeleteArrayListOfString() {
		assert(driver.delete(new ArrayList<String>() ));
	}
	
	public void testFuzzySearch() {
		assert(driver.fuzzySearch("10086").size()>0);
	}
}
