package org.module.client.businesslogicservice.ticketBLservice;


/**
 * 入库管理
 * 
 *
 */
public interface GoDownEntryBLService {
    /**
	 * 前置：选择新建
	 * 后置：更新
	 * 依赖：GoDownEntryListService.
     * @param string 
	 * @param t
	 * @return
	 */
	public boolean createTicket( String warehouseOfWhichTranCenter,String courier, String date, String destination,
			String qu, String pai, String jia, String wei);
	
}
