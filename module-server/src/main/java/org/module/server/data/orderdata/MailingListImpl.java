package org.module.server.data.orderdata;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.module.common.dataservice.MyList;
import org.module.common.dataservice.orderdataservice.MailingListService;
import org.module.common.po.DepartmentPO;
import org.module.common.po.MailingListPO;
import org.module.common.po.OfficeArrivalListPO;
import org.module.common.po.OfficeLoadingListPO;
import org.module.common.po.State;
import org.module.server.data.FileHelper;

public class MailingListImpl extends UnicastRemoteObject implements MailingListService{
	private String spt = ":%:%:";
	private String path = "file"+File.separator+"mailingList.txt";
	File file = new File(path);
	FileHelper help = new FileHelper(file);
	public MailingListImpl() throws RemoteException{
		
	}
	//觉得有问题
	
	
	public MyList<MailingListPO> getAll() throws RemoteException{
		
		MyList<MailingListPO> re = new MyList<MailingListPO>();
		MyList<String>    strs = help.read();
		for (String string : strs) {
			String[] temp = string.split(":%:%:");
			re.add(new MailingListPO(temp));
		}
		return re;
	}

	public boolean add(MailingListPO o) throws RemoteException{
		
		return this.help.add(o);
	}

	public boolean update(MailingListPO newone)  throws RemoteException{
		// TODO 自动生成的方法存根
		return false;
	}

	public MyList<MailingListPO> getByState(State s) throws RemoteException {
		// TODO 自动生成的方法存根
		MyList<MailingListPO> oal = this.getAll();
		MyList<MailingListPO> newone = new MyList<MailingListPO>();
		for(MailingListPO a : oal){
			if(a.getState().toString().equals(s.toString())){
				newone.add(a);
			}
		}
		return newone;
		
	}

}
