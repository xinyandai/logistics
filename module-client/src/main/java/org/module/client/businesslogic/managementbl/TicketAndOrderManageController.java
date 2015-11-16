package org.module.client.businesslogic.managementbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.management.TicketAndOrderManageService;
import org.module.client.businesslogicservice.managementBLservice.TicketAndOrderManageBLService;

public class TicketAndOrderManageController implements TicketAndOrderManageBLService{
	
	private TicketAndOrderManageService ticketAndorder ;
	public TicketAndOrderManageController(TicketAndOrderManageService ticketAndorder) {
		super();
		this.ticketAndorder = ticketAndorder;
	}

	public TicketAndOrderManageController() {
		this.ticketAndorder = new TicketAndOrder();
	}
	
	public boolean hasTicketToManage() {
		// TODO Auto-generated method stub
		return ticketAndorder.hasTicketToManage();
	}

	public ArrayList<Object> getTicket() {
		// TODO Auto-generated method stub
		return ticketAndorder.getTicket();
	}

	public boolean pass(ArrayList<String> id) {
		// TODO Auto-generated method stub
		return ticketAndorder.pass(id);
	}

	public boolean unpass(ArrayList<String> id) {
		// TODO Auto-generated method stub
		return ticketAndorder.unpass(id);
	}

}
