package org.module.client.BL.management;

import java.util.ArrayList;

import org.module.client.businesslogicservice.management.TicketAndOrderManageService;

public class TicketAndOrderMock implements TicketAndOrderManageService{

	public boolean hasTicketToManage() {
		// TODO Auto-generated method stub
		return true;
	}

	public ArrayList<Object> getTicket() {
		// TODO Auto-generated method stub
		ArrayList<Object> oj=new ArrayList<Object>();
		return oj;
	}

	public boolean pass(ArrayList<String> id) {
		// TODO Auto-generated method stub		
		return id.get(0)=="10086";
	}

	public boolean unpass(ArrayList<String> id) {
		// TODO Auto-generated method stub
		return id.get(0)=="10086";
	}

}
