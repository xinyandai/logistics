package org.module.client.businesslogicservice.orderBLservice;

import java.util.ArrayList;

import org.module.client.vo.MailingListVO;



/**
 * 寄件
 * @author 
 */
public interface MailingBLService extends OrderService<MailingListVO>{

	/**
	 * 前置：订单输入参数合法，enderCity，receiveCity是当前城市列表中的索引，不能越界，costOfDecoration是数值
	 * 后置：计算参考价格并返回
	 * 依赖：PriceAndCityDataService.getAll 得到所有城市间价格
	 *
	 * @return
	 */
	public double price(int senderCity,
			int receiveCity,
			String  costOfDecoration
			);

	/**
	 * 前置：订单输入合法，enderCity，receiveCity是当前城市列表中的索引，不能越界
	 * 后置：计算估计时间并返回
	 * 依赖：MailingListService.getAll 得到所有PO
	 * @param m
	 * @return
	 */
	public int time(int senderCity,int receiveCity);
	/**
	 * 前置：新建寄件单
	 * 后置：更新信息
	 * 依赖：MailingListService.add 增加一个PO
	 * @param o
	 * @return
	 */
	/*public boolean handleMailingList(String  senderName,
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
			String  id);*/
	
	/**
	 * 前置： 该收据相同的ID未存在于当前列表中， 而且VO中的属性值符合规范
	 * 后置： 更新当前列表项，增加一个持久化对象，根据操作结果返回
	 * 依赖：MailingListService.add 增加一个PO
	 * @param o
	 * @return
	 */
	public boolean creat(MailingListVO mailingListVO);
	
	/**
	 * 前置： 当前用户已经有效登录（后续要根据订单填写人查找ticket）
	 * 后置： 查找并返回属于当前用户拥有权限的订单
	 * 依赖：MailingListService.getAll(String w) 返回所有PO
	 * @return
	 */
	public ArrayList<MailingListVO> getAll();
	/**
	 * 所有的有服务覆盖的城市
	 * 前置：无
	 * 后置：查找所有城市列表，更新当前列表，返回
	 * 依赖：PriceAndCityDataService.getCity()
	 * @return
	 */
	public String[] getAllCitiesArray();
	
	/**
	 * 前置：相同iD值的ticket已存在于当前列表，但审批不通过或者未审批，
	 *       若相同ID值的ticket不存在返回false
	 * 后置： 更新当前列表项，更新持久化对象，根据操作结果返回
	 * 依赖：MailingListService.update(MailingListPO newone)
	 * @param vo
	 * @return
	 */
	public boolean update(MailingListVO vo);
}
