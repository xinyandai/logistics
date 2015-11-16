package org.module.client.BL.management;

import org.module.client.businesslogic.managementbl.WarehouseManageController;
import org.module.client.businesslogicservice.managementBLservice.WarehouseManageBLService;
import org.module.client.vo.GoDownEntryListVO;
import org.module.client.vo.OutBoundListVO;

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
		assert(warehouse.modify("10086","1","1","1","1").getNumber()=="10086");
	}

	public void testoutBound(){
		OutBoundListVO re = new OutBoundListVO("01","2015","beijing","01","10086","100");
		assert(warehouse.outBound(re).getNumber()=="10086");
	}

	public void testgoDown(){
		GoDownEntryListVO re = new GoDownEntryListVO("01","2015","beijing","1","1","1","1");
		assert(warehouse.goDown(re).getNumber()=="10086");
	}
}
