package org.module.server.data.managementdata;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.module.common.dataservice.MyList;
import org.module.common.dataservice.managementdataservice.CarDataService;
import org.module.common.po.CarPO;
import org.module.server.data.FileHelper;

public class CarDataImpl extends UnicastRemoteObject implements CarDataService {
	
	public CarDataImpl() throws RemoteException {
		super();
	}
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 5027123081037793884L;
	String path = 
			"file"+"/"+"Car.txt"
    	;
	File file=new File(path);
	FileHelper help=new FileHelper(file);
	

	public MyList<CarPO> getAll() {
		// TODO Auto-generated method stub
		ArrayList<String> re = this.help.read();
		MyList<CarPO> ar =  new MyList<CarPO>();	
		for (String string : re) {
			ar.add(new CarPO(string));
		}
		return ar;
	}

	public boolean add(CarPO cp) {
		// TODO Auto-generated method stub
		return this.help.add(cp);
	}

	public boolean delete(String cp) {
		// TODO Auto-generated method stub
		ArrayList<CarPO> pos = this.getAll();
		 for (int i = 0; i < pos.size(); i++) {
			 if(pos.get(i).getId().equals(cp)){
				 pos.remove(i);					
				 return help.rewrite(pos);
			 }
		 }
		return false;
	}

	public boolean delete(MyList<String> al) {
		// TODO Auto-generated method stub
		boolean re = true;
		for (String s : al) {
			if(!this.delete(s)) {
				re = false;
			}
		}
		return re;
	}

	public boolean update(CarPO newone) {
		// TODO Auto-generated method stub
		this.delete(newone.getId());
		this.add(newone);
		return false;
	}

}
