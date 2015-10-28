package data.departmentdata;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import po.DepartmentPO;
import po.UserPO;
import dataservice.MyList;
import dataservice.departmentdataservice.DepartmentDataService;

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
	
	
	
	@Override
	public ArrayList<DepartmentPO> getAll() {
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

	@Override
	public boolean add(DepartmentPO dp) {
		ArrayList<DepartmentPO> re = this.getAll();
		re.add(dp);
		return this.write(re);
		
	}

	@Override
	public boolean delete(DepartmentPO dp) {
		ArrayList<DepartmentPO> re = this.getAll();
		re.remove(dp);
		return this.write(re);
	}

	@Override
	public boolean delete(ArrayList<DepartmentPO> al) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updata(DepartmentPO old, DepartmentPO newone) {
		// TODO Auto-generated method stub
		return false;
	}

}
