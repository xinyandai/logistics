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
	 * 后置：查找并返回所有机构信息
	 * 依赖：DepartmentDataService.getAll 返回所有PO
	 * @return 
	 */
	public ArrayList<DepartmentVO> showAll();
	
	/**选择增加机构，输入新增机构信息
	 * 前置：持久化增加机构信息，机构信息格式符合规范，name不为空，类别不为空，location不为空，identity为九尾数值
	 * 后置：更新机构信息，根据操作结果返回
	 * 依赖：DepartmentDataService.add 增加一个PO
	 * @param d
	 * @return
	 */
	public boolean add(String name, String category, String location,
			String identity);
	/**
	 * 前置：选择删除机构，与删除的机构identity有效
	 * 后置：删除持久化对象，更新机构信息，，根据操作结果返回
	 * 依赖：DepartmentDataService.delete 删除一个PO
	 * @param identity 机构唯一标识符
	 * @return
	 */
	public boolean delete(String identity);
	/**
	 * 前置：选择欲删除的机构，IDS中包含的identity值有效
	 * 后置：删除对应持久化对象，更新机构信息，根据操作结果返回
	 * 依赖：DepartmentDataService.delete删除arraylist中的PO
	 * @param ald
	 * @return
	 */
	public boolean delete(MyList<String> ids);
	/**
	 * 前置：修改后的新信息符合规范， identity必须是九位数字
	 * 后置：更新持久化对象，更新机构信息，根据操作结果返回
	 * 依赖：DepartmentDataService.midify 修改一个PO
	 * @param old
	 * @param newone
	 * @return
	 */
	public boolean update(String name, String category, String location,
			String identity);
	
	/**
	 * 更新同步数据
	 * 主要是从服务端读取数据
	 * @return
	 */
//	public void refresh();
	/**
	 * 前置：无
	 * 后置：返回所有机构信息，VO中属性数组形式表示
	 * 依赖：this.showAll
	 * @return
	 */
	public ArrayList<String[]> toArrayList();
	
}
