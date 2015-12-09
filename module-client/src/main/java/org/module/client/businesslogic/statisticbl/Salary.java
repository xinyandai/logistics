package org.module.client.businesslogic.statisticbl;

import java.rmi.RemoteException;

import org.module.client.businesslogicservice.statistic.SalaryService;
import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.salary.AccountantSalaryVO;
import org.module.client.vo.salary.CourierSalaryVO;
import org.module.client.vo.salary.DriverSalaryVO;
import org.module.client.vo.salary.OfficeClerkSalaryVO;
import org.module.client.vo.salary.TranCenterClerkSalaryVO;
import org.module.client.vo.salary.WarehouseManagerSalaryVO;
import org.module.common.dataservice.statisticdataservice.SalarySettingDateService;
import org.module.common.po.salary.AccountantSalaryPO;
import org.module.common.po.salary.CourierSalaryPO;
import org.module.common.po.salary.DriverSalaryPO;
import org.module.common.po.salary.OfficeClerkSalaryPO;
import org.module.common.po.salary.TranCenterClerkSalaryPO;
import org.module.common.po.salary.WarehouseManagerSalaryPO;

public class Salary implements SalaryService {

	private SalarySettingDateService data;
	public Salary(){
		this.data = new RmiClient().get(SalarySettingDateService.class);
	}
	public boolean setAccountSalary(AccountantSalaryVO a) {
		
		try {
			return this.data.setAccountSalary(new AccountantSalaryPO(a.getBase(),a.getBonus()));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public AccountantSalaryVO getAccountantSalaryVO(){
		AccountantSalaryPO a = null;
		try {
			a = this.data.getAccountSalary();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(a==null){
			return new AccountantSalaryVO(0,0);
		}
		return new AccountantSalaryVO(a.getBase(),a.getBonus());
	}
	
	public boolean setCourierSalary(CourierSalaryVO c) {
		try {
			return this.data.setCourierSalary(new CourierSalaryPO(c.getBase(),c.getBonusEveryDelivered(),c.getBonusEveryReceive()));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public CourierSalaryVO getCourierSalaryVO(){
		CourierSalaryPO c = null;
		try {
			c = this.data.getCourierSalary();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(c==null){
			return new CourierSalaryVO(0,0,0);
		}
		return new CourierSalaryVO(c.getBase(),c.getBonusEveryDelivered(),c.getBonusEveryReceive());
	}
	
	public boolean setDriverSalary(DriverSalaryVO driverSalaryVO) {
		try {
			return this.data.setDriverSalary(
					new DriverSalaryPO(driverSalaryVO.getBase(),
					  driverSalaryVO.getBonusEveryIncityDriving(),
					  driverSalaryVO.getBonusEveryKilometersOutcityDriving()
					 )
					);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;

	}

	public DriverSalaryVO getDriverSalaryVO(){
		DriverSalaryPO driverSalaryPO = null;
		try {
			driverSalaryPO = this.data.getDriverSalary();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(driverSalaryPO==null){
			return new DriverSalaryVO(0,0,0);
		}
		return new DriverSalaryVO(driverSalaryPO.getBase(),
				  driverSalaryPO.getBonusEveryIncityDriving(),
				  driverSalaryPO.getBonusEveryKilometersOutcityDriving());
	}
	
	public boolean setOfficeClerkSalary(OfficeClerkSalaryVO officeClerkSalaryVO) {
		try {
			return this.data.setOfficeClerkSalary(
					new OfficeClerkSalaryPO(
							officeClerkSalaryVO.getBase(),
							officeClerkSalaryVO.getBonusEveryDelivered(),
							officeClerkSalaryVO.getBonusEveryReceive()
							)
					);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public OfficeClerkSalaryVO getOfficeClerkSalaryVO(){
		OfficeClerkSalaryPO officeClerkSalaryPO = null;
		try {
			officeClerkSalaryPO = this.data.getOfficeClerkSalary();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(officeClerkSalaryPO==null){
			return new OfficeClerkSalaryVO( 0,0,0);

		}
		return new OfficeClerkSalaryVO(

				officeClerkSalaryPO.getBase(),
				officeClerkSalaryPO.getBonusEveryDelivered(),
				officeClerkSalaryPO.getBonusEveryReceive());
	}
	
	
	
	public boolean setTranCenterClerkSalary(TranCenterClerkSalaryVO tranCenterClerkSalaryVO) {
		try {
			return this.data.setTranCenterClerkSalary(
					new TranCenterClerkSalaryPO(
							tranCenterClerkSalaryVO.getBase(),
							tranCenterClerkSalaryVO.getBonusEveryArrival(),
							tranCenterClerkSalaryVO.getBonusEveryLoading()
							)
					);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	
	public TranCenterClerkSalaryVO getTranCenterClerkSalaryVO(){
		TranCenterClerkSalaryPO tranCenterClerkSalaryVO = null;
		try {
			tranCenterClerkSalaryVO = this.data.getTranCenterClerkSalary();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(tranCenterClerkSalaryVO==null){
			return new TranCenterClerkSalaryVO( 0,0,0);
		}
		return new TranCenterClerkSalaryVO(
				tranCenterClerkSalaryVO.getBase(),
				tranCenterClerkSalaryVO.getBonusEveryArrival(),
				tranCenterClerkSalaryVO.getBonusEveryLoading()
				);
	}
	
	
	public boolean setWarehouseSalary(WarehouseManagerSalaryVO w) {
		try {
			return this.data.setWarehouseSalary(
					new WarehouseManagerSalaryPO(
							w.getBase(),
							w.getBonusEveryGodownEntry(),
							w.getBonusEveryOutBound()
							)
					);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	public WarehouseManagerSalaryVO getWarehouseManagerSalaryVO(){
		WarehouseManagerSalaryPO w = null;
		try {
			w = this.data.getWarehouseSalary();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(w==null){
			return new WarehouseManagerSalaryVO( 0, 0, 0);
		}
		return new WarehouseManagerSalaryVO(
				w.getBase(),
				w.getBonusEveryGodownEntry(),
				w.getBonusEveryOutBound()
				);
	}
}
