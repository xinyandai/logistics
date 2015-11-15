package org.module.client.businesslogic.statisticbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.statistic.AccountService;
import org.module.client.businesslogicservice.statisticBLservice.AccountManageBLService;
import org.module.client.vo.AccountVO;

public class AccountManageController implements AccountManageBLService {

	private AccountService account;
	public AccountManageController() {
		account = new Account();
	}

	public AccountManageController(AccountService accountManager) {
		super();
		this.account = accountManager;
	}



	public boolean add(String id, String rest) {
		
		return account.add(new AccountVO(id,rest));
	}

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return account.delete(id);
	}

	public boolean delete(ArrayList<String> a) {
		// TODO Auto-generated method stub
		return account.delete(a);
	}

	public boolean update(String id, String rest) {
		// TODO Auto-generated method stub
		return account.update(new AccountVO(id,rest));
	}

	public ArrayList<AccountVO> showAll() {
		// TODO Auto-generated method stub
		return account.showAll();
	}

	public ArrayList<AccountVO> fuzzySearch(String s) {
		// TODO Auto-generated method stub
		return account.fuzzySearch(s);
	}

}
