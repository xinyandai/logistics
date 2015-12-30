package org.module.client.businesslogicservice.statisticBLservice;

import java.util.ArrayList;

import org.module.client.vo.AccountVO;
import org.module.client.vo.CarVO;
import org.module.client.vo.DepartmentVO;
import org.module.client.vo.StuffVO;
import org.module.client.vo.WarehouseVO;

public interface InitAccountBLService {

	/**
	 * 前置：选择期初建账
	 * 后置：保存期初账户信息
	 * 依赖： 
	 * @return
	 */
	public boolean init();
	
	
	
	
	/**
	 * 前置：无
	 * 选择查看期初信息
	 * 后置：返回一个arraylist
	 * 依赖：*InitDateService.getInitCar返回所有单据  
	 * @return
	 */
	public ArrayList<CarVO> getInitCar();
	
	
	
	
	
	
	
	/**
	 * 前置：无
	 * 选择查看期初信息
	 * 后置：返回一个arraylist
	 * 依赖：*InitDateService.getInitStuff返回所有单据  
	 * @return
	 */
	public ArrayList<StuffVO> getInitStuff();
	
	
	
	
	
	
	
	
	
	/**
	 * 前置：无
	 * 选择查看期初信息
	 * 后置：返回一个arraylist
	 * 依赖：*InitDateService.getInitDepartment返回所有单据  
	 * @return
	 */
	public ArrayList<DepartmentVO> getInitDepartment();
	
	
	
	
	
	
	
	/**
	 * 前置：无
	 * 选择查看期初信息
	 * 后置：返回一个arraylist
	 * 依赖：*InitDateService.getInitAccount返回所有单据  
	 * @return
	 */
	public ArrayList<AccountVO> getInitAccount();
	
	
	
	
	
	
	/**
	 * 前置：无
	 * 选择查看期初信息
	 * 后置：返回一个arraylist
	 * 依赖：InitDateService.getInitWarehouse返回所有单据  
	 * @return
	 */
	public ArrayList<WarehouseVO> getInitWarehouse();
}
