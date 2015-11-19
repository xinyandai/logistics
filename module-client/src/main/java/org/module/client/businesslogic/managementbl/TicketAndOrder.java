package org.module.client.businesslogic.managementbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.management.TicketAndOrderManageService;

public class TicketAndOrder implements TicketAndOrderManageService{

	public boolean hasTicketToManage() {
		return false;
	}

	public ArrayList<Object> getTicket() {
		return null;
	}

	public boolean pass(ArrayList<String> id) {
		return false;
	}

	public boolean unpass(ArrayList<String> id) {
		return false;
	}

}
