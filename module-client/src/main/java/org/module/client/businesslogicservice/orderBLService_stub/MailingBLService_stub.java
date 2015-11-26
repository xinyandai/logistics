package org.module.client.businesslogicservice.orderBLService_stub;

import java.util.ArrayList;

import org.module.client.businesslogicservice.orderBLservice.MailingBLService;
import org.module.client.vo.MailingListVO;
import org.module.common.po.State;


public class MailingBLService_stub implements MailingBLService{

	public double price(String senderCity, String receiveCity,
			String counts, String weight, String volume,
			String costOfDecoration, String type) {
		System.out.println("price");
		return 10;
	}

	public int time(String senderCity, String receiveCity) {
		System.out.println("time");
		return 10;
	}


	public ArrayList<MailingListVO> getAll() {
		// TODO �Զ����ɵķ������
		return null;
	}



	public boolean handleMailingList(String senderName, String senderCompany,
			String senderMobile, String senderPhone, String senderCity,
			String senderPosition, String receiveName, String receiveCompany,
			String receiveMobile, String receivePhone, String receiveCity,
			String receivePosition, String nameOfGood, String counts,
			String weight, String volume, String costOfDecoration, String type,
			String id) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
