package org.module.client.businesslogicservice.managementBLservice_Driver;

import java.util.ArrayList;

import org.module.client.businesslogicservice.managementBLservice.TicketAndOrderManageBLService;


public class TicketAndOrderManageService_Driver {
	public void drive(TicketAndOrderManageBLService ticketAndOrderManageService){
		ArrayList<Object> result=new ArrayList<Object>();
		result=null;
		result=ticketAndOrderManageService.getTicket();
		if(result!=null)
			System.out.println("get successfully!");
	}
}
