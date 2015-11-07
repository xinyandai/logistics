package org.module.common.dataservice.managementdataservice;

import java.util.ArrayList;

import org.module.common.po.CarPO;


/**
* 20151022
* 车辆信息
* @author 颜
*/
public interface CarDataService {
	/**
	 * 前置：无
	 * 后置：返回所有汽车PO
	 * @param s
	 * @return
	 */
	public ArrayList<CarPO> getAll();
	/**
	 * 前置：数据库中不存在相同ID值的PO
	 * 后置：增加一个PO
	 * @param cp
	 * @return
	 */
	public boolean add(CarPO cp);
	/**
	 * 前置：数据库中已经存在该PO
	 * 后置：删除一个PO
	 * @param cp
	 * @return
	 */
	public boolean delete(CarPO cp);
	/**
	 * 前置：数据库中存在这些PO
	 * 后置：删除这些PO
	 * @return
	 */
	public boolean delete(ArrayList<CarPO> al);
	/**
	 * 前置：数据库中存在原PO
	 * 后置：修改该PO
	 * @param old
	 * @param newone
	 * @return
	 */
	public boolean updata(CarPO old,CarPO newone);
}
