package org.module.common.dataservice.managementdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.module.common.dataservice.MyList;
import org.module.common.po.CityPO;
import org.module.common.po.PriceAndCityPO;


public interface PriceAndCityDataService  extends Remote{

	/**
	 * 前置：无
	 * 后置：查找并返回返回所有城际距离，即PriceAndCityPO组成的序列化列表
	 * @return
	 */
	public MyList<PriceAndCityPO> getAll()throws RemoteException;
	/**
	 * 前置：无
	 * 后置：返回所有城市，即City的序列化列表
	 * @return
	 */
	public MyList<CityPO>  getCity()throws RemoteException;
	/**
	 * 前置：相同id值的PO不存在于数据库中
	 * 后置：添加一个PO，根据操作结果返回
	 * @param po 增加的cityPO
	 * @return
	 */
	public boolean addCity(CityPO po)throws RemoteException;
	/**
	 * 前置：相同ID值的PO不存在于数据库中
	 * 后置：添加一个PO，根据操作结果返回
	 * @param p 包含城市与价格的PO
	 * @return
	 */
	public boolean addPriceAndCity(PriceAndCityPO p)throws RemoteException;
	/**
	 * 前置：相同ID值的PO存在于数据库中
	 * 后置：修改一个PO，根据操作结果返回
	 * @param p 新的PO
	 * @return
	 */
	public boolean update(PriceAndCityPO p)throws RemoteException;
	/**
	 * 前置： ID是cityA的城市A与id是cityB的城市B在文件中已经存在
	 * 后置: 查找并返回对应priceAndCityPO
	 * @param cityA 城市A的ID
	 * @param cityB 城市B的ID
	 * @return 返回查找的PO
	 * @throws RemoteException
	 */
	public PriceAndCityPO find(String cityA,String cityB)throws RemoteException;
	
	/***
	 * 前置： 相同id值的CityPO在数据文件中已经存在
	 * 后置： 删除对应PO，根据操作结果返回
	 * @param id cityPO的id
	 * @return
	 * @throws RemoteException
	 */
	public boolean deleteCity(String id)throws RemoteException;
	/**
	 * 前置：相同ID值的PO存在于数据文件中
	 * 后置：更新相应的PO，根据操作结果返回
	 * @param po 修改后的PO
	 * @return
	 * @throws RemoteException
	 */
	public boolean modifyCity(CityPO po)throws RemoteException;
}
