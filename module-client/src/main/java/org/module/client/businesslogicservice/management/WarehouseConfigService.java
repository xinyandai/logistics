package org.module.client.businesslogicservice.management;

import java.util.ArrayList;

import org.module.client.vo.WarehouseConfigVO;

public interface WarehouseConfigService {

	/**
	 * 更新
	 * @param warehouseConfigVO
	 * @return
	 */
	public boolean update(WarehouseConfigVO warehouseConfigVO);
	
	/**
	 * 根据中转中心ID查找配置信息
	 * @param tranCenterID
	 * @return
	 */
	public ArrayList<WarehouseConfigVO> getAll();

	/**
	 * 增加一个分区
	 * @param warehouseConfigVO
	 * @return
	 */
	public boolean add(WarehouseConfigVO warehouseConfigVO);
	
	/**
	 * 
	 * @param tranCenterID
	 * @return
	 */
	public WarehouseConfigVO find(String tranCenterID);
}
