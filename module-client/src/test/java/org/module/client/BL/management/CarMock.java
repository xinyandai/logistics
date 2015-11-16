package org.module.client.BL.management;

import java.util.ArrayList;

import org.module.client.businesslogicservice.management.CarsManageService;
import org.module.client.vo.CarVO;

public class CarMock implements CarsManageService{

	public ArrayList<CarVO> showAll() {
		// TODO Auto-generated method stub
		ArrayList<CarVO> re = new ArrayList<CarVO>();
		re.add(new CarVO("10086","110","2015"));
		return re;
	}

	public boolean add(CarVO c) {
		// TODO Auto-generated method stub		
		return (c.getId().equals("10086"));
	}

	public boolean modify(CarVO newone) {
		// TODO Auto-generated method stub
		return (newone.getId().equals("10086"));
	}

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return (id.equals("10086"));
	}

	public boolean delete(ArrayList<String> id) {
		// TODO Auto-generated method stub
		return true;
	}

	public ArrayList<CarVO> fuzzySearch(String s) {
		// TODO Auto-generated method stub
		ArrayList<CarVO> re = new ArrayList<CarVO>();
		re.add(new CarVO("10086","110","2015"));
		return re;
	}

}
