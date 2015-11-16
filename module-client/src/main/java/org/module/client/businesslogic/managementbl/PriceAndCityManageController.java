package org.module.client.businesslogic.managementbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.management.PriceAndCityManageService;
import org.module.client.businesslogicservice.managementBLservice.PriceAndCityManageBLService;
import org.module.client.vo.PriceAndCityVO;

public class PriceAndCityManageController implements PriceAndCityManageBLService{

	private PriceAndCityManageService priceAndcity ;
	public PriceAndCityManageController(PriceAndCityManageService priceAndcity) {
		super();
		this.priceAndcity = priceAndcity;
	}

	public PriceAndCityManageController() {
		this.priceAndcity = new PriceAndCity();
	}
	
	public ArrayList<String> showAllCity() {
		// TODO Auto-generated method stub
		return priceAndcity.showAllCity();
	}

	public boolean addCity(String city) {
		// TODO Auto-generated method stub
		return priceAndcity.addCity(city);
	}

	public boolean deleteCity(String city) {
		// TODO Auto-generated method stub
		return priceAndcity.deleteCity(city);
	}

	public boolean modifyCity(String city) {
		// TODO Auto-generated method stub
		return priceAndcity.modifyCity(city);
	}

	public boolean setDiretionAndPrice(String cityA, String cityB,
			String distance, String price) {
		// TODO Auto-generated method stub
		return priceAndcity.setDiretionAndPrice(new PriceAndCityVO(cityA, cityB,
				distance, price));
	}

}
