package org.module.client.businesslogic.orderbl;

import java.rmi.RemoteException;

import org.module.client.businesslogicservice.order.CalculateDriverCostService;
import org.module.client.javaRMI.RmiClient;
import org.module.common.dataservice.managementdataservice.PriceAndCityDataService;
import org.module.common.po.PriceAndCityPO;

public class CalculateDriverCost implements CalculateDriverCostService {

	private PriceAndCityDataService data = new RmiClient().get(PriceAndCityDataService.class);

	public double calculateDriverCost(String origin, String target) {
		double re = .0;
		try {
			PriceAndCityPO po = this.data.find(origin, target);
			if(po!=null){
				re += Double.parseDouble(po.getPrice());
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return re;
	}

}
