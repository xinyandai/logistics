package dataservice.orderdataservice;

import java.util.ArrayList;

import po.TransportListPO;


/**
 * 中转单
 * @author 
 *
 */
public interface TransportList {
	/**
	 * 前置：无
	 * 后置：返回所有PO
	 * @return
	 */
	public ArrayList<TransportListPO> getAll();
	/**
	 * 前置：不存在相同ID的收件单
	 * 后置：增加一个PO
	 * @return
	 */
    public boolean add(TransportListPO o);
}
