package org.module.client.businesslogicservice.ticket;

import java.util.ArrayList;

import org.module.client.vo.OutBoundListVO;

public interface OutBoundService {
	/**
	 * 前置：前置：新建输入出库单符合规范
	 * 后置：更新当前显示列表； 持久化输入信息； 根据操作结果返回
	 * 依赖：OutBoundListService.getAll(String tranCenterID) 增加一个出库单持久化对象
	 * @param out
	 * @return
	 */
	public boolean createTicket(OutBoundListVO out);

	/**
	 * 前置：新建输入出库单符合规范
	 * 后置：更新当前显示列表；更新 持久化输入信息； 根据操作结果返回
	 * 依赖：OutBoundListService.update(OutBoundListPO ticket) 更新一个出库单持久化对象
	 * @param vo
	 * @return
	 */
	public boolean update(OutBoundListVO vo);
	/**
	 * 前置： 起始和终止时间符合规范
	 * 后置：查询并返回相应时间段内出库单，更新当前显示列表，
	 * 依赖：OutBoundListService.getAll(String tranCenterID)
	 * @return
	 */
	public ArrayList<OutBoundListVO> getAll(long start , long end);
}
