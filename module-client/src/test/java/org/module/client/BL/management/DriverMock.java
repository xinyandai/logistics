package org.module.client.BL.management;

import java.util.ArrayList;

import org.module.client.businesslogicservice.management.DriversManageService;
import org.module.client.vo.DriverVO;

public class DriverMock implements DriversManageService{

	public ArrayList<DriverVO> showAll() {
		// TODO Auto-generated method stub
		ArrayList<DriverVO> re = new ArrayList<DriverVO>();
		re.add(new DriverVO("10086","name","0401","342401199001010000",
				"13812345678","男","2015"));
		return re;
	}

	public boolean add(DriverVO c) {
		// TODO Auto-generated method stub
		return (c.getId()=="10086");
	}

	public boolean modify(DriverVO newone) {
		// TODO Auto-generated method stub
		return (newone.getId()=="10086");
	}

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return (id=="10086");
	}

	public boolean delete(ArrayList<String> al) {
		// TODO Auto-generated method stub
		return true;
	}

	public ArrayList<DriverVO> fuzzySearch(String s) {
		// TODO Auto-generated method stub
		ArrayList<DriverVO> re = new ArrayList<DriverVO>();
		re.add(new DriverVO("10086","name","0401","342401199001010000",
				"13812345678","男","2015"));
		return re;
	}

}
