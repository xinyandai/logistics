package org.module.client.businesslogicservice.managementBLservice;

import java.util.ArrayList;

import org.module.client.vo.WarehouseConfigVO;

public interface WarehouseConfigBLService {
	/**
	 * 更新
	 * 如果对应的区本身存在的，则重置区的大小
	 * 如果对应区是不存在的，则增加改区到仓库中
	 * 并设置对应大小
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
	 * 根据仓库名，也就是中转中心名查找对应的仓库配置
	 * 前置： 该仓库存在
	 * 后置：无
	 * @param tranCenterID
	 * @return
	 */
	public WarehouseConfigVO find();

	
	/**
	 * 根据当前库存信息计算对应区的比例
	 * @param qu
	 * @return
	 */
	public String calculateCurrentBorderLine(String qu);
	/**
	 * 根据区号查找警戒比例
	 * @param qu
	 * @return
	 */
	public String getBorderLine(String qu);
	/**
	 * 该仓库的所有区号
	 * @return 通过数列形式返回
	 */
	public String[] getQus();
	/**
	 * 前置： 该区存在
	 * 后置： 无
	 * 根据对应区名查找区大小
	 * @param qu 根据对应区号
	 * @return
	 */
	public String getQuSize(String qu);
}
