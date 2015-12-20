package org.module.server.data.statisticdata;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.module.common.dataservice.MyList;
import org.module.common.dataservice.statisticdataservice.CostDataService;
import org.module.common.po.CostListPO;
import org.module.common.po.State;
import org.module.server.data.FileHelper;

public class CostDataImpl extends UnicastRemoteObject implements CostDataService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public CostDataImpl() throws RemoteException {
		super();
	}
	private String s = "file"+"/"+"costl.txt";
	private FileHelper helper = new FileHelper(new File(s));
	

	public boolean update(CostListPO newone){
		ArrayList<CostListPO> re = this.getAll();
		for (int i = 0; i < re.size(); i++) {
			if(re.get(i).getID().equals(newone.getID())){
				re.remove(i);
				re.add(newone);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean addCostList(CostListPO c) {
		
		return this.helper.add(c);
	}

	public MyList<CostListPO> getAll() {
		MyList<CostListPO> re = new MyList<CostListPO>();
		ArrayList<String> strs = this.helper.read();
		for (String string : strs) {
			re.add(new CostListPO(string));
		}
		return re;
	}

	public MyList<CostListPO> getAllBySatte(State state) throws RemoteException {
		MyList<CostListPO> re = new MyList<CostListPO>();
		ArrayList<String> strs = this.helper.read();
		for (String string : strs) {
			CostListPO temp = new CostListPO(string);
			if(temp.getState().toString().equals(state.toString())){
				re.add(temp);
			}
		}
		return re;
	}

}
