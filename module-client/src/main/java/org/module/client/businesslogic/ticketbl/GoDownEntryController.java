package org.module.client.businesslogic.ticketbl;

import org.module.client.businesslogicservice.ticket.GoDownEntryService;
import org.module.client.businesslogicservice.ticketBLservice.GoDownEntryBLService;
import org.module.client.vo.GoDownEntryVO;

public class GoDownEntryController implements GoDownEntryBLService{

	private GoDownEntryService goDownEntry ;
	public GoDownEntryController(GoDownEntryService goDownEntry) {
		super();
		this.goDownEntry = goDownEntry;
	}

	public GoDownEntryController() {
		this.goDownEntry = new GoDownEntry();
	}
	
	public boolean createTicket(String courier, String date,
			String destination, String qu, String pai, String jia, String wei) {
		return goDownEntry.createTicket(new GoDownEntryVO(courier, date,
				destination, qu,pai, jia, wei));
	}

}
