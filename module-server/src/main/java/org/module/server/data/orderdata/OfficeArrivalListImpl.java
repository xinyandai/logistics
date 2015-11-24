package org.module.server.data.orderdata;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.module.common.dataservice.MyList;
import org.module.common.dataservice.orderdataservice.OfficeArrivalListService;
import org.module.common.po.OfficeArrivalListPO;
import org.module.common.po.State;
import org.module.server.data.FileHelper;

public class OfficeArrivalListImpl extends UnicastRemoteObject implements OfficeArrivalListService{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FileHelper help;
	public OfficeArrivalListImpl() throws RemoteException{
		help = new FileHelper(new File("file"+File.separator+"officeArrivalList.txt"));
	}
	public MyList<OfficeArrivalListPO> getAll()  throws RemoteException{
		MyList<OfficeArrivalListPO> re = new MyList<OfficeArrivalListPO>();
		MyList<String>    strs = help.read();
		for (String string : strs) {
		//	String[] temp = string.split(":%:%:");
			re.add(new OfficeArrivalListPO(string));
		}
		return re;

		
	}

	public boolean add(OfficeArrivalListPO o)  throws RemoteException{
		
		return this.help.add(o);
	}

	public boolean update(OfficeArrivalListPO newone)  throws RemoteException{
		MyList<OfficeArrivalListPO> all = this.getAll();
		for (int i = 0; i < all.size(); i++) {
			if(all.get(i).getTransportListId().equals(newone.getTransportListId())){
				all.remove(i);
				all.add(newone);
				return this.help.rewrite(all);
			}
		}
		return false;
	}

	public MyList<OfficeArrivalListPO> getByState(State s)  throws RemoteException{
		// TODO 自动生成的方法存根
		MyList<OfficeArrivalListPO> oal = this.getAll();
		MyList<OfficeArrivalListPO> newone = new MyList<OfficeArrivalListPO>();
		for(OfficeArrivalListPO a : oal){
			if(a.getState().toString().equals(s.toString())){
				newone.add(a);
			}
		}
		return newone;
	}

}
