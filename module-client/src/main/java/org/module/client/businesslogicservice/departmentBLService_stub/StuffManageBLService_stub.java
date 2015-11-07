package org.module.client.businesslogicservice.departmentBLService_stub;

import java.util.ArrayList;

import org.module.client.businesslogicservice.departmentBLservice.StuffManageBLService;
import org.module.client.vo.StuffVO;



public class StuffManageBLService_stub implements StuffManageBLService{
	StuffVO svo;
	public ArrayList<StuffVO> showAll() {
		System.out.println("show all stuff"); 
		return null;
	}

	public boolean add(StuffVO d) {
		System.out.println("add successfully");
		return false;
	}

	public boolean delete(StuffVO d) {
		if(d.getIdentity().length() == 9){
			this.svo = d;
			System.out.println("delete successfully");
			return true;
		}
		return false;
	}

	public boolean delete(ArrayList<StuffVO> ald) {
		return false;
	}

	public boolean modify(StuffVO newone) {
		if(newone.getIdentity().equals("140010001")){
			System.out.println("can change");
			return true;
		}
		return false;
	}

	public ArrayList<StuffVO> fuzzySearch(String s) {
		return null;
	}
	
}
