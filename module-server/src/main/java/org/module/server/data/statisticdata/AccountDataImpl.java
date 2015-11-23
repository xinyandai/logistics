package org.module.server.data.statisticdata;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.module.common.dataservice.MyList;
import org.module.common.dataservice.statisticdataservice.AccountDataService;
import org.module.common.po.AccountPO;
import org.module.server.data.FileHelper;

public class AccountDataImpl extends UnicastRemoteObject implements AccountDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FileHelper helper = new FileHelper(new File("file"+File.separator+"account.txt"));
	public AccountDataImpl()  throws RemoteException{
	}

	public MyList<AccountPO> getAll() {
		MyList<AccountPO> re = new MyList<AccountPO>();
		ArrayList<String> strs = this.helper.read();
		for (String string : strs) {
			re.add(new AccountPO(string));
		}
		return re;
	}

	public boolean add(AccountPO ticket) {
		
		return this.helper.add(ticket);
	}

	public boolean delete(String id) {
		ArrayList<AccountPO> pos = this.getAll();
		 for (int i = 0; i < pos.size(); i++) {
			 if(pos.get(i).getId().equals(id)){
				 pos.remove(i);
				 this.helper.rewrite(pos);
				 return true;
			 }
		 }
		return false;
	}

	public boolean delete(MyList<String> ticket) {
		boolean re = true;
		for (String id : ticket) {
			if(!this.delete(id)) {
				re = false;
			}
		}
		return re;
	}

	public boolean update(AccountPO newone) {
		this.delete(newone.getId());
		this.add(newone);
		return false;
	}

	public MyList<AccountPO> fuzzusearch(String key) {
		return null;
	}

}
