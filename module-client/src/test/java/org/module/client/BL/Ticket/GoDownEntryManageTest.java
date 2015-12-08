package org.module.client.BL.Ticket;

import org.module.client.businesslogic.ticketbl.GoDownEntryController;
import org.module.client.businesslogicservice.ticketBLservice.GoDownEntryBLService;

import junit.framework.TestCase;

public class GoDownEntryManageTest extends TestCase {
	private GoDownEntryBLService goDownEntry;
	
	protected void setUp() throws Exception {
		super.setUp();
		goDownEntry = new GoDownEntryController(new GoDownEntryMock());
	}
	
	public void testcreateTicket(){
		//assert(goDownEntry.createTicket("025156","01","2015","beijing","110","1","1","1"));
	}
}
