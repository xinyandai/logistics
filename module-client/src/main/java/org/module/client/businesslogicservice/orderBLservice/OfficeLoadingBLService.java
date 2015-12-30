package org.module.client.businesslogicservice.orderBLservice;

import java.util.ArrayList;

import org.module.client.vo.OfficeLoadingListVO;


public interface OfficeLoadingBLService {
	/**
	 * 前置： 该收据相同的ID未存在于当前列表中， 而且VO中的属性值符合规范
	 * 后置： 更新当前列表项，增加一个持久化对象，根据操作结果返回
	 * 依赖：OfficeLoadingListService.add 增加一个营业厅装车单 PO
	 * @param o
	 * @return
	 */
	public boolean creat(OfficeLoadingListVO  vo);
	
	/**
	 * 前置：相同iD值的ticket已存在于当前列表，但审批不通过或者未审批，
	 *       若相同ID值的ticket不存在返回false
	 * 后置： 更新当前列表项，更新持久化对象，根据操作结果返回
	 * @param vo
	 * @return
	 */
	public boolean update(OfficeLoadingListVO  vo);
	/**
	 * 前置： 当前用户已经有效登录（后续要根据订单填写人查找ticket）
	 * 后置： 查找并返回属于当前用户拥有权限的订单
	 * 依赖：OfficeLoadingListService.getAll 返回所有的营业厅装车单PO
	 * @return
	 */
	public ArrayList<OfficeLoadingListVO> getAll( );
	
	/**
	 * 计算运费
	 * @param origin 出发地
	 * @param target 目的地
	 * @return
	 */
	public double calculateDriverCost(String origin,String target);
	/**
	 * 所有的有服务覆盖的城市
	 * 前置：无
	 * 后置：查找所有城市列表，更新当前列表，返回
	 * 依赖：PriceAndCityDataService.getCity()
	 * @return
	 */
	public String[] getCityArray();
}
