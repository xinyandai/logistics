package org.module.client.businesslogicservice.managementBLservice;

import java.util.ArrayList;

import org.module.client.vo.WarehouseConfigVO;

public interface WarehouseConfigBLService {
	/**
	 * 前置： 输入qu有效，size是数值，borderline是数值，
	 *       当前登陆者是仓库管理员，且当前登陆者所在中转中心的仓库已经初始化
	 * 后置：更新持久化对象，根据操作结果返回
	 * 依赖：WarehouseConfigDataService.update(PO)
	 * 如果对应的区本身存在的，则重置区的大小
	 * 如果对应区是不存在的，则增加改区到仓库中
	 * 并设置对应大小
	 * @param warehouseConfigVO
	 * @return
	 */
	public boolean update(String qu, String size, String borderline);
	
	/**
	 * 前置：无
	 * 后置：返回所有仓库配置信息
	 * 依赖：WarehouseConfigDataService.getAll()
	 * 根据中转中心ID查找配置信息
	 * @param tranCenterID
	 * @return
	 */
	public ArrayList<WarehouseConfigVO> getAll();
	
	/**
	 * 根据仓库名，也就是中转中心名查找对应的仓库配置
	 * 前置：当前登陆者是仓库管理员，且当前登陆者所在中转中心的仓库已经初始化
	 * 后置：查询当前登录者所在中转中心的库存配置并返回配置信息
	 * 依赖：WarehouseConfigDataService.find()
	 * 根据中转中心ID查找配置信息
	 * @param tranCenterID
	 * @return
	 */
	public WarehouseConfigVO find();

	
	/**
	 * 根据当前库存信息计算对应区的比例
	 * 前置：当前登陆者是仓库管理员，且当前登陆者所在中转中心的仓库已经初始化;
	 *       输入qu格式符合规范且实际有效
	 * 后置：查找当前登陆者对应仓库的配置信息，查找当前登录者对应仓库的当前仓库信息
	 *       计算仓库当前库存比例
	 * 依赖：this.find()  WarehouseManageBLService.getAll
	 *    
	 * @param qu
	 * @return
	 */
	public String calculateCurrentBorderLine(String qu);
	/**
	 * 根据区号查找警戒比例
	 * 前置：qu有效且在当前登陆者所管理的仓库中存在
	 * 后置：返回对应警戒比例
	 * @param qu
	 * @return
	 */
	public String getBorderLine(String qu);
	/**
	 * 该仓库的所有区号
	 * 前置：当前登陆者是仓库管理员，且当前登陆者所在中转中心的仓库已经初始化
	 * 后置：查找当前登陆者的所在的仓库的配置信息返回对应分区
	 * 依赖：this.find()
	 * @return 通过数列形式返回
	 */
	public String[] getQus();
	/**
	 * 前置： qu格式有效
	 * 后置： 返回区大小
	 * 根据对应区名查找区大小
	 * @param qu 根据对应区号
	 * @return
	 */
	public String getQuSize(String qu);
}
