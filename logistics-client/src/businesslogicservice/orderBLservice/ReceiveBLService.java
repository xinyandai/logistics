package businesslogicservice.orderBLservice;

import java.util.ArrayList;

import vo.ReceiveListVO;

/**
 * 收件单
 * @author 
 *
 */
public interface ReceiveBLService {
	/**
	 * 前置：新建收件单
	 * 后置：更新
	 * 依赖：ReceiveListService.add 增加一个收件单PO
	 * @param o
	 * @return
	 */
	public boolean creat(ReceiveListVO o);
	/**
	 * 前置：选择查看所有收件单
	 * 后置：显示所有收件单
	 * 依赖：ReceiveListService.getAll 返回所有的收件单PO
	 * @return
	 */
	public ArrayList<ReceiveListVO> getAll();
	/**
	 *前置：选择起初建账户进行初始化
	 *后置：清空订单
	 * 依赖：ReceiveListService.clear 清空数据
	 * @return
	 */
	public boolean clear();
}
