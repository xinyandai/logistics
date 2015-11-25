package org.module.common.dataservice.managementdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.module.common.po.PriceAndCityPO;


public interface PriceAndCityDataService  extends Remote{

	/**
	 * 前置：无
	 * 后置：返回所有城际距离
	 * @return
	 */
	public ArrayList<PriceAndCityPO> getAll()throws RemoteException;
	/**
	 * 前置：无
	 * 后置：返回所有城市
	 * @return
	 */
	public ArrayList<String>  getCity()throws RemoteException;
	/**
	 * 前置：该PO不存在于数据库中
	 * 后置：添加一个PO
	 * @param p
	 * @return
	 */
	public boolean addCity(String city)throws RemoteException;
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
	
	
}
