package dataservice.orderdataservice;

import java.util.ArrayList;

import po.ReceiveListPO;


/**
 * 收件单
 * @author 
 *
 */
public interface ReceiveList {
	/**
	 * 前置：无
	 * 后置：返回所有PO
	 * @return
	 */
	public ArrayList<ReceiveListPO> getAll();
	/**
	 * 前置：不存在相同ID的收件单
	 * 后置：增加一个PO
	 * @return
	 */
    public boolean add(ReceiveListPO o);
}
