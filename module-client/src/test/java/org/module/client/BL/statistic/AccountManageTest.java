package org.module.client.BL.statistic;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.module.client.businesslogic.statisticbl.AccountManageController;
import org.module.client.businesslogicservice.statisticBLservice.AccountManageBLService;
import org.module.client.vo.AccountVO;

public class AccountManageTest extends TestCase {

	private AccountManageBLService account;
	protected void setUp() throws Exception {
		super.setUp();
		account =new AccountManageController( new AccountMock());
		account.showAll();
	}

	

	public void testAdd() {
		assert(account.add("62202", "100"));
	}

	public void testDeleteString() {
		assert(account.delete("62202"));
	}


	public void testAll() {
		ArrayList<AccountVO> a =  account.fuzzySearch("62202");
		assert(a.size()>0);
		
		account.update("62202","200");
		ArrayList<AccountVO> b =  account.fuzzySearch("62202");
		assert(b.get(0).getMoney()-200<1 &&b.get(0).getMoney()-200>-1);
		
		
	}

}
