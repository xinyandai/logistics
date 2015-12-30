package org.module.client.businesslogicservice.orderBLservice;

import java.util.ArrayList;

import org.module.client.vo.SendingListVO;


/**
 * 派件管理
 * @author 颜
 *
 */
public interface SendingBLService {

	/**
	 *前置： 该收据相同的ID未存在于当前列表中， 而且VO中的属性值符合规范
	 * 后置： 更新当前列表项，增加一个持久化对象，根据操作结果返回
	 * 依赖：SendingListService.add 增加一个PO
	 * @param o
	 * @return
	 */
	public boolean creat(SendingListVO vo);
	/**
	 * 前置： 当前用户已经有效登录（后续要根据订单填写人查找ticket）
	 * 后置： 查找并返回属于当前用户拥有权限的订单
	 * 依赖：SendingListService.getAll 返回所有派件单 PO
	 * @return
	 */
	public ArrayList<SendingListVO> getAll();
	/**
	 * 前置：相同iD值的ticket已存在于当前列表，但审批不通过或者未审批，
	 *       若相同ID值的ticket不存在返回false
	 * 后置： 更新当前列表项，更新持久化对象，根据操作结果返回
	 * @param vo
	 * @return
	 */
	public boolean update(SendingListVO vo);

}
