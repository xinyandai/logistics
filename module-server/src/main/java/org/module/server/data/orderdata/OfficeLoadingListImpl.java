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
		help = new FileHelper(new File("file"+File.separator+"officeLoadingList.txt"));
	}
	public MyList<OfficeLoadingListPO> getAll()  throws RemoteException{
		// TODO 自动生成的方法存根
		MyList<OfficeLoadingListPO> re = new MyList<OfficeLoadingListPO>();
		MyList<String>    strs = help.read();
		for (String string : strs) {
			String[] temp = string.split(":%:%:");
			re.add(new OfficeLoadingListPO(temp));
		}
		return re;
	}

	public boolean add(OfficeLoadingListPO o)  throws RemoteException{
		
		return this.help.add(o);
	}

	public boolean update(OfficeLoadingListPO newone)  throws RemoteException{
		// TODO 自动生成的方法存根
		return false;
	}

	public MyList<OfficeLoadingListPO> getByState(State s)  throws RemoteException{
		// TODO 自动生成的方法存根
		MyList<OfficeLoadingListPO> oal = this.getAll();
		MyList<OfficeLoadingListPO> newone = new MyList<OfficeLoadingListPO>();
		for(OfficeLoadingListPO a : oal){
			if(a.getState().toString().equals(s.toString())){
				newone.add(a);
			}
		}
		return newone;
	}

}
