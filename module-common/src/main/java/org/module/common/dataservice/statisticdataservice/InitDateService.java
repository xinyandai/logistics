package org.module.common.dataservice.statisticdataservice;

import java.util.ArrayList;

import org.module.common.po.AccountPO;
import org.module.common.po.CarPO;
import org.module.common.po.DepartmentPO;
import org.module.common.po.StuffPO;
import org.module.common.po.WarehousePO;

public interface InitDateService {

	/**
	 * 前置：选择期初建账
	 * 后置：保存期初账户信息
	 * 依赖： 
	 * @return
	 */
	public boolean init();
	/**
	 * 前置：选择查看期初信息
	 * 后置：返回一个arraylist
	 * 依赖：*dataService.getAll返回所有单据  
	 * @return
	 */
	public ArrayList<CarPO> getInitCar();
	/**
	 * 前置：选择查看期初信息
	 * 后置：返回一个arraylist
	 * 依赖：*dataService.getAll返回所有单据  
	 * @return
	 */
	public ArrayList<StuffPO> getInitStuff();
	/**
	 * 前置：选择查看期初信息
	 * 后置：返回一个arraylist
	 * 依赖：*dataService.getAll返回所有单据  
	 * @return
	 */
	public ArrayList<DepartmentPO> getInitDepartment();
	/**
	 * 前置：选择查看期初信息
	 * 后置：返回一个arraylist
	 * 依赖：*dataService.getAll返回所有单据  
	 * @return
	 */
	public ArrayList<AccountPO> getInitAccount();
	/**
	 * 前置：选择查看期初信息
	 * 后置：返回一个arraylist
	 * 依赖：*dataService.getAll返回所有单据  
	 * @return
	 */
	public ArrayList<WarehousePO> getInitWarehouse();
}
