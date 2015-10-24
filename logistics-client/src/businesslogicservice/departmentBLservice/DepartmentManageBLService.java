package businesslogicservice.departmentBLservice;

import java.util.ArrayList;

import vo.DepartmentVO;
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
	 * @return 
	 */
	public ArrayList<DepartmentVO> showAll();
	
	/**
	 * 前置：选择增加机构，输入新增机构信息
	 * 后置：更新机构信息
	 * @param d
	 * @return
	 */
	public boolean add(DepartmentVO d);
	/**
	 * 前置：选择删除机构
	 * 后置：更新机构信息
	 * @param d
	 * @return
	 */
	public boolean delete(DepartmentVO d);
	/**
	 * 前置：选择欲删除的机构
	 * 后置：更新机构信息
	 * @param ald
	 * @return
	 */
	public boolean delete(ArrayList<DepartmentVO> ald);
	/**
	 * 前置：选择机构进行修改，输入修改后的新信息
	 * 后置：更新机构信息
	 * @param old
	 * @param newone
	 * @return
	 */
	public boolean modify(DepartmentVO old,DepartmentVO newone);
	/**
	 * 前置：输入关键字模糊查找
	 * 后置：返回查找结果
	 * @param s
	 * @return
	 */
	public ArrayList<DepartmentVO> fuzzySearch(String s);
	
}
