package org.module.client.businesslogicservice.order;

import java.util.ArrayList;

import org.module.client.vo.SendingListVO;


/**
 * 中转中心接收
 * @author 华硕
 *
 */
public interface TranCenterArrivalService {
	/**
	 * 前置：新建中转中心接收单
	 * 后置：更新
	 * 依赖：TranCenterArrivalListService.add 增加一个接受单PO
	 * @param o
	 * @return
	 */
	public boolean creat(SendingListVO o);
	/**
	 * 前置：选择查看所有中转中心接收单
	 * 后置：显示所有收件单
	 * 依赖：TranCenterArrivalListService.getAll 返回所有的接受单PO
	 * @return
	 */
	public ArrayList<SendingListVO> getAll();
	
}
