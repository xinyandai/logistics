package businesslogicservice.ticketBLservice;

import java.util.ArrayList;

import vo.GoDownEntryListVO;

/**
 * 入库管理
 * @author 颜
 *
 */
public interface GoDownEntryBLService {
    /**
	 * 前置：选择新建
	 * 后置：更新
	 * @param t
	 * @return
	 */
	public boolean creatTicket(GoDownEntryListVO t);
	/**
	 * 前置：选择订单进行修改，并输入新信息
	 * 后置：更新
	 * @param old
	 * @param newOne
	 * @return
	 */
	public boolean modifyTicket(GoDownEntryListVO newOne);
	/**
	 * 前置：选择时间段查看ticket
	 * 后置：显示ticket
	 * @param timeStart
	 * @param timeEnd
	 * @return
	 */
	public ArrayList<GoDownEntryListVO> findTicketByTime(long timeStart,long timeEnd);
	/**
	 *前置：选择起初建账户进行初始化
	 *后置：清空订单
	 * @return
	 */
	public boolean clear();
}
