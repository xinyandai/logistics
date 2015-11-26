package org.module.client.businesslogicservice.managementBLService_stub;

import java.util.ArrayList;

import org.module.client.businesslogicservice.managementBLservice.CarsManageBLService;
import org.module.client.vo.CarVO;
import org.module.common.dataservice.MyList;
import org.module.common.po.CarPO;


public class CarsManageService_stub implements CarsManageBLService{
	CarPO cp;
	public ArrayList<CarVO> showAll() {
		// TODO �Զ����ɵķ������
		System.out.println("car");
		return null;
	}

	public boolean add(CarVO c) {
		// TODO �Զ����ɵķ������
		System.out.println("car");
		return false;
	}

	public boolean modify(CarVO newone) {
		// TODO �Զ����ɵķ������
		System.out.println("car");
		return false;
	}

	public boolean delete(ArrayList<String> al) {
		// TODO �Զ����ɵķ������
		System.out.println("car");
		return false;
	}

	public ArrayList<CarVO> fuzzySearch(String s) {
		// TODO �Զ����ɵķ������
		System.out.println("car");
		return null;
	}

	public boolean add(String id, String license, String time) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean modify(String id, String license, String time) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(MyList<String> id) {
		// TODO Auto-generated method stub
		return false;
	}

}
