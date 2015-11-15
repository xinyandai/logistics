package org.module.client.businesslogic.deparmentbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.department.DepartmentManageService;
import org.module.client.businesslogicservice.departmentBLservice.DepartmentManageBLService;
import org.module.client.vo.DepartmentVO;

public class DepartmentManageController implements DepartmentManageBLService{
	private DepartmentManageService department ;
	public DepartmentManageController(DepartmentManageService department) {
		super();
		this.department = department;
	}

	public DepartmentManageController() {
		this.department = new Department();
	}

	public ArrayList<DepartmentVO> showAll() {
		// TODO Auto-generated method stub
		return department.showAll();
	}

	public boolean add(String name, String category, String location,
			String identity) {
		// TODO Auto-generated method stub
		return department.add(new DepartmentVO(name,category,location,identity));
	}

	public boolean delete(String identity) {
		// TODO Auto-generated method stub
		return department.delete(identity);
	}

	public boolean delete(ArrayList<String> ids) {
		// TODO Auto-generated method stub
		return department.delete(ids);
	}

	public boolean modify(String name, String category, String location,
			String identity) {
		// TODO Auto-generated method stub
		return department.modify(new DepartmentVO(name,category,location,identity));
	}

	public ArrayList<DepartmentVO> fuzzySearch(String s) {
		// TODO Auto-generated method stub
		return department.fuzzySearch(s);
	}

}
