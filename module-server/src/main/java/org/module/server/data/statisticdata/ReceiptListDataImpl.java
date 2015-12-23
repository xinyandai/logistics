package org.module.server.data.statisticdata;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.module.common.dataservice.MyList;
import org.module.common.dataservice.statisticdataservice.ReceiptListService;
import org.module.common.po.ReceiptPO;
import org.module.common.po.State;
import org.module.server.data.FileHelper;

public class ReceiptListDataImpl extends UnicastRemoteObject implements ReceiptListService {

	
	private static final long serialVersionUID = 1L;

	public ReceiptListDataImpl() throws RemoteException {
		super();
	}
	private String path = 
			"file"+"/"+"receiptlist.txt";
	private FileHelper dh= new FileHelper(new File(path));
	
	
	public MyList<ReceiptPO> getAll() {
		MyList<ReceiptPO> re = new MyList<ReceiptPO>();
		ArrayList<String>    strs = dh.read();
		for (String string : strs) {
			re.add(new ReceiptPO(string));
		}
		return re;
	}

	
	public boolean add(ReceiptPO ticket) {
		
		return this.dh.add(ticket);
	}

	public boolean delete(String ticket) {
		ArrayList<ReceiptPO> re = this.getAll();
		for (int i = 0; i < re.size(); i++) {
			if(re.get(i).getID().equals(ticket)){
				re.remove(i);
				this.dh.rewrite(re);
				return true;
			}
		}
		
		return false;
	}

	

	public boolean update(ReceiptPO newone) {
		
		ArrayList<ReceiptPO> re = this.getAll();
		for (int i = 0; i < re.size(); i++) {
			if(re.get(i).getID().equals(newone.getID())){
				re.remove(i);
				re.add(newone);
				return true;
			}
		}
		
		return false;
	}


	public MyList<ReceiptPO> getAllBySatte(State state) throws RemoteException {
		MyList<ReceiptPO> re = new MyList<ReceiptPO>();
		ArrayList<String>    strs = dh.read();
		for (String string : strs) {
			ReceiptPO temp = new ReceiptPO(string);
			if(temp.getState()==state){
				re .add(temp);
			}
		}
		return re;
	}


	public MyList<ReceiptPO> getAll(String w) throws RemoteException {
		MyList<ReceiptPO> re = new MyList<ReceiptPO>();
		ArrayList<String>    strs = dh.read();
		for (String string : strs) {
			ReceiptPO po = (new ReceiptPO(string));
			if(po.getWriter().equals(w)){
				re.add(po);
			}
		}
		return re;
	}



}
