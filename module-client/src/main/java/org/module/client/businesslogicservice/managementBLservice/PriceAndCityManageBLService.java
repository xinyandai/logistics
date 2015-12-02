package org.module.client.businesslogicservice.managementBLservice;

import java.util.ArrayList;

import org.module.client.vo.CityVO;


public interface PriceAndCityManageBLService {

	/**
	 * 前置：进入价格与城市管理
	 * 后置：显示所有城市
	 * 依赖：PriceAndCityDataService.getAll 返回所有PO
	 * @return
	 */
	public ArrayList<CityVO> showAllCity();
	
	public ArrayList<String[]> toArray(); 

	/**
	 * 前置：选择增加城市，并输入
	 * 后置：默认新城市与其他城市间距离都是0；更新
	 * 依赖：PriceAndCityDataService.getAll 返回所有PO
	 * @return
	 */
	public boolean addCity(String city,String id);

	public boolean deleteCity(String id);
	public boolean modifyCity(String city,String id);
	
	/**
	 * 前置：选择城市，并输入城市间距离
	 * 后置：更新
	 * 依赖：PriceAndCityDataService.add 增加一个PO
	 * @param old
	 * @param direction
	 * @return
	 */
	public boolean setDiretionAndPrice(String cityA, String cityB,String distance,String price);
	/**
	 * 前置：选择设置各费用（包装费/元，运费/元/km）
	 * 后置：更新
	 * 依赖：PriceAndCityDataService.update 更改一个PO
	 * @return
	 */
}
