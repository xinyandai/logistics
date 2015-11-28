package org.module.common.dataservice.managementdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.module.common.dataservice.MyList;
import org.module.common.po.CityPO;
import org.module.common.po.PriceAndCityPO;


public interface PriceAndCityDataService  extends Remote{

	/**
	 * 前置：无
	 * 后置：返回所有城际距离
	 * @return
	 */
	public MyList<PriceAndCityPO> getAll()throws RemoteException;
	/**
	 * 前置：无
	 * 后置：返回所有城市
	 * @return
	 */
	public MyList<CityPO>  getCity()throws RemoteException;
	/**
	 * 前置：该PO不存在于数据库中
	 * 后置：添加一个PO
	 * @param p
	 * @return
	 */
	public boolean addCity(CityPO po)throws RemoteException;
	/**
	 * 前置：该PO不存在于数据库中
	 * 后置：添加一个PO
	 * @param p
	 * @return
	 */
	public boolean addPriceAndCity(PriceAndCityPO p)throws RemoteException;
	/**
	 * 前置：该PO存在于数据库中
	 * 后置：修改一个PO
	 * @param p
	 * @return
	 */
	public boolean update(PriceAndCityPO p)throws RemoteException;
	
	public boolean deleteCity(String id)throws RemoteException;
	public boolean modifyCity(CityPO po)throws RemoteException;
}
