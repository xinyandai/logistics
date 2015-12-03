package org.module.client.businesslogicservice.order;

import java.util.ArrayList;

import org.module.client.vo.MailingListVO;

/**
 * 寄件
 * @author 
 */
public interface MailingService {

	public boolean creat(MailingListVO o) ;

	public ArrayList<MailingListVO> getAll() ;

	public double calculatePrice(String senderCity, String receiveCity,
			String counts, String weight, String volume,
			String costOfDecoration, String type);

	public int calculateTime(String senderCity, String receiveCity) ;
	
}
