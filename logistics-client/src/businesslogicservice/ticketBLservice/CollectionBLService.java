package businesslogicservice.ticketBLservice;

import java.util.ArrayList;

import vo.ReceiptListVO;


/**
 * 收款管理
 * @author 
 *
 */
public interface CollectionBLService {
	/**
	 * 前置：选择新建
	 * 后置：更新
	 * 依赖：ReceiptListService.add  增加一个PO
	 * @param t
	 * @return
	 */
	public boolean creatTicket(ReceiptListVO t);
	/**
	 * 前置：选择收款单进行修改，并输入新信息
	 * 后置：更新
	 * 依赖：ReceiptListService.update 修改一个收据信息
	 * @param old
	 * @param newOne
	 * @return
	 */
	public boolean modifyTicket(ReceiptListVO newOne);
	/**
	 * 前置：选择时间段查看ticket
	 * 后置：显示ticket
	 * 依赖：ReceiptListService.getAll 返回所有的收据PO
	 * @param timeStart
	 * @param timeEnd
	 * @return
	 */
	public ArrayList<ReceiptListVO> findTicketByTime(long timeStart,long timeEnd);
	/**
	 *前置：选择起初建账户进行初始化
	 *后置：清空订单
	 *依赖：ReceiptListService.clear 清空数据
	 * @return
	 */
	public boolean clear();
}
