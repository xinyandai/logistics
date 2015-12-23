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
	 * 所有收据显示
	 * @return
	 */
	public ArrayList<ReceiptVO> getAll();
	/**
	 * 增加一个收据
	 * 前置： 该收据相同的ID未存在
	 * 后置：条用数据层进行修改
	 * @param vo
	 * @return
	 */
	public boolean add(ReceiptVO vo);
	/**
	 * 对已存在的一个收据进行修改
	 * 前置：该收据已存在，但审批通过或者未审批
	 * 后置： 会调用数据层进行修改
	 * @param vo
	 * @return
	 */
	public boolean update(ReceiptVO vo);
}
