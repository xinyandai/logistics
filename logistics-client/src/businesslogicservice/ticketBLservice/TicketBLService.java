package businesslogicservice.ticketBLservice;
/**
 * 对应单据信息:(寄件单、)装车单、营业厅到达单、收款单、派件单、中转中心到达单 、入库单、(中转单)、出库单、付款单(收件单)
 * 进行：装车管理，营业厅接收，收款单管理，营业厅派送，中转中心接收、中转中心入库，中转中心出库，新建付款
 */
import java.util.ArrayList;

import vo.TicketVO;

public interface TicketBLService {

	/**
	 * 前置：选择新建
	 * 后置：更新
	 * @param t
	 * @return
	 */
	public boolean creatTicket(TicketVO t);
	/**
	 * 前置：选择订单进行修改，并输入新信息
	 * 后置：更新
	 * @param old
	 * @param newOne
	 * @return
	 */
	public boolean modifyTicket(TicketVO newOne);
	/**
	 * 前置：选择时间段查看ticket
	 * 后置：显示ticket
	 * @param timeStart
	 * @param timeEnd
	 * @return
	 */
	public ArrayList<TicketVO> findTicketByTime(long timeStart,long timeEnd);
	
	
	
}
