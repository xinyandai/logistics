package org.module.client.businesslogic.managementbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.management.PriceAndCityManageService;
import org.module.client.businesslogicservice.managementBLservice.PriceAndCityManageBLService;
import org.module.client.vo.CityVO;
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
	
	

	public boolean setDiretionAndPrice(String cityA, String cityB,
			String distance, String price) {
		// TODO Auto-generated method stub
		return priceAndcity.setDiretionAndPrice(new PriceAndCityVO(cityA, cityB,
				distance, price));
	}

	public boolean addCity(String city, String id) {
		
		return this.priceAndcity.addCity(new CityVO(city,id));
	}

	public boolean modifyCity(String city, String id) {
		
		return this.priceAndcity.modifyCity(new CityVO(city,id));
	}

	public ArrayList<CityVO> showAllCity() {
		
		return this.priceAndcity.showAllCity();
	}

	public boolean deleteCity(String id) {
		return this.priceAndcity.deleteCity(id);
	}

}
