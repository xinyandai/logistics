package org.module.client.businesslogicservice.statistic;

import java.util.ArrayList;

import org.module.client.vo.AccountVO;
import org.module.client.vo.CarVO;
import org.module.client.vo.DepartmentVO;
import org.module.client.vo.StuffVO;
import org.module.client.vo.WarehouseVO;

public interface InitAccountService {
	/**
	 * 前置：选择期初建账
	 * 后置：保存期初账户信息
	 * 依赖：initialData.clear() 
	 *       initialData.save()
	 * @return
	 */
	public boolean init();
	/**
	 * 前置：选择查看期初信息
	 * 后置：返回一个arraylist
	 * 依赖：initialDataService.getAll返回所有单据  
	 * @return
	 */
	public ArrayList<CarVO> getInitCar();
	/**
	 * 前置：选择查看期初信息
	 * 后置：返回一个arraylist
	 * 依赖：initialDataService.getAll返回所有单据  
	 * @return
	 */
	public ArrayList<StuffVO> getInitStuff();
	/**
	 * 前置：选择查看期初信息
	 * 后置：返回一个arraylist
	 * 依赖：initialDataService.getAll返回所有单据  
	 * @return
	 */
	public ArrayList<DepartmentVO> getInitDepartment();
	/**
	 * 前置：选择查看期初信息
	 * 后置：返回一个arraylist
	 * 依赖：initialDataService返回所有单据  
	 * @return
	 */
	public ArrayList<AccountVO> getInitAccount();
	/**
	 * 前置：选择查看期初信息
	 * 后置：返回一个arraylist
	 * 依赖：initialDataService.getAll返回所有单据  
	 * @return
	 */
	public ArrayList<WarehouseVO> getInitWarehouse();
}
