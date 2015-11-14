package org.module.client.businesslogicservice.statistic;

import java.util.ArrayList;

import org.module.client.vo.ReceiptListVO;

public interface IncomeManageService {
	/**
	 * 前置：选择查看所有收款
	 * 后置：显示所有收款单
	 * 依赖：ReceiptListService.getAll 返回所有的收款单信息
	 * @return
	 */
	public ArrayList<ReceiptListVO> getAllIncomeList(String office,double startTime,double endTime);
}
