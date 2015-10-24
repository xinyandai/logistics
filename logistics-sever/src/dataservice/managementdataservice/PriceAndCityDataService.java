package dataservice.managementdataservice;

import java.util.ArrayList;

import po.PriceAndCityPO;
import po.PricePO;

public interface PriceAndCityDataService {

	/**
	 * 前置：无
	 * 后置：返回所有城际距离
	 * @return
	 */
	public ArrayList<PriceAndCityPO> getAll();
	/**
	 * 前置：无
	 * 后置：返回所有城市
	 * @return
	 */
	public ArrayList<String>  getCity();
	/**
	 * 前置：该PO不存在于数据库中
	 * 后置：添加一个PO
	 * @param p
	 * @return
	 */
	public boolean addCity(String city);
	/**
	 * 前置：该PO不存在于数据库中
	 * 后置：添加一个PO
	 * @param p
	 * @return
	 */
	public boolean addPriceAndCity(PriceAndCityPO p);
	/**
	 * 前置：该PO存在于数据库中
	 * 后置：修改一个PO
	 * @param p
	 * @return
	 */
	public boolean update(PriceAndCityPO p);
	/**
	 * 前置：该PO存在于数据库中
	 * 后置：修改一个PO
	 * @param p
	 * @return
	 */
	public boolean setPrice(PricePO p);
}
