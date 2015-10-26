package businesslogicservice.managementBLService_stub;

import java.util.ArrayList;

import vo.PriceAndCityVO;
import businesslogicservice.managementBLservice.PriceAndCityManageService;

public class PriceAndCityManageService_stub implements PriceAndCityManageService{

	@Override
	public ArrayList<String> showAllCity() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<PriceAndCityVO> showPartDirection(String city) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<PriceAndCityVO> showAllDirection() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public boolean addCity(String city) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean setDiretion(PriceAndCityVO old, int direction) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean setPrice(PriceAndCityVO old, double price) {
		// TODO 自动生成的方法存根
		return false;
	}

}
