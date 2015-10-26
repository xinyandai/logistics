package businesslogicservice.ticketBLservice;

import java.util.ArrayList;

import vo.OutBoundListVO;

/**
 * 出库管理
 * @author 颜
 *
 */
public interface OutBoundBLService {
	/**
	 * 前置：选择新建
	 * 后置：更新
	 * 依赖：OutBoundListService.add 增加一个出库单PO
	 * @param t
	 * @return
	 */
	public boolean creatTicket(OutBoundListVO t);
	/**
	 * 前置：选择出库单进行修改，并输入新信息
	 * 后置：更新
	 * 依赖：OutBoundListService.update
	 * @param old
	 * @param newOne
	 * @return
	 */
	public boolean modifyTicket(OutBoundListVO newOne);
	/**
	 * 前置：选择时间段查看ticket
	 * 后置：显示ticket
	 * 依赖：OutBoundListService.getall 返回所有的出库单PO
	 * @param timeStart
	 * @param timeEnd
	 * @return
	 */
	public ArrayList<OutBoundListVO> findTicketByTime(long timeStart,long timeEnd);
	/**
	 *前置：选择起初建账户进行初始化
	 *后置：清空订单
	 * 依赖：OutBoundListService.clear 清空出库单数据
	 * @return
	 */
	public boolean clear();
	
}
