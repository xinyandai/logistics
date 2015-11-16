package org.module.client.BL.management;

import java.util.ArrayList;

import org.module.client.businesslogic.managementbl.TicketAndOrderManageController;
import org.module.client.businesslogicservice.managementBLservice.TicketAndOrderManageBLService;

import junit.framework.TestCase;

public class TicketAndOrderManageTest extends TestCase {
	private TicketAndOrderManageBLService ticketAndOrder;
	
	protected void setUp() throws Exception {
		super.setUp();
		ticketAndOrder = new TicketAndOrderManageController(new TicketAndOrderMock());
	}
	
	public void testhasTicketToManage(){
		assert(ticketAndOrder.hasTicketToManage());
	}
	
	/*public void testgetTicket(){
		assert(ticketAndOrder.getTicket().get(0).equals(null));
	}*/
	
	public void testpass(){
		ArrayList<String> st=new ArrayList<String>();
		st.add("10086");
		assert(ticketAndOrder.pass(st));
	}
	
	public void testunpass(){
		ArrayList<String> st=new ArrayList<String>();
		st.add("10086");
		assert(ticketAndOrder.unpass(st));
	}
}
