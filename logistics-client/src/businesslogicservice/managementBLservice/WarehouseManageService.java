package businesslogicservice.managementBLservice;

import java.util.ArrayList;

import vo.GoDownEntryVO;
import vo.OutBoundListVO;
import vo.WarehouseVO;
/**
 * 仓库库存信息管理
 */
public interface WarehouseManageService {

	/**
	 * 前置： 库存盘点
	 * 后置：显示所有订单库存信息
	 * @return
	 */
	public ArrayList<WarehouseVO> getAll();
	/**
	 * 前置：出库
	 * 后置：更新库存信息
	 * @param w
	 * @return
	 */
	public WarehouseVO outBound(OutBoundListVO w);
	/**
	 * 前置：入库
	 * 后置：更新库存
	 * @param w
	 * @return
	 */
	public WarehouseVO goDown(GoDownEntryVO w);
	/**
	 * 前置：设置警戒比例
	 * 后置：更新
	 * @param a
	 */
	public void setBorderline(double a); 
}
