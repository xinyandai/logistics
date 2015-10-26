package businesslogicservice.orderBLservice;

import java.util.ArrayList;

import vo.OfficeArrivalListVO;

/**
 * 
 * @author 营业厅接单
 *
 */
public interface OfficeArrivalBLService {
	/**
	 * 前置：新建营业厅接收单
	 * 后置：更新
	 * 依赖：OfficeArrivalListService.add 增加一个营业厅接受单PO
	 * @param o
	 * @return
	 */
	public boolean creat(OfficeArrivalListVO o);
	/**
	 * 前置：选择查看所有营业厅接收单
	 * 后置：显示所有营业厅接收单
	 * 依赖：OfficeArrivalListService.getAll 返回所有的营业厅接受单
	 * @return
	 */
	public ArrayList<OfficeArrivalListVO> getAll();
	/**
	 *前置：选择起初建账户进行初始化
	 *后置：清空订单
	 *依赖：OfficeArrivalListService.clear 清空数据
	 * @return
	 */
	public boolean clear();
}
