package org.module.client.businesslogicservice.managementBLService_stub;

import java.util.ArrayList;

import org.module.client.businesslogicservice.managementBLservice.DriversManageBLService;
import org.module.client.vo.DriverVO;


public class DriversManageService_stub implements DriversManageBLService{

	public ArrayList<DriverVO> showAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean add(String id, String name, String birthday, String idcard,
			String phone, String gender, String date) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean modify(String id, String name, String birthday,
			String idcard, String phone, String gender, String date) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(ArrayList<String> id) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<DriverVO> fuzzySearch(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
