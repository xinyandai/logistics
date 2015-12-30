package org.module.client.businesslogicservice.logisticsBLservice;


import org.module.client.vo.LogisticsVO;


public interface LogisticsBLService {

	/**
	 * 前置：输入物流单号查询物流信息且该单号符合规范且存在
	 * 后置：返回物流信息
	 * 依赖：LogisticsDataService.getAll 返回所有PO
	 * @param id
	 * @return 若ID不符合规范或者空，返回null
	 */
	public LogisticsVO showState(String id);
	
	/**
	 * 前置：输入物流单号且物流单号格式符合规范
	 * 后置：跟新持久化对象，根据操作结果返回
	 * 依赖：LogisticsDataService.update 修改一个PO
	 * @param 
	 * @return
	 */
	public boolean setState(String origin, String estination, String location,
			String orderId, String[] historyLocation,String[] historyTime) ;
}
