package dataservice.orderdataservice;

import java.util.ArrayList;

import po.MailingListPO;

/**
 * 寄件单
 * @author 
 *
 */
public interface MailingList {
 
	/**
	 * 前置：无
	 * 后置：返回所有PO
	 * @return
	 */
	public ArrayList<MailingListPO> getAll();
	/**
	 * 前置：不存在相同ID的寄件单
	 * 后置：增加一个PO
	 * @return
	 */
    public boolean add(MailingListPO o);
}
