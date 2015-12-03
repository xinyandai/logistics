package org.module.server.statisticdata;

import java.rmi.RemoteException;

import junit.framework.TestCase;

import org.module.common.po.ReceiptPO;
import org.module.common.po.State;
import org.module.server.data.statisticdata.ReceiptListDataImpl;

public class ReceiptListTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void test(){
		ReceiptListDataImpl receiptTest;
		try {
			receiptTest = new ReceiptListDataImpl();
			String[] s = { "1234567890" };
			ReceiptPO po = new ReceiptPO("2015-10-31", "29.6", "141250023", s, State.PASS);
		    receiptTest.add(po);
		    
		    ReceiptPO po2 = receiptTest.getAll().get(0);
		assert(po.toString().equals(po2.toString()));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}
}
