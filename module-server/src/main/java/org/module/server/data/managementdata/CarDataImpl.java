package org.module.server.data.managementdata;

import java.io.File;
import java.util.ArrayList;

import org.module.common.dataservice.managementdataservice.CarDataService;
import org.module.common.po.CarPO;
import org.module.server.data.FileHelper;

public class CarDataImpl implements CarDataService {
	
	String path="file"+File.separator+"Car.txt";
	File file=new File(path);
	FileHelper help=new FileHelper(file);
	public CarDataImpl() {
		// TODO Auto-generated constructor stub
		
	}

	public ArrayList<CarPO> getAll() {
		// TODO Auto-generated method stub
		ArrayList<String> re = this.help.read();
		ArrayList<CarPO> ar =  new ArrayList<CarPO>();	
		for (String string : re) {
			ar.add(new CarPO(string));
		}
		return ar;
	}

	public boolean add(CarPO cp) {
		// TODO Auto-generated method stub
		return this.help.add(cp);
	}

	public boolean delete(CarPO cp) {
		// TODO Auto-generated method stub
		ArrayList<CarPO> pos = this.getAll();
		 for (int i = 0; i < pos.size(); i++) {
			 if(pos.get(i).getId().equals(cp.getId())){
				 pos.remove(i);					
				 return help.rewrite(pos);
			 }
		 }
		return false;
	}

	public boolean delete(ArrayList<CarPO> al) {
		// TODO Auto-generated method stub
		boolean re = true;
		for (CarPO CarPO : al) {
			if(!this.delete(CarPO)) {
				re = false;
			}
		}
		return re;
	}

	public boolean update(CarPO old, CarPO newone) {
		// TODO Auto-generated method stub
		this.delete(old);
		this.add(newone);
		return false;
	}

}
