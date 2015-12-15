package org.module.client.businesslogic.orderbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.order.TransportService;
import org.module.client.businesslogicservice.orderBLservice.TransportBLService;
import org.module.client.vo.TransportListVO;

public class TransportController implements TransportBLService {

	private TransportService transport;
	private CalculateDriverCost cityAndCost;
	private ArrayList<TransportListVO> list;
	
	public TransportController() {

		this.transport = new Transport();
		cityAndCost = new CalculateDriverCost();
	}

	public TransportController(TransportService transport ) {
		super();
		this.transport = transport;
	}

	public boolean creat(TransportListVO o) {
		for (TransportListVO transportListVO : list) {
			if(transportListVO.getTransId().equals(o.getTransId())){
				return false;
			}
		}
		this.list.add(o);
		return this.transport.creat(o);
	}

	public ArrayList<TransportListVO> getAll() {
		this.list =  this.transport.getAll();
		return list;
	}

	public boolean update(TransportListVO o) {
		for (TransportListVO transportListVO : list) {
			if(transportListVO.getTransId().equals(o.getTransId())){
				list.remove(transportListVO);
				list.add(o);
				return this.transport.update(transportListVO);
			}
		}
		return false;
	}

	public String[] getCityArray() {
		return this.cityAndCost.getAllCitiesArray();
	}

	public double calculateDriverCost(String origin, String target) {
		return this.cityAndCost.calculateDriverCostByCityName(origin, target);
	}
}
