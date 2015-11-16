package org.module.client.BL.order;

import junit.framework.TestCase;

import org.module.client.businesslogic.orderbl.MailingListControl;
import org.module.client.businesslogicservice.order.MailingService;
import org.module.client.businesslogicservice.orderBLservice.MailingBLService;

public class MailingTest extends TestCase {

	private MailingBLService mail;
	protected void setUp() throws Exception {
		super.setUp();
		mail = new MailingListControl(new MailingMock(),
				new CalculateTimeMock(),
				new CalculateDriverCostMock(),
				new LogisticsMock());
	}

	public void testAdd() {
		assert(mail.handleMailingList("senderName",  "senderCompany",
				 "senderMobile",  "senderPhone",  "senderCity",
				 "senderPosition",  "receiveName",  "receiveCompany",
				 "receiveMobile",  "receivePhone",  "receiveCity",
				 "receivePosition",  "nameOfGood",  "counts",
				 "weight",  "volume",  "costOfDecoration","type",
				 "1400000000"));
	}
	
	public void testPrice(){
		double a = mail.price("南京", "北京","1" ," 2", "20", "1", "经济快递");
		assert(a>0);
	}
	
	public void testTime(){
		int time = mail.time("南京", "北京");
		assert(time>0);
	}
}
