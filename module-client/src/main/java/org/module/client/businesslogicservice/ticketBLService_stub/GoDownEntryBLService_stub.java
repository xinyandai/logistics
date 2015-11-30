package org.module.client.businesslogicservice.ticketBLService_stub;


import org.module.client.businesslogicservice.ticketBLservice.GoDownEntryBLService;


public class GoDownEntryBLService_stub implements GoDownEntryBLService{
	
	public boolean createTicket(String courier, String date,
			String destination, String qu, String pai, String jia, String wei) {
		// TODO Auto-generated method stub
		
		return false;
	}

	public boolean createTicket(String warehouseOfWhichTranCenter,
			String courier, String date, String destination, String qu,
			String pai, String jia, String wei) {
		System.out.println("GodownEntry");
		return true;
	}
}
