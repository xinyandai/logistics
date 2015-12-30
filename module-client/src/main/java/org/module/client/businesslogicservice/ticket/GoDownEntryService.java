package org.module.client.businesslogicservice.ticket;

import java.util.ArrayList;

import org.module.client.vo.GoDownEntryVO;

public interface GoDownEntryService {
    /**
	 * 前置：新建输入入库单符合规范
	 * 后置：更新当前显示列表； 持久化输入信息； 根据操作结果返回
	 * 依赖：GoDownEntryListService.add(GoDownEntryListPO ticket) 增加一个入库单持久化对象
	 * @param go
	 * @return
	 */
	public boolean createTicket(GoDownEntryVO go);
	/**
	 * 前置： 起始和终止时间符合规范
	 * 后置：查询并返回相应时间段内入库单，更新当前显示列表，
	 * 依赖：GoDownEntryListService.getAll(String tranCenterID)
	 * @return
	 */
	public ArrayList<GoDownEntryVO> getAll(long start , long end);
	
	/**
	 * 前置：新建输入入库单符合规范
	 * 后置：更新当前显示列表；更新 持久化输入信息； 根据操作结果返回
	 * 依赖：GoDownEntryListService.update(GoDownEntryListPO ticket) 更新一个入库单持久化对象
	 * @param vo
	 * @return
	 */
	public boolean update( GoDownEntryVO vo);
	
}