package org.module.client.businesslogicservice.orderBLservice;

import java.util.ArrayList;

import org.module.client.vo.ReceivingListVO;
import org.module.common.po.State;


/**
 * 收件单
 * @author 
 *
 */
public interface ReceiveBLService {
	/**
	 * 前置：新建收件单
	 * 后置：更新
	 * 依赖：ReceiveListService.add 增加一个收件单PO
	 * @param o
	 * @return
	 */
	public boolean creat(ReceivingListVO o);
	/**
	 * 前置：选择查看所有收件单
	 * 后置：显示所有收件单
	 * 依赖：ReceiveListService.getAll 返回所有的收件单PO
	 * @return
	 */
	public ArrayList<ReceivingListVO> getAll();
	/**
	 * 
	 * @param o
	 * @return
	 */
	public boolean update(ReceivingListVO o);
	
}
