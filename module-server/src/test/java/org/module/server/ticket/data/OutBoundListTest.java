package org.module.server.ticket.data;

import java.rmi.RemoteException;

import junit.framework.TestCase;

import org.module.common.po.OutBoundListPO;
import org.module.common.po.State;
import org.module.server.data.ticketData.OutBoundListDataImpl;

public class OutBoundListTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testUpdate() {
		try {
			OutBoundListDataImpl data = new OutBoundListDataImpl();
			OutBoundListPO po = new OutBoundListPO("courier","date","destination",
					"car","tansportListId","通过");
			data.add(po);
			assert(data.getByState(State.PASS).get(0).equals(po.toString()));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
