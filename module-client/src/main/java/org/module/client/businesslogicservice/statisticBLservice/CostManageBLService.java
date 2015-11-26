package org.module.client.businesslogicservice.statisticBLservice;

import java.util.ArrayList;

import org.module.client.vo.CostListVO;


/**
 * 付款单管理（成本管理）
 * @author 
 *
 */
public interface CostManageBLService {

	/**
	 * 前置：新建付款单并输入信息
	 * 后置：保存付款单
	 * 依赖：CostDataService.add 增加一个付款单PO
	 * @param c
	 * @return
	 */
	public boolean add(String date, String money, String people, String accout,
			String entry, String note);
	/**
	 * 前置：选择查看所有成本支出
	 * 后置：显示所有付款单
	 * 依赖：CostDataService.getAll 返回所有付款单
	 * @return
	 */
	public ArrayList<CostListVO> showAll(long startTime,long endTime);
	
}
