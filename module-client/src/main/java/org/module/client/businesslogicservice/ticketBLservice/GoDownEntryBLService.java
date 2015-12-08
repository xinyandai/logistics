package org.module.client.businesslogicservice.ticketBLservice;

import java.util.ArrayList;

import org.module.client.vo.GoDownEntryVO;


/**
 * 入库管理
 * 
 *
 */
public interface GoDownEntryBLService {
    /**
	 * 前置：选择新建
	 * 后置：更新
	 * 依赖：GoDownEntryListService.
     * @param string 
	 * @param t
	 * @return
	 */
	public boolean createTicket( GoDownEntryVO vo);
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
