package org.module.server.data.orderdata;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.module.common.dataservice.MyList;
import org.module.common.dataservice.orderdataservice.AbstractOrderDataService;
import org.module.common.po.AbstractPO;
import org.module.common.po.State;
import org.module.server.data.FileHelper;
import org.module.server.data.POfactory;

public class OrderDataImpl<T extends AbstractPO> extends UnicastRemoteObject implements AbstractOrderDataService<T> {

	
	private static final long serialVersionUID = -9044257448337594066L;
	FileHelper help;
	POfactory<T>  poFactory;
	
	public OrderDataImpl(String path,POfactory<T> po) throws RemoteException {
		poFactory = po;
		help = new FileHelper(new File(path));
	}
	
	public MyList<T> getAll()  throws RemoteException{
		MyList<T> re = new MyList<T>();
		MyList<String>    strs = help.read();
		for (String string : strs) {
			re.add(poFactory.getPO(string));
		}
		return re;

		
	}

	public boolean add(T o)  throws RemoteException{
		return this.help.add(o);
	}

	public boolean update(T newone)  throws RemoteException{
		MyList<T> all = this.getAll();
		for (int i = 0; i < all.size(); i++) {
			if(all.get(i).getNniqueID().equals(newone.getNniqueID())){
				all.remove(i);
				all.add(newone);
				return this.help.rewrite(all);
			}
		}
		return false;
	}

	public MyList<T> getByState(State s)  throws RemoteException{
		// TODO 自动生成的方法存根
		MyList<T> oal = this.getAll();
		MyList<T> newone = new MyList<T>();
		for(T a : oal){
			if(a.getState()==s){
				newone.add(a);
			}
		}
		return newone;
	}
	public MyList<T> getAll(String w)
			throws RemoteException {
		MyList<T> re = new MyList<T>();
		MyList<String>    strs = help.read();
		for (String string : strs) {
			T po = (poFactory.getPO(string));
			if(po.getBelongsToPersonOrDepartment().equals(w)){
				re.add(po);
			}
		}
		return re;
	}

	

}
