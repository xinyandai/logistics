package org.module.client.businesslogicservice.departmentBLservice;

import java.util.ArrayList;

import org.module.client.vo.DepartmentVO;
import org.module.common.dataservice.MyList;

/**
 * 20151024
 * 机构管理：对机构的增删改查
 * @author 
 *
 */
public interface DepartmentManageBLService {

	/**
	 * 前置：启动机构管理
	 * 后置：显示所有机构信息
	 * 依赖：DepartmentDataService.getAll 返回所有PO
	 * @return 
	 */
	public ArrayList<DepartmentVO> showAll();
	
	/**
	 * 前置：选择增加机构，输入新增机构信息
	 * 后置：更新机构信息
	 * 依赖：DepartmentDataService.add 增加一个PO
	 * @param d
	 * @return
	 */
	public boolean add(String name, String category, String location,
			String identity);
	/**
	 * 前置：选择删除机构
	 * 后置：更新机构信息
	 * 依赖：DepartmentDataService.delete 删除一个PO
	 * @param d
	 * @return
	 */
	public boolean delete(String identity);
	/**
	 * 前置：选择欲删除的机构
	 * 后置：更新机构信息
	 * 依赖：DepartmentDataService.delete删除arraylist中的PO
	 * @param ald
	 * @return
	 */
	public boolean delete(MyList<String> ids);
	/**
	 * 前置：选择机构进行修改，输入修改后的新信息
	 * 后置：更新机构信息
	 * 依赖：DepartmentDataService.midify 修改一个PO
	 * @param old
	 * @param newone
	 * @return
	 */
	public boolean update(String name, String category, String location,
			String identity);
	/**
	 * 前置：输入关键字模糊查找
	 * 后置：返回查找结果
	 * 依赖：DepartmentDataService.getAll 得到所有的PO
	 * @param s
	 * @return
	 */
	public ArrayList<DepartmentVO> fuzzySearch(String s);
	/**
	 * 更新同步数据
	 * 主要是从服务端读取数据
	 * @return
	 */
//	public void refresh();
	/**
	 * 
	 * @return
	 */
	public ArrayList<String[]> toArrayList();
	
}
