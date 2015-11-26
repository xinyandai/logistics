package org.module.client.businesslogicservice.department;

import java.util.ArrayList;

import org.module.client.vo.StuffVO;
import org.module.common.dataservice.MyList;

public interface StuffService {
	/**
	 * 前置：选择员工管理
	 * 后置：显示所有员工
	 * 依赖：StuffDataService.getAll 得到所有员工信息
	 * @return
	 */
	public ArrayList<StuffVO> showAll();
	/**
	 * 前置：选择增加员工并输入新员工信息
	 * 后置：更新员工信息
	 * 依赖：StuffDataService.add 增加一个PO
	 * @param d
	 * @return
	 */
	public boolean add(StuffVO vo);
	/**
	 * 前置：选择删除员工
	 * 后置：更新员工信息
	 * 依赖：StuffDataService.delete 删除一个PO
	 * @param d
	 * @return
	 */
	public boolean delete( String identity);
	
	/**
	 * 前置：选择删除员工
	 * 后置：更新员工信息
	 * 依赖：StuffDataService.delete 删除arraylist里面 的PO
	 * @param ald
	 * @return
	 */
	public boolean delete(MyList<String> ald);
	/**
	 * 前置：选择修改员工，输入员工新信息
	 * 后置：更新员工信息
	 * 依赖：StuffDataService.update 修改一个PO
	 * @param old
	 * @param newone
	 * @return
	 */
	public boolean modify(StuffVO vo);
	/**
	 * 前置：输入关键字模糊查找
	 * 后置：返回查找结果
	 * 依赖：StuffDataService.getAll 返回所有PO
	 * @param s
	 * @return
	 */
	public ArrayList<StuffVO> fuzzySearch(String s);
}
