package org.module.client.businesslogicservice.ticketBLservice;

import java.util.ArrayList;

import org.module.client.vo.AbstractVO;
import org.module.client.vo.OutBoundListVO;

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
	 * @param car
	 * 
	 * @return
	 */
	public boolean createTicket(OutBoundListVO vo);

	/**
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public ArrayList<OutBoundListVO> getAll(long start , long end);
	/**
	 * 
	 * @param vo
	 * @return
	 */
	public boolean update(OutBoundListVO vo);
}
