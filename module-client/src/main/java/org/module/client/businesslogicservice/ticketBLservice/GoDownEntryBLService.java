package org.module.client.businesslogicservice.ticketBLservice;


/**
 * 入库管理
 * @author 颜
 *
 */
public interface GoDownEntryBLService {
    /**
	 * 前置：选择新建
	 * 后置：更新
	 * 依赖：GoDownEntryListService.
	 * @param t
	 * @return
	 */
	public boolean createTicket(String courier, String date, String destination,
			String qu, String pai, String jia, String wei);
	
}
