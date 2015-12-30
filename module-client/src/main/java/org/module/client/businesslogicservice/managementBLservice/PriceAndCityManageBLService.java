package org.module.client.businesslogicservice.managementBLservice;

import java.util.ArrayList;

import org.module.client.vo.CityVO;
import org.module.client.vo.PriceAndCityVO;


public interface PriceAndCityManageBLService {

	/**
	 * 前置：无
	 * 后置：返回所有城市
	 * 依赖：PriceAndCityDataService.getAll 返回所有PO
	 * @return
	 */
	public ArrayList<CityVO> showAllCity();
	
	/**
	 * 前置：无
	 * 后置：把所有城市VO转为数组返回
	 * 依赖：this.showAllCity（）
	 * @return
	 */
	public ArrayList<String[]> toArray(); 

	/**
	 * 前置：城市名与ID值符合规范 
	 * 后置：默认新城市与其他城市间距离都是0；增加对应持久化对象；根据操作结果返回
	 * 依赖：PriceAndCityDataService.getAll 返回所有PO
	 * @return
	 */
	public boolean addCity(String city,String id);

	/**
	 * 根据city id删除城市
	 * 前置：id有效
	 * 后置：删除一个持久化对象，根据操作结果返回
	 * 依赖：PriceAndCityDataService。deleteCity(String id)
	 * @param id
	 * @return
	 * @deprecated
	 */
	public boolean deleteCity(String id);
	/**
	 * 
	 * 前置：输入城市信息符合规范
	 * 后置：更新持久化对象，根据操作结果返回
	 * 依赖：PriceAndCityDataService.modifyCity((CityPO po)
	 * @param city 城市名（城市名必须是唯一的）
	 * @param id 城市唯一标示号
	 * @return
	 */
	public boolean modifyCity(String city,String id);
	
	/**
	 * 前置：cityA与cityB格式符合规范且有效存在，distance与price符合规范（都是数值）
	 * 后置：更新持久化对象，根据操作结果返回
	 * 依赖：PriceAndCityDataService..update(PriceAndCityPO p) 更新PriceAndCityPO
	 * @return
	 */
	public boolean setDiretionAndPrice(int cityA, int cityB,String distance,String price);
	/**
	 * 前置：cityA与cityB格式符合规范且有效存在
	 * 后置：返回价格信息
	 * 依赖：PriceAndCityDataService find(String cityA,String cityB 查找一个PriceAndCityPO
	 * @param o
	 * @param direction
	 * @return
	 */
	public PriceAndCityVO getDiretionAndPrice(int cityA, int cityB);
	
	/**
	 * 返回所有城市的数组
	 * 前置：无
	 * 后置：所有城市信息用数组表示并返回
	 * 依赖：this.getAll()
	 * @return
	 */
	public String[] getAllCitiesArray();
}
