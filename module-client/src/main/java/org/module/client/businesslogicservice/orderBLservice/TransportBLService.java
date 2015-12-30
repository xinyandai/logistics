package org.module.client.businesslogicservice.orderBLservice;

import java.util.ArrayList;

import org.module.client.vo.TransportListVO;


/**
 * 中转单
 * @author 
 *
 */
public interface TransportBLService {
	/**
	 * 前置： 该收据相同的ID未存在于当前列表中， 而且VO中的属性值符合规范
	 * 后置： 更新当前列表项，增加一个持久化对象，根据操作结果返回
	 * 依赖：TransportListService.add 增加一个中转单PO
	 * @param o
	 * @return
	 */
	public boolean creat(TransportListVO o);
	
	/**
	 * 前置：相同iD值的ticket已存在于当前列表，但审批不通过或者未审批，
	 *       若相同ID值的ticket不存在返回false
	 * 后置： 更新当前列表项，更新持久化对象，根据操作结果返回
	 * @param o
	 * @return
	 */
	public boolean update(TransportListVO o) ;
	
	/**
	 * 前置： 当前用户已经有效登录（后续要根据订单填写人查找ticket）
	 * 后置： 查找并返回属于当前用户拥有权限的订单
	 * 依赖：TransportListService.getAll 返回所有中转单PO
	 * @return
	 */
	public ArrayList<TransportListVO> getAll();
	/**
	 * 所有的有服务覆盖的城市
	 * 前置：无
	 * 后置：查找所有城市列表，更新当前列表，返回
	 * 依赖：PriceAndCityDataService.getCity()
	 * @return
	 */
	public String[] getCityArray() ;

	/**
	 * 前置：origin与target是城市名，必须合法且存在与本地城市列表
	 * 后置：计算运费
	 * 依赖：PriceAndCityDataService.find(String cityA,String cityB)
	 * @param origin
	 * @param target
	 * @return
	 */
	public double calculateDriverCost(String origin, String target) ;
}
