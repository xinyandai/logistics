package org.module.client.businesslogicservice.statisticBLservice;

public interface SalarySettingBLService {

	/**
	 * 
	 * @param base  底薪
	 * @param bonus 提成 
	 * 
	 * @return
	 */
	public boolean setAccountSalary(String base, String bonus);
	public boolean setCourierSalary(String base, String bonusEveryDelivered,
			String bonusEveryReceive);
	public boolean setDriverSalary(String base, String bonusEveryIncityDriving,
			String bonusEveryKilometersOutcityDriving);
	public boolean setOfficeClerkSalary(String base, String bonusEveryDelivered,
			String bonusEveryReceive);
	public boolean setTranCenterClerkSalary(String base, String bonusEveryArrival,
			String bonusEveryLoading);
	public boolean setWarehouseSalary(String base, String bonusEveryGodownEntry,
			String bonusEveryOutBound);
	
}
