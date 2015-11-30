package org.module.client.businesslogicservice.order;

public interface CalculateTimeService {

	/**
	 * 
	 * @param origin 出发城市
	 * @param target 目的城市
	 * @return
	 */
	public int calculateTime(String origin,String target);
}
