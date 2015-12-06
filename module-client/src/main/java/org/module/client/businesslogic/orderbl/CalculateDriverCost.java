package org.module.client.businesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.module.client.businesslogicservice.order.CalculateDriverCostService;
import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.CityVO;
import org.module.common.dataservice.managementdataservice.PriceAndCityDataService;
import org.module.common.po.CityPO;
import org.module.common.po.PriceAndCityPO;

public class CalculateDriverCost implements CalculateDriverCostService {

	private PriceAndCityDataService data = new RmiClient().get(PriceAndCityDataService.class);
	private ArrayList<CityVO> cityVOs;
	
	public double calculateDriverCost(String originID, String targetID) {
		if(originID==null || targetID==null) return .0;
		double re = .0;
		try {
			PriceAndCityPO po = this.data.find(originID, targetID);
			if(po!=null){
				re += Double.parseDouble(po.getPrice());
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return re;
	}

	public double calculateDriverCostByCityName(String a,String b){
		return this.calculateDriverCost(this.nameToId(a), this.nameToId(b));
		
	}
	private ArrayList<CityVO> showAllCity() {
		this.cityVOs = new ArrayList<CityVO>();
		try {
			ArrayList<CityPO> pos  = this.data.getCity();
			for (CityPO cityPO : pos) {
				this.cityVOs.add(new CityVO(cityPO.getName(),cityPO.getId()));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return this.cityVOs;
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
	
	private String nameToId(String name){
		
		for (CityVO cityVO : cityVOs) {
			if(cityVO.getName().equals(name)){
				return cityVO.getId();
			}
		}
		return null;
	}
	
	/**
	 * cityArraylist 的index查找该城市
	 * 然后返回城市ID
	 * @param i
	 * @return
	 */
	private String indexesToID(int i){
		return this.cityVOs.get(i).getId();
	}
}
