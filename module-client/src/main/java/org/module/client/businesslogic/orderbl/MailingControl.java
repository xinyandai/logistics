package org.module.client.businesslogic.orderbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.order.MailingService;
import org.module.client.businesslogicservice.orderBLservice.MailingBLService;
import org.module.client.vo.MailingListVO;


public class MailingControl implements MailingBLService{
	
	private MailingService mailingBLImpl;
	
//	private LogisticsService logistics;
	
	public MailingControl( ) {
		super();
		this.mailingBLImpl = new Mailing();
//		this.logistics = new Logistics();
	}
	public MailingControl(MailingService mailingBLImpl  ) {
		super();
		this.mailingBLImpl = mailingBLImpl;	
//		this.logistics = logistics;
	}



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
		if(mailingBLImpl.creat(mailingListVO)) return true;
		return false;
	}

	

	public int time(String senderCity, String receiveCity) {
		
		return mailingBLImpl.calculateTime(senderCity, receiveCity);
	}



	public double price(String senderCity, String receiveCity, String counts,
			String weight, String volume, String costOfDecoration, String type) {
		
		return mailingBLImpl.calculatePrice(senderCity, receiveCity, counts, 
				weight, volume, costOfDecoration, type);
	}
	public ArrayList<MailingListVO> getAll() {
		// TODO 自动生成的方法存根
		return null;
	}



	

}
