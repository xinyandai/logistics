package org.module.server.data.orderdata;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.module.common.dataservice.MyList;
import org.module.common.dataservice.orderdataservice.TransportListService;
import org.module.common.po.State;
import org.module.common.po.TransportListPO;
import org.module.server.data.FileHelper;


public class TransportListImpl extends UnicastRemoteObject implements TransportListService{

	private static final long serialVersionUID = 1L;
	FileHelper help;
	public TransportListImpl() throws RemoteException{
		
		String path = 
				"file"+"/"+"TransportList.txt"
	    	;
		help = new FileHelper(new File(path));
	}
	public MyList<TransportListPO> getAll()  throws RemoteException{
		MyList<TransportListPO> re = new MyList<TransportListPO>();
		MyList<String>    strs = help.read();
		for (String string : strs) {
			
			re.add(new TransportListPO(string));
		}
		return re;
	}

	public boolean add(TransportListPO o) throws RemoteException {
		// TODO 自动生成的方法存根
		return this.help.add(o);
	}

	public boolean update(TransportListPO newone)  throws RemoteException{
		MyList<TransportListPO> all = this.getAll();
		for (int i = 0; i < all.size(); i++) {
			if(all.get(i).getTransListId().equals(newone.getTransListId())){
				all.remove(i);
				all.add(newone);
				return this.help.rewrite(all);
			}
		}
		return false;
	}

	public MyList<TransportListPO> getByState(State s)  throws RemoteException{
		MyList<TransportListPO> oal = this.getAll();
		MyList<TransportListPO> newone = new MyList<TransportListPO>();
		for(TransportListPO a : oal){
			if(a.getState()==s){
				newone.add(a);
			}
		}
		return newone;
	}
	public TransportListPO findById(String id)
			throws RemoteException {
		MyList<TransportListPO> pos = this.getAll();
		for (TransportListPO transportListPO : pos) {
			if(transportListPO.getTransListId().equals(id)){
				return transportListPO;
			}
		}
		return null;
	}
	public MyList<TransportListPO> getAll(String w) throws RemoteException {
		MyList<TransportListPO> re = new MyList<TransportListPO>();
		MyList<String>    strs = help.read();
		for (String string : strs) {
			
			TransportListPO po = (new TransportListPO(string));
			if(po.getWriter().equals(w)){
				re.add(po);
			}
		}
		return re;
	}

}