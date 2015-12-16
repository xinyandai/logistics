package org.module.client.businesslogicservice.managementBLservice;

import java.util.ArrayList;

import org.module.client.vo.GoDownEntryVO;
import org.module.client.vo.OutBoundListVO;
import org.module.client.vo.WarehouseVO;

/**
 * 仓库库存信息管理
 */
public interface WarehouseManageBLService {

	/**
	 * 前置： 库存盘点
	 * 后置：显示所有订单库存信息
	 * 依赖：WarahouseDataService.getAll 得到所有PO
	 * @return
	 */
	public ArrayList<WarehouseVO> getAll();
	/**
	 * 前置：显示
	 * 后置：更新库存信息
	 * 依赖：WarahouseDataService.delete 删除一个PO OutBoundListService.creatTiket 新建出库单
	 * @param w
	 * @return
	 */
	public boolean modify( WarehouseVO vo);
	/**
	 * 前置：出库
	 * 后置：更新库存信息
	 * 依赖：WarahouseDataService.delete 删除一个PO OutBoundListService.creatTiket 新建出库单
	 * @param w
	 * @return
	 *//*
	public boolean outBound(OutBoundListVO w);
	*//**
	 * 前置：入库
	 * 后置：更新库存
	 * 依赖：WarahouseDataService.add增加一个PO  GoDownEntryListService.createTicket 新建入库单
	 * @param w
	 * @return
	 *//*
	public boolean goDown(GoDownEntryVO w);*/
	
	
	
}
