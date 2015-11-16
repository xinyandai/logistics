package org.module.client.businesslogicservice.order;
/**
 * 计算运费职责类
 * @author 华硕
 *
 */
public interface CalculateDriverCostService {

	public double calculateDriverCost(String origin,String target);
}
