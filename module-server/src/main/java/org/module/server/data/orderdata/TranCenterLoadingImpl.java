package org.module.server.data.orderdata;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.module.common.dataservice.orderdataservice.TranCenterLoadingService;
import org.module.common.po.SendingListPO;
import org.module.common.po.State;
import org.module.common.po.TranCenterLoadingListPO;
import org.module.server.data.FileHelper;

public class TranCenterLoadingImpl extends UnicastRemoteObject  implements TranCenterLoadingService{
	FileHelper help;
	public TranCenterLoadingImpl() throws RemoteException{
		help = new FileHelper(new File("file"+File.separator+"TranCenterLoadingList.txt"));
	}
	public ArrayList<TranCenterLoadingListPO> getAll()  throws RemoteException{
		// TODO 自动生成的方法存根
		ArrayList<TranCenterLoadingListPO> re = new ArrayList<TranCenterLoadingListPO>();
		ArrayList<String>    strs = help.read();
		for (String string : strs) {
			String[] temp = string.split(":%:%:");
			
			
		}
		return re;
	}

	public boolean add(TranCenterLoadingListPO o)  throws RemoteException{
		// TODO 自动生成的方法存根
		return false;
	}

	public boolean update(TranCenterLoadingListPO newone)  throws RemoteException{
		// TODO 自动生成的方法存根
		return false;
	}

	public ArrayList<TranCenterLoadingListPO> getByState(State s) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

}
