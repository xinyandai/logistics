package org.module.server.data.managementdata;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.module.common.dataservice.managementdataservice.DriversDataService;
import org.module.common.po.DriverPO;
import org.module.server.data.FileHelper;

public class DriversDataImpl extends UnicastRemoteObject  implements DriversDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8447605741329427326L;



	public DriversDataImpl() throws RemoteException {
		super();
	}

	String path="file"+File.separator+"Driver.txt";
	File file=new File(path);
	FileHelper help=new FileHelper(file);
	
	

	public ArrayList<DriverPO> getAll() {
		// TODO Auto-generated method stub
		ArrayList<String> re = this.help.read();
		ArrayList<DriverPO> ar =  new ArrayList<DriverPO>();	
		for (String string : re) {
			ar.add(new DriverPO(string));
		}
		return ar;
	}

	public boolean add(DriverPO cp) {
		// TODO Auto-generated method stub
		return this.help.add(cp);
	}

	public boolean delete(DriverPO cp) {
		// TODO Auto-generated method stub
		ArrayList<DriverPO> pos = this.getAll();
		 for (int i = 0; i < pos.size(); i++) {
			 if(pos.get(i).getId().equals(cp.getId())){
				 pos.remove(i);
					return help.rewrite(pos);
			 }
		 }
		return false;
	}

	public boolean delete(ArrayList<DriverPO> al) {
		// TODO Auto-generated method stub
		boolean re = true;
		for (DriverPO DriverPO : al) {
			if(!this.delete(DriverPO)) {
				re = false;
			}
		}
		return re;
	}

	public boolean update(DriverPO newone) {
		// TODO Auto-generated method stub
		ArrayList<DriverPO> re = this.getAll();
		for (int i = 0; i < re.size(); i++) {
			if(re.get(i).getId().equals(newone.getId())){
				re.remove(i);
				re.add(newone);
				return help.rewrite(re);
			}
		}		
		return false;
	}

}
