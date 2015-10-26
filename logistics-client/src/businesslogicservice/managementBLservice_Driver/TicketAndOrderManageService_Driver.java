package businesslogicservice.managementBLservice_Driver;

import java.util.ArrayList;

import businesslogicservice.managementBLservice.TicketAndOrderManageService;

public class TicketAndOrderManageService_Driver {
	public void drive(TicketAndOrderManageService ticketAndOrderManageService){
		ArrayList<Object> result=new ArrayList();
		result=null;
		result=ticketAndOrderManageService.getTicket("tickettype", "state");
		if(result!=null)
			System.out.println("get successfully!");
	}
}
