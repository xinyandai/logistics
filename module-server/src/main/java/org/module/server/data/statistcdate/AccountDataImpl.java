package org.module.server.data.statistcdate;

import java.io.File;
import java.util.ArrayList;

import org.module.common.dataservice.statisticdataservice.AccountDataService;
import org.module.common.po.AccountPO;
import org.module.common.po.StuffPO;
import org.module.server.data.FileHelper;

public class AccountDataImpl implements AccountDataService {

	private FileHelper helper = new FileHelper(new File("src"+File.separator+".txt"));
	public AccountDataImpl() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<AccountPO> getAll() {
		ArrayList<AccountPO> re = new ArrayList<AccountPO>();
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
				 return true;
			 }
		 }
		return false;
	}

	public boolean delete(ArrayList<String> ticket) {
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

	public ArrayList<AccountPO> fuzzusearch(String key) {
		return null;
	}

}
