package org.module.client.businesslogicservice.managementBLservice;

import java.util.ArrayList;

import org.module.client.vo.CarVO;
import org.module.common.dataservice.MyList;



public interface CarsManageBLService {

	/**
	 * 前置：无
	 * 选择汽车信息管理
	 * 后置：返回所有汽车信息
	 * 依赖：CarDataService.getAll 返回所有PO
	 * @return
	 */
	public ArrayList<CarVO> showAll();
	/**
	 * 前置：输入的汽车信息符合规范，id已存在carVO重复
	 * 后置：增加一个持久化对象，根据操作结果返回
	 * 依赖：CarDataService.add 增加一个PO
	 * @param c
	 * @return
	 */
	public boolean add(String id, String license, String time);
	/**
	 * 前置：选择汽车进行更改，汽车信息符合规范
	 * 后置：更新持久化对象，根据操作结果返回
	 * 依赖：CarDataService.update 修改一个PO
	 * @param
	 * @return
	 */
	public boolean modify(String id, String license, String time);
	/**
	 * 前置：id符合规范并有效
	 * 后置：删除一个持久化对象，根据操作结果返回
	 * 依赖：CarDataService.删除一个PO
	 * @param al
	 * @return
	 */
	public boolean delete(String id);
	/**
	 * 前置：批量选择汽车信息并删除
	 * 后置：更新
	 * 依赖：CarDataService.删除一些PO
	 * @param al
	 * @return
	 */
	public boolean delete(MyList<String> id);
	/**
	 * 前置：输入关键字符合规范
	 * 后置：返回查找结果
	 * 依赖：CarDataService.getAll 返回所有PO
	 * @param s
	 * @return
	 */
	public ArrayList<CarVO> fuzzySearch(String s);
	
	/**
	 * 前置： 无
	 * 后置： 吧所有车辆信息以数组形式返回
	 * 依赖：this.getAll()
	 * @return
	 */
	public ArrayList<String[]> getAllToArray();
}

