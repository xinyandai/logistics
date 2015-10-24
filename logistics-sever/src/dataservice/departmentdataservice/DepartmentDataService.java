package dataservice.departmentdataservice;

import java.util.ArrayList;

import po.DepartmentPO;

/**
 * 20151022
 * 部门信息
 * @author 颜
 */
public interface DepartmentDataService {
	/**
	 * 前置：无
	 * 后置：返回所有的机构信息
	 * @return
	 */
	public ArrayList<DepartmentPO> getAll();
	/**
	 * 前置：同样ID的po在还未存在
	 * 后置：在数据中增加一个PO
	 * @param dp
	 * @return
	 */
	public boolean add(DepartmentPO dp);
	/**
	 * 前置：该PO已经存在于数据
	 * 后置：在数据中删除一个PO
	 * @param dp
	 * @return
	 */
	public boolean delete(DepartmentPO dp);
	/**
	 * 前置：这些PO已经存在于数据
	 * 后置：在数据中删除这些PO
	 * @param al
	 * @return
	 */
	public boolean delete(ArrayList<DepartmentPO> al);
	/**
	 * 前置：该PO已经存在于数据
	 * 后置：在数据中修改一个PO
	 * @param 
	 * @return
	 */
	public boolean updata(DepartmentPO old,DepartmentPO newone);
}
