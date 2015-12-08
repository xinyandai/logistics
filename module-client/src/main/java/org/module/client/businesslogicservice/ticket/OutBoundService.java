package org.module.client.businesslogicservice.ticket;

import java.util.ArrayList;

import org.module.client.vo.GoDownEntryVO;
import org.module.client.vo.OutBoundListVO;

public interface OutBoundService {
	/**
	 * 前置：选择新建
	 * 后置：更新
	 * 依赖：OutBoundListService.add 增加一个出库单PO
	 * @param t
	 * @return
	 */
	public boolean createTicket(OutBoundListVO out);

	/**
	 * 
	 * @param vo
	 * @return
	 */
	public boolean update(OutBoundListVO vo);
	/**
	 * 
	 * @return
	 */
	public ArrayList<OutBoundListVO> getAll(long start , long end);
}
