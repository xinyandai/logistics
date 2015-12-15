package org.module.client.businesslogic.statisticbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.statistic.AccountService;
import org.module.client.businesslogicservice.statisticBLservice.AccountManageBLService;
import org.module.client.vo.AccountVO;
import org.module.common.dataservice.MyList;

public class AccountManageController implements AccountManageBLService {

	private AccountService account;
	private ArrayList<AccountVO> list;
	
	public AccountManageController() {
		account = new Account();
	}

	public AccountManageController(AccountService accountManager) {
		super();
		this.account = accountManager;
	}



	public boolean add(String id, String rest) {
		
		for (AccountVO accountVO : list) {
			if(accountVO.getId().equals(id)){
				return false;
			}
		}
		AccountVO vo = new AccountVO(id,rest);
		this.list.add(vo);
		return account.add(vo);
	}

	public boolean delete(String id) {
		return account.delete(id);
	}

	public boolean delete(MyList<String> a) {
		return account.delete(a);
	}

	public boolean update(String id, String rest) {
		return account.update(new AccountVO(id,rest));
	}

	public ArrayList<AccountVO> showAll() {
		this.list = account.showAll();
		return this.list;
	}

	public ArrayList<AccountVO> fuzzySearch(String s) {
		return account.fuzzySearch(s);
	}

	public boolean delete(int[] a) {
		
		MyList<String> ids  = new MyList<String>();
		for (int i = a.length-1 ; i>=0 ; i--) {
			ids.add(list.get(a[i]).getId());
			this.list.remove(a[i]);
			
		}
		return this.account.delete(ids);
	}

}
