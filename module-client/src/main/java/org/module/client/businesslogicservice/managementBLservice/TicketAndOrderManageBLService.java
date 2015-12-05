package org.module.client.businesslogicservice.managementBLservice;

import java.util.ArrayList;

import org.module.client.vo.AbstractVO;


public interface TicketAndOrderManageBLService{

	/**
	 * 前置：总经理登陆后则重复判断
	 * 后置：判断是否有待提交单据未审批
	 * @return
	 */
	public boolean hasTicketToVerify();

	/**
	 * 前置：经理查看未审批单据
	 * 后置：显示未审批单据
	 * @param tickettype
	 * @param state
	 * @return
	 */
	public ArrayList<? extends AbstractVO> getAll(String type);
	/**
	 * 前置：经理通过单据
	 * 后置：更新
	 * @param type
	 * @param o
	 * @return
	 */
	public boolean pass(int[] indexes,String type);
	/**
	 * 前置：经理未通过单据
	 * 后置：更新
	 * @param type
	 * @param o
	 * @return
	 */
	public boolean unpass(int[] indexes,String type);
	/**
	 * 所有需要审批的单据类型
	 * @return
	 */
	public String[] getTypes();
}
