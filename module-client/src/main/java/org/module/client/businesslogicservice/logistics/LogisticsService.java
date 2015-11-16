package org.module.client.businesslogicservice.logistics;


import org.module.client.vo.LogisticsVO;

public interface LogisticsService {

	/**
	 * 前置：输入物流单号查询物流信息且该单号存在
	 * 后置：显示物流信息
	 * 依赖：LogisticsDataService.getAll 返回所有PO
	 * @param id
	 * @return
	 */
	public LogisticsVO showState(String id);
	/**
	 * 前置：输入物流单号并修改物流信息
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
	public boolean setState(LogisticsVO o);
}
