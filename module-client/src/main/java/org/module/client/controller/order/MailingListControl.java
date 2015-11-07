package org.module.client.controller.order;

import org.module.client.businesslogicservice.orderBLService_stub.MailingBLService_stub;
import org.module.client.businesslogicservice.orderBLservice.MailingBLService;
import org.module.client.controllerService.order.InputMailingListService;
import org.module.client.vo.MailingListVO;

public class MailingListControl implements InputMailingListService{
	private MailingBLService mailingBLImpl = new MailingBLService_stub();
	public boolean handleMailingList(String senderName, String senderCompany,
			String senderMobile, String senderPhone, String senderCity,
			String senderPosition, String receiveName, String receiveCompany,
			String receiveMobile, String receivePhone, String receiveCity,
			String receivePosition, String nameOfGood, String counts,
			String weight, String volume, String costOfDecoration, String type,
			String id) {

		MailingListVO mailingListVO = new MailingListVO( senderName,  senderCompany,
				 senderMobile,  senderPhone,  senderCity,
				 senderPosition,  receiveName,  receiveCompany,
				 receiveMobile,  receivePhone,  receiveCity,
				 receivePosition,  nameOfGood,  counts,
				 weight,  volume,  costOfDecoration,type,
				 id);
		String[] info =  { senderName,  senderCompany,
				 senderMobile,  senderPhone,  senderCity,
				 senderPosition,  receiveName,  receiveCompany,
				 receiveMobile,  receivePhone,  receiveCity,
				 receivePosition,  nameOfGood,  counts,
				 weight,  volume,  costOfDecoration,type};
		for (String string : info) {
			if(string.isEmpty()) return false;
		}
		return mailingBLImpl.creat(mailingListVO);
	}

	

	public int time(String senderCity, String receiveCity) {
		
		return (int)mailingBLImpl.calculateTime(senderCity, receiveCity);
	}



	public int price(String senderCity, String receiveCity, String counts,
			String weight, String volume, String costOfDecoration, String type) {
		
		return (int)mailingBLImpl.calculatePrice(senderCity, receiveCity, counts, 
				weight, volume, costOfDecoration, type);
	}
	

}
