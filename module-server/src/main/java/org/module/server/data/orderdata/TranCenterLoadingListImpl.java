package org.module.server.data.orderdata;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.module.common.dataservice.MyList;
import org.module.common.dataservice.orderdataservice.TranCenterLoadingListService;
import org.module.common.po.State;
import org.module.common.po.TranCenterLoadingListPO;
import org.module.server.data.FileHelper;

public class TranCenterLoadingListImpl extends UnicastRemoteObject  implements TranCenterLoadingListService{

	private static final long serialVersionUID = 1L;
	FileHelper help;
	public TranCenterLoadingListImpl() throws RemoteException{
		
		String path = 
				"file"+"/"+"TranCenterLoadingList.txt"
	    	;
		help = new FileHelper(new File(path));
	}
	public MyList<TranCenterLoadingListPO> getAll()  throws RemoteException{

		MyList<TranCenterLoadingListPO> re = new MyList<TranCenterLoadingListPO>();
		MyList<String>    strs = help.read();
		for (String string : strs) {
		
			re.add(new TranCenterLoadingListPO(string));
		}
		return re;
	}

	public boolean add(TranCenterLoadingListPO o)  throws RemoteException{
		// TODO 自动生成的方法存根
		return this.help.add(o);
	}

	public boolean update(TranCenterLoadingListPO newone)  throws RemoteException{
		MyList<TranCenterLoadingListPO> all = this.getAll();
		for (int i = 0; i < all.size(); i++) {
			if(all.get(i).getOfficeId().equals(newone.getOfficeId())){
				all.remove(i);
				all.add(newone);
				return this.help.rewrite(all);
			}
		}
		return false;
	}

	public MyList<TranCenterLoadingListPO> getByState(State s) throws RemoteException {
		MyList<TranCenterLoadingListPO> oal = this.getAll();
		MyList<TranCenterLoadingListPO> newone = new MyList<TranCenterLoadingListPO>();
		for(TranCenterLoadingListPO a : oal){
			if(a.getState()==s){
				newone.add(a);
			}
		}
		return newone;
	}
	public MyList<TranCenterLoadingListPO> getAll(String w)
			throws RemoteException {
		MyList<TranCenterLoadingListPO> re = new MyList<TranCenterLoadingListPO>();
		MyList<String>    strs = help.read();
		for (String string : strs) {
		
			TranCenterLoadingListPO po = (new TranCenterLoadingListPO(string));
			if(po.getWriter().equals(w)){
				re.add(po);
			}
		}
		return re;
	}

}
