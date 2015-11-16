package org.module.client.BL.order;

import org.module.client.businesslogic.orderbl.TransportController;
import org.module.client.businesslogicservice.orderBLservice.TransportBLService;

import junit.framework.TestCase;


public class TransportTest extends TestCase {

	private TransportBLService t;
	protected void setUp() throws Exception {
		super.setUp();
		t = new TransportController(new TransportMock());
	}

	public void testCreat() {
		assert(t.creat("025000001", "1000036562362", "00200020140880000001", "025000001", "南京", "北京", "", "", "", ""));
	}

}
