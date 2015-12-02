package org.module.server.data.managementdata;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.module.common.dataservice.MyList;
import org.module.common.dataservice.managementdataservice.WarahouseDataService;
import org.module.common.po.WarehousePO;
import org.module.server.data.FileHelper;

public class WarahouseDataImpl extends UnicastRemoteObject  implements WarahouseDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4574838135272237174L;



	public WarahouseDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	


	public boolean add(WarehousePO cp) {
		FileHelper help=new FileHelper(new File(
				"file"+File.separator+"warehouse"+File.separator+cp.getWarehouseOfWhichTranCenter()+".txt"));
		return help.add(cp);
	}

	

	public boolean update( WarehousePO newone) throws RemoteException{
		FileHelper help=new FileHelper(new File(
				"file"+File.separator+"warehouse"+File.separator+newone.getWarehouseOfWhichTranCenter()+".txt"));
		ArrayList<WarehousePO> re = this.getAll(newone.getWarehouseOfWhichTranCenter());
		for (int i = 0; i < re.size(); i++) {
			if(re.get(i).samePalace(newone)){
				re.remove(i);
				re.add(newone);
				return help.rewrite(re);
			}
		}		
		return false;
	}

	public MyList<WarehousePO> getAll(String id) throws RemoteException {
		FileHelper help=new FileHelper(new File(
				"file"+File.separator+"warehouse"+File.separator+id+".txt"));
		ArrayList<String> re = help.read();
		MyList<WarehousePO> ar =  new MyList<WarehousePO>();	
		for (String string : re) {
			ar.add(new WarehousePO(string));
		}
		return ar;
	}

	public boolean delete(WarehousePO cp) throws RemoteException {
		FileHelper help=new FileHelper(new File(
				"file"+File.separator+"warehouse"+File.separator+cp.getWarehouseOfWhichTranCenter()+".txt"));
		
		ArrayList<WarehousePO> pos = this.getAll(cp.getWarehouseOfWhichTranCenter());
		 for (int i = 0; i < pos.size(); i++) {
			 if(pos.get(i).samePalace(cp)){
				pos.remove(i);
				return help.rewrite(pos);
			 }
		 }
		return false;
	}


}