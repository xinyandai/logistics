package businesslogicservice.orderBLservice;

import java.util.ArrayList;

import vo.TranCenterLoadingListVO;

public interface TranCenterLoadingBLService {

	/**
	 * 前置：新建装车单
	 * 后置：更新
	 * 依赖：TranCenterLoadingService.add 增加一个装车单
	 * @param o
	 * @return
	 */
	public boolean creat(TranCenterLoadingListVO o);
	/**
	 * 前置：选择查看所有装车单
	 * 后置：显示所有装车单
	 * 依赖：TranCenterLoadingService.getAll返回所有装车单PO
	 * @return
	 */
	public ArrayList<TranCenterLoadingListVO> getAll();
	/**
	 *前置：选择起初建账户进行初始化
	 *后置：清空订单
	 * 依赖：TranCenterLoadingService.clear 清空数据
	 * @return
	 */
	public boolean clear();
}
