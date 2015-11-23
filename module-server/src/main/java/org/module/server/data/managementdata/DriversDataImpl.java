package org.module.server.data.managementdata;

import java.io.File;
import java.util.ArrayList;

import org.module.common.dataservice.managementdataservice.DriversDataService;
import org.module.common.po.DriverPO;
import org.module.server.data.FileHelper;

public class DriversDataImpl implements DriversDataService{

	String path="file"+File.separator+"Driver.txt";
	File file=new File(path);
	FileHelper help=new FileHelper(file);
	
	public DriversDataImpl() {
		// TODO Auto-generated constructor stub
	}

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
				 ArrayList<Object> c =  new ArrayList<Object>();
					c.add(pos);
					return help.rewrite(c);
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
				ArrayList<Object> c =  new ArrayList<Object>();
				c.add(re);
				return help.rewrite(c);
			}
		}		
		return false;
	}

}
