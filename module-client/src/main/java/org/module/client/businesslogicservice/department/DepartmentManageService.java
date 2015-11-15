package org.module.client.businesslogicservice.department;

import java.util.ArrayList;

import org.module.client.vo.DepartmentVO;

public interface DepartmentManageService {
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
	public boolean add(DepartmentVO vo);
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
	public boolean delete(ArrayList<String> ids);
	/**
	 * 前置：选择机构进行修改，输入修改后的新信息
	 * 后置：更新机构信息
	 * 依赖：DepartmentDataService.midify 修改一个PO
	 * @param old
	 * @param newone
	 * @return
	 */
	public boolean modify(DepartmentVO vo);
	/**
	 * 前置：输入关键字模糊查找
	 * 后置：返回查找结果
	 * 依赖：DepartmentDataService.getAll 得到所有的PO
	 * @param s
	 * @return
	 */
	public ArrayList<DepartmentVO> fuzzySearch(String s);
}
