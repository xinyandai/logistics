package org.module.client.businesslogicservice.departmentBLService_stub;

import java.util.ArrayList;

import org.module.client.businesslogicservice.departmentBLservice.DepartmentManageBLService;
import org.module.client.vo.DepartmentVO;


public class DepartmentManageBLService_stub implements DepartmentManageBLService {
	DepartmentVO dpvo;
	public ArrayList<DepartmentVO> showAll() {
		System.out.println("show all departments");
		return null;
	}

	public boolean add(DepartmentVO d) {
		System.out.println("add successfully");
		return false;
	}

	public boolean delete(DepartmentVO d) {
		System.out.println("delete successfully");
		return false;
	}

	public boolean delete(ArrayList<DepartmentVO> ald) {
		System.out.println("delete successfully");
		return false;
	}

	public boolean modify(DepartmentVO newone) {
		System.out.println("modify successfully");
		return false;
	}

	public ArrayList<DepartmentVO> fuzzySearch(String s) {
		System.out.println("find!");
		return null;
	}

}
