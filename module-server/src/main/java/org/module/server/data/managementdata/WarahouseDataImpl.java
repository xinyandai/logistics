package org.module.server.data.managementdata;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.module.common.dataservice.managementdataservice.WarahouseDataService;
import org.module.common.po.WarehousePO;
import org.module.server.data.FileHelper;

public class WarahouseDataImpl  extends UnicastRemoteObject implements WarahouseDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8672640557938555302L;



	public WarahouseDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	String path="file"+File.separator+"Warahouse.txt";
	File file=new File(path);
	FileHelper help=new FileHelper(file);
	
	

	public ArrayList<WarehousePO> getAll() {
		// TODO Auto-generated method stub
		ArrayList<String> re = this.help.read();
		ArrayList<WarehousePO> ar =  new ArrayList<WarehousePO>();	
		for (String string : re) {
			ar.add(new WarehousePO(string));
		}
		return ar;
	}

	public boolean add(WarehousePO cp) {
		// TODO Auto-generated method stub
		return this.help.add(cp);
	}

	public boolean delete(WarehousePO cp) {
		// TODO Auto-generated method stub
		ArrayList<WarehousePO> pos = this.getAll();
		 for (int i = 0; i < pos.size(); i++) {
			 if(pos.get(i).getNumber().equals(cp.getNumber())){
				pos.remove(i);
				return help.rewrite(pos);
			 }
		 }
		return false;
	}

	public boolean update(WarehousePO old, WarehousePO newone) {
		// TODO Auto-generated method stub
		ArrayList<WarehousePO> re = this.getAll();
		for (int i = 0; i < re.size(); i++) {
			if(re.get(i).getNumber().equals(newone.getNumber())){
				re.remove(i);
				re.add(newone);
				return help.rewrite(re);
			}
		}		
		return false;
	}

	public void setBorderline(double a) {
		// TODO Auto-generated method stub

	}

}
