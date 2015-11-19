package org.module.client.businesslogic.orderbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.order.OfficeArrivalService;
import org.module.client.businesslogicservice.orderBLservice.OfficeArrivalBLService;
import org.module.client.vo.OfficeArrivalListVO;

public class OfficeArrivalController implements OfficeArrivalBLService{
	private OfficeArrivalService  officeArrival;
//	private LogisticsService logistics;
	public OfficeArrivalController(OfficeArrivalService officeArrival ) {
		super();
		this.officeArrival = officeArrival;
//		this.logistics = logistics;
	}

	public OfficeArrivalController() {
		officeArrival = new OfficeArrival();
//		this.logistics = new Logistics();
	}

	public boolean creat(String officeid, String date, String transportListId,
			String origin, String state) {
		
		return officeArrival.creat(new OfficeArrivalListVO( officeid,  date,  transportListId,
			 origin,  state));
	}

	public ArrayList<OfficeArrivalListVO> getAll() {
		
		return officeArrival.getAll();
	}

}
