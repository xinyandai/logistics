package org.module.common.dataservice.statisticdataservice;

import java.util.ArrayList;

import org.module.common.po.ReceiptPO;


/**
 * 20151022
 * @author 颜
 *
 */
public interface ReceiptListService {

	
	/**
	 * 前置：无
	 * 后置：返回所有PO
	 * @return 所有的列表信息
	 */
	public ArrayList<ReceiptPO> getAll();
	/**
	 * 前置：数据库中不含有相同ID的PO
	 * 后置：增加一个PO
	 * @param   欲增加的持久化对象
	 * @return  添加成功返回true
	 */
	public boolean add(ReceiptPO ticket);
	
	/**
	 * 前置：数据库中含有该PO
	 * 后置：删除一个PO
	 * @param   欲删除的持久化对象
	 * @return  添加成功返回true
	 */
	
	public boolean delete(ReceiptPO ticket);

	/**
	 * 前置：该PO存在于数据库
	 * 后置：修改一个PO
	 * @param user 修改成功返回true
	 * @return
	 */
	public boolean update(ReceiptPO newone);
}
