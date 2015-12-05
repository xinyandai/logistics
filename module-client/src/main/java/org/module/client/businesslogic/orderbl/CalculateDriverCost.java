package org.module.client.businesslogic.orderbl;

import java.rmi.RemoteException;

import org.module.client.businesslogicservice.order.CalculateDriverCostService;
import org.module.client.javaRMI.RmiClient;
import org.module.common.dataservice.MyList;
import org.module.common.dataservice.managementdataservice.PriceAndCityDataService;
import org.module.common.po.PriceAndCityPO;

public class CalculateDriverCost implements CalculateDriverCostService {

	private PriceAndCityDataService data = new RmiClient().get(PriceAndCityDataService.class);

	public double calculateDriverCost(String origin, String target) {
		double re = .0;
		try {
			MyList<PriceAndCityPO> prices = this.data.getAll();
			for (PriceAndCityPO priceAndCityPO : prices) {
				if( (priceAndCityPO.getcityA().equals(origin)&&priceAndCityPO.getcityB().equals(target))
						&&(priceAndCityPO.getcityB().equals(origin)&&priceAndCityPO.getcityA().equals(target))
						){
					re+=Double.parseDouble(priceAndCityPO.getPrice());
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return re;
	}

}
