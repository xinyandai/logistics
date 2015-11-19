package org.module.client.BL.order;

import junit.framework.TestCase;

import org.module.client.businesslogic.orderbl.MailingControl;
import org.module.client.businesslogicservice.orderBLservice.MailingBLService;

public class MailingTest extends TestCase {

	private MailingBLService mail;
	protected void setUp() throws Exception {
		super.setUp();
		mail = new MailingControl(new MailingMock());
	}

	public void testAdd() {
		boolean a = mail.handleMailingList("senderName",  "senderCompany",
				 "senderMobile",  "senderPhone",  "senderCity",
				 "senderPosition",  "receiveName",  "receiveCompany",
				 "receiveMobile",  "receivePhone",  "receiveCity",
				 "receivePosition",  "nameOfGood",  "counts",
				 "weight",  "volume",  "costOfDecoration","type",
				 "1400000000");
		//System.out.println(a);
		assert(a);
	}
	
	public void testPrice(){
		double a = mail.price("南京", "北京","1" ," 2", "20", "1", "经济快递");
		//System.out.println(a);
		assert(a>0);
	}
	
	public void testTime(){
		int time = mail.time("南京", "北京");
		assert(time>0);
	}
}
