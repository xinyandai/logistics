package org.module.client.BL.management;

import junit.framework.TestCase;

import org.module.client.businesslogic.managementbl.WarehouseManageController;
import org.module.client.businesslogicservice.managementBLservice.WarehouseManageBLService;

public class WarehouseManageTest extends TestCase {
	private WarehouseManageBLService warehouse;
	
	protected void setUp() throws Exception {
		super.setUp();
		warehouse = new WarehouseManageController(new WarehouseMock());
	}
	
	public void testgetAll(){
		assert(warehouse.getAll().get(0).getNumber()=="10086");
	}
	
	/*public void testmodify(){
		assert(warehouse.modify("10086","1","1","1","1","warehouse"));
	}*/

	public void testoutBound(){
		
		assert(true);
	}

	
}
