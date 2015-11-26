package org.module.client.BL.management;

import java.util.ArrayList;

import org.module.client.businesslogicservice.management.PriceAndCityManageService;
import org.module.client.vo.CityVO;
import org.module.client.vo.PriceAndCityVO;


public class PriceAndCityMock implements PriceAndCityManageService{

	
	/*public ArrayList<String> showAllCity() {
		// TODO Auto-generated method stub
		ArrayList<String> s=new ArrayList<String>();
		s.add("nanjing");
		return s;
	}*/

	public boolean addCity(String city) {
		// TODO Auto-generated method stub
		return city.equals("nanjing");
	}

	public boolean deleteCity(String city) {
		// TODO Auto-generated method stub
		return city.equals("nanjing");
	}

	public boolean modifyCity(String city) {
		// TODO Auto-generated method stub
		return city.equals("nanjing");
	}

	public boolean setDiretionAndPrice(PriceAndCityVO priceAndcity) {
		// TODO Auto-generated method stub
		return priceAndcity.getcityA().equals("nanjing");
	}

	public boolean addCity(CityVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean modifyCity(CityVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<CityVO> showAllCity() {
		// TODO Auto-generated method stub
		return null;
	}

}
