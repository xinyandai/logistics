package dataservice.ticketdataservice;

import java.util.ArrayList;

import po.TicketPO;

/**
 * 20151022
 * 单据信息:(寄件单、)装车单、营业厅到达单、收款单、派件单、中转中心到达单 、入库单、(中转单)、出库单、付款单(收件单)
 * @author 颜
 *
 */
public interface TicketDataService {

	
	/**
	 * 前置：无
	 * 后置：返回所有PO
	 * @return 所有的列表信息
	 */
	public ArrayList<TicketPO> getAll();
	/**
	 * 前置：数据库中不含有相同ID的PO
	 * 后置：增加一个PO
	 * @param   欲增加的持久化对象
	 * @return  添加成功返回true
	 */
	public boolean add(TicketPO ticket);
	
	/**
	 * 前置：数据库中含有该PO
	 * 后置：删除一个PO
	 * @param   欲删除的持久化对象
	 * @return  添加成功返回true
	 */
	
	public boolean delete(TicketPO ticket);
	/**
	 * 前置：数据库中含有这些PO
	 * 后置：删除这些PO
	 * @param ticket
	 * @return
	 */
	public boolean delete(ArrayList<TicketPO> ticket);
	/**
	 * 前置：该PO存在于数据库
	 * 后置：修改一个PO
	 * @param user 修改成功返回true
	 * @return
	 */
	public boolean updata(TicketPO newone);
}
