package org.module.server.data.orderdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.module.common.dataservice.orderdataservice.TransportListService;
import org.module.common.po.State;
import org.module.common.po.TransportListPO;

public class TransportListImpl extends UnicastRemoteObject implements TransportListService{
	public TransportListImpl() throws RemoteException{
		
	}
	public ArrayList<TransportListPO> getAll()  throws RemoteException{
		// TODO 自动生成的方法存根
		return null;
	}

	public boolean add(TransportListPO o) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public boolean update(TransportListPO newone)  throws RemoteException{
		// TODO 自动生成的方法存根
		return false;
	}

	public ArrayList<TransportListPO> getByState(State s)  throws RemoteException{
		// TODO 自动生成的方法存根
		return null;
	}

}
