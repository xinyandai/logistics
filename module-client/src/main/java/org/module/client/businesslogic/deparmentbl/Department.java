package org.module.client.businesslogic.deparmentbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.module.client.businesslogicservice.department.DepartmentService;
import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.DepartmentVO;
import org.module.common.dataservice.MyList;
import org.module.common.dataservice.departmentdataservice.DepartmentDataService;
import org.module.common.po.DepartmentPO;

public class Department implements DepartmentService {
	
	private DepartmentDataService data;
	public Department() {
		this.data = new RmiClient().get(DepartmentDataService.class);
	}

	public ArrayList<DepartmentVO> showAll() {
		ArrayList<DepartmentVO> vos = new ArrayList<DepartmentVO>();
		ArrayList<DepartmentPO> pos;
		try {
			pos = this.data.getAll();
			for (DepartmentPO departmentPO : pos) {
			vos.add(new DepartmentVO(
					departmentPO.getName(),
					departmentPO.getCategory(),
					departmentPO.getLocation(),
					departmentPO.getIdentity()
					)
			);
		}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return vos;
	}

	public boolean add(DepartmentVO departmentPO) {
		try {
			return this.data.add(
					new DepartmentPO(
							departmentPO.getName(),
							departmentPO.getCategory(),
							departmentPO.getLocation(),
							departmentPO.getIdentity()
							)
					);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(String identity) {
		try {
			return this.data.delete(identity);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(MyList<String> ids) {
		try {
			return this.data.delete(ids);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean modify(DepartmentVO departmentPO) {
		try {
			return this.data.update(
					new DepartmentPO(
							departmentPO.getName(),
							departmentPO.getCategory(),
							departmentPO.getLocation(),
							departmentPO.getIdentity()
							)
					);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<DepartmentVO> fuzzySearch(String s) {
		ArrayList<DepartmentVO> vos = new ArrayList<DepartmentVO>();
		ArrayList<DepartmentPO> pos;
		try {
			pos = this.data.fuzzusearch(s);
			for (DepartmentPO departmentPO : pos) {
			vos.add(new DepartmentVO(
					departmentPO.getName(),
					departmentPO.getCategory(),
					departmentPO.getLocation(),
					departmentPO.getIdentity()
					)
			);
		}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return vos;
	}

}
