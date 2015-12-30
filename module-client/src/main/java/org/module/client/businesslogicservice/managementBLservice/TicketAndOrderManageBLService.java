package org.module.client.businesslogicservice.managementBLservice;

import java.util.ArrayList;

import org.module.client.vo.AbstractVO;


public interface TicketAndOrderManageBLService{

	/**
	 * 前置：无
	 * 后置：根据是否有待提交单据未审批返回
	 * @deprecated
	 * @return
	 */
	public boolean hasTicketToVerify();

	/**
	 * 前置：type必须符合约定规范
	 * 经理查看未审批单据
	 * 后置：根据type返回所有未审批单据
	 * 依赖：type+DataService.getAll()
	 * @param tickettype
	 * @param state
	 * @return
	 */
	public ArrayList<? extends AbstractVO> getAll(String type);
	/**
	 * 前置：经理通过单据，所有indexes中值符合规范，标示当前展示列表中VO的下表，不越界
	 * 后置：更新持久化对象，更新当前列表
	 * 依赖：type+DataService.update()
	 * @param type
	 * @param o
	 * @return
	 */
	public boolean pass(int[] indexes,String type);
	/**
	 * 前置：经理未通过单据，所有indexes中值符合规范，标示当前展示列表中VO的下表，不越界
	 * 后置：更新持久化对象，更新当前列表
	 * 依赖：type+DataService.update()
	 * @param type
	 * @param o
	 * @return
	 */
	public boolean unpass(int[] indexes,String type);
	/**
	 * 所有需要审批的单据类型
	 * 前置： 无
	 * 后置： 返回所有需要审批的单据的列表
	 * 依赖：type+DataService.update()
	 * @return
	 */
	public String[] getTypes();
}
