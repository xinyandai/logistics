package org.module.client.businesslogic.managementbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.management.CarsManageService;
import org.module.client.businesslogicservice.managementBLservice.CarsManageBLService;
import org.module.client.vo.CarVO;

public class CarsManageController implements CarsManageBLService{

	private CarsManageService car ;
	public CarsManageController(CarsManageService car) {
		super();
		this.car = car;
	}

	public CarsManageController() {
		this.car = new Car();
	}

	public ArrayList<CarVO> showAll() {
		// TODO Auto-generated method stub
		return car.showAll();
	}

	public boolean add(String id, String license, String time) {
		// TODO Auto-generated method stub
		return car.add(new CarVO( id, license, time));
	}

	public boolean modify(String id, String license, String time) {
		// TODO Auto-generated method stub
		return car.modify(new CarVO( id, license, time));
	}

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return car.delete(id);
	}

	public boolean delete(ArrayList<String> id) {
		// TODO Auto-generated method stub
		return car.delete(id);
	}

	public ArrayList<CarVO> fuzzySearch(String s) {
		// TODO Auto-generated method stub
		return car.fuzzySearch(s);
	}
	
	

}
