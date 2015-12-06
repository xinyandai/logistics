package org.module.client.businesslogic.managementbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.management.PriceAndCityManageService;
import org.module.client.businesslogicservice.managementBLservice.PriceAndCityManageBLService;
import org.module.client.vo.CityVO;
import org.module.client.vo.PriceAndCityVO;

public class PriceAndCityManageController implements PriceAndCityManageBLService{

	private PriceAndCityManageService priceAndcity ;
	private ArrayList<CityVO> cityVOs;
	
	public PriceAndCityManageController(PriceAndCityManageService priceAndcity) {
		super();
		this.priceAndcity = priceAndcity;
	}

	public PriceAndCityManageController() {
		this.priceAndcity = new PriceAndCity();
	}
	
	

	public boolean setDiretionAndPrice(int cityA, int cityB,
			String distance, String price) {

		return priceAndcity.setDiretionAndPrice(new PriceAndCityVO(
				this.cityVOs.get(cityA).getId(), 
				this.cityVOs.get(cityB).getId(),
				distance, price));
	}

	public boolean addCity(String city, String id) {
		return this.priceAndcity.addCity(new CityVO(city,id));
	}

	public boolean modifyCity(String city, String id) {
		
		return this.priceAndcity.modifyCity(new CityVO(city,id));
	}

	public ArrayList<CityVO> showAllCity() {
		this.cityVOs = this.priceAndcity.showAllCity();
		return this.cityVOs;
	}

	public boolean deleteCity(String id) {
		return this.priceAndcity.deleteCity(id);
	}

	public ArrayList<String[]> toArray() {
		ArrayList<String[]> re = new ArrayList<String[]>();
		ArrayList<CityVO> vos = this.showAllCity();
		for (CityVO cityVO : vos) {
			re.add(cityVO.toArray());
		}
		return re;
	}

	public String[] getAllCitiesArray() {
		if(this.cityVOs==null){
			this.showAllCity();
		}
		String[] city = new String[cityVOs.size()];
		for (int i = 0; i < city.length; i++) {
			city[i] = cityVOs.get(i).getName();
		}
		return city;
	}

	public PriceAndCityVO getDiretionAndPrice(int cityA, int cityB) {
		
		PriceAndCityVO re =  this.priceAndcity.getDiretionAndPrice(this.cityVOs.get(cityA).getId(),
				this.cityVOs.get(cityB).getId());
		if(re==null){
			re = new PriceAndCityVO(this.cityVOs.get(cityA).getId(),
					this.cityVOs.get(cityB).getId(), "0", "0");
		}
		return re;
	}
}
