package businesslogicservice.orderBLservice;

import java.util.ArrayList;

import vo.TransitListVO;

/**
 * 中转单管理
 * @author 
 *
 */
public interface TransitListManageService {
	/**
	 * 前置：新建中转单管理
	 * 后置：更新
	 * @param o
	 * @return
	 */
	public boolean creat(TransitListVO o);
	/**
	 * 前置：选择查看所有中转单管理
	 * 后置：显示所有中转单管理
	 * @return
	 */
	public ArrayList<TransitListVO> getAll();
	/**
	 *前置：选择起初建账户进行初始化
	 *后置：清空订单
	 * @return
	 */
	public boolean clear();
}
