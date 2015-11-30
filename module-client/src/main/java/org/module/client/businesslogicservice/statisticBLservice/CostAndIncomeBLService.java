package org.module.client.businesslogicservice.statisticBLservice;

/**
 * 
 * @author 
 *
 */
public interface CostAndIncomeBLService {

	/**
	 * 前置： 选择查看成本收益表
	 * 后置：显示总成本
	 * 依赖：CostDataService.getAll 返回所有的付款单信息
	 * @return
	 */
	public double getCost(long startTime,long endTime);
	/**
	 * 前置：选择查看成本收益表
	 * 后置：显示总收益
	 * 依赖：ReceiptListService.getAll 返回所有的收款单
	 * @return
	 */
	public double getIncome(long startTime,long endTime);
	
	/**
	 * 前置：选择查看成本收益表
	 * 后置：显示总收益
	 * 依赖：getCost();getIncome();
	 * @param startTime 开始时间
	 * @param endTime   结束时间

	 * @return
	 */
	public double getPureIncome(long startTime,long endTime);
	}
