package org.module.client.businesslogic.statisticbl;

import org.module.client.businesslogicservice.statistic.SalaryService;
import org.module.client.businesslogicservice.statisticBLservice.SalarySettingBLService;
import org.module.client.vo.salary.AccountantSalaryVO;
import org.module.client.vo.salary.CourierSalaryVO;
import org.module.client.vo.salary.OfficeClerkSalaryVO;
import org.module.client.vo.salary.TranCenterClerkSalaryVO;
import org.module.client.vo.salary.WarehouseManagerSalaryVO;

public class SalaryController implements SalarySettingBLService {
	private SalaryService salary;
	
	public SalaryController(SalaryService salary) {
		super();
		this.salary = salary;
	}

	public boolean setAccountSalary(String base, String bonus) {
		
		return salary.setAccountSalary(new AccountantSalaryVO
				(Double.parseDouble(base),Double.parseDouble(bonus) )) ;
	}

	public boolean setCourierSalary(String base, String bonusEveryDelivered,
			String bonusEveryReceive) {
		// TODO Auto-generated method stub
		return salary.setCourierSalary(new CourierSalaryVO( Double.parseDouble(base),  
				Double.parseDouble(bonusEveryDelivered),
				Double.parseDouble(bonusEveryReceive)));
	}

	public boolean setDriverSalary(String base, String bonusEveryIncityDriving,
			String bonusEveryKilometersOutcityDriving) {
		// TODO Auto-generated method stub
		return salary.setCourierSalary(new CourierSalaryVO(Double.parseDouble(base),
				                                      Double.parseDouble(bonusEveryIncityDriving),
				                                     Double.parseDouble(bonusEveryKilometersOutcityDriving)));
	}

	public boolean setOfficeClerkSalary(String base,
			String bonusEveryDelivered, String bonusEveryReceive) {
		// TODO Auto-generated method stub
		return salary.setOfficeClerkSalary(new OfficeClerkSalaryVO(Double.parseDouble(base),
				                                     Double.parseDouble(bonusEveryDelivered),
				                                     Double.parseDouble(bonusEveryReceive)));
	}

	public boolean setTranCenterClerkSalary(String base,
			String bonusEveryArrival, String bonusEveryLoading) {
		
		return salary.setTranCenterClerkSalary(new TranCenterClerkSalaryVO(
				Double.parseDouble(base),
				Double.parseDouble(bonusEveryArrival),
				Double.parseDouble(bonusEveryLoading)));
	}

	public boolean setWarehouseSalary(String base,
			String bonusEveryGodownEntry, String bonusEveryOutBound) {
		
		return salary.setWarehouseSalary(new WarehouseManagerSalaryVO(
				Double.parseDouble(base),
				Double.parseDouble(bonusEveryGodownEntry),
				Double.parseDouble(bonusEveryOutBound)));
	}

}
