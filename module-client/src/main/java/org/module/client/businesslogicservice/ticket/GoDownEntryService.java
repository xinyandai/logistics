package org.module.client.businesslogicservice.ticket;

import java.util.ArrayList;

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
	/**
	 * 
	 * @return
	 */
	public ArrayList<GoDownEntryVO> getAll(long start , long end);
	
	/**
	 * 
	 * @param vo
	 * @return
	 */
	public boolean update( GoDownEntryVO vo);
	
}