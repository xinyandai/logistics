package org.module.client.businesslogic.statisticbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.statisticBLservice.InitAccountBLService;
import org.module.client.vo.AccountVO;
import org.module.client.vo.CarVO;
import org.module.client.vo.DepartmentVO;
import org.module.client.vo.StuffVO;
import org.module.client.vo.WarehouseVO;

public class InitAccountController implements InitAccountBLService {

	private InitAccount initccount ;
	public InitAccountController() {
		this.initccount = new InitAccount();
	}

	public boolean init() {
		return this.initccount.init();
	}

	public ArrayList<CarVO> getInit() {
		return this.initccount.getInitCar();
	}
	
	public ArrayList<CarVO> getInitCar() {
		return this.initccount.getInitCar();
	}

	public ArrayList<StuffVO> getInitStuff() {
		return this.initccount.getInitStuff();
	}

	public ArrayList<DepartmentVO> getInitDepartment() {
		return this.initccount.getInitDepartment();
	}

	public ArrayList<AccountVO> getInitAccount() {
		return this.initccount.getInitAccount();
	}

	public ArrayList<WarehouseVO> getInitWarehouse() {
		return this.initccount.getInitWarehouse();
	}

}
