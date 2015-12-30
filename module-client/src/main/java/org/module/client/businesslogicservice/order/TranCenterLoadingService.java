package org.module.client.businesslogicservice.order;

import java.util.ArrayList;

import org.module.client.vo.TranCenterLoadingListVO;


public interface TranCenterLoadingService {

	/**
	 * 前置：新建装车单
	 * 后置：更新
	 * 依赖：TranCenterLoadingService.add 增加一个装车单
	 * @param o
	 * @return
	 */
	public boolean creat(TranCenterLoadingListVO o);
	/**
	 * 前置：选择查看所有装车单
	 * 后置：显示所有装车单
	 * 依赖：TranCenterLoadingService.getAll返回所有装车单PO
	 * @return
	 */
	public ArrayList<TranCenterLoadingListVO> getAll();
	/**
	 * 对未审核或者审核不通过的单据修改并更新
	 * @param o
	 * @return
	 */
	public boolean update(TranCenterLoadingListVO o);
}
