package org.module.client.businesslogicservice.logisticsBLservice;


import org.module.client.vo.LogisticsVO;


public interface LogisticsBLService {

	/**
	 * 前置：输入物流单号查询物流信息且该单号存在
	 * 后置：显示物流信息
	 * 依赖：LogisticsDataService.getAll 返回所有PO
	 * @param id
	 * @return
	 */
	public LogisticsVO showState(String id);
	/**
	 * 更新物流信息，更新最新到达位置及相应时间
	 * 前置：根据物流单号并修改物流信息
	 * 后置：更新
	 * 依赖：LogisticsDataService.update 修改一个PO
	 * @param id
	 * @param state
	 * @return
	 */
	public boolean setState(String id,String state);
	/**
	 * 前置：输入物流单号并修改物流信息
	 * 后置：更新
	 * 依赖：LogisticsDataService.update 修改一个PO
	 * @param 
	 * @return
	 */
	public boolean setState(String origin, String estination,
			String location,String orderId, String[][] historyLocationAndTime);
}
