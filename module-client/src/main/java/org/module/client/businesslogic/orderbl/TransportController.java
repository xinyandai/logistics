package org.module.client.businesslogic.orderbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.order.TransportService;
import org.module.client.businesslogicservice.orderBLservice.TransportBLService;
import org.module.client.vo.TransportListVO;

public class TransportController implements TransportBLService {

	private TransportService transport;
	public TransportController() {

		this.transport = new Transport();
	}

	public TransportController(TransportService transport) {
		super();
		this.transport = transport;
	}

	public boolean creat(String car, String loadingDate, String transId,
			String carId, String origin, String arrival, String counterId,
			String supervision, String shippingId, String price) {
		// TODO Auto-generated method stub
		return this.transport.creat(new TransportListVO( car,  loadingDate,  transId,
			 carId,  origin,  arrival,  counterId,
			 supervision,  shippingId,  price));
	}

	public ArrayList<TransportListVO> getAll() {
		// TODO Auto-generated method stub
		return this.transport.getAll();
	}

}
