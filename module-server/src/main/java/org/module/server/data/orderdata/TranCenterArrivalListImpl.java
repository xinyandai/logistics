package org.module.server.data.orderdata;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.module.common.dataservice.MyList;
import org.module.common.dataservice.orderdataservice.TranCenterArrivalListService;
import org.module.common.po.State;
import org.module.common.po.TranCenterArrivalListPO;
import org.module.server.data.FileHelper;

public class TranCenterArrivalListImpl extends UnicastRemoteObject implements TranCenterArrivalListService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FileHelper help;
	public TranCenterArrivalListImpl() throws RemoteException{
		help = new FileHelper(new File("file"+File.separator+"TranCenterArrivalList.txt"));
	}
	public MyList<TranCenterArrivalListPO> getAll()  throws RemoteException{
		// TODO 自动生成的方法存根
		MyList<TranCenterArrivalListPO> re = new MyList<TranCenterArrivalListPO>();
		MyList<String>    strs = help.read();
		for (String string : strs) {
			String[] temp = string.split(":%:%:");
			re.add(new TranCenterArrivalListPO(temp));
		}
		return re;
	}

	public boolean add(TranCenterArrivalListPO o)  throws RemoteException{
		// TODO 自动生成的方法存根
		
		return this.help.add(o);
	}

	public boolean update(TranCenterArrivalListPO newone) throws RemoteException {
		MyList<TranCenterArrivalListPO> all = this.getAll();
		for (int i = 0; i < all.size(); i++) {
			if(all.get(i).getTransId().equals(newone.getTransId())){
				all.remove(i);
				all.add(newone);
				this.help.rewrite(all);
			}
		}
		return false;
	}

	public ArrayList<TranCenterArrivalListPO> getByState(State s)  throws RemoteException{
		// TODO 自动生成的方法存根
		ArrayList<TranCenterArrivalListPO> oal = this.getAll();
		ArrayList<TranCenterArrivalListPO> newone = new ArrayList<TranCenterArrivalListPO>();
		for(TranCenterArrivalListPO a : oal){
			if(a.getState().toString().equals(s.toString())){
				newone.add(a);
			}
		}
		return newone;
	}

}
