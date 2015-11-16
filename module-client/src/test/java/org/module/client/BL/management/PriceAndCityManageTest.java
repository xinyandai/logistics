package org.module.client.BL.management;

import org.module.client.businesslogic.managementbl.PriceAndCityManageController;
import org.module.client.businesslogicservice.managementBLservice.PriceAndCityManageBLService;

import junit.framework.TestCase;

public class PriceAndCityManageTest extends TestCase {
	private PriceAndCityManageBLService priceAndCity;
	
	protected void setUp() throws Exception {
		super.setUp();
		priceAndCity = new PriceAndCityManageController(new PriceAndCityMock());
	}
	
	public void testshowAllCity(){
		assert(priceAndCity.showAllCity().get(0)=="nanjing");
	}
	
	public void testAddCity() {
		assert(priceAndCity.addCity("nanijng"));
	}
	
	public void testModifyCity() {
		assert(priceAndCity.modifyCity("nanjing"));
	}
	
	public void testDeleteCityString() {
		assert(priceAndCity.deleteCity("city"));
	}
	
	public void testsetDiretionAndPrice(){
		assert(priceAndCity.setDiretionAndPrice("nanjing", "beijing", "1000", "10"));
	}
}
