package org.module.client.businesslogicservice.orderBLservice;

import java.util.ArrayList;

import org.module.client.vo.ReceivingListVO;


/**
 * 收件单
 * @author 
 *
 */
public interface ReceiveBLService {
	/**
	 * 前置： 该收据相同的ID未存在于当前列表中， 而且VO中的属性值符合规范
	 * 后置： 更新当前列表项，增加一个持久化对象，根据操作结果返回
	 * 依赖：ReceiveListService.add 增加一个收件单PO
	 * @param o
	 * @return
	 */
	public boolean creat(ReceivingListVO o);
	/**
	 *前置： 当前用户已经有效登录（后续要根据订单填写人查找ticket）
	 * 后置： 查找并返回属于当前用户拥有权限的订单
	 * 依赖：ReceiveListService.getAll 返回所有的收件单PO
	 * @return
	 */
	public ArrayList<ReceivingListVO> getAll();
	/**
	 * 前置：相同iD值的ticket已存在于当前列表，但审批不通过或者未审批，
	 *       若相同ID值的ticket不存在返回false
	 * 后置： 更新当前列表项，更新持久化对象，根据操作结果返回
	 * @param o
	 * @return
	 */
	public boolean update(ReceivingListVO o);
	
}
