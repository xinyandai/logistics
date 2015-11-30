package org.module.client.businesslogicservice.order;
/**
 * 计算运费职责类
 * @author 
 *
 */
public interface CalculateDriverCostService {

	/**
	 * 
	 * @param origin 出发城市
	 * @param target 目的城市
	 * @return
	 */
	public double calculateDriverCost(String origin,String target);
}
