package org.module.client.businesslogic.orderbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.order.OfficeArrivalService;
import org.module.client.businesslogicservice.orderBLservice.OfficeArrivalBLService;
import org.module.client.vo.OfficeArrivalListVO;

public class OfficeArrivalController implements OfficeArrivalBLService{
	private OfficeArrivalService  officeArrival;
	public OfficeArrivalController(OfficeArrivalService officeArrival) {
		super();
		this.officeArrival = officeArrival;
	}

	public OfficeArrivalController() {
		officeArrival = new OfficeArrival();
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
