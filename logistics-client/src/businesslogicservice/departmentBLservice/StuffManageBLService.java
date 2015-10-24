package businesslogicservice.departmentBLservice;

import java.util.ArrayList;

import vo.StuffVO;

public interface StuffManageBLService {
	/**
	 * 前置：选择员工管理
	 * 后置：显示所有员工
	 * @return
	 */
	public ArrayList<StuffVO> showAll();
	/**
	 * 前置：选择增加员工并输入新员工信息
	 * 后置：更新员工信息
	 * @param d
	 * @return
	 */
	public boolean add(StuffVO d);
	/**
	 * 前置：选择删除员工
	 * 后置：更新员工信息
	 * @param d
	 * @return
	 */
	public boolean delete(StuffVO d);
	
	/**
	 * 前置：选择删除员工
	 * 后置：更新员工信息
	 * @param ald
	 * @return
	 */
	public boolean delete(ArrayList<StuffVO> ald);
	/**
	 * 前置：选择修改员工，输入员工新信息
	 * 后置：更新员工信息
	 * @param old
	 * @param newone
	 * @return
	 */
	public boolean modify(StuffVO old,StuffVO newone);
	/**
	 * 前置：输入关键字模糊查找
	 * 后置：返回查找结果
	 * @param s
	 * @return
	 */
	public ArrayList<StuffVO> fuzzySearch(String s);
}
