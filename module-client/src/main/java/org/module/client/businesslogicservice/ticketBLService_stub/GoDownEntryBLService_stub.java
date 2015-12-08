package org.module.client.businesslogicservice.ticketBLService_stub;


import java.util.ArrayList;

import org.module.client.businesslogicservice.ticketBLservice.GoDownEntryBLService;
import org.module.client.vo.GoDownEntryVO;


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

	public boolean createTicket(GoDownEntryVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<GoDownEntryVO> getAll(long start, long end) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean update(GoDownEntryVO vo) {
		// TODO Auto-generated method stub
		return false;
	}
}
