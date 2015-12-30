package org.module.client.businesslogicservice.statisticBLservice;

/**
 * 
 * @author 
 *
 */
public interface CostAndIncomeBLService {

	/**
	 * 前置： 起始时间与结束时间符合规范
	 * 后置：通过查询相应时间段内所有付款单，计算总成本
	 * 依赖：CostDataService.getAll 查询所有的付款单信息
	 * @return
	 */
	public double getCost(long startTime,long endTime);
	/**
	 * 前置： 起始时间与结束时间符合规范
	 * 后置：通过查询相应时间段内所有收款单，计算总收入
	 * 依赖：ReceiptListService.getAll 返回所有的收款单
	 * @return
	 */
	public double getIncome(long startTime,long endTime);
	
	/**
	 * 前置：起始时间与结束时间符合规范
	 * 后置：计算纯收益并返回
	 * 依赖：getCost();getIncome();
	 * @param startTime 开始时间
	 * @param endTime   结束时间

	 * @return
	 */
	public double getPureIncome(long startTime,long endTime);
	}
