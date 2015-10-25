package businesslogicservice.orderBLservice;

import java.util.ArrayList;

import vo.TranCenterLoadingListVO;

public interface TranCenterLoadingService {

	/**
	 * 前置：新建派件单
	 * 后置：更新
	 * @param o
	 * @return
	 */
	public boolean creat(TranCenterLoadingListVO o);
	/**
	 * 前置：选择查看所有派件单
	 * 后置：显示所有收件单
	 * @return
	 */
	public ArrayList<TranCenterLoadingListVO> getAll();
	/**
	 *前置：选择起初建账户进行初始化
	 *后置：清空订单
	 * @return
	 */
	public boolean clear();
}
