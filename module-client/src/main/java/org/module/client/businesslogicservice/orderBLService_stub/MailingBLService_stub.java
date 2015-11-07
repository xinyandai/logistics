package org.module.client.businesslogicservice.orderBLService_stub;

import java.util.ArrayList;

import org.module.client.businesslogicservice.orderBLservice.MailingBLService;
import org.module.client.vo.MailingListVO;


public class MailingBLService_stub implements MailingBLService{

	public double calculatePrice(String senderCity, String receiveCity,
			String counts, String weight, String volume,
			String costOfDecoration, String type) {
		System.out.println("price");
		return 10;
	}

	public double calculateTime(String senderCity, String receiveCity) {
		System.out.println("time");
		return 10;
	}

	public boolean creat(MailingListVO o) {
		// TODO �Զ����ɵķ������
		System.out.println("mail");
		return false;
	}

	public ArrayList<MailingListVO> getAll() {
		// TODO �Զ����ɵķ������
		return null;
	}

	

}
