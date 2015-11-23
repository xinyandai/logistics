package org.module.server.ticket.data;

import java.rmi.RemoteException;

import junit.framework.TestCase;

import org.module.common.po.GoDownEntryListPO;
import org.module.server.data.ticketData.GoDownEntryListDataImpl;

public class GoDownEntryListTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testGoDownEntryListDataImpl() {
		try {
			GoDownEntryListDataImpl data = new GoDownEntryListDataImpl();
			GoDownEntryListPO po = new GoDownEntryListPO("courier","date", "destination",
					"qu", "pai","jia", "wei","不通过");
			data.add(po);
			
			assert(data.getAll().get(0).toString().equals(po.toString()));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
