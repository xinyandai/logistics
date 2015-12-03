package org.module.client.businesslogicservice.managementBLservice;

import java.util.ArrayList;

import org.module.client.vo.WarehouseConfigVO;

public interface WarehouseConfigBLService {
	/**
	 * 更新
	 * @param warehouseConfigVO
	 * @return
	 */
	public boolean update(String qu, String size, String borderline);
	
	/**
	 * 根据中转中心ID查找配置信息
	 * @param tranCenterID
	 * @return
	 */
	public ArrayList<WarehouseConfigVO> getAll();
	
	/**
	 * 
	 * @param tranCenterID
	 * @return
	 */
	public WarehouseConfigVO find();

	public String getQuSize(String qu);
	public String calculateCurrentBorderLine(String qu);
	public String getBorderLine(String qu);
	public String[] getQus();
}
