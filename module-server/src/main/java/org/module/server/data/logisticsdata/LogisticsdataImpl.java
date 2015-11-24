package org.module.server.data.logisticsdata;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.module.common.dataservice.MyList;
import org.module.common.dataservice.logisticsdataservice.Logisticsdataservice;
import org.module.common.po.LogisticsPO;
import org.module.server.data.FileHelper;


public class LogisticsdataImpl extends UnicastRemoteObject implements Logisticsdataservice {

	
	private FileHelper helper = new FileHelper(new File("file"+File.separator+"logistics.txt"));
	public LogisticsdataImpl() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = -2401297333474889326L;

	public MyList<LogisticsPO> getAll() throws RemoteException {
		MyList<LogisticsPO> re = new MyList<LogisticsPO>();
		ArrayList<String> strs = this.helper.read();
		for (String string : strs) {
			re.add(new LogisticsPO(string));
		}
		return re;
	}

	public LogisticsPO getOrder(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updata(LogisticsPO newone) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	


}
