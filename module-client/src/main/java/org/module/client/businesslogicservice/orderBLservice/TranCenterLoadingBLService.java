package org.module.client.businesslogicservice.orderBLservice;

import java.util.ArrayList;

import org.module.client.vo.TranCenterLoadingListVO;
import org.module.common.po.State;


public interface TranCenterLoadingBLService {

	/**
	 * 前置：新建装车单
	 * 后置：更新
	 * 依赖：TranCenterLoadingService.add 增加一个装车单
	 * @param o
	 * @return
	 */
	public boolean creat(String loadingDate, String officeId,
			String trucksId, String city,String location, String carId, String supervision,
			String escort, String[] shippingId, String price,String state);
	/**
	 * 前置：选择查看所有装车单
	 * 后置：显示所有装车单
	 * 依赖：TranCenterLoadingService.getAll返回所有装车单PO
	 * @return
	 */
	public ArrayList<TranCenterLoadingListVO> getAll(State s);

	/**
	 * 计算运费
	 * @param origin 出发地
	 * @param target 目的地
	 * @return
	 */
	public double calculateDriverCost(String origin,String target);
}
