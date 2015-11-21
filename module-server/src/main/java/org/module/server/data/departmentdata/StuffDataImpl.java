package org.module.server.data.departmentdata;

import java.io.File;
import java.util.ArrayList;

import org.module.common.dataservice.departmentdataservice.StuffDataService;
import org.module.common.po.StuffPO;
import org.module.server.data.FileHelper;

public class StuffDataImpl implements StuffDataService {

	private FileHelper helper = new FileHelper(new File("src"+File.separator+".txt"));
	public StuffDataImpl() {
	}

	public ArrayList<StuffPO> getAll() {
		ArrayList<StuffPO> re = new ArrayList<StuffPO>();
		ArrayList<String>  strs = this.helper.read();
		for (String string : strs) {
			re.add(new StuffPO(string));
		}
		return re;
	}

	public boolean add(StuffPO dp) {
		return this.helper.add(dp);
	}

	

	

	public boolean update(StuffPO one) {
		this.delete(one.getIdentity());
		this.add(one);
		return false;
	}

	public ArrayList<StuffPO> fuzzusearch(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(String id) {
		 ArrayList<StuffPO> pos = this.getAll();
		 for (int i = 0; i < pos.size(); i++) {
			 if(pos.get(i).getIdentity().equals(id)){
				 pos.remove(i);
				 return true;
			 }
		 }
		return false;
	}

	public boolean delete(ArrayList<String> id) {
		boolean re = true;
		for (int i = 0; i < id.size(); i++) {
			if(!this.delete(id.get(i))) re = false;
		 }
		return re;
	}

}
