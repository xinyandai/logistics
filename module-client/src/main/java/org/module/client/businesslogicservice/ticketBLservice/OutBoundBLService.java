package org.module.client.businesslogicservice.ticketBLservice;

/**
 * 出库管理
 * @author 颜
 *
 */
public interface OutBoundBLService {
	/**
	 * 前置：选择新建
	 * 后置：更新
	 * 依赖：OutBoundListService.add 增加一个出库单PO
	 * @param t
	 * @return
	 */
	public boolean createTicket(String courier, String date, String destination,
			String car, String tansportListId, String carId);
	
}
