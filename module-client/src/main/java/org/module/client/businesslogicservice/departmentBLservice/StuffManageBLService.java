package org.module.client.businesslogicservice.departmentBLservice;

import java.util.ArrayList;

import org.module.client.vo.StuffVO;
import org.module.common.dataservice.MyList;


public interface StuffManageBLService {
	/**
	 * 前置：无
	 * 选择员工管理
	 * 后置：返回所有员工
	 * 依赖：StuffDataService.getAll 得到所有员工PO
	 * @return
	 */
	public ArrayList<StuffVO> showAll();
	/**
	 * 前置：选择增加员工，输入新员工的信息符合规范
	 * 后置：持久化增加新增员工，更新员工信息，根据操作结果返回
	 * 依赖：StuffDataService.add 增加一个PO
	 * @param d
	 * @return
	 */
	public boolean add(String name, String age, String category, String identity);
	/**
	 * 前置：员工ID有效
	 * 后置：删除员工持久化对象，更新员工信息，根据操作结果返回
	 * 依赖：StuffDataService.delete 删除一个PO
	 * @param id 是该vo唯一标识符
	 * @return
	 */
	public boolean delete(String id);
	
	/**
	 * 前置：ids中含有的员工ID号都有效且存在
	 * 后置：删除员工持久化对象，更新员工信息，根据操作结果返回
	 * 依赖：StuffDataService.delete 删除arraylist里面id对应的PO
	 * @param ald
	 * @return
	 */
	public boolean delete(MyList<String> ids);
	/**
	 * 前置：选择修改员工，输入的员工新信息符合规范
	 * 后置：更新持久化对象，更新员工信息，根据操作结果返回
	 * 依赖：StuffDataService.update 修改一个PO
	 * @param old
	 * @param newone
	 * @return
	 */
	public boolean update(String name, String age, String category, String identity);
	/**
	 * 前置：关键字格式符合规范
	 * 输入关键字模糊查找，
	 * 后置：返回查找结果
	 * 依赖：StuffDataService.getAll 返回所有PO
	 * @param s
	 * @return
	 */
	public ArrayList<StuffVO> fuzzySearch(String s);
	/**
	 * 前置：ins是本地内存中StuffVO列表的有效 编号，不越界
	 * 后置：删除持久化对象，更新员工信息，根据操作结果返回
	 * 依赖：this.delete(MyList<String> ids);
	 * @param ins
	 */
	public boolean delete(int[] ins);
	
	
}
