package org.module.client.businesslogicservice.managementBLservice;

import java.io.File;
import java.util.ArrayList;

import javax.swing.table.TableModel;

import org.module.client.vo.WarehouseVO;

/**
 * 仓库库存信息管理
 */
public interface WarehouseManageBLService {

	/**
	 * 前置：无
	 * 库存盘点
	 * 后置：返回所有订单库存信息
	 * 依赖：WarahouseDataService.getAll 得到所有PO
	 * @return
	 */
	public ArrayList<WarehouseVO> getAll();
	/**
	 * 前置：输入新的WarehouseVO属性符合规范
	 * 后置：更新库存信息，更新持久化对象，根据操作结果返回
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
	
	/**
	 * 前置： 当前文件路径有效，当前表格Model不为null
	 * 后置：导出excel文件，根据导出是否成功返回
	 * 导出excel文件
	 * @param model
	 * @param file
	 */
	public void export(TableModel model,File file);
	
}
