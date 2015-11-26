package org.module.client.BL.department;

import junit.framework.TestCase;

import org.module.client.businesslogic.deparmentbl.StuffManageController;
import org.module.client.businesslogicservice.departmentBLservice.StuffManageBLService;
import org.module.common.dataservice.MyList;

public class StuffManageTest extends TestCase {
	private StuffManageBLService stuff;
	
	protected void setUp() throws Exception {
		super.setUp();
		stuff = new StuffManageController(new StuffMock(),new CalculateSalaryMock());
	}

	

	
	public void testShowAll() {
		assert(stuff.showAll().get(0).getSlary()-500<1);
	}

	public void testAdd() {
		assert(stuff.add("name","18","快递员","140010001"));
	}

	public void testDeleteString() {
		assert(stuff.delete("140010001"));
	}

	public void testDeleteArrayListOfString() {
		assert(stuff.delete(new MyList<String>() ));
	}

	public void testModify() {
		assert(stuff.update("name","18","快递员","140010001"));
	}

	public void testFuzzySearch() {
		assert(stuff.fuzzySearch("140010001").size()>0);
	}

}
