package org.module.server.data.ticketData;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.module.common.dataservice.MyList;
import org.module.common.dataservice.ticketdataservice.GoDownEntryListService;
import org.module.common.po.GoDownEntryListPO;
import org.module.common.po.State;
import org.module.server.data.FileHelper;

public class GoDownEntryListDataImpl extends UnicastRemoteObject  implements GoDownEntryListService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GoDownEntryListDataImpl() throws RemoteException {
		super();
	}
	private FileHelper helper = new FileHelper(new File("file"+File.separator+"goDownEntryList.txt"));
	
	public MyList<GoDownEntryListPO> getAll() throws RemoteException {
		
		MyList<GoDownEntryListPO> re = new MyList<GoDownEntryListPO>();
		ArrayList<String> strs = this.helper.read();
		for (String string : strs) {
			re.add(new GoDownEntryListPO(string));
		}
		return re;
	}
	
	public boolean add(GoDownEntryListPO ticket) throws RemoteException {
		return this.helper.add(ticket);
	}
	
	public boolean update(GoDownEntryListPO newone) throws RemoteException {
		MyList<GoDownEntryListPO> all = this.getAll();
		for (int i = 0; i < all.size(); i++) {
			if(all.get(i).getId().equals(newone.getId())){
				all.remove(i);
				all.add(newone);
				this.helper.rewrite(all);
			}
		}
		return false;
	}
	public MyList<GoDownEntryListPO> getByState(State s) throws RemoteException{
		MyList<GoDownEntryListPO> all = this.getAll();
		MyList<GoDownEntryListPO> re = new MyList<GoDownEntryListPO>();
		for (int i = 0; i < all.size(); i++) {
			if(all.get(i).getState().toString().equals(s.toString())){
				re.add(all.get(i));
			}
		}
		return re;
	}

}
