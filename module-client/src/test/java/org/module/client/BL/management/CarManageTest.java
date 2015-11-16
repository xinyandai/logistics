package org.module.client.BL.management;

import java.util.ArrayList;

import org.module.client.businesslogic.managementbl.CarsManageController;
import org.module.client.businesslogicservice.managementBLservice.CarsManageBLService;

import junit.framework.TestCase;

public class CarManageTest extends TestCase {
	private CarsManageBLService car;
	
	protected void setUp() throws Exception {
		super.setUp();
		car = new CarsManageController(new CarMock());
	}
	
	public void testshowAll(){
		assert(car.showAll().get(0).getId()=="10086");
	}
	
	public void testAdd() {
		assert(car.add("10086","110","2015"));
	}
	
	public void testModify() {
		assert(car.modify("10086","110","2015"));
	}
	
	public void testDeleteString() {
		assert(car.delete("10086"));
	}

	public void testDeleteArrayListOfString() {
		assert(car.delete(new ArrayList<String>() ));
	}
	
	public void testFuzzySearch() {
		assert(car.fuzzySearch("10086").size()>0);
	}
	
}
