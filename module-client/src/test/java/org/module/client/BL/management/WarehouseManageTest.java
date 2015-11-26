package org.module.client.BL.management;

import org.module.client.businesslogic.managementbl.WarehouseManageController;
import org.module.client.businesslogicservice.managementBLservice.WarehouseManageBLService;
import org.module.client.vo.GoDownEntryVO;

import junit.framework.TestCase;

public class WarehouseManageTest extends TestCase {
	private WarehouseManageBLService warehouse;
	
	protected void setUp() throws Exception {
		super.setUp();
		warehouse = new WarehouseManageController(new WarehouseMock());
	}
	
	public void testgetAll(){
		assert(warehouse.getAll().get(0).getNumber()=="10086");
	}
	
	public void testmodify(){
		assert(warehouse.modify("10086","1","1","1","1"));
	}

	public void testoutBound(){
		
		assert(true);
	}

	
}
