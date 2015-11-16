package org.module.client.BL.order;

import java.util.ArrayList;

import org.module.client.businesslogicservice.order.MailingService;
import org.module.client.vo.MailingListVO;

public class MailingMock implements MailingService {

	public MailingMock() {
		// TODO Auto-generated constructor stub
	}

	public boolean creat(MailingListVO o) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<MailingListVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public double calculatePrice(String senderCity, String receiveCity,
			String counts, String weight, String volume,
			String costOfDecoration, String type) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int calculateTime(String senderCity, String receiveCity) {
		// TODO Auto-generated method stub
		return 0;
	}

}
