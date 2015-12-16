package org.module.server.data.departmentdata;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.module.common.dataservice.MyList;
import org.module.common.dataservice.departmentdataservice.DepartmentDataService;
import org.module.common.po.DepartmentPO;
import org.module.server.data.FileHelper;


public class DepartmentDataImpl extends UnicastRemoteObject implements DepartmentDataService {

	public DepartmentDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 4789097559305194975L;
	
	private String path = "file"+File.separator+"departmnt.txt";
	private FileHelper helper = new FileHelper(new File(path));

	
	
	
	
	
	public MyList<DepartmentPO> getAll(){
		MyList<DepartmentPO> re = new MyList<DepartmentPO>();
		MyList<String> strs = this.helper.read();
		for (String string : strs) {
			re.add(new DepartmentPO(string));
		}
		return re;
	}

	public boolean add(DepartmentPO dp) {
		
		return this.helper.add(dp);
		
	}

	public boolean delete(String dp) {
		MyList<DepartmentPO> re = this.getAll();
		for (int i = 0; i < re.size(); i++) {
			System.out.println(re.get(i).getIdentity());
			if(re.get(i).getIdentity().equals(dp)){
				re.remove(i);
				return this.helper.rewrite(re);
			}
		}
		return false;
	}

	public boolean delete(MyList<String> al) {
		boolean re = true;
		for (String string : al) {
			System.out.println(string);
			re = re && this.delete(string);
		}
		return re;
	}

	public boolean update(DepartmentPO one) {
		MyList<DepartmentPO> re = this.getAll();
		for (int i = 0; i < re.size(); i++) {
			if(re.get(i).getIdentity().equals(one.getIdentity())){
				re.remove(i);
				re.add(one);
				return this.helper.rewrite(re);
			}
		}
		return false;
	}


	public DepartmentPO findById(String key) {
		
		MyList<DepartmentPO>  all = this.getAll();
		for (DepartmentPO departmentPO : all) {
			if(departmentPO.getIdentity().equals(key)){
				return departmentPO;
			}
		}
		return null;
	}

	public MyList<DepartmentPO> findByType(String type) throws RemoteException {
		MyList<DepartmentPO> re = new MyList<DepartmentPO>();
		MyList<DepartmentPO> all = this.getAll();
		for (DepartmentPO departmentPO : all) {
			if(departmentPO.getCategory().equals(type)){
				re.add(departmentPO);
			}
		}
		return re;
	}

}
