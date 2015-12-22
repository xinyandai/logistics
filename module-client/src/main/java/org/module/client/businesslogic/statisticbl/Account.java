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

	private AccountDataService data;
	public Account() {
		this.data = new RmiClient().get(AccountDataService.class);
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
		
		if(b<=0){
			return false;
		}
		return this.change(id, -b);
	}

	public boolean income(String id, double b) {
		if(b<=0){
			return false;
		}
		return this.change(id, b);
	}

	private boolean change(String id, double b){
		try {
			AccountPO po = this.data.findById(id);
			if( Double.parseDouble(po.getMoney())+b<0){
				return false;
			}
			if( Double.parseDouble(po.getMoney())+b>Double.MAX_VALUE){
				return false;
			}
			AccountVO vo = new AccountVO(po.getId(),(Double.parseDouble(po.getMoney())+b)+"");
			return this.data.update(new AccountPO(vo.getId(),vo.getMoney()+""));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<AccountVO> showAll() {
		ArrayList<AccountVO> re = new ArrayList<AccountVO>();
		try {
			ArrayList<AccountPO> pos = this.data.getAll();
			for (AccountPO accountPO : pos) {
				re.add(new AccountVO(accountPO.getId(),accountPO.getMoney()));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return re;
	}


	public ArrayList<AccountVO> fuzzySearch(String s) {
		ArrayList<AccountVO> re = new ArrayList<AccountVO>();
		try {
			ArrayList<AccountPO> pos = this.data.fuzzusearch(s);
			for (AccountPO accountPO : pos) {
				re.add(new AccountVO(accountPO.getId(),accountPO.getMoney()));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return re;
	}
	
	public String[] getAccountArray(){
		ArrayList<AccountVO> vos = this.showAll();
		String[] re = new String[vos.size()];
		for (int i = 0; i < re.length; i++) {
			re[i] = vos.get(i).getId();
		}
		return re;
	}
	
	public AccountVO getDefaultAccount(){
		ArrayList<AccountVO> pos = this.showAll();
		if(pos.size()==0) {
			return null;
		}
		return pos.get(0);
	}

}
