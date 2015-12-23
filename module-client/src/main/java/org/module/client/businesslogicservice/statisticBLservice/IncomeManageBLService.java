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
	 * 前置：选择查看所有收款
	 * 后置：显示所有收款单
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
	 */
	public boolean add(String date, String money, String courier,
			String[] orderId);
	
	/**
	 * 
	 * @return
	 */
	public String[] getAllOffice();
}
