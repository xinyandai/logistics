package org.module.client.businesslogicservice.ticket;

import org.module.client.vo.GoDownEntryVO;

public interface GoDownEntryService {
    /**
	 * 前置：选择新建
	 * 后置：更新
	 * 依赖：GoDownEntryListService.
	 * @param t
	 * @return
	 */
	public boolean createTicket(GoDownEntryVO go);
	
}