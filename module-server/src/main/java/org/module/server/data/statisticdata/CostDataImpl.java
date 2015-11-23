package org.module.server.data.statisticdata;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.module.common.dataservice.MyList;
import org.module.common.dataservice.statisticdataservice.CostDataService;
import org.module.common.po.CostListPO;
import org.module.server.data.FileHelper;

public class CostDataImpl extends UnicastRemoteObject implements CostDataService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public CostDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private FileHelper helper = new FileHelper(new File("file"+File.separator+"costl.txt"));
	

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

}
