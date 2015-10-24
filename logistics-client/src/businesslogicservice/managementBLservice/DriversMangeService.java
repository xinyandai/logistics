package businesslogicservice.managementBLservice;

import java.util.ArrayList;

import vo.DriverVO;

public interface DriversMangeService {

	/**
	 * 前置：选择司机信息管理
	 * 后置：显示所有司机信息
	 * @return
	 */
	public ArrayList<DriverVO> showAll();
	/**
	 * 前置：选择增加司机并输入司机信息
	 * 后置：更新
	 * @param c
	 * @return
	 */
	public boolean add(DriverVO c);
	/**
	 * 前置：选择司机进行更改
	 * 后置：更新
	 * @param old
	 * @param newone
	 * @return
	 */
	public boolean modify(DriverVO old,DriverVO newone);
	/**
	 * 前置：批量选择司机信息并删除
	 * 后置：更新
	 * @param al
	 * @return
	 */
	public boolean delete(ArrayList<DriverVO> al);
	/**
	 * 前置：输入关键字模糊查找
	 * 后置：返回查找结果
	 * @param s
	 * @return
	 */
	public ArrayList<DriverVO> fuzzySearch(String s);
	
}
