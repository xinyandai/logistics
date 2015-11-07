package org.module.client.businesslogicservice.orderBLservice;

import java.util.ArrayList;

import org.module.client.vo.MailingListVO;

/**
 * 寄件
 * @author 
 */
public interface MailingBLService {

	/**
	 * 前置：订单输入
	 * 后置：显示价格
	 * 依赖：PriceAndCityDataService.getAll 得到所有城市间价格
	 *
	 * @return
	 */
	public double price(String senderCity,
    		String receiveCity,
    		String  counts,
			String  weight,
			String  volume,  
			String  costOfDecoration,
			String type);

	/**
	 * 前置：订单输入
	 * 后置：显示估计时间
	 * 依赖：MailingListService.getAll 得到所有PO
	 * @param m
	 * @return
	 */
	public double time(String senderCity,String receiveCity);
	/**
	 * 前置：新建寄件单
	 * 后置：更新信息
	 * 依赖：MailingListService.add 增加一个PO
	 * @param o
	 * @return
	 */
	public boolean handleMailingList(String  senderName,
			String  senderCompany,
			String  senderMobile,
			String  senderPhone,
			String  senderCity,
			String  senderPosition,
			String  receiveName,
			String  receiveCompany,
			String  receiveMobile,
			String  receivePhone,
			String  receiveCity,
			String  receivePosition,
			String  nameOfGood,
			String  counts,
			String  weight,
			String  volume,
			String  costOfDecoration,
			String  type,
			String  id);
	/**
	 * 前置：选择查看所有订单
	 * 后置：显示所有订单
	 * 依赖：MailingListService.getAll 返回所有PO
	 * @return
	 */
	//public ArrayList<MailingListVO> getAll();
	
}
