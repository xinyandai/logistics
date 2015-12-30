package org.module.client.businesslogicservice.statisticBLservice;

import java.util.ArrayList;

import org.module.client.vo.ReceiptVO;
/**
 * 
 * @author 
 *
 */
public interface ReceiptBLService {
	
	/**
	 * 前置： 当前用户已经有效登录（后续要根据订单填写人查找ticket）
	 * 后置： 查找并返回属于当前用户拥有权限的订单
	 * 依赖：ReceiptListService.getAll(String w)
	 * 所有收据显示
	 * @return
	 */
	public ArrayList<ReceiptVO> getAll();
	/**
	 * 增加一个收据
	 * 前置： 该收据相同的ID未存在于当前列表中， 而且VO中的属性值符合规范
	 * 后置： 更新当前列表项，增加一个持久化对象，根据操作结果返回
	 * 依赖：ReceiptListService.add（ReceiptPO po）
	 * @param vo
	 * @return
	 */
	public boolean add(ReceiptVO vo);
	/**
	 * 对已存在的一个收据进行修改
	 * 前置：相同iD值的ticket已存在于当前列表，但审批不通过或者未审批，
	 *       若相同ID值的ticket不存在返回false
	 * 后置： 更新当前列表项，更新持久化对象，根据操作结果返回
	 * 依赖：ReceiptListService。update（ReceiptPO po）
	 * @param vo
	 * @return
	 */
	public boolean update(ReceiptVO vo);
}
