package org.module.client.businesslogic.statisticbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.module.client.businesslogicservice.statistic.AccountService;
import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.AccountVO;
import org.module.common.dataservice.MyList;
import org.module.common.dataservice.statisticdataservice.AccountDataService;
import org.module.common.po.AccountPO;

public class Account implements AccountService {

	AccountDataService data;
	public Account() {
		this.data = RmiClient.get(AccountDataService.class);
	}

	
	public boolean add(AccountVO vo) {
		try {
			return data.add(new AccountPO(vo.getId(),vo.getMoney()+""));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(String id) {
		try {
			return data.delete(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(MyList<String> a) {
		try {
			return this.data.delete(a);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(AccountVO vo) {
		try {
			return this.data.update(new AccountPO(vo.getId(),vo.getMoney()+""));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	

	public boolean pay(String id, double b) {
		return false;
	}

	public boolean income(String id, double b) {
		return false;
	}


	public ArrayList<AccountVO> showAll() {
		return null;
	}


	public ArrayList<AccountVO> fuzzySearch(String s) {
		return null;
	}

}
