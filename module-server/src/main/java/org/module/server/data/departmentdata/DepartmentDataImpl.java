package org.module.server.data.departmentdata;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.module.common.dataservice.MyList;
import org.module.common.dataservice.departmentdataservice.DepartmentDataService;
import org.module.common.po.DepartmentPO;


public class DepartmentDataImpl implements DepartmentDataService {

	private String spt = ":%:%:";
	private String path = "file"+File.separator+"departmnt.txt";
	public DepartmentDataImpl() {
	}

	
	public boolean write(ArrayList<DepartmentPO> r){

		File file = new File(path);
		try {
			FileWriter fW = new FileWriter(file);
			BufferedWriter br = new BufferedWriter(fW);
			for (DepartmentPO po : r) {
				br.write(po.toString()+"\n");
			}
			br.flush();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	
	public ArrayList<DepartmentPO> getAll(){
		MyList<DepartmentPO> re = new MyList<DepartmentPO>();
		File file = new File(path);
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String record = null;
			while ((record = br.readLine()) != null) {
				re.add(new DepartmentPO(record.split(spt)));
			}
			br.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return re;
	}

	public boolean add(DepartmentPO dp) {
		ArrayList<DepartmentPO> re = this.getAll();
		re.add(dp);
		return this.write(re);
		
	}

	public boolean delete(String dp) {
		ArrayList<DepartmentPO> re = this.getAll();
		re.remove(dp);
		return this.write(re);
	}

	public boolean delete(ArrayList<String> al) {
		return false;
	}

	public boolean update(DepartmentPO one) {
		return false;
	}


	public ArrayList<DepartmentPO> fuzzusearch(String key) {
		return null;
	}

}
