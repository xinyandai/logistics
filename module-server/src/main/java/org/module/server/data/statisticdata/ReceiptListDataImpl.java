package org.module.server.data.statisticdata;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.module.common.dataservice.MyList;
import org.module.common.dataservice.statisticdataservice.ReceiptListService;
import org.module.common.po.ReceiptPO;
import org.module.server.data.FileHelper;

public class ReceiptListDataImpl extends UnicastRemoteObject implements ReceiptListService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public ReceiptListDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}



	FileHelper dh= new FileHelper(new File("file"+File.separator+"receiptlist.txt"));
	
	
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
			if(re.get(i).getOrderId().equals(ticket)){
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
			if(re.get(i).getOrderId().equals(newone.getOrderId())){
				re.remove(i);
				re.add(newone);
				return true;
			}
		}
		
		return false;
	}



}
