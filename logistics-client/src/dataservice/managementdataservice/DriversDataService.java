package dataservice.managementdataservice;

import java.util.ArrayList;

import po.DriverPO;

public interface DriversDataService {
	/**
	 * 前置：无
	 * 后置：返回所有司机PO
	 * @param s
	 * @return
	 */
	public ArrayList<DriverPO> getAll();
	/**
	 * 前置：数据库中不存在相同ID值的PO
	 * 后置：增加一个PO
	 * @param cp
	 * @return
	 */
	public boolean add(DriverPO cp);
	/**
	 * 前置：数据库中已经存在该PO
	 * 后置：删除一个PO
	 * @param cp
	 * @return
	 */
	public boolean delete(DriverPO cp);
	/**
	 * 前置：数据库中存在这些PO
	 * 后置：删除这些PO
	 * @return
	 */
	public boolean delete(ArrayList<DriverPO> al);
	/**
	 * 前置：数据库中存在原PO
	 * 后置：修改该PO
	 * @param
	 * @return
	 */
	public boolean updata(DriverPO newone);
}
