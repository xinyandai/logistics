package org.module.client.businesslogicservice.order;

import java.util.ArrayList;

import org.module.client.vo.OfficeLoadingListVO;


public interface OfficeLoadingService {
	/**
	 * 前置：新建装车单
	 * 后置：更新
	 * 依赖：OfficeLoadingListService.add 增加一个营业厅装车单 PO
	 * @param o
	 * @return
	 */
	public boolean creat(OfficeLoadingListVO o);
	/**
	 * 前置：选择查看所有装车单
	 * 后置：显示所有收件单
	 * 依赖：OfficeLoadingListService.getAll 返回所有的营业厅装车单PO
	 * @return
	 */
	public ArrayList<OfficeLoadingListVO> getAll( );
	/**
	 * 
	 * @param o
	 * @return
	 */
	public boolean update(OfficeLoadingListVO o);
	
}
