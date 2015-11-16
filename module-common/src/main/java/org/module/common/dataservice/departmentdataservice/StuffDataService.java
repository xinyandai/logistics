package org.module.common.dataservice.departmentdataservice;

import java.util.ArrayList;

import org.module.common.po.StuffPO;


/**
 * 20151022
 * 员工信息
 * @author 颜
 */
public interface StuffDataService {
	
	/**
	 * 前置：无
	 * 后置：返回所有的员工PO信息
	 * @return
	 */
	public ArrayList<StuffPO> getAll();
	/**
	 * 前置：同样ID的po在还未存在
	 * 后置：在数据中增加一个PO
	 * @param dp
	 * @return
	 */
	public boolean add(StuffPO dp);
	/**
	 * 前置：该PO已经存在于数据
	 * 后置：在数据中删除一个PO
	 * @param dp
	 * @return
	 */
	public boolean delete(StuffPO dp);
	/**
	 * 前置：这些PO已经存在于数据
	 * 后置：在数据中删除这些PO
	 * @param al
	 * @return
	 */
	public boolean delete(ArrayList<StuffPO> al);
	/**
	 * 前置：该PO已经存在于数据
	 * 后置：在数据中修改一个PO
	 * @param 
	 * @return
	 */
	public boolean update(StuffPO one);
	
	public ArrayList<StuffPO> fuzzusearch(String key);
	
}
