package org.module.server.data.orderdata;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.module.common.dataservice.MyList;
import org.module.common.dataservice.orderdataservice.SendingListService;
import org.module.common.po.SendingListPO;
import org.module.common.po.State;
import org.module.server.data.FileHelper;

public class SendingListImpl extends UnicastRemoteObject implements SendingListService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FileHelper help;
	public SendingListImpl() throws RemoteException{
		help = new FileHelper(new File("file"+File.separator+"SendingList.txt"));
	}
	
	public MyList<SendingListPO> getAll()  throws RemoteException{
		
		MyList<SendingListPO> re = new MyList<SendingListPO>();
		MyList<String>    strs = help.read();
		for (String string : strs) {
//			String[] temp = string.split(":%:%:");
			re.add(new SendingListPO(string));
		}
		return re;
	}

	public boolean add(SendingListPO o)  throws RemoteException{
		// TODO 自动生成的方法存根
		
		return this.help.add(o);
	}

	public boolean update(SendingListPO newone)  throws RemoteException{
		MyList<SendingListPO> all = this.getAll();
		for (int i = 0; i < all.size(); i++) {
			if(all.get(i).getShippingId().equals(newone.getShippingId())){
				all.remove(i);
				all.add(newone);
				return this.help.rewrite(all);
			}
		}
		return false;
	}

	public MyList<SendingListPO> getByState(State s) throws RemoteException {
		// TODO 自动生成的方法存根
		MyList<SendingListPO> oal = this.getAll();
		MyList<SendingListPO> newone = new MyList<SendingListPO>();
		for(SendingListPO a : oal){
			if(a.getState().toString().equals(s.toString())){
				newone.add(a);
			}
		}
		return newone;
	}

}
