package dataservice.statisticdataservice;

import java.util.ArrayList;

import po.CostListPO;


public interface CostDataService {

	/**
	 * 前置：数据库中不存在该PO的ID
	 * 后置：增加一个PO
	 * @param c
	 * @return
	 */
	public boolean addCostList(CostListPO c);
	/**
	 * 前置：无
	 * 后置：返回所有IO
	 * @return
	 */
	public ArrayList<CostListPO> getAll();
}
