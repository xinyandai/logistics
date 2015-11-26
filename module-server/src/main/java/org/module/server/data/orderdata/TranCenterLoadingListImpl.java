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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FileHelper help;
	public TranCenterLoadingListImpl() throws RemoteException{
		help = new FileHelper(new File("file"+File.separator+"TranCenterLoadingList.txt"));
	}
	public MyList<TranCenterLoadingListPO> getAll()  throws RemoteException{
		// TODO 自动生成的方法存根
		MyList<TranCenterLoadingListPO> re = new MyList<TranCenterLoadingListPO>();
		MyList<String>    strs = help.read();
		for (String string : strs) {
		/*	String[] temp = string.split(":%:%:");
			String[] ids = new String[temp.length-8];
			for(int i = 0;i<temp.length-8;i++){
				ids[i] = temp[i+6];
			}
			TranCenterLoadingListPO lpo = new TranCenterLoadingListPO(temp[0],temp[1],temp[2],
					temp[3],temp[4],temp[5],ids,temp[temp.length-2],temp[temp.length-1]);
			re.add(lpo);*/
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
			if(all.get(i).getTransportListId().equals(newone.getTransportListId())){
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
			if(a.getState().toString().equals(s.toString())){
				newone.add(a);
			}
		}
		return newone;
	}

}
