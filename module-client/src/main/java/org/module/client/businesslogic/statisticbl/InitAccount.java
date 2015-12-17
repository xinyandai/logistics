package org.module.client.businesslogic.statisticbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.AccountVO;
import org.module.client.vo.CarVO;
import org.module.client.vo.DepartmentVO;
import org.module.client.vo.StuffVO;
import org.module.client.vo.WarehouseVO;
import org.module.common.dataservice.MyList;
import org.module.common.dataservice.statisticdataservice.InitDateService;
import org.module.common.po.AccountPO;
import org.module.common.po.CarPO;
import org.module.common.po.DepartmentPO;
import org.module.common.po.StuffPO;

public class InitAccount {
	
	
	private InitDateService data ;
	public InitAccount(){
		data = new RmiClient().get(InitDateService.class);
	}
	public boolean init() {
		try {
			return this.data.init();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<CarVO> getInitCar() {
		 MyList<CarVO> re = new  MyList<CarVO> ();  
		 try {
			MyList<CarPO>  pos = this.data.getInitCar();
			for (CarPO carPO : pos) {
				re.add(new CarVO(carPO));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return re;
	}

	public ArrayList<StuffVO> getInitStuff() {
		ArrayList<StuffVO> re = new ArrayList<StuffVO>();
		try {
			ArrayList<StuffPO> pos = this.data.getInitStuff();
			for (StuffPO stuffPO : pos) {
				re.add(new StuffVO(stuffPO));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return re;
	}

	public ArrayList<DepartmentVO> getInitDepartment() {
		ArrayList<DepartmentVO> re = new ArrayList<DepartmentVO>();
		try {
			ArrayList<DepartmentPO> pos = this.data.getInitDepartment();
			for (DepartmentPO departmentPO : pos) {
				re.add(new DepartmentVO(departmentPO));
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}

	public ArrayList<AccountVO> getInitAccount() {
		ArrayList<AccountVO> re = new ArrayList<AccountVO>();
		try {
			ArrayList<AccountPO> pos = this.data.getInitAccount();
			for (AccountPO accountPO : pos) {
				re.add(new AccountVO(accountPO));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return re;
	}

	public ArrayList<WarehouseVO> getInitWarehouse() {
		return null;
	}
}
