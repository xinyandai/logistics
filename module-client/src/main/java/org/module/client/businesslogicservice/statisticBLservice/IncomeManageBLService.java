package org.module.client.businesslogicservice.statisticBLservice;

import java.util.ArrayList;

import org.module.client.vo.ReceiptVO;

/**
 * 收款单统计
 * 用于财务人员查看所有收款单
 * @author 
 *
 */
public interface IncomeManageBLService {

	/**
	 * 前置：office必须是有效存在的， startTime endTime 必须是符合规范的起始与结束时间的long型表示
	 * 后置：查找并返回所有相应时间段内收款单
	 * 依赖：ReceiptListService.getAll 返回所有的收款单信息
	 * @return
	 */
	public ArrayList<ReceiptVO> showIncomeList(String office,long startTime,long endTime);
	/**
	 * 
	 * @param date
	 * @param money
	 * @param courier
	 * @param orderId
	 * @return
	 *//*
	public boolean add(String date, String money, String courier,
			String[] orderId);
	*/
	/**
	 * 
	 * @return
	 */
	
	/**
	 * 前置： 无
	 * 后置： 查找所有的营业厅，已数组形式返回
	 * 依赖：DepartmentDataService.getAll()
	 * @return
	 */
	public String[] getAllOffice();
}
