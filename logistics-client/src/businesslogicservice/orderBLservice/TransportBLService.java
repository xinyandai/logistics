package businesslogicservice.orderBLservice;

import java.util.ArrayList;

import vo.TransportListVO;


/**
 * 中转单
 * @author 
 *
 */
public interface TransportBLService {
	/**
	 * 前置：新建中转单
	 * 后置：更新
	 * @param o
	 * @return
	 */
	public boolean creat(TransportListVO o);
	/**
	 * 前置：选择查看所有中转单
	 * 后置：显示所有中转单
	 * @return
	 */
	public ArrayList<TransportListVO> getAll();
	/**
	 *前置：选择起初建账户进行初始化
	 *后置：清空订单
	 * @return
	 */
	public boolean clear();
	
}
