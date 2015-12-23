package org.module.server.data.orderdata;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

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
		String path = 
				"file"+"/"+"TranCenterArrivalList.txt"
	    	;
		help = new FileHelper(new File(path));
	}
	public MyList<TranCenterArrivalListPO> getAll()  throws RemoteException{
		MyList<TranCenterArrivalListPO> re = new MyList<TranCenterArrivalListPO>();
		MyList<String>    strs = help.read();
		for (String string : strs) {
			re.add(new TranCenterArrivalListPO(string));
		}
		return re;
	}

	public boolean add(TranCenterArrivalListPO o)  throws RemoteException{
		
		return this.help.add(o);
	}

	public boolean update(TranCenterArrivalListPO newone) throws RemoteException {
		MyList<TranCenterArrivalListPO> all = this.getAll();
		for (int i = 0; i < all.size(); i++) {
			if(all.get(i).getTransId().equals(newone.getTransId())){
				all.remove(i);
				all.add(newone);
				this.help.rewrite(all);
				return true;
			}
		}
		return false;
	}

	public MyList<TranCenterArrivalListPO> getByState(State s)  throws RemoteException{

		MyList<TranCenterArrivalListPO> oal = this.getAll();
		MyList<TranCenterArrivalListPO> newone = new MyList<TranCenterArrivalListPO>();
		for(TranCenterArrivalListPO a : oal){
			if(a.getState()==s){
				newone.add(a);
			}
		}
		return newone;
	}
	public MyList<TranCenterArrivalListPO> getAll(String w)
			throws RemoteException {
		MyList<TranCenterArrivalListPO> re = new MyList<TranCenterArrivalListPO>();
		MyList<String>    strs = help.read();
		for (String string : strs) {
			TranCenterArrivalListPO po = (new TranCenterArrivalListPO(string));
			if(po.getWriter().equals(w)){
				re.add(po);
			}
		}
		return re;
	}

}
