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
			ReceiptPO po = new ReceiptPO("2015-10-31", "29.6", "141250023", "1234567890", State.PASS);
		    receiptTest.add(po);
		    
		    ReceiptPO po2 = receiptTest.getAll().get(0);
		    //po = new ReceiptPO("2015-10-31", "29.6", "141250023", "1234567890", State.UNPASS);
		  //  receiptTest.delete("1234567890");
		assert(po.toString().equals(po2.toString()));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
