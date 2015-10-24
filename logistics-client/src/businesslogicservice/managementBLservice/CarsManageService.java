package businesslogicservice.managementBLservice;

import java.util.ArrayList;

import vo.CarVO;

public interface CarsManageService {

	/**
	 * 前置：选择汽车信息管理
	 * 后置：显示所有汽车信息
	 * @return
	 */
	public ArrayList<CarVO> showAll();
	/**
	 * 前置：选择增加汽车并输入汽车信息
	 * 后置：更新
	 * @param c
	 * @return
	 */
	public boolean add(CarVO c);
	/**
	 * 前置：选择汽车进行更改
	 * 后置：更新
	 * @param old
	 * @param newone
	 * @return
	 */
	public boolean modify(CarVO old,CarVO newone);
	/**
	 * 前置：批量选择汽车信息并删除
	 * 后置：更新
	 * @param al
	 * @return
	 */
	public boolean delete(ArrayList<CarVO> al);
	/**
	 * 前置：输入关键字模糊查找
	 * 后置：返回查找结果
	 * @param s
	 * @return
	 */
	public ArrayList<CarVO> fuzzySearch(String s);
}
