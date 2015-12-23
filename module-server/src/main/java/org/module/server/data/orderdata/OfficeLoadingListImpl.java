package org.module.server.data.orderdata;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.module.common.dataservice.MyList;
import org.module.common.dataservice.orderdataservice.OfficeLoadingListService;
import org.module.common.po.OfficeLoadingListPO;
import org.module.common.po.State;
import org.module.server.data.FileHelper;

public class OfficeLoadingListImpl extends UnicastRemoteObject implements OfficeLoadingListService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FileHelper help;
	public OfficeLoadingListImpl() throws RemoteException{
		String path = 
				"file"+"/"+"officeLoadingList.txt"
	    	;
		help = new FileHelper(new File(path));
	}
	public MyList<OfficeLoadingListPO> getAll()  throws RemoteException{
		MyList<OfficeLoadingListPO> re = new MyList<OfficeLoadingListPO>();
		MyList<String>    strs = help.read();
		for (String string : strs) {
			re.add(new OfficeLoadingListPO(string));
		}
		return re;
	}

	public boolean add(OfficeLoadingListPO o)  throws RemoteException{
		
		return this.help.add(o);
	}

	public boolean update(OfficeLoadingListPO newone)  throws RemoteException{
		MyList<OfficeLoadingListPO> all = this.getAll();
		for (int i = 0; i < all.size(); i++) {
			if(all.get(i).getTrucksId().equals(newone.getTrucksId())){
				all.remove(i);
				all.add(newone);
				return this.help.rewrite(all);
			}
		}
		return false;
	}

	public MyList<OfficeLoadingListPO> getByState(State s)  throws RemoteException{
		// TODO 自动生成的方法存根
		MyList<OfficeLoadingListPO> oal = this.getAll();
		MyList<OfficeLoadingListPO> newone = new MyList<OfficeLoadingListPO>();
		for(OfficeLoadingListPO a : oal){
			if(a.getState()==s){
				newone.add(a);
			}
		}
		return newone;
	}
	public MyList<OfficeLoadingListPO> getAll(String w) throws RemoteException {
		MyList<OfficeLoadingListPO> re = new MyList<OfficeLoadingListPO>();
		MyList<String>    strs = help.read();
		for (String string : strs) {
			OfficeLoadingListPO po = (new OfficeLoadingListPO(string));
			if(po.getWriter().equals(w)){
				re.add(po);
			}
		}
		return re;
	}

}
