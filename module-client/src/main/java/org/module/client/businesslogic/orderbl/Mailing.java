package org.module.client.businesslogic.orderbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.order.CalculateDriverCostService;
import org.module.client.businesslogicservice.order.CalculateTimeService;
import org.module.client.businesslogicservice.order.MailingService;
import org.module.client.vo.MailingListVO;

public class Mailing  implements MailingService{

	private CalculateDriverCostService driverCost;
	public Mailing(CalculateTimeService time,
			CalculateDriverCostService driverCost) {
		super();
		this.driverCost = driverCost;
	}

	public Mailing(){
		this.driverCost = new CalculateDriverCost();
	}
	public boolean creat(MailingListVO o) {
		return false;
	}

	public ArrayList<MailingListVO> getAll() {
		return null;
	}

	public double calculatePrice(String senderCity, String receiveCity,
			String counts, String weight, String volume,
			String costOfDecoration, String type) {
		return 0;
	}

	public int calculateTime(String senderCity, String receiveCity) {
		return 0;
	}

}
