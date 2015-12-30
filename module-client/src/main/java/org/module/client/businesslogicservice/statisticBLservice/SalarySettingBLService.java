package org.module.client.businesslogicservice.statisticBLservice;

import org.module.client.vo.salary.AccountantSalaryVO;
import org.module.client.vo.salary.CourierSalaryVO;
import org.module.client.vo.salary.DriverSalaryVO;
import org.module.client.vo.salary.OfficeClerkSalaryVO;
import org.module.client.vo.salary.TranCenterClerkSalaryVO;
import org.module.client.vo.salary.WarehouseManagerSalaryVO;

public interface SalarySettingBLService {

	/**
	 * 前置：VO中属性值有效，必须是可转换成数值的字符串
	 * 后置：更新持久化对象，根据操作结果返回
	 * 依赖：SalarySettingDateService.setAccountSalary(AccountantSalaryPO po);
	 * @return
	 */
	public boolean setAccountSalary(AccountantSalaryVO vo);
	/**
	 * 前置：VO中属性值有效，必须是可转换成数值的字符串
	 * 后置：更新持久化对象，根据操作结果返回
	 * 依赖：SalarySettingDateService.setCourierSalary(CourierSalaryPO po)
	 * @param vo
	 * @return
	 */
	public boolean setCourierSalary(CourierSalaryVO vo);
	/**
	 * 前置：VO中属性值有效，必须是可转换成数值的字符串
	 * 后置：更新持久化对象，根据操作结果返回
	 * 依赖：SalarySettingDateService.setDriverSalary(DriverSalaryPO po)
	 * @param vo
	 * @return
	 */
	public boolean setDriverSalary(DriverSalaryVO vo);
	/**
	 * 前置：VO中属性值有效，必须是可转换成数值的字符串
	 * 后置：更新持久化对象，根据操作结果返回
	 * 依赖：SalarySettingDateService.setOfficeClerkSalary(OfficeClerkSalaryPO PO)
	 * @param vo
	 * @return
	 */
	public boolean setOfficeClerkSalary(OfficeClerkSalaryVO vo);
	/**
	 * 前置：VO中属性值有效，必须是可转换成数值的字符串
	 * 后置：更新持久化对象，根据操作结果返回
	 * 依赖：SalarySettingDateService.setTranCenterClerkSalary(TranCenterClerkSalaryPO PO)
	 * @param vo
	 * @return
	 */
	public boolean setTranCenterClerkSalary(TranCenterClerkSalaryVO vo);
	
	/**
	 * 前置：VO中属性值有效，必须是可转换成数值的字符串
	 * 后置：更新持久化对象，根据操作结果返回
	 * 依赖：SalarySettingDateService.setWarehouseSalary(WarehouseManagerSalaryPO PO)
	 * @param vo
	 * @return
	 */
	public boolean setWarehouseSalary(WarehouseManagerSalaryVO vo);

	/**
	 * 前置：无
	 * 后置：查找持久化对象，根据操作结果返回
	 * 依赖：SalarySettingDateService.getAccountantSalaryPO()
	 * @return
	 */
	public AccountantSalaryVO getAccountantSalaryVO();
	/**
	 * 前置：无
	 * 后置：查找持久化对象，根据操作结果返回
	 * 依赖：SalarySettingDateService.getCourierSalaryPO()
	 * @return
	 */
	public CourierSalaryVO getCourierSalaryVO();
	/**
	 * 前置：无
	 * 后置：查找持久化对象，根据操作结果返回
	 * 依赖：SalarySettingDateService.getDriverSalaryPO()
	 * @return
	 */
	public DriverSalaryVO getDriverSalaryVO();
	/**
	 * 前置：无
	 * 后置：查找持久化对象，根据操作结果返回
	 * 依赖：SalarySettingDateService.getTranCenterClerkSalaryPO
	 * @return
	 */
	public OfficeClerkSalaryVO getOfficeClerkSalaryVO();
	/**
	 * 前置：无
	 * 后置：查找持久化对象，根据操作结果返回
	 * 依赖：SalarySettingDateService.getTranCenterClerkSalaryPO()
	 * @return
	 */
	public TranCenterClerkSalaryVO getTranCenterClerkSalaryVO();
	/**
	 * 前置：无
	 * 后置：查找持久化对象，根据操作结果返回
	 * 依赖：SalarySettingDateService.getWarehouseManagerSalaryPO()
	 * @return
	 */
	public WarehouseManagerSalaryVO getWarehouseManagerSalaryVO();
	
}
