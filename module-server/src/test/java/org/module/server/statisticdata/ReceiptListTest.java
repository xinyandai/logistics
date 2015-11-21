package org.module.server.statisticdata;

import junit.framework.TestCase;

import org.module.common.po.ReceiptPO;
import org.module.server.data.statistcdate.ReceiptListDataImpl;

public class ReceiptListTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void test(){
		ReceiptListDataImpl r = new ReceiptListDataImpl();
		ReceiptPO po = new ReceiptPO("2015-10-31", "29.6", "141250023", "1234567890", "通过");
		r.add(po);
		ReceiptPO po2 = r.getAll().get(0);
		assert(po.toString().equals(po2.toString()));
	}
}
