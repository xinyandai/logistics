package org.module.client.businesslogic.managementbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.management.DriversManageService;
import org.module.client.businesslogicservice.managementBLservice.DriversManageBLService;
import org.module.client.vo.DriverVO;
import org.module.common.dataservice.MyList;

public class DriversManageController implements DriversManageBLService{
	
	private DriversManageService driver ;
	public DriversManageController(DriversManageService driver) {
		super();
		this.driver = driver;
	}

	public DriversManageController() {
		this.driver = new Driver();
	}
	
	public ArrayList<DriverVO> showAll() {
		// TODO Auto-generated method stub
		return driver.showAll();
	}

	public boolean add(String id, String name, String birthday, String idcard,
			String phone, String gender, String date) {
		// TODO Auto-generated method stub
		return driver.add(new DriverVO(id,name,birthday,idcard,phone, gender, date));
	}

	public boolean modify(String id, String name, String birthday,
			String idcard, String phone, String gender, String date) {
		// TODO Auto-generated method stub
		return driver.modify(new DriverVO(id,name,birthday,idcard,phone, gender, date));
	}

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return driver.delete(id);
	}

	public boolean delete(MyList<String> id) {
		// TODO Auto-generated method stub
		return driver.delete(id);
	}

	public ArrayList<DriverVO> fuzzySearch(String s) {
		// TODO Auto-generated method stub
		return driver.fuzzySearch(s);
	}

	public ArrayList<String[]> toArray() {
		ArrayList<String[]> re = new ArrayList<String[]>();
		
		ArrayList<DriverVO> vos = this.showAll();
		for (DriverVO driverVO : vos) {
			re.add(driverVO.toArray());
		}
		return re;
	}

}
