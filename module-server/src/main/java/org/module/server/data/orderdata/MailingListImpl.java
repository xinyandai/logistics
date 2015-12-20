package org.module.server.data.orderdata;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.module.common.dataservice.MyList;
import org.module.common.dataservice.orderdataservice.MailingListService;
import org.module.common.po.MailingListPO;
import org.module.common.po.State;
import org.module.server.data.FileHelper;

public class MailingListImpl extends UnicastRemoteObject implements MailingListService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String path = 
			"file"+"/"+"mailingList.txt"
    	;
	File file = new File(path);
	FileHelper help = new FileHelper(file);
	
	public MailingListImpl() throws RemoteException{
		
	}
	//觉得有问题
	
	
	public MyList<MailingListPO> getAll() throws RemoteException{
		
		MyList<MailingListPO> re = new MyList<MailingListPO>();
		MyList<String>    strs = help.read();
		for (String string : strs) {
			//String[] temp = string.split(":%:%:");
			re.add(new MailingListPO(string));
		}
		return re;
	}

	public boolean add(MailingListPO o) throws RemoteException{
		return this.help.add(o);
	}

	public boolean update(MailingListPO newone)  throws RemoteException{
		MyList<MailingListPO> all = this.getAll();
		for (int i = 0; i < all.size(); i++) {
			if(all.get(i).getId().equals(newone.getId())){
				all.remove(i);
				all.add(newone);
				this.help.rewrite(all);
				return true;
			}
		}
		return false;
	}

	public MyList<MailingListPO> getByState(State s) throws RemoteException {
		MyList<MailingListPO> oal = this.getAll();
		MyList<MailingListPO> newone = new MyList<MailingListPO>();
		for(MailingListPO a : oal){
			if(a.getState().toString().equals(s.toString())){
				newone.add(a);
			}
		}
		return newone;
		
	}
	public ArrayList<MailingListPO> getAll(String w) throws RemoteException {
		MyList<MailingListPO> re = new MyList<MailingListPO>();
		MyList<String>    strs = help.read();
		for (String string : strs) {
			MailingListPO  po= 	new MailingListPO(string);
			if(po.getWriter().equals(w)){
				re.add(po);
			}
		}
		return re;
	}

}
