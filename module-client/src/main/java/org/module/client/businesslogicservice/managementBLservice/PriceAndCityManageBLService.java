package org.module.client.businesslogicservice.managementBLservice;

import java.util.ArrayList;

import org.module.client.vo.CityVO;
import org.module.client.vo.PriceAndCityVO;


public interface PriceAndCityManageBLService {

	/**
	 * 前置：进入价格与城市管理
	 * 后置：显示所有城市
	 * 依赖：PriceAndCityDataService.getAll 返回所有PO
	 * @return
	 */
	public ArrayList<CityVO> showAllCity();
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<String[]> toArray(); 

	/**
	 * 前置：选择增加城市，并输入
	 * 后置：默认新城市与其他城市间距离都是0；更新
	 * 依赖：PriceAndCityDataService.getAll 返回所有PO
	 * @return
	 */
	public boolean addCity(String city,String id);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteCity(String id);
	/**
	 * 
	 * @param city
	 * @param id
	 * @return
	 */
	public boolean modifyCity(String city,String id);
	
	/**
	 * 前置：选择城市，并输入城市间距离
	 * 后置：更新
	 * 依赖：PriceAndCityDataService.add 增加一个PO
	 * @param old
	 * @param direction
	 * @return
	 */
	public boolean setDiretionAndPrice(int cityA, int cityB,String distance,String price);
	/**
	 * 前置：选择城市
	 * 后置：
	 * 依赖：PriceAndCityDataService  查找一个PO
	 * @param o
	 * @param direction
	 * @return
	 */
	public PriceAndCityVO getDiretionAndPrice(int cityA, int cityB);
	
	/**
	 * 
	 * @return
	 */
	public String[] getAllCitiesArray();
}
