package org.module.client.businesslogicservice.orderBLservice;

import java.util.ArrayList;

import org.module.client.vo.TranCenterArrivalListVO;


/**
 * 中转中心接收
 * @author 华硕
 *
 */
public interface TranCenterArrivalBLService extends OrderService<TranCenterArrivalListVO>{
	/**
	 * 前置： 该收据相同的ID未存在于当前列表中， 而且VO中的属性值符合规范
	 * 后置： 更新当前列表项，增加一个持久化对象，根据操作结果返回
	 * 依赖：TranCenterArrivalListService.add 增加一个接受单PO
	 * @param o
	 * @return
	 */
	public boolean creat(TranCenterArrivalListVO vo);
	/**
	 * 前置： 当前用户已经有效登录（后续要根据订单填写人查找ticket）
	 * 后置： 查找并返回属于当前用户拥有权限的订单
	 * 依赖：TranCenterArrivalListService.getAll 返回所有的接受单PO
	 * @return
	 */
	public ArrayList<TranCenterArrivalListVO> getAll( );
	/**
	 * 前置：相同iD值的ticket已存在于当前列表，但审批不通过或者未审批，
	 *       若相同ID值的ticket不存在返回false
	 * 后置： 更新当前列表项，更新持久化对象，根据操作结果返回
	 * @param o
	 * @return
	 */
	public boolean update(TranCenterArrivalListVO o);
	
}
