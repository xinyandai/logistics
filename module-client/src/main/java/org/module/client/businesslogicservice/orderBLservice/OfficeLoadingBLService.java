package org.module.client.businesslogicservice.orderBLservice;

import java.util.ArrayList;

import org.module.client.vo.OfficeLoadingListVO;
import org.module.common.po.State;


public interface OfficeLoadingBLService {
	/**
	 * 前置：新建装车单
	 * 后置：更新
	 * 依赖：OfficeLoadingListService.add 增加一个营业厅装车单 PO
	 * @param o
	 * @return
	 */
	public boolean creat(String loadingDate, String officeId,
			String trucksId, String city,String location, String carId, String supervision,
			String escort, String[] shippingId, String price);
	/**
	 * 前置：选择查看所有装车单
	 * 后置：显示所有收件单
	 * 依赖：OfficeLoadingListService.getAll 返回所有的营业厅装车单PO
	 * @return
	 */
	public ArrayList<OfficeLoadingListVO> getAll(State s);
	
	/**
	 * 计算运费
	 * @param origin 出发地
	 * @param target 目的地
	 * @return
	 */
	public double calculateDriverCost(String origin,String target);
	
}
