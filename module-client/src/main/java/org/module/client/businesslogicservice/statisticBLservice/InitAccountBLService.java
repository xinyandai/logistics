package org.module.client.businesslogicservice.statisticBLservice;

public interface InitAccountBLService {

	/**
	 * 前置：选择期初建账
	 * 后置：保存期初账户信息
	 * 依赖：*dataService.getAll返回所有单据  *dataService.clear清空所有数据
	 * @return
	 */
	public boolean init();
}
