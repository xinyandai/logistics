package org.module.client.businesslogic.managementbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.module.client.businesslogicservice.management.PriceAndCityManageService;
import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.CityVO;
import org.module.client.vo.PriceAndCityVO;
import org.module.common.dataservice.managementdataservice.PriceAndCityDataService;
import org.module.common.po.CityPO;
import org.module.common.po.PriceAndCityPO;

public class PriceAndCity implements PriceAndCityManageService{

	private PriceAndCityDataService data = new RmiClient().get(PriceAndCityDataService.class);
	
	public ArrayList<CityVO> showAllCity() {
		ArrayList<CityVO> vos = new ArrayList<CityVO>();
		try {
			ArrayList<CityPO> pos = this.data.getCity();
			for (CityPO cityPO : pos) {
				vos.add(new CityVO(cityPO.getName(),cityPO.getId()));
			}
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
		return vos;
	}

	public boolean addCity(CityVO city) {
		try {
			return this.data.addCity(new CityPO(city.getName(),city.getId()));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteCity(String id) {
		
		try {
			return this.data.deleteCity(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	

	public boolean setDiretionAndPrice(PriceAndCityVO priceAndcity) {
		PriceAndCityPO po =new PriceAndCityPO(
				priceAndcity.getcityA(),
				priceAndcity.getcityB(),
				priceAndcity.getDistance(),
				priceAndcity.getPrice()
				);
		
		try {
			return this.data.update(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean modifyCity(CityVO city) {
		CityPO po = new CityPO(city.getName(),city.getId());
		try {
			return this.data.modifyCity(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	
}
