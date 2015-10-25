package businesslogicservice.orderBLservice;

import java.util.ArrayList;

import vo.SendingListVO;

/**
 * 中转中心接收
 * @author 华硕
 *
 */
public interface TranCenterArrivalService {
	/**
	 * 前置：新建中转中心接收单
	 * 后置：更新
	 * @param o
	 * @return
	 */
	public boolean creat(SendingListVO o);
	/**
	 * 前置：选择查看所有中转中心接收单
	 * 后置：显示所有收件单
	 * @return
	 */
	public ArrayList<SendingListVO> getAll();
	/**
	 *前置：选择起初建账户进行初始化
	 *后置：清空订单
	 * @return
	 */
	public boolean clear();
}
