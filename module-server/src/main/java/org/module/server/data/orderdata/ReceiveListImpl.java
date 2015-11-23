package org.module.server.data.orderdata;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.module.common.dataservice.MyList;
import org.module.common.dataservice.orderdataservice.ReceiveListService;
import org.module.common.po.ReceivingListPO;
import org.module.common.po.State;
import org.module.server.data.FileHelper;

public class ReceiveListImpl extends UnicastRemoteObject implements ReceiveListService{
	
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	FileHelper help;
	public ReceiveListImpl() throws RemoteException{
		help = new FileHelper(new File("file"+File.separator+"ReceiveList.txt"));
	}
	public MyList<ReceivingListPO> getAll() throws RemoteException {
		// TODO 自动生成的方法存根
		MyList<ReceivingListPO> re = new MyList<ReceivingListPO>();
		MyList<String>    strs = help.read();
		for (String string : strs) {
			String[] temp = string.split(":%:%:");
			re.add(new ReceivingListPO(temp));
		}
		return re;
		
	}
	
	public boolean add(ReceivingListPO o)  throws RemoteException{
		// TODO 自动生成的方法存根
		return this.help.add(o);
	}

	public boolean update(ReceivingListPO newone)  throws RemoteException{
		MyList<ReceivingListPO> all = this.getAll();
		for (int i = 0; i < all.size(); i++) {
			if(all.get(i).getOrderId().equals(newone.getOrderId())){
				all.remove(i);
				all.add(newone);
				this.help.rewrite(all);
			}
		}
		return false;
	}

	public MyList<ReceivingListPO> getByState(State s)  throws RemoteException{
		// TODO 自动生成的方法存根
		MyList<ReceivingListPO> oal = this.getAll();
		MyList<ReceivingListPO> newone = new MyList<ReceivingListPO>();
		for(ReceivingListPO a : oal){
			if(a.getState().toString().equals(s.toString())){
				newone.add(a);
			}
		}
		return newone;
	}

}
