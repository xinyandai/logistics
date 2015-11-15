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



	public ArrayList<StuffVO> fuzzySearch(String s) {
		return null;
	}

	public boolean add(String name, String age, String category, String identity) {
		System.out.println("add successfully");
		return false;
	}

	public boolean delete(String identity) {
		if(identity.length() == 9){
			System.out.println("delete successfully");
			return true;
		}
		return false;
	}

	public boolean delete(ArrayList<String> ids) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(String name, String age, String category,
			String identity) {
		if(identity.equals("0250000000")){
			System.out.println("can change");
			return true;
		}
		return false;
	}
	
	
	
	
	
	
}
