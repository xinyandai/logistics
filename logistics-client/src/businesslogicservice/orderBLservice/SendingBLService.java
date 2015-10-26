package businesslogicservice.orderBLservice;

import java.util.ArrayList;

import vo.SendingListVO;

/**
 * 派件管理
 * @author 颜
 *
 */
public interface SendingBLService {

	/**
	 * 前置：新建派件单
	 * 后置：更新
	 * 依赖：SendingListService.add 增加一个PO
	 * @param o
	 * @return
	 */
	public boolean creat(SendingListVO o);
	/**
	 * 前置：选择查看所有派件单
	 * 后置：显示所有收件单
	 * 依赖：SendingListService.getAll 返回所有派件单 PO
	 * @return
	 */
	public ArrayList<SendingListVO> getAll();
	/**
	 *前置：选择起初建账户进行初始化
	 *后置：清空订单
	 * 依赖：SendingListService.clear 清空数据
	 * @return
	 */
	public boolean clear();
}
