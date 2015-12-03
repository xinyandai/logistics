package org.module.server.data.departmentdata;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.module.common.dataservice.MyList;
import org.module.common.dataservice.departmentdataservice.StuffDataService;
import org.module.common.po.StuffPO;
import org.module.server.data.FileHelper;

public class StuffDataImpl extends UnicastRemoteObject implements StuffDataService {

	public StuffDataImpl() throws RemoteException {
		super();
	}

	
	private static final long serialVersionUID = 1L;
	private FileHelper helper = new FileHelper(new File("file"+File.separator+"stuff.txt"));


	public MyList<StuffPO> getAll() {
		MyList<StuffPO> re = new MyList<StuffPO>();
		ArrayList<String>  strs = this.helper.read();
		for (String string : strs) {
			re.add(new StuffPO(string));
		}
		return re;
	}

	public boolean add(StuffPO dp) {
		return this.helper.add(dp);
	}

	

	

	public boolean update(StuffPO one) {
		if(this.delete(one.getIdentity())){
			if(this.add(one)){
				return true;
			}
		}
		return false;
	}

	public MyList<StuffPO> fuzzusearch(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(String id) {
		 ArrayList<StuffPO> pos = this.getAll();
		 for (int i = 0; i < pos.size(); i++) {
			 if(pos.get(i).getIdentity().equals(id)){
				 pos.remove(i);
				 return this.helper.rewrite(pos);
			 }
		 }
		return false;
	}

	public boolean delete(MyList<String> id) {
		boolean re = true;
		for (int i = 0; i < id.size(); i++) {
			if(!this.delete(id.get(i))) re = false;
		 }
		return re;
	}

}
