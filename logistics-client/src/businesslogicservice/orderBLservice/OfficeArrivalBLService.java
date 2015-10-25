package businesslogicservice.orderBLservice;

import java.util.ArrayList;

import vo.ReceiveListVO;

/**
 * 
 * @author 营业厅接单
 *
 */
public interface OfficeArrivalBLService {
	/**
	 * 前置：新建营业厅接收单
	 * 后置：更新
	 * @param o
	 * @return
	 */
	public boolean creat(ReceiveListVO o);
	/**
	 * 前置：选择查看所有营业厅接收单
	 * 后置：显示所有营业厅接收单
	 * @return
	 */
	public ArrayList<ReceiveListVO> getAll();
	/**
	 *前置：选择起初建账户进行初始化
	 *后置：清空订单
	 * @return
	 */
	public boolean clear();
}
