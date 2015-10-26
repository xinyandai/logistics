package businesslogicservice.managementBLService_stub;

import java.util.ArrayList;

import po.CarPO;
import vo.CarVO;
import businesslogicservice.managementBLservice.CarsManageService;

public class CarsManageService_stub implements CarsManageService{
	CarPO cp;
	@Override
	public ArrayList<CarVO> showAll() {
		// TODO 自动生成的方法存根
		System.out.println("car");
		return null;
	}

	@Override
	public boolean add(CarVO c) {
		// TODO 自动生成的方法存根
		System.out.println("car");
		return false;
	}

	@Override
	public boolean modify(CarVO newone) {
		// TODO 自动生成的方法存根
		System.out.println("car");
		return false;
	}

	@Override
	public boolean delete(ArrayList<CarVO> al) {
		// TODO 自动生成的方法存根
		System.out.println("car");
		return false;
	}

	@Override
	public ArrayList<CarVO> fuzzySearch(String s) {
		// TODO 自动生成的方法存根
		System.out.println("car");
		return null;
	}

}
