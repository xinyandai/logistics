package org.module.client.BL.statistic;

import java.util.ArrayList;

import org.module.client.businesslogicservice.statistic.AccountService;
import org.module.client.vo.AccountVO;
import org.module.common.dataservice.MyList;

public class AccountMock implements AccountService{

	private AccountVO vo = new AccountVO("62202","100");
  
	public boolean add(AccountVO vo) {
		return true;
	}

	public boolean delete(String id) {
		if(id.equals("62202")) return true;
		return false;
	}

	public boolean delete(MyList<String> a) {
		return true;
	}

	public boolean update(AccountVO a) {
		
		if( a.getId().equals(vo.getId())){
			this.vo.setMoney(a.getMoney());
		}
		return false;
	}

	

	public boolean pay(String id, double b) {
		ArrayList<AccountVO> list = this.showAll();
		for (AccountVO a : list) {
			if(a.getId().equals(id)){
				a.setMoney(a.getMoney()-b);
			}
		}
		return false;
	}

	public boolean income(String id, double b) {
		ArrayList<AccountVO> list = this.showAll();
		for (AccountVO a : list) {
			if(a.getId().equals(id)){
				a.setMoney(a.getMoney()+b);
			}
		}
		return false;
	}

	public ArrayList<AccountVO> showAll() {
		ArrayList<AccountVO> list = new ArrayList<AccountVO>();
		list.add(vo);
		return list;
	}

	public ArrayList<AccountVO> fuzzySearch(String s) {
		ArrayList<AccountVO> list = new ArrayList<AccountVO>();
		if(s.equals(vo.getId())) list.add(vo);
		return list;
		
	}

}
