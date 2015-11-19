package org.module.common.dataservice.orderdataservice;

import java.util.ArrayList;

import org.module.common.po.ReceivingListPO;
import org.module.common.po.State;


/**
 * 收件单
 * @author 
 *
 */
public interface ReceiveListService {
	/**
	 * 前置：无
	 * 后置：返回所有PO
	 * @return
	 */
	public ArrayList<ReceivingListPO> getAll();
	/**
	 * 前置：不存在相同ID的收件单
	 * 后置：增加一个PO
	 * @return
	 */
    public boolean add(ReceivingListPO o);
    /**
	 * 前置：欲修改的PO存在
	 * 后置：更新PO信息
	 * @param old
	 * @param newone
	 * @return
	 */
	public boolean update(ReceivingListPO newone);
	
	/**
     * 根据状态查找
     * @param s
     * @return
     */
	public ArrayList<ReceivingListPO> getByState(State s);
    
}