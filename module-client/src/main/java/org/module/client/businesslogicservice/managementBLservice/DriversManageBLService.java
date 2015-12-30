package org.module.client.businesslogicservice.managementBLservice;

import java.util.ArrayList;

import org.module.client.vo.DriverVO;
import org.module.common.dataservice.MyList;


public interface DriversManageBLService {

	/**
	 * 前置：无
	 * 后置：显示所有司机信息
	 * 依赖：DriversDataService.getAll 返回所有PO
	 * @return
	 */
	public ArrayList<DriverVO> showAll();
	/**
	 * 前置：司机属性符合规范，id不与当前司机列表重复
	 * 后置：增加对应司机持久化对象，更新当前司机显示信息，根据操作结果返回
	 * 依赖：DriversDataService.add  增加一个PO
	 * @param c
	 * @return
	 */
	public boolean add(String id, String name, String birthday, String idcard,
			String phone, String gender, String date);
	/**
	 * 前置：司机属性符合规范
	 * 后置：更新对应司机持久化对象，更新当前司机列表，根据操作结果返回
	 * 依赖：DriversDataService.update 修改一个PO
	 * @param 
	 * @return
	 */
	public boolean modify(String id, String name, String birthday, String idcard,
			String phone, String gender, String date);
	/**
	 * 前置：id有效
	 * 选择司机信息并删除
	 * 后置：删除一个持久化对象，跟新当前信息，根据操作结果返回
	 * 依赖：DriversDataService.delete 删除一些PO
	 * @param al
	 * @return
	 */
	public boolean delete(String id);
	/**
	 * 前置：批量选择司机信息并删除
	 * 后置：删除对应所有持久化对象，跟新当前信息，根据操作结果返回
	 * 依赖：DriversDataService.delete 删除一些PO
	 * @param al
	 * @return
	 */
	public boolean delete(MyList<String> id);
	/**
	 * 前置：关键字符合规范存在匹配此关键字司机持久化对象
	 * 后置：返回查找结果
	 * 依赖：DriversDataService.getAll 返回所有PO
	 * @deprecated
	 * @param s
	 * @return 无匹配结果则返回null
	 */
	public ArrayList<DriverVO> fuzzySearch(String s);
	
	/**
	 * 前置： 无
	 * 后置： 把所有司机信息转为数组形式返回
	 * 依赖：this.getAll()
	 * @return
	 */
	public ArrayList<String[]> toArray();
	
}
